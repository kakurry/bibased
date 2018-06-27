package com.example.bibased.controller;

import com.example.bibased.dto.BootstrapTablePageDTO;
import com.example.bibased.javabean.ChuancaiMst;
import com.example.bibased.javabean.ChuancaiMstExample;
import com.example.bibased.service.ChuancaiService;
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
public class ChuanCaiController {
    @Autowired
    @Qualifier("chuancaiServiceImpl")
    private ChuancaiService chuancaiService;

    /**
     * 川菜的table查询
     * @param page
     * @param createTime
     * @param updataTime
     * @param caiming
     * @return
     */
    @RequestMapping("queryChuanCai.action")
    public @ResponseBody
    BootstrapTablePageDTO queryPages(JqPage page, Date createTime, Date updataTime, String caiming) {
        ChuancaiMstExample criteria = new ChuancaiMstExample();
        ChuancaiMstExample.Criteria cri = criteria.createCriteria();
        if(createTime != null) {
            cri.andCreatetimeEqualTo(createTime);
        }
        if(updataTime != null) {
            cri.andCreatetimeLessThanOrEqualTo(updataTime);
        }
        if(caiming != "") {	//姓名
            cri.andCaimingEqualTo(caiming);
        }
        List<ChuancaiMst> list = chuancaiService.selectByExample(criteria);
        int count = this.chuancaiService.countByCriteria(criteria);
        BootstrapTablePageDTO bootTable = new BootstrapTablePageDTO(String.valueOf(count));
        bootTable.pageValue(page, list);
        bootTable.setPageSize(page.getPageSize() + "");
        return bootTable;
    }

    /**
     * 川菜的新增或修改
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
    @RequestMapping("addChuanCai.action")
    public @ResponseBody Boolean ADDorUpdate(String id,String caiming,String img,String neirong1,String neirong2,String neirong3,String neirong4,String neirong5){
        Boolean rusult = true;
        ChuancaiMst chuancaiMst = new ChuancaiMst();
        chuancaiMst.setCaiming(caiming);
        chuancaiMst.setImg(img);
        chuancaiMst.setNeirong1(neirong1);
        chuancaiMst.setNeirong2(neirong2);
        chuancaiMst.setNeirong3(neirong3);
        chuancaiMst.setNeirong4(neirong4);
        chuancaiMst.setNeirong5(neirong5);
        chuancaiMst.setCreatetime(new Date());
        chuancaiMst.setUpdatetime(new Date());
        if(id == ""){
            //新增店铺
            chuancaiMst.setId(UUIDGenerator.create32Key());
            chuancaiService.insert(chuancaiMst);
        }else{
            chuancaiMst.setId(id);
            chuancaiService.update(chuancaiMst);
            //修改店铺
        }
        return  rusult;
    }

    /**
     * 批量删除川菜
     * @param ids
     * @return
     */
    @RequestMapping("deleteChuanCai.action")
    public @ResponseBody
    boolean deleteTemplates(String ids) {
        String idArr[] = ids.split(",");
        List<ChuancaiMst> list = new ArrayList<ChuancaiMst>();
        for (int i = 0; i < idArr.length; i++) {
            ChuancaiMst chuancaiMst = new ChuancaiMst();
            chuancaiMst.setId(idArr[i]);
            list.add(chuancaiMst);
        }
        try {
            this.chuancaiService.batchDisabled(list);
            return true;
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 前端初始化时加载的川菜list
     */
    @RequestMapping("chuancaiCHU.action")
    public @ResponseBody List<ChuancaiMst> chuancaichushihualist(){
        ChuancaiMstExample criteria = new ChuancaiMstExample();
        ChuancaiMstExample.Criteria cri = criteria.createCriteria();
        List<ChuancaiMst> chuancaiMstList = chuancaiService.selectByExample(criteria);
        return  chuancaiMstList;
    }
}
