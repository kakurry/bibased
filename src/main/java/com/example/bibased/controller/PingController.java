package com.example.bibased.controller;

import com.example.bibased.dto.BootstrapTablePageDTO;
import com.example.bibased.javabean.*;
import com.example.bibased.service.*;
import com.example.bibased.util.JqPage;
import com.example.bibased.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理前端评论的的controller
 */
@RestController
public class PingController {
    @Autowired
    @Qualifier("pinglunServiceImpl")
    private PinglunService pinglunService;

    @Autowired
    @Qualifier("zhongleiServiceImpl")
    private ZhongleiService zhongleiService;

    @Autowired
    @Qualifier("chuancaiServiceImpl")
    private ChuancaiService chuancaiService;

    @Autowired
    @Qualifier("yuecaiServiceImpl")
    private YuecaiService yuecaiService;

    @Autowired
    @Qualifier("xiangcaiServiceImpl")
    private XiangcaiService xiangcaiService;

    @Autowired
    @Qualifier("koreacaiServiceImpl")
    private KoreacaiService koreacaiService;

    @Autowired
    @Qualifier("japancaiServiceImpl")
    private JapancaiService japancaiService;

    @Autowired
    @Qualifier("frencaiServiceImpl")
    private FrenchcaiService frenchcaiService;

    @Autowired
    @Qualifier("huipingServiceImpl")
    private HuipingService huipingService;

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    /**
     * 新增或修改评论
     * @param content
     * @param people
     * @return
     */
    @RequestMapping("pinlunbaocun.action")
    public @ResponseBody Boolean pinglun(String content,String people){
        PinglunMstExample criteria = new PinglunMstExample();
        PinglunMstExample.Criteria cri = criteria.createCriteria();
        cri.andPeopleEqualTo(people);
        int number = 0;
        boolean result = true;
        number = pinglunService.countPinglun(criteria);
        PinglunMst pinglunMst = new PinglunMst();
        pinglunMst.setContent(content);
        pinglunMst.setPeople(people);
        if(number > 0){
            PinglunMst pinglunMst1 = new PinglunMst();
            pinglunMst1 = pinglunService.selectCunZai(people);
            pinglunMst.setId(pinglunMst1.getId());
            //修改评论
            result = pinglunService.update(pinglunMst);
        }else{
            pinglunMst.setId(UUIDGenerator.create32Key());
            //新增评论
            result = pinglunService.insert(pinglunMst);
        }
        return result;
    }

    /**
     * 查找当前用户是否已经评论过，评论过显示在富文本编辑器中
     */
    @RequestMapping("chazhao.action")
    public @ResponseBody PinglunMst chazhao(String people){
        PinglunMst pinglunMst = new PinglunMst();
        pinglunMst = pinglunService.selectCunZai(people);
        if(pinglunMst.getPeople() != ""){
            return pinglunMst;
        }
        return pinglunMst;
    }

    /**
     * 点评页面的国家查询
     * @return
     */
    @RequestMapping("guojiaquery.action")
    public @ResponseBody  List<ZhongleiMst> chaxunguojia(){
        ZhongleiMstExample criteria = new ZhongleiMstExample();
        ZhongleiMstExample.Criteria cri = criteria.createCriteria();
        return  zhongleiService.selectByExample(criteria);
    }

    /**
     * 点评页面的菜系查询
     * @return
     */
    @RequestMapping("zhongleiFUquery.action")
    public @ResponseBody  List<ZhongleiMst> caixiquery(String lishu){
        ZhongleiMstExample criteria = new ZhongleiMstExample();
        ZhongleiMstExample.Criteria cri = criteria.createCriteria();
        if(lishu != ""){
            cri.andLishuEqualTo(lishu);
        }
        return  zhongleiService.selectByExample(criteria);
    }

