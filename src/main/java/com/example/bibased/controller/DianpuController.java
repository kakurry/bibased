package com.example.bibased.controller;

import com.example.bibased.dto.BootstrapTablePageDTO;
import com.example.bibased.javabean.DianpuMst;
import com.example.bibased.javabean.DianpuMstExample;
import com.example.bibased.service.DianpuService;
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
public class DianpuController {
    @Autowired
    @Qualifier("dianpuServiceImpl")
    private DianpuService dianpuService;

    /**
     * 店铺的table查询
     * @param page
     * @param createTime
     * @param updataTime
     * @param dianming
     * @return
     */
    @RequestMapping("queryDianPu.action")
    public @ResponseBody  BootstrapTablePageDTO queryPages(JqPage page, Date createTime, Date updataTime, String dianming) {
        DianpuMstExample criteria = new DianpuMstExample();
        DianpuMstExample.Criteria cri = criteria.createCriteria();
        if(createTime != null) {
            cri.andCreatetimeEqualTo(createTime);
        }
        if(updataTime != null) {
            cri.andCreatetimeLessThanOrEqualTo(updataTime);
        }
        if(dianming != "") {	//姓名
            cri.andDianmingEqualTo(dianming);
        }
        List<DianpuMst> list = dianpuService.selectByExample(criteria);
        int count = this.dianpuService.countByCriteria(criteria);
        BootstrapTablePageDTO bootTable = new BootstrapTablePageDTO(String.valueOf(count));
        bootTable.pageValue(page, list);
        bootTable.setPageSize(page.getPageSize() + "");
        return bootTable;
    }

    /**
     * 新增或修改店铺
     * @param id
     * @param dianming
     * @param img
     * @param neirong1
     * @param neirong2
     * @param neirong3
     * @param dizhi
     * @return
     */
    @RequestMapping("addDianPu.action")
    public @ResponseBody Boolean ADDorUpdate(String id,String dianming,String img,String neirong1,String neirong2,String neirong3,String dizhi){
        Boolean rusult = true;
        DianpuMst dianpuMst = new DianpuMst();
        dianpuMst.setDianming(dianming);
        dianpuMst.setDizhi(dizhi);
        dianpuMst.setImg(img);
        dianpuMst.setNeirong1(neirong1);
        dianpuMst.setNeirong2(neirong2);
        dianpuMst.setNeirong3(neirong3);
        dianpuMst.setCreatetime(new Date());
        dianpuMst.setUpdatetime(new Date());
        if(id == ""){
            //新增店铺
            dianpuMst.setId(UUIDGenerator.create32Key());
            dianpuService.insert(dianpuMst);
        }else{
            dianpuMst.setId(id);
            dianpuService.update(dianpuMst);
            //修改店铺
        }
        return  rusult;
    }

    /**
     * 批量删除店铺
     * @param ids
     * @return
     */
    @RequestMapping("deleteDianPu.action")
    public @ResponseBody boolean deleteTemplates(String ids) {
        String idArr[] = ids.split(",");
        List<DianpuMst> list = new ArrayList<DianpuMst>();
        for (int i = 0; i < idArr.length; i++) {
            DianpuMst dianpuMst = new DianpuMst();
            dianpuMst.setId(idArr[i]);
            list.add(dianpuMst);
        }
        try {
            this.dianpuService.batchDisabled(list);
            return true;
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 前端的店铺数据查询
     * @return
     */
    @RequestMapping("qianduandianpu.action")
    public @ResponseBody List<DianpuMst> qianduanquerydainpu(){
        DianpuMstExample criteria = new DianpuMstExample();
        DianpuMstExample.Criteria cri = criteria.createCriteria();
        List<DianpuMst> dianpuMstList = dianpuService.selectByExample(criteria);
        return dianpuMstList;
    }

    /**
     * 前端的点评里的店铺数据查询
     * @return
     */
    @RequestMapping("dianpingDianPuquery.action")
    public @ResponseBody List<DianpuMst> dianpingDianPuquery(){
        DianpuMstExample criteria = new DianpuMstExample();
        DianpuMstExample.Criteria cri = criteria.createCriteria();
        List<DianpuMst> dianpuMstList = dianpuService.selectByExample(criteria);
        return dianpuMstList;
    }
}
