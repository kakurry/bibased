package com.example.bibased.controller;


import com.example.bibased.dto.BootstrapTablePageDTO;
import com.example.bibased.javabean.QianlinshiMst;
import com.example.bibased.javabean.UserMst;
import com.example.bibased.javabean.UserMstExample;
import com.example.bibased.service.QianlinshiService;
import com.example.bibased.service.UserService;
import com.example.bibased.util.JqPage;
import com.example.bibased.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @Autowired
    @Qualifier("qianlinshiServiceImpl")
    private QianlinshiService qianlinshiService;
    /**
     *
     * @param username
     * @param password
     * @return查询是否存在当前用户
     */
    @RequestMapping("login.action")
    public @ResponseBody Boolean saveOrUpdate(String username,String password) {
        /*开始进来就清空前端临时用户表*/
        qianlinshiService.delete();
        UserMstExample criteria = new UserMstExample();
        UserMstExample.Criteria cri = criteria.createCriteria();
        cri.andUsernameEqualTo(username);
        cri.andPasswordEqualTo(password);
        boolean result = true;
        int number = 0;
        number = userService.selectByusernameAndpassword(criteria);
        if(number > 0){
            List<UserMst> list = userService.selectByExample(criteria);
            for(UserMst aa : list){
                QianlinshiMst qianlinshiMst = new QianlinshiMst();
                qianlinshiMst.setId(aa.getId());
                qianlinshiMst.setEmail(aa.getEmail());
                qianlinshiMst.setTelephone(aa.getTelephone());
                qianlinshiMst.setPassword(aa.getPassword());
                qianlinshiMst.setUsername(aa.getUsername());
                qianlinshiService.insert(qianlinshiMst);
            }
            return result;
        }

        return false;
    }

    @RequestMapping("zhuce.action")
    public @ResponseBody Boolean saveOrUpdate(String username,String password,String telephone,String email) {
        UserMst userMst = new UserMst();
        userMst.setId(UUIDGenerator.create32Key());
        userMst.setUsername(username);
        userMst.setPassword(password);
        userMst.setTelephone(telephone);
        userMst.setEmail(email);
        boolean result = true;
        result = userService.insert(userMst);
        return result;
    }

    /**
     * 普通用户查询
     * @param page
     * @param username
     * @param telephone
     * @param email
     * @return
     */
    @RequestMapping("querytableuser.action")
    public @ResponseBody BootstrapTablePageDTO queryuser(JqPage page,String username, String telephone,String email) {
        UserMstExample criteria = new UserMstExample();
        UserMstExample.Criteria cri = criteria.createCriteria();
        if(username != ""){
            cri.andUsernameEqualTo(username);
        }
        if(telephone != ""){
            cri.andTelephoneEqualTo(telephone);
        }
        if(email != ""){
            cri.andEmailEqualTo(email);
        }
        List<UserMst> list = userService.selectByExample(criteria);
        int count = this.userService.countByCriteria(criteria);
        BootstrapTablePageDTO bootTable = new BootstrapTablePageDTO(String.valueOf(count));
        bootTable.pageValue(page, list);
        bootTable.setPageSize(page.getPageSize() + "");
        return bootTable;
    }

    @RequestMapping("adduser.action")
    public @ResponseBody String addorupdate(String id,String username,String password,String telephone,String email){
        UserMst userMst = new UserMst();
        userMst.setUsername(username);
        userMst.setPassword(password);
        userMst.setTelephone(telephone);
        userMst.setEmail(email);
        if(id == ""){
            userMst.setId(UUIDGenerator.create32Key());
            userService.insert(userMst);
        }else{
            userMst.setId(id);
            userService.update(userMst);
        }
        return "true";
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("deleteuser.action")
    public @ResponseBody boolean deleteTemplates(String ids) {
        String idArr[] = ids.split(",");
        List<UserMst> list = new ArrayList<UserMst>();
        for (int i = 0; i < idArr.length; i++) {
            UserMst userMst = new UserMst();
            userMst.setId(idArr[i]);
            list.add(userMst);
        }
        try {
            this.userService.batchDisabled(list);
            return true;
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 动态切换前台登录的用户
     * @return
     */
    @RequestMapping("dongtaiusername.action")
    public @ResponseBody QianlinshiMst quqianlinshiuser(){
        return qianlinshiService.selectqianlinshi();
    }

    /**
     * 注销
     * @return
     */
    @RequestMapping("zhuxiao.action")
    public @ResponseBody Boolean zhuxiao(){
        qianlinshiService.delete();
        return true;
    }

    /**
     * 查询后台的用户数量显示在index
     */
    @RequestMapping("chayonghushuliang.action")
    public @ResponseBody int chayonghushuliang(){
        UserMstExample criteria = new UserMstExample();
        UserMstExample.Criteria cri = criteria.createCriteria();
        return userService.countByCriteria(criteria);
    }
}
