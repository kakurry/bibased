package com.example.bibased.controller;

import com.example.bibased.dto.BootstrapTablePageDTO;
import com.example.bibased.javabean.GuanliyuanuserMst;
import com.example.bibased.javabean.GuanliyuanuserMstExample;
import com.example.bibased.javabean.LingshiMst;
import com.example.bibased.service.GuanliyuanService;
import com.example.bibased.service.LingshiService;
import com.example.bibased.util.JqPage;
import com.example.bibased.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class GuanliyuanController {
    @Autowired
    @Qualifier("guanliyuanServiceImpl")
    private GuanliyuanService guanliyuanService;

    @Autowired
    @Qualifier("lingshiServiceImpl")
    private LingshiService lingshiService;

    /**
     * <p>Title: queryPages</p>
     * <p>Description: 列表页分页数据</p>
     * @author hdx
     */
    @RequestMapping("querytable.action")
    public @ResponseBody BootstrapTablePageDTO queryPages(JqPage page,int pageNo,int pageSize , Date creatTime,Date updataTime,String name,String nicheng,String gonghao) {
        GuanliyuanuserMstExample criteria = new GuanliyuanuserMstExample();
        GuanliyuanuserMstExample.Criteria cri = criteria.createCriteria();
        if(creatTime != null) {
            cri.andCreattimeEqualTo(creatTime);
        }
        if(updataTime != null) {
            cri.andCreattimeGreaterThanOrEqualTo(updataTime);
        }
        if(name != "") {	//姓名
            cri.andNameEqualTo(name);
        }
        if(nicheng != "") {	//昵称
            cri.andNichengEqualTo(nicheng);
        }
        if(gonghao != "") {	//工号
            cri.andGonghaoEqualTo(gonghao);
        }
        List<GuanliyuanuserMst> list = guanliyuanService.selectByExample(criteria);
        int count = this.guanliyuanService.countByCriteria(criteria);
        BootstrapTablePageDTO bootTable = new BootstrapTablePageDTO(String.valueOf(count));
        bootTable.pageValue(page, list);
        bootTable.setPageSize(page.getPageSize() + "");
        return bootTable;
    }

    /**
     * 管理员新增或修改
     * @param id
     * @param name
     * @param nicheng
     * @param gonghao
     * @param dizhi
     * @param telephone
     * @param email
     * @param description
     * @param password
     * @return
     */
    @RequestMapping("add.action")
    public @ResponseBody String saveOrUpdate(String id,String name,String nicheng,String gonghao,String dizhi,String telephone,String email,String description, String password,String status) {
        GuanliyuanuserMstExample criteria = new GuanliyuanuserMstExample();
        GuanliyuanuserMstExample.Criteria cri = criteria.createCriteria();
        cri.andNameEqualTo(name);
        int number = 0;
        number = guanliyuanService.yanchongByname(criteria);
        if(number > 0){
            return "repeat";
        }
        GuanliyuanuserMst gly = new GuanliyuanuserMst();
        gly.setName(name);
        gly.setPassword(password);
        gly.setNicheng(nicheng);
        gly.setGonghao(gonghao);
        gly.setEmail(email);
        gly.setTelephone(telephone);
        gly.setDizhi(dizhi);
        gly.setDescription(description);
        gly.setCreattime(new Date());
        gly.setUpdatetime(new Date());
        gly.setStatus(status);
        String result = "true";
        if(id == ""){
            gly.setId(UUIDGenerator.create32Key());
            guanliyuanService.insert(gly);
        }else{
            gly.setId(id);
            guanliyuanService.update(gly);
        }
        return result;
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("delete.action")
    public @ResponseBody boolean deleteTemplates(String ids) {
        String idArr[] = ids.split(",");
        List<GuanliyuanuserMst> list = new ArrayList<GuanliyuanuserMst>();
        for (int i = 0; i < idArr.length; i++) {
            GuanliyuanuserMst guanliyuanuserMst = new GuanliyuanuserMst();
            guanliyuanuserMst.setId(idArr[i]);
            list.add(guanliyuanuserMst);
        }
        try {
            this.guanliyuanService.batchDisabled(list);
            return true;
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("guanliyuanlogin.action")
    public @ResponseBody Boolean loginguanliyuan(String name,String password){
        /*开始进来就清空临时表*/
        lingshiService.delete();
        GuanliyuanuserMstExample criteria = new GuanliyuanuserMstExample();
        GuanliyuanuserMstExample.Criteria cri = criteria.createCriteria();
        cri.andNameEqualTo(name);
        cri.andPasswordEqualTo(password);
        boolean result = true;
        int number = 0;
        number = guanliyuanService.selectBynameAndpassword(criteria);
        if(number > 0){
            List<GuanliyuanuserMst> list = guanliyuanService.selectByExample(criteria);
            for (GuanliyuanuserMst aa : list){
                LingshiMst lingshiMst = new LingshiMst();
                lingshiMst.setId(aa.getId());
                lingshiMst.setCreattime(aa.getCreattime());
                lingshiMst.setDescription(aa.getDescription());
                lingshiMst.setDizhi(aa.getDizhi());
                lingshiMst.setEmail(aa.getEmail());
                lingshiMst.setErweima(aa.getErweima());
                lingshiMst.setGonghao(aa.getGonghao());
                lingshiMst.setName(aa.getName());
                lingshiMst.setNicheng(aa.getNicheng());
                lingshiMst.setPassword(aa.getPassword());
                lingshiMst.setTelephone(aa.getTelephone());
                lingshiMst.setUpdatetime(aa.getUpdatetime());
                lingshiMst.setStatus(aa.getStatus());
                lingshiService.insert(lingshiMst);
            }

            return result;
        }

        return false;
    }

    /**
     * 查询临时表中动态的登录用户
     * @return
     */
    @RequestMapping("dongtaiuser.action")
    public @ResponseBody LingshiMst loginguanliyuan(){
        return lingshiService.select();
    }

    /**
     * 注销管理员
     * @return
     */
    @RequestMapping("zhuxiaohoutai.action")
    public @ResponseBody Boolean zhuxiaohoutai(){
        lingshiService.delete();
        return true;
    }
}
