package com.example.bibased.controller;

import com.example.bibased.dto.BootstrapTablePageDTO;
import com.example.bibased.excelutil.ExcelUtil;
import com.example.bibased.excelutil.StringUtil;
import com.example.bibased.javabean.GuanliyuanuserMst;
import com.example.bibased.javabean.GuanliyuanuserMstExample;
import com.example.bibased.javabean.LingshiMst;
import com.example.bibased.service.GuanliyuanService;
import com.example.bibased.service.LingshiService;
import com.example.bibased.util.JqPage;
import com.example.bibased.util.Pdf2Image;
import com.example.bibased.util.UUIDGenerator;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.FileOutputStream;
import java.util.*;
import java.util.List;

@RestController
public class GuanliyuanController {
    @Autowired
    @Qualifier("guanliyuanServiceImpl")
    private GuanliyuanService guanliyuanService;

    @Autowired
    @Qualifier("lingshiServiceImpl")
    private LingshiService lingshiService;

    /**
     * <p>Title: queryPages</p>
     * <p>Description: 列表页分页数据</p>
     * @author hdx
     */
    @RequestMapping("querytable.action")
    public @ResponseBody BootstrapTablePageDTO queryPages(JqPage page,int pageNo,int pageSize , Date creatTime,Date updataTime,String name,String nicheng,String gonghao) {
        GuanliyuanuserMstExample criteria = new GuanliyuanuserMstExample();
        GuanliyuanuserMstExample.Criteria cri = criteria.createCriteria();
        if(creatTime != null) {
            cri.andCreattimeEqualTo(creatTime);
        }
        if(updataTime != null) {
            cri.andCreattimeGreaterThanOrEqualTo(updataTime);
        }
        if(name != "") {	//姓名
            cri.andNameEqualTo(name);
        }
        if(nicheng != "") {	//昵称
            cri.andNichengEqualTo(nicheng);
        }
        if(gonghao != "") {	//工号
            cri.andGonghaoEqualTo(gonghao);
        }
       // List<GuanliyuanuserMst> list1 = guanliyuanService.selectByCriteriaPage(criteria,(page.getPageNo() - 1) * page.getPageSize(),page.getPageSize());
        List<GuanliyuanuserMst> list = guanliyuanService.selectByExample(criteria);
        int count = this.guanliyuanService.countByCriteria(criteria);
        BootstrapTablePageDTO bootTable = new BootstrapTablePageDTO(String.valueOf(count));
        bootTable.pageValue(page, list);
        bootTable.setPageSize(page.getPageSize() + "");
        return bootTable;
    }

