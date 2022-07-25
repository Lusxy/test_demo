package com.gx.test_demo.controller;

import com.gx.test_demo.entity.CertificateType;
import com.gx.test_demo.entity.Member;
import com.gx.test_demo.entity.MemberType;
import com.gx.test_demo.service.ICertificateTypeService;
import com.gx.test_demo.service.IMemberService;
import com.gx.test_demo.service.IMemberTypeService;
import com.gx.test_demo.util.Tools;
import com.gx.test_demo.vo.SysMemberVo;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 会员 前端控制器
 * </p>
 *
 * @author Lucky
 * @since 2022-06-23
 */
@Controller
@RequestMapping("/member")
public class MemberController {

    //设置图片文件保存的路径
    private static final String UPLOAD_PATH_S="C:/Lucky/admin/Desktop/test/User_img/";
    @Autowired
    private IMemberTypeService memberTypeService;
    @Autowired
    private ICertificateTypeService certificateTypeService;
    private IMemberService MemberService;
    @Autowired
    public MemberController(IMemberService memberService) {
        MemberService = memberService;
    }

    /**
     * 开始页面【初始页面】
     * @param model
     * @return
     */
    @RequestMapping("/welcome")
    public String welcome(Model model){
        List<SysMemberVo> memberVo= MemberService.selectVoData();

        model.addAttribute("memberVo",memberVo);

        return  "test";
    }

    /**
     * 查询数据并返回页面
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String selectAll(Model model){
        List<SysMemberVo> memberVo= MemberService.selectVoData();

         model.addAttribute("memberVo",memberVo);

        return  "admin";
    }


    /**
     * 新增的页面
     * @param model
     * @return
     */
    @RequestMapping("/insert")
    public String insertView(Model model)
    {
        List<CertificateType> CerTypeList=this.certificateTypeService.selectAllCertificateType();
        List<MemberType> MemTypeList=this.memberTypeService.selectAllMemberType();
        model.addAttribute("CerTypeList",CerTypeList );
        model.addAttribute("MemTypeList",MemTypeList );
        return "insert";
    }

    /**
     * 保存新增的方法
     */
    @RequestMapping("/SaveInsert")
    public String SaveInsert(Member member, MultipartFile userImg) throws IOException {


        if(userImg!=null)
        {
            SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMdd_HHmmssSSS_");//获取当前的时间，用于文件路径前缀的拼接
            //判断文件存放目录是否存在
            File uploadDir=new File(UPLOAD_PATH_S);
            if (!uploadDir.exists()) {//.exists()方法用来检测文件是否存在
                uploadDir.mkdirs();//mkdirs()创建目录
            }
            //拼接文件名 item.getName()-->>文件名
            //.format()将日期对象格式化为指定格式的字符串   System.nanoTime()返回的是纳秒级精度的时间    .getFileExt()获得文件拓展名
            String fileName = dateFormat.format(new Date()) + System.nanoTime() + Tools.getFileExt(userImg.getOriginalFilename());

            //文件存放路径
            String filePaths = UPLOAD_PATH_S + fileName;
            File saveFile = new File(filePaths);

            userImg.transferTo(saveFile);

            //把文件的路径保存到po类中
            member.setPhoto(fileName);
            //调用新增的方法

            //获取当前时间
            LocalDateTime localDateTime = LocalDateTime.now ();
            member.setRegisterTime(localDateTime);

            int blr=this.MemberService.addMember(member);
            if(blr>0)
            {   //成功
                return "state/succeed";
            }else {//失败
                return "state/defeated";
            }
        }
        else
        {
            return "state/defeated";
        }
    }


    /**
     * 修改页面
     * @param id
     * @return
     */
    @RequestMapping("/update")
    public String updateView(String id,Model model)
    {
        Integer memberID=Integer.parseInt(id);
        List<CertificateType> CerTypeList=this.certificateTypeService.selectAllCertificateType();
        List<MemberType> MemTypeList=this.memberTypeService.selectAllMemberType();
        SysMemberVo memberVo=this.MemberService.selectById(memberID);
        model.addAttribute("memberVo",memberVo);
        model.addAttribute("CerTypeList",CerTypeList );
        model.addAttribute("MemTypeList",MemTypeList );
        return "update";
    }

    /**
     * 保存修改的方法
     * @param member
     * @return
     */
    @RequestMapping("/saveUpdate")
    public String saveUpdate(Member member,MultipartFile userImg) throws IOException {
        //根据id查询用户数据(需要用户原来保存的图片路径用于图片删除)
        SysMemberVo memberVo=this.MemberService.selectById(member.getMemberId());
        String imgString=userImg.getOriginalFilename();
        //判断用户有无上传图片
        if(imgString!="")
        {
            SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMdd_HHmmssSSS_");//获取当前的时间，用于文件路径前缀的拼接
            //判断文件存放目录是否存在
            File uploadDir=new File(UPLOAD_PATH_S);
            if (!uploadDir.exists()) {//.exists()方法用来检测文件是否存在
                uploadDir.mkdirs();//mkdirs()创建目录
            }
            //拼接文件名  item.getName()--》文件名
            String fileName = dateFormat.format(new Date()) + System.nanoTime() + Tools.getFileExt(userImg.getOriginalFilename());
            //存放路径
            String filePaths = UPLOAD_PATH_S + fileName;
            File saveFile = new File(filePaths);
            //保存文件到硬盘
            userImg.transferTo(saveFile);
            //有图片
            //删除旧照片
            String imgPath=UPLOAD_PATH_S+memberVo.getPhoto();
            File oldImg=new File(imgPath);
            if (oldImg.exists()){//检查文件路径是否存在
                oldImg.delete();//文件存在，执行删除
            }
            //将新照片的路径保存到数据库中
            member.setPhoto(fileName);
            //将时间数据返回
            member.setRegisterTime(memberVo.getRegisterTime());
            member.setPassword(memberVo.getPassword());
            //调用修改的方法
            int blr=this.MemberService.updateMember(member);
            if(blr>0)
            {   //成功
                return "state/succeed";
            }else {//失败
                return "state/defeated";
            }
        }
        else
        {
            //没有新图片上传，将数据库中保存的图片路径赋值，并且将保存
            member.setPhoto(memberVo.getPhoto());
            member.setRegisterTime(memberVo.getRegisterTime());
            member.setPassword(memberVo.getPassword());
            //调用修改的方法
            int blr=this.MemberService.updateMember(member);
            if(blr>0)
            {   //成功
                return "state/succeed";
            }else {//失败
                return "state/defeated";
            }
        }

    }


    /**
     * 删除的方法
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public String delete(String id)
    {
        Integer memberID=Integer.parseInt(id);
        Integer blr=this.MemberService.deleteMember(memberID);
        if(blr>0)
        {   //成功
            return "state/succeed";
        }else {//失败
            return "state/defeated";
        }
    }

    @RequestMapping(value = "/getPortraitImage/{userImage}",method =
            RequestMethod.GET)
    public void getPortraitImage(@PathVariable("userImage") String userImage, HttpServletResponse response) throws IOException {
        if (Tools.isNotNull(userImage)){
            String imgPath=UPLOAD_PATH_S+userImage;
            File fileImg=new File(imgPath);
            if (fileImg.exists()){
                //指定返的类型
                response.setContentType(Tools.getImageContentType(userImage));

                InputStream in=null;
                OutputStream out=null;
                try {
                    in= new FileInputStream(fileImg);
                    out=response.getOutputStream();
                    IOUtils.copy(in,out);
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (in!=null)in.close();
                    if (out!=null)out.close();
                }
            }
        }
    }






}