    /**
     * 点评页面的菜系_菜名查询
     * @return
     */
    @RequestMapping("caimingFUquery.action")
    public @ResponseBody  List<ChuancaiMst> caimingquery(String caixi){
        ChuancaiMstExample criteria = new ChuancaiMstExample();
        ChuancaiMstExample.Criteria cri = criteria.createCriteria();
        return  chuancaiService.selectByExample(criteria);
    }

    @RequestMapping("caimingXIANGquery.action")
    public @ResponseBody  List<XiangcaiMst> caimingXIANGquery(String caixi){
        XiangcaiMstExample criteria = new XiangcaiMstExample();
        XiangcaiMstExample.Criteria cri = criteria.createCriteria();
        return  xiangcaiService.selectByExample(criteria);
    }

    @RequestMapping("caimingYUEquery.action")
    public @ResponseBody  List<YuecaiMst> caimingYUEquery(String caixi){
        YuecaiMstExample criteria = new YuecaiMstExample();
        YuecaiMstExample.Criteria cri = criteria.createCriteria();
        return  yuecaiService.selectByExample(criteria);
    }

    @RequestMapping("caimingKOREAquery.action")
    public @ResponseBody  List<KoreacaiMst> caimingKOREAquery(String caixi){
        KoreacaiMstExample criteria = new KoreacaiMstExample();
        KoreacaiMstExample.Criteria cri = criteria.createCriteria();
        return  koreacaiService.selectByExample(criteria);
    }

    @RequestMapping("caimingJAPANquery.action")
    public @ResponseBody  List<JapancaiMst> caimingJAPANquery(String caixi){
        JapancaiMstExample criteria = new JapancaiMstExample();
        JapancaiMstExample.Criteria cri = criteria.createCriteria();
        return  japancaiService.selectByExample(criteria);
    }
    @RequestMapping("caimingFRENCHquery.action")
    public @ResponseBody  List<FrenchcaiMst> caimingFRENCHquery(String caixi){
        FrenchcaiMstExample criteria = new FrenchcaiMstExample();
        FrenchcaiMstExample.Criteria cri = criteria.createCriteria();
        return  frenchcaiService.selectByExample(criteria);
    }

    /**
     * 查询所有的评论
     */
    @RequestMapping("queryALLpinglun.action")
    public @ResponseBody List<PinglunMst> queryAllpinglun(){
        PinglunMstExample criteria = new PinglunMstExample();
        PinglunMstExample.Criteria cri = criteria.createCriteria();
        return  pinglunService.selectByExample(criteria);
    }

    /**
     * 查看有多少条留言
     */
    @RequestMapping("queryALLpinglunCount.action")
    public @ResponseBody int queryAllPingLunCount(){
        PinglunMstExample criteria = new PinglunMstExample();
        PinglunMstExample.Criteria cri = criteria.createCriteria();
        return pinglunService.countPinglunALL(criteria);
    }

    /**
     * 保存回评
     * @param content
     * @param people
     * @param yuanpeople
     * @return
     */
    @RequestMapping("huifupinglunbaocun.action")
    public @ResponseBody Boolean huifupinglunbaocun(String content,String people,String yuanpeople){
        HuipingMst huipingMst = new HuipingMst();
        huipingMst.setId(UUIDGenerator.create32Key());
        huipingMst.setContent(content);
        huipingMst.setNewuser(people);
        huipingMst.setYuanuser(yuanpeople);
        huipingService.insert(huipingMst);
        return true;
    }

    /**
     * 前端显示回评
     * @param people
     * @param yuanpeople
     * @return
     */
    @RequestMapping("queryhuiping.action")
    public @ResponseBody List<HuipingMst> huipingquery(String people,String yuanpeople){
        HuipingMstExample criteria = new HuipingMstExample();
        HuipingMstExample.Criteria cri = criteria.createCriteria();
        if(people != ""){
            cri.andNewuserEqualTo(people);
        }
        if(yuanpeople != ""){
            cri.andYuanuserEqualTo(yuanpeople);
        }
        return  huipingService.selectByExample(criteria);
    }

