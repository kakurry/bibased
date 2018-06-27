package com.example.bibased.controller;

import com.example.bibased.dto.BootstrapTablePageDTO;
import com.example.bibased.javabean.*;
import com.example.bibased.service.JapancaiService;
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
public class JapancaiController {
    @Autowired
    @Qualifier("japancaiServiceImpl")
    private JapancaiService japancaiService;

    /**
     * 日本菜的table查询
     * @param page
     * @param createTime
     * @param updataTime
     * @param caiming
     * @return
     */
    @RequestMapping("queryJapanCai.action")
    public @ResponseBody BootstrapTablePageDTO queryPages(JqPage page, Date createTime, Date updataTime, String caiming) {
        JapancaiMstExample criteria = new JapancaiMstExample();
        JapancaiMstExample.Criteria cri = criteria.createCriteria();
        if(createTime != null) {
            cri.andCreatetimeEqualTo(createTime);
        }
        if(updataTime != null) {
            cri.andCreatetimeLessThanOrEqualTo(updataTime);
        }
        if(caiming != "") {	//菜名
            cri.andCaimingEqualTo(caiming);
        }
        List<JapancaiMst> list = japancaiService.selectByExample(criteria);
        int count = this.japancaiService.countByCriteria(criteria);
        BootstrapTablePageDTO bootTable = new BootstrapTablePageDTO(String.valueOf(count));
        bootTable.pageValue(page, list);
        bootTable.setPageSize(page.getPageSize() + "");
        return bootTable;
    }

    /**
     * 日本菜的新增或修改
     * @param id
     * @param caiming
     * @param img
     * @param neirong1
     * @param neirong2
     * @param neirong3
     * @param neirong4
     * @param neirong5
     * @return
     */
    @RequestMapping("addJapanCai.action")
    public @ResponseBody Boolean ADDorUpdate(String id,String caiming,String img,String neirong1,String neirong2,String neirong3,String neirong4,String neirong5){
        Boolean rusult = true;
        JapancaiMst japancaiMst = new JapancaiMst();
        japancaiMst.setCaiming(caiming);
        japancaiMst.setImg(img);
        japancaiMst.setNeirong1(neirong1);
        japancaiMst.setNeirong2(neirong2);
        japancaiMst.setNeirong3(neirong3);
        japancaiMst.setNeirong4(neirong4);
        japancaiMst.setNeirong5(neirong5);
        japancaiMst.setCreatetime(new Date());
        japancaiMst.setUpdatetime(new Date());
        if(id == ""){
            //新增日本菜
            japancaiMst.setId(UUIDGenerator.create32Key());
            japancaiService.insert(japancaiMst);
        }else{
            japancaiMst.setId(id);
            japancaiService.update(japancaiMst);
            //修改日本菜
        }
        return  rusult;
    }

    /**
     * 批量删除日本菜
     * @param ids
     * @return
     */
    @RequestMapping("deleteJapanCai.action")
    public @ResponseBody
    boolean deleteTemplates(String ids) {
        String idArr[] = ids.split(",");
        List<JapancaiMst> list = new ArrayList<JapancaiMst>();
        for (int i = 0; i < idArr.length; i++) {
            JapancaiMst japancaiMst = new JapancaiMst();
            japancaiMst.setId(idArr[i]);
            list.add(japancaiMst);
        }
        try {
            this.japancaiService.batchDisabled(list);
            return true;
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * 前端初始化时加载的日本菜list
     */
    @RequestMapping("japancaiCHU.action")
    public @ResponseBody List<JapancaiMst> chuancaichushihualist(){
        JapancaiMstExample criteria = new JapancaiMstExample();
        JapancaiMstExample.Criteria cri = criteria.createCriteria();
        List<JapancaiMst> japancaiMstList = japancaiService.selectByExample(criteria);
        return  japancaiMstList;
    }
}
