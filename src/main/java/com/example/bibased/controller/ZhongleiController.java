package com.example.bibased.controller;

import com.example.bibased.dto.BootstrapTablePageDTO;
import com.example.bibased.javabean.ZhongleiMst;
import com.example.bibased.javabean.ZhongleiMstExample;
import com.example.bibased.service.ZhongleiService;
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
public class ZhongleiController {
    @Autowired
    @Qualifier("zhongleiServiceImpl")
    private ZhongleiService zhongleiService;

    /**
     * 查询
     * @param page
     * @param caixi

     * @return
     */
    @RequestMapping("querycaixi.action")
    public @ResponseBody BootstrapTablePageDTO querytablecaixi(JqPage page, String caixi){
        ZhongleiMstExample criteria = new ZhongleiMstExample();
        ZhongleiMstExample.Criteria cri = criteria.createCriteria();
  /*      if(createTime != null) {
            cri.andCreatetimeEqualTo(createTime);
        }
        if(updateTime != null) {
            cri.andCreatetimeGreaterThanOrEqualTo(updateTime);
        }*/
        if(caixi != ""){
            cri.andCaixiEqualTo(caixi);
        }
        List<ZhongleiMst> list = zhongleiService.selectByExample(criteria);
        int count = this.zhongleiService.countByCriteria(criteria);
        BootstrapTablePageDTO bootTable = new BootstrapTablePageDTO(String.valueOf(count));
        bootTable.pageValue(page, list);
        bootTable.setPageSize(page.getPageSize() + "");
        return bootTable;
    }

    /**
     * 新增或修改
     * @param id
     * @param caixi
     * @param lishu
     * @param description
     * @return
     */
    @RequestMapping("addcaixi.action")
    public @ResponseBody String addorupdate(String id,String caixi,String lishu,String description){
        ZhongleiMst zhongleiMst = new ZhongleiMst();
        zhongleiMst.setCaixi(caixi);
        zhongleiMst.setLishu(lishu);
        zhongleiMst.setDescription(description);
        zhongleiMst.setCreatetime(new Date());
        zhongleiMst.setUpdatetime(new Date());
        if(id == ""){
            zhongleiMst.setId(UUIDGenerator.create32Key());
            zhongleiService.insert(zhongleiMst);
            return "true";
        }else{
            zhongleiMst.setId(id);
            zhongleiService.update(zhongleiMst);
            return "true";
        }
    }

    /**
     * 删除菜系种类
     * @param ids
     * @return
     */
    @RequestMapping("deletecaixi.action")
    public @ResponseBody boolean deleteTemplates(String ids) {
        String idArr[] = ids.split(",");
        List<ZhongleiMst> list = new ArrayList<ZhongleiMst>();
        for (int i = 0; i < idArr.length; i++) {
            ZhongleiMst zhongleiMst = new ZhongleiMst();
            zhongleiMst.setId(idArr[i]);
            list.add(zhongleiMst);
        }
        try {
            this.zhongleiService.batchDisabled(list);
            return true;
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