    /**
     * 管理员新增或修改
     * @param id
     * @param name
     * @param nicheng
     * @param gonghao
     * @param dizhi
     * @param telephone
     * @param email
     * @param description
     * @param password
     * @return
     */
    @RequestMapping("add.action")
    public @ResponseBody String saveOrUpdate(String id,String name,String nicheng,String gonghao,String dizhi,String telephone,String email,String description, String password,String status) {
        GuanliyuanuserMstExample criteria = new GuanliyuanuserMstExample();
        GuanliyuanuserMstExample.Criteria cri = criteria.createCriteria();
        cri.andNameEqualTo(name);
        int number = 0;
        number = guanliyuanService.yanchongByname(criteria);
        if(number > 0){
            return "repeat";
        }
        GuanliyuanuserMst gly = new GuanliyuanuserMst();
        gly.setName(name);
        gly.setPassword(password);
        gly.setNicheng(nicheng);
        gly.setGonghao(gonghao);
        gly.setEmail(email);
        gly.setTelephone(telephone);
        gly.setDizhi(dizhi);
        gly.setDescription(description);
        gly.setCreattime(new Date());
        gly.setUpdatetime(new Date());
        gly.setStatus(status);
        String result = "true";
        if(id == ""){
            gly.setId(UUIDGenerator.create32Key());
            guanliyuanService.insert(gly);
        }else{
            gly.setId(id);
            guanliyuanService.update(gly);
        }
        return result;
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("delete.action")
    public @ResponseBody boolean deleteTemplates(String ids) {
        String idArr[] = ids.split(",");
        List<GuanliyuanuserMst> list = new ArrayList<GuanliyuanuserMst>();
        for (int i = 0; i < idArr.length; i++) {
            GuanliyuanuserMst guanliyuanuserMst = new GuanliyuanuserMst();
            guanliyuanuserMst.setId(idArr[i]);
            list.add(guanliyuanuserMst);
        }
        try {
            this.guanliyuanService.batchDisabled(list);
            return true;
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("guanliyuanlogin.action")
    public @ResponseBody Boolean loginguanliyuan(String name,String password){
        /*开始进来就清空临时表*/
        lingshiService.delete();
        GuanliyuanuserMstExample criteria = new GuanliyuanuserMstExample();
        GuanliyuanuserMstExample.Criteria cri = criteria.createCriteria();
        cri.andNameEqualTo(name);
        cri.andPasswordEqualTo(password);
        boolean result = true;
        int number = 0;
        number = guanliyuanService.selectBynameAndpassword(criteria);
        if(number > 0){
            List<GuanliyuanuserMst> list = guanliyuanService.selectByExample(criteria);
            for (GuanliyuanuserMst aa : list){
                LingshiMst lingshiMst = new LingshiMst();
                lingshiMst.setId(aa.getId());
                lingshiMst.setCreattime(aa.getCreattime());
                lingshiMst.setDescription(aa.getDescription());
                lingshiMst.setDizhi(aa.getDizhi());
                lingshiMst.setEmail(aa.getEmail());
                lingshiMst.setErweima(aa.getErweima());
                lingshiMst.setGonghao(aa.getGonghao());
                lingshiMst.setName(aa.getName());
                lingshiMst.setNicheng(aa.getNicheng());
                lingshiMst.setPassword(aa.getPassword());
                lingshiMst.setTelephone(aa.getTelephone());
                lingshiMst.setUpdatetime(aa.getUpdatetime());
                lingshiMst.setStatus(aa.getStatus());
                lingshiService.insert(lingshiMst);
            }

            return result;
        }

        return false;
    }

    /**
     * 查询临时表中动态的登录用户
     * @return
     */
    @RequestMapping("dongtaiuser.action")
    public @ResponseBody LingshiMst loginguanliyuan(){
        return lingshiService.select();
    }

    /**
     * 注销管理员
     * @return
     */
    @RequestMapping("zhuxiaohoutai.action")
    public @ResponseBody Boolean zhuxiaohoutai(){
        lingshiService.delete();
        return true;
    }

    /**
     * 管理员表导出Excel
     * @param response
     * @return
     */
    @RequestMapping("daochu.action")
    public @ResponseBody void Daochu(HttpServletResponse response){
        GuanliyuanuserMstExample criteria = new GuanliyuanuserMstExample();
        criteria.createCriteria();
        List<GuanliyuanuserMst> list = guanliyuanService.selectByExample(criteria);

        //excel标题
        String[] title = {"姓名","密码","工号","昵称","电话号码","地址","邮箱","描述","状态"};
        String[][] content = new String[list.size()][];
        //excel文件名
        String fileName = "管理员信息表"+System.currentTimeMillis()+".xls";//System.currentTimeMillis()当前时间的秒数
        //sheet名
        String sheetName = "管理员信息表";
        for (int i = 0; i < list.size(); i++) {
            content[i] = new String[title.length];
            GuanliyuanuserMst obj = list.get(i);
            if(StringUtils.isNotBlank(obj.getName())) {
                content[i][0] = obj.getName().toString();
            }else {
                content[i] = new String[title.length];
                continue;
            }
            if(StringUtils.isNotBlank(obj.getPassword())) {
                content[i][1] = obj.getPassword().toString();
            }else {
                content[i] = new String[title.length];
                continue;
            }
            if(StringUtils.isNotBlank(obj.getGonghao())) {
                content[i][2] = obj.getGonghao().toString();
            }else {
                content[i] = new String[title.length];
                continue;
            }
            if(StringUtils.isNotBlank(obj.getNicheng())) {
                content[i][3] = obj.getNicheng().toString();
            }else {
                content[i] = new String[title.length];
                continue;
            }
            if(StringUtils.isNotBlank(obj.getTelephone())) {
                content[i][4] = obj.getTelephone().toString();
            }else {
                content[i] = new String[title.length];
                continue;
            }
            if(StringUtils.isNotBlank(obj.getDizhi())) {
                content[i][5] = obj.getDizhi().toString();
            }else {
                content[i] = new String[title.length];
                continue;
            }
            if(StringUtils.isNotBlank(obj.getEmail())) {
                content[i][6] = obj.getEmail().toString();
            }else {
                content[i] = new String[title.length];
                continue;
            }

            if(StringUtils.isNotBlank(obj.getDescription())) {
                content[i][7] = obj.getDescription().toString();
            }else {
                content[i] = new String[title.length];
                continue;
            }
            if(StringUtils.isNotBlank(obj.getStatus())) {
                content[i][8] = obj.getStatus().toString();
            }else {
                content[i] = new String[title.length];
                continue;
            }
        }
        //创建HSSFWorkbook
        ExcelUtil.getHSSFWorkbook(response,fileName,sheetName, title, content, null);

//        return true;
    }

    /**
     * 管理员Excel批量导入
     * @return
     */
    @RequestMapping("upload.action")
    public @ResponseBody String Daoru(@RequestParam(value="file",required=false) MultipartFile[] files, HttpServletResponse resp, HttpServletRequest request){
        /*后面加了让他图片上显示水印start*/
        /**
         * @param srcImgPath 源图片路径
         * @param tarImgPath 保存的图片路径
         * @param waterMarkContent 水印内容
         * @param markContentColor 水印颜色
         * @param font 水印字体
         */
        Font font = new Font("微软雅黑", Font.PLAIN, 35);                     //水印字体
        //String srcImgPath="C:/Users/Administrator/Desktop/文件上传资料/9e9f470d1d53f39f505a33836e9233c9.jpg"; //源图片地址
        //String tarImgPath="H:/安静时写写/写写博客/Java实现给图片添加水印/t.jpg"; //待存储的地址
        String waterMarkContent="图片来源：http://blog.csdn.net/zjq_1314520";  //水印内容
        Color color=new Color(255,255,255,128);                               //水印图片色彩以及透明度
        //String markContentColor = "red";
        /*后面加了让他图片上显示水印end*/

        //获取文件上传绝对路径
        String uploadPath = "E:\\abc";
        resp.setContentType("text/html");
        File baseFile = new File(uploadPath);
        String fileName = "";
        if(!baseFile.exists()){
            baseFile.mkdirs();
        }
        try{
            if(files!=null){
                for(int i=0;i<files.length;i++){
                    if(StringUtil.isblank(files[i].getOriginalFilename())){
                        continue;
                    }
                    fileName = files[i].getOriginalFilename();
                    String filePath =  uploadPath + "/" + fileName;
                    files[i].transferTo(new File(filePath));

                    /*后面加了让他图片上显示水印start*/
                    // 读取原图片信息
                    File srcImgFile = new File(filePath);//得到文件
                    Image srcImg = ImageIO.read(srcImgFile);//文件转化为图片
                    int srcImgWidth = srcImg.getWidth(null);//获取图片的宽
                    int srcImgHeight = srcImg.getHeight(null);//获取图片的高
                    // 加水印
                    BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
                    Graphics2D g = bufImg.createGraphics();
                    g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
                    //g.setColor(markContentColor); //根据图片的背景设置水印颜色
                    g.setFont(font);              //设置字体

                    //设置水印的坐标
                    /*int x = srcImgWidth - 2*getWatermarkLength(waterMarkContent, g);
                    int y = srcImgHeight - 2*getWatermarkLength(waterMarkContent, g);*/
                    int x = 50;
                    int y = 50;
                    g.drawString(waterMarkContent, x, y);  //画出水印
                    g.dispose();
                    // 输出图片
                    FileOutputStream outImgStream = new FileOutputStream("E:\\"+fileName);
                    ImageIO.write(bufImg, "jpg", outImgStream);
                    System.out.println("添加水印完成");
                    outImgStream.flush();
                    outImgStream.close();
                    /*后面加了让他图片上显示水印end*/
                }
            }
            resp.flushBuffer();
            //遍历本地的excel，获取sheet名称以及sheet在poi中的值
            String localPath = uploadPath+ "/" + fileName;
            //List<ExcelModel> sheetName = ExcelUtil.getSheetName(localPath);

            //String list2json = JsonChangeUtil.list2json(sheetName);
           /* return JsonChangeUtil.string2json(this.importExcel(localPath));*/
        }catch(Exception e){
            return null;
        }
        return "true";
    }

    public int getWatermarkLength(String waterMarkContent, Graphics2D g) {
        return g.getFontMetrics(g.getFont()).charsWidth(waterMarkContent.toCharArray(), 0, waterMarkContent.length());
    }

    /**
     * pdf切图
     * @param files
     * @param resp
     * @param request
     * @return
     */
    @RequestMapping("qietu.action")
    public @ResponseBody String qietu(@RequestParam(value="file",required=false) MultipartFile[] files, HttpServletResponse resp, HttpServletRequest request){

        //获取文件上传绝对路径
        String uploadPath = "E:\\abc";
        resp.setContentType("text/html");
        File baseFile = new File(uploadPath);
        String fileName = "";
        if(!baseFile.exists()){
            baseFile.mkdirs();
        }
        try{
            if(files!=null){
                for(int i=0;i<files.length;i++){
                    if(StringUtil.isblank(files[i].getOriginalFilename())){
                        continue;
                    }
                    fileName = files[i].getOriginalFilename();
                    String filePath =  uploadPath + "/" + fileName;
                    files[i].transferTo(new File(filePath));


                    //切图
                    String qietupath = "E:\\pdfQieTu";
                    File qietu = new File(qietupath);
                    if(!qietu.exists()){
                        qietu.mkdirs();
                    }
                    File filepathfile = new File(filePath);
                    Pdf2Image.conver(filepathfile , qietu, 1);
                }
            }
            resp.flushBuffer();
        }catch(Exception e){
            return null;
        }
        return "true";
    }


}
