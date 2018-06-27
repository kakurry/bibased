package com.example.bibased.controller;

import com.example.bibased.dto.BootstrapTablePageDTO;
import com.example.bibased.javabean.ChuancaiMst;
import com.example.bibased.javabean.ChuancaiMstExample;
import com.example.bibased.javabean.XiangcaiMst;
import com.example.bibased.javabean.XiangcaiMstExample;
import com.example.bibased.service.XiangcaiService;
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
public class XiangcaiController {
    @Autowired
    @Qualifier("xiangcaiServiceImpl")
    private XiangcaiService xiangcaiService;

    /**
     * 湘菜的table查询
     * @param page
     * @param createTime
     * @param updataTime
     * @param caiming
     * @return
     */
    @RequestMapping("queryXiangCai.action")
    public @ResponseBody BootstrapTablePageDTO queryPages(JqPage page, Date createTime, Date updataTime, String caiming) {
        XiangcaiMstExample criteria = new XiangcaiMstExample();
        XiangcaiMstExample.Criteria cri = criteria.createCriteria();
        if(createTime != null) {
            cri.andCreatetimeEqualTo(createTime);
        }
        if(updataTime != null) {
            cri.andCreatetimeLessThanOrEqualTo(updataTime);
        }
        if(caiming != "") {	//菜名
            cri.andCaimingEqualTo(caiming);
        }
        List<XiangcaiMst> list = xiangcaiService.selectByExample(criteria);
        int count = this.xiangcaiService.countByCriteria(criteria);
        BootstrapTablePageDTO bootTable = new BootstrapTablePageDTO(String.valueOf(count));
        bootTable.pageValue(page, list);
        bootTable.setPageSize(page.getPageSize() + "");
        return bootTable;
    }

    /**
     * 湘菜的新增或修改
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
    @RequestMapping("addXiangCai.action")
    public @ResponseBody Boolean ADDorUpdate(String id,String caiming,String img,String neirong1,String neirong2,String neirong3,String neirong4,String neirong5){
        Boolean rusult = true;
        XiangcaiMst xiangcaiMst = new XiangcaiMst();
        xiangcaiMst.setCaiming(caiming);
        xiangcaiMst.setImg(img);
        xiangcaiMst.setNeirong1(neirong1);
        xiangcaiMst.setNeirong2(neirong2);
        xiangcaiMst.setNeirong3(neirong3);
        xiangcaiMst.setNeirong4(neirong4);
        xiangcaiMst.setNeirong5(neirong5);
        xiangcaiMst.setCreatetime(new Date());
        xiangcaiMst.setUpdatetime(new Date());
        if(id == ""){
            //新增湘菜
            xiangcaiMst.setId(UUIDGenerator.create32Key());
            xiangcaiService.insert(xiangcaiMst);
        }else{
            xiangcaiMst.setId(id);
            xiangcaiService.update(xiangcaiMst);
            //修改湘菜
        }
        return  rusult;
    }

    /**
     * 批量删除湘菜
     * @param ids
     * @return
     */
    @RequestMapping("deleteXiangCai.action")
    public @ResponseBody boolean deleteTemplates(String ids) {
        String idArr[] = ids.split(",");
        List<XiangcaiMst> list = new ArrayList<XiangcaiMst>();
        for (int i = 0; i < idArr.length; i++) {
            XiangcaiMst xiangcaiMst = new XiangcaiMst();
            xiangcaiMst.setId(idArr[i]);
            list.add(xiangcaiMst);
        }
        try {
            this.xiangcaiService.batchDisabled(list);
            return true;
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 前端初始化时加载的湘菜list
     */
    @RequestMapping("xiangcaiXIANG.action")
    public @ResponseBody List<XiangcaiMst> xiangcaichushihualist(){
        XiangcaiMstExample criteria = new XiangcaiMstExample();
        XiangcaiMstExample.Criteria cri = criteria.createCriteria();
        List<XiangcaiMst> xiangcaiMsts = xiangcaiService.selectByExample(criteria);
        return  xiangcaiMsts;
    }

}
