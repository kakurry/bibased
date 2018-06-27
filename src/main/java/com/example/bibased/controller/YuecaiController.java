package com.example.bibased.controller;

import com.example.bibased.dto.BootstrapTablePageDTO;
import com.example.bibased.javabean.ChuancaiMst;
import com.example.bibased.javabean.ChuancaiMstExample;
import com.example.bibased.javabean.YuecaiMst;
import com.example.bibased.javabean.YuecaiMstExample;
import com.example.bibased.service.YuecaiService;
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
public class YuecaiController {
    @Autowired
    @Qualifier("yuecaiServiceImpl")
    private YuecaiService yuecaiService;

    /**
     * 粤菜的table查询
     * @param page
     * @param createTime
     * @param updataTime
     * @param caiming
     * @return
     */
    @RequestMapping("queryYueCaiyuecai.action")  public @ResponseBody
    BootstrapTablePageDTO queryPages(JqPage page, Date createTime, Date updataTime, String caiming) {
        YuecaiMstExample criteria = new YuecaiMstExample();
        YuecaiMstExample.Criteria cri = criteria.createCriteria();
        if(createTime != null) {
            cri.andCreatetimeEqualTo(createTime);
        }
        if(updataTime != null) {
            cri.andCreatetimeLessThanOrEqualTo(updataTime);
        }
        if(caiming != "") {	//菜名
            cri.andCaimingEqualTo(caiming);
        }
        List<YuecaiMst> list = yuecaiService.selectByExample(criteria);
        int count = this.yuecaiService.countByCriteria(criteria);
        BootstrapTablePageDTO bootTable = new BootstrapTablePageDTO(String.valueOf(count));
        bootTable.pageValue(page, list);
        bootTable.setPageSize(page.getPageSize() + "");
        return bootTable;
    }

    /**
     * 粤菜的新增或修改
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
    @RequestMapping("addYuecai.action")
    public @ResponseBody Boolean ADDorUpdate(String id,String caiming,String img,String neirong1,String neirong2,String neirong3,String neirong4,String neirong5){
        Boolean rusult = true;
        YuecaiMst yuecaiMst = new YuecaiMst();
        yuecaiMst.setCaiming(caiming);
        yuecaiMst.setImg(img);
        yuecaiMst.setNeirong1(neirong1);
        yuecaiMst.setNeirong2(neirong2);
        yuecaiMst.setNeirong3(neirong3);
        yuecaiMst.setNeirong4(neirong4);
        yuecaiMst.setNeirong5(neirong5);
        yuecaiMst.setCreatetime(new Date());
        yuecaiMst.setUpdatetime(new Date());
        if(id == ""){
            //新增粤菜
            yuecaiMst.setId(UUIDGenerator.create32Key());
            yuecaiService.insert(yuecaiMst);
        }else{
            yuecaiMst.setId(id);
            yuecaiService.update(yuecaiMst);
            //修改粤菜
        }
        return  rusult;
    }

    /**
     * 批量删除粤菜
     * @param ids
     * @return
     */
    @RequestMapping("deleteYueCai.action")
    public @ResponseBody boolean deleteTemplates(String ids) {
        String idArr[] = ids.split(",");
        List<YuecaiMst> list = new ArrayList<YuecaiMst>();
        for (int i = 0; i < idArr.length; i++) {
            YuecaiMst yuecaiMst = new YuecaiMst();
            yuecaiMst.setId(idArr[i]);
            list.add(yuecaiMst);
        }
        try {
            this.yuecaiService.batchDisabled(list);
            return true;
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 前端初始化时加载的粤菜list
     */
    @RequestMapping("yuecaiYUE.action")
    public @ResponseBody List<YuecaiMst> yuecaichushihualist(){
        YuecaiMstExample criteria = new YuecaiMstExample();
        YuecaiMstExample.Criteria cri = criteria.createCriteria();
        List<YuecaiMst> yuecaiMstList = yuecaiService.selectByExample(criteria);
        return  yuecaiMstList;
    }
}
