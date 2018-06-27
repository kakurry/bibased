package com.example.bibased.controller;

import com.example.bibased.dto.BootstrapTablePageDTO;
import com.example.bibased.javabean.*;
import com.example.bibased.service.FrenchcaiService;
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
public class FrenchcaiController {
    @Autowired
    @Qualifier("frencaiServiceImpl")
    private FrenchcaiService frenchcaiService;


    /**
     * 法国菜的table查询
     * @param page
     * @param createTime
     * @param updataTime
     * @param caiming
     * @return
     */
    @RequestMapping("queryFrenchCai.action")
    public @ResponseBody BootstrapTablePageDTO queryPages(JqPage page, Date createTime, Date updataTime, String caiming) {
        FrenchcaiMstExample criteria = new FrenchcaiMstExample();
        FrenchcaiMstExample.Criteria cri = criteria.createCriteria();
        if(createTime != null) {
            cri.andCreatetimeEqualTo(createTime);
        }
        if(updataTime != null) {
            cri.andCreatetimeLessThanOrEqualTo(updataTime);
        }
        if(caiming != "") {	//菜名
            cri.andCaimingEqualTo(caiming);
        }
        List<FrenchcaiMst> list = frenchcaiService.selectByExample(criteria);
        int count = this.frenchcaiService.countByCriteria(criteria);
        BootstrapTablePageDTO bootTable = new BootstrapTablePageDTO(String.valueOf(count));
        bootTable.pageValue(page, list);
        bootTable.setPageSize(page.getPageSize() + "");
        return bootTable;
    }

    /**
     * 法国菜的新增或修改
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
    @RequestMapping("addFrenchCai.action")
    public @ResponseBody Boolean ADDorUpdate(String id,String caiming,String img,String neirong1,String neirong2,String neirong3,String neirong4,String neirong5){
        Boolean rusult = true;
        FrenchcaiMst frenchcaiMst = new FrenchcaiMst();
        frenchcaiMst.setCaiming(caiming);
        frenchcaiMst.setImg(img);
        frenchcaiMst.setNeirong1(neirong1);
        frenchcaiMst.setNeirong2(neirong2);
        frenchcaiMst.setNeirong3(neirong3);
        frenchcaiMst.setNeirong4(neirong4);
        frenchcaiMst.setNeirong5(neirong5);
        frenchcaiMst.setCreatetime(new Date());
        frenchcaiMst.setUpdatetime(new Date());
        if(id == ""){
            //新增法国菜
            frenchcaiMst.setId(UUIDGenerator.create32Key());
            frenchcaiService.insert(frenchcaiMst);
        }else{
            frenchcaiMst.setId(id);
            frenchcaiService.update(frenchcaiMst);
            //修改法国菜
        }
        return  rusult;
    }

    /**
     * 批量删除法国菜
     * @param ids
     * @return
     */
    @RequestMapping("deleteFrenchCai.action")
    public @ResponseBody
    boolean deleteTemplates(String ids) {
        String idArr[] = ids.split(",");
        List<FrenchcaiMst> list = new ArrayList<FrenchcaiMst>();
        for (int i = 0; i < idArr.length; i++) {
            FrenchcaiMst frenchcaiMst = new FrenchcaiMst();
            frenchcaiMst.setId(idArr[i]);
            list.add(frenchcaiMst);
        }
        try {
            this.frenchcaiService.batchDisabled(list);
            return true;
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 前端初始化时加载的法国菜list
     */
    @RequestMapping("frenchcaiCHU.action")
    public @ResponseBody List<FrenchcaiMst> frenchcaichushihualist(){
        FrenchcaiMstExample criteria = new FrenchcaiMstExample();
        FrenchcaiMstExample.Criteria cri = criteria.createCriteria();
        List<FrenchcaiMst> frenchcaiMstList = frenchcaiService.selectByExample(criteria);
        return  frenchcaiMstList;
    }
}
