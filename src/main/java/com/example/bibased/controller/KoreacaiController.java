package com.example.bibased.controller;

import com.example.bibased.dto.BootstrapTablePageDTO;
import com.example.bibased.javabean.*;
import com.example.bibased.service.KoreacaiService;
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
public class KoreacaiController {
    @Autowired
    @Qualifier("koreacaiServiceImpl")
    private KoreacaiService koreacaiService;


    /**
     * 韩国菜的table查询
     * @param page
     * @param createTime
     * @param updataTime
     * @param caiming
     * @return
     */
    @RequestMapping("queryKoreaCai.action")
    public @ResponseBody BootstrapTablePageDTO queryPages(JqPage page, Date createTime, Date updataTime, String caiming) {
        KoreacaiMstExample criteria = new KoreacaiMstExample();
        KoreacaiMstExample.Criteria cri = criteria.createCriteria();
        if(createTime != null) {
            cri.andCreatetimeEqualTo(createTime);
        }
        if(updataTime != null) {
            cri.andCreatetimeLessThanOrEqualTo(updataTime);
        }
        if(caiming != "") {	//菜名
            cri.andCaimingEqualTo(caiming);
        }
        List<KoreacaiMst> list = koreacaiService.selectByExample(criteria);
        int count = this.koreacaiService.countByCriteria(criteria);
        BootstrapTablePageDTO bootTable = new BootstrapTablePageDTO(String.valueOf(count));
        bootTable.pageValue(page, list);
        bootTable.setPageSize(page.getPageSize() + "");
        return bootTable;
    }

    /**
     * 韩国菜的新增或修改
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
    @RequestMapping("addKoreaCai.action")
    public @ResponseBody Boolean ADDorUpdate(String id,String caiming,String img,String neirong1,String neirong2,String neirong3,String neirong4,String neirong5){
        Boolean rusult = true;
        KoreacaiMst koreacaiMst = new KoreacaiMst();
        koreacaiMst.setCaiming(caiming);
        koreacaiMst.setImg(img);
        koreacaiMst.setNeirong1(neirong1);
        koreacaiMst.setNeirong2(neirong2);
        koreacaiMst.setNeirong3(neirong3);
        koreacaiMst.setNeirong4(neirong4);
        koreacaiMst.setNeirong5(neirong5);
        koreacaiMst.setCreatetime(new Date());
        koreacaiMst.setUpdatetime(new Date());
        if(id == ""){
            //新增韩国菜
            koreacaiMst.setId(UUIDGenerator.create32Key());
            koreacaiService.insert(koreacaiMst);
        }else{
            koreacaiMst.setId(id);
            koreacaiService.update(koreacaiMst);
            //修改韩国菜
        }
        return  rusult;
    }

    /**
     * 批量删除韩国菜
     * @param ids
     * @return
     */
    @RequestMapping("deleteKoreaCai.action")
    public @ResponseBody
    boolean deleteTemplates(String ids) {
        String idArr[] = ids.split(",");
        List<KoreacaiMst> list = new ArrayList<KoreacaiMst>();
        for (int i = 0; i < idArr.length; i++) {
            KoreacaiMst koreacaiMst = new KoreacaiMst();
            koreacaiMst.setId(idArr[i]);
            list.add(koreacaiMst);
        }
        try {
            this.koreacaiService.batchDisabled(list);
            return true;
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 前端初始化时加载的韩国菜list
     */
    @RequestMapping("koreacaiCHU.action")
    public @ResponseBody List<KoreacaiMst> chuancaichushihualist(){
        KoreacaiMstExample criteria = new KoreacaiMstExample();
        KoreacaiMstExample.Criteria cri = criteria.createCriteria();
        List<KoreacaiMst> koreacaiMstList = koreacaiService.selectByExample(criteria);
        return  koreacaiMstList;
    }
}