    /**
     * 评论管理的评论人查询
     *
     * @return
     */
    @RequestMapping("querypinglunpeople.action")
    public @ResponseBody List<UserMst> querypinglunpeople(){
        UserMstExample criteria = new UserMstExample();
        UserMstExample.Criteria cri = criteria.createCriteria();
        return userService.selectByExample(criteria);
    }

    /**
     * 评论管理的查询
     * @param page
     * @param people
     * @param content
     * @return
     */
    @RequestMapping("pinglunhoutaiQuery.action")
    public @ResponseBody BootstrapTablePageDTO pinglunhoutaiQuery(JqPage page,String people,String content){
        PinglunMstExample criteria = new PinglunMstExample();
        PinglunMstExample.Criteria cri = criteria.createCriteria();
        if(people != ""){
            cri.andPeopleEqualTo(people);
        }
        if(content != ""){
            cri.andContentLike("%" + content + "%");
        }
        List<PinglunMst> list = pinglunService.selectByExample(criteria);
        int count = this.pinglunService.countByCriteria(criteria);
        BootstrapTablePageDTO bootTable = new BootstrapTablePageDTO(String.valueOf(count));
        bootTable.pageValue(page, list);
        bootTable.setPageSize(page.getPageSize() + "");
        return bootTable;
    }

    /**
     * 新增评论管理
     * @param people
     * @param content
     * @return
     */
    @RequestMapping("addpinglunhoutai.action")
    public @ResponseBody String addpinglunguanli(String id,String people,String content){
        PinglunMst pinglunMst = new PinglunMst();
        pinglunMst.setPeople(people);
        pinglunMst.setContent(content);
        if(id != ""){
            pinglunMst.setId(id);
            pinglunService.update(pinglunMst);
        }else{
            pinglunMst.setId(UUIDGenerator.create32Key());
            pinglunService.insert(pinglunMst);
        }
        return "true";
    }
    /**
     * 删除评论管理
     */
    @RequestMapping("deletepinglunhoutai.action")
    public @ResponseBody  boolean deletepinglunhoutai (String ids){
        String idArr[] = ids.split(",");
        List<PinglunMst> list = new ArrayList<PinglunMst>();
        for (int i = 0; i < idArr.length; i++) {
            PinglunMst pinglunMst = new PinglunMst();
            pinglunMst.setId(idArr[i]);
            list.add(pinglunMst);
        }
        try {
            this.pinglunService.batchDisabled(list);
            return true;
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 菜品详情里的评论展示查询
     * @param content
     * @return
     */
    @RequestMapping("caipingxiangqingPingLun.action")
    public @ResponseBody List<PinglunMst> caipingxiangqingPingLun(String content){
        PinglunMstExample criteria = new PinglunMstExample();
        PinglunMstExample.Criteria cri = criteria.createCriteria();
        cri.andContentLike("%" + content + "%");
        return  pinglunService.selectByExample(criteria);
    }

    @RequestMapping("caipinxiangqingpinlunbaocun.action")
    public @ResponseBody Boolean caipinxiangqingpinlunbaocun(String content,String people){
        PinglunMst pinglunMst = new PinglunMst();
        pinglunMst.setId(UUIDGenerator.create32Key());
        pinglunMst.setContent(content);
        pinglunMst.setPeople(people);
        try {
            pinglunService.insert(pinglunMst);
            return true;
        }catch (Exception e){
            return  false;
        }
    }

    /**
     * 查询整个回评的list
     * @return
     */
    @RequestMapping("huipingAlllist.action")
    public @ResponseBody List<HuipingMst> huipingqueryAlllist(){
        HuipingMstExample criteria = new HuipingMstExample();
        HuipingMstExample.Criteria cri = criteria.createCriteria();
        return  huipingService.selectByExample(criteria);
    }
}

