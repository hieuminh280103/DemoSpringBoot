package vn.hieuminh.spring6.Project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.hieuminh.spring6.Project.dao.UserRepository;
import vn.hieuminh.spring6.Project.entity.Information;
import vn.hieuminh.spring6.Project.entity.Password;
import vn.hieuminh.spring6.Project.entity.Staff;
import vn.hieuminh.spring6.Project.entity.User;
import vn.hieuminh.spring6.Project.service.MyService;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private MyService myService;

    @Autowired
    public UserController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/create")
    public String createUser(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "user/user-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("user")User user,Model model){
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        User userExisting = this.myService.findUserByUsername(user.getUsername());
        if(userExisting!=null){
            model.addAttribute("error1","Username đã tồn tại !");
            return "user/user-form";
        }
        if(!(user.getRole().equals("ROLE_TEACHER")||user.getRole().equals("ROLE_MANAGER")||user.getRole().equals("ROLE_FORMTEACHER"))){
            model.addAttribute("error2","Vui lòng nhập 1 trong 3 role : ROLE_TEACHER, ROLE_MANAGER, ROLE_FORMTEACHER");
            return "user/user-form";
        }

        user.setEnable(true);
        String password ="{bcrypt}"+bCrypt.encode(user.getPassword());
        user.setPassword(password);
        model.addAttribute("success","Tạo user thành công !");

        this.myService.saveUser(user);
        return "user/user-form";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<User> list = this.myService.getAllUser();
        model.addAttribute("users",list);
        return "user/users";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id")String username){
        this.myService.deleteUserByUsername(username);
        return "redirect:/user/list";
    }

    @GetMapping("/information")
    public String information( Model model, Authentication authentication){
        String username = authentication.getName();
        User user = this.myService.findUserByUsername(username);
        model.addAttribute("user",user);
        return "user/user-information";
    }

    @GetMapping("/list/information")
    public String informationUserList( Model model, @RequestParam("username") String username){
        User user = this.myService.findUserByUsername(username);
        model.addAttribute("user",user);
        return "user/user-information";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("user")User user, @RequestParam("username")String username, Model model){
//        ,@RequestParam("idStaff")long idStaff, @RequestParam("idInformation")long idInformation

        User user1 = this.myService.findUserByUsername(username);
        if(user1.getStaff()==null){

            Information information = this.myService.updateInformation(user.getStaff().getInformation());
            Staff staff = new Staff();
            staff.setInformation(information);
            Staff staff1 = this.myService.updateStaff(staff);
            user1.setStaff(staff1);
            this.myService.updateUser(user1);

            model.addAttribute("success","Cập nhật thông tin thành công !");
            return "user/user-information";
        }


//        Staff staff = this.myService.findStaffById(idStaff);
//        Information information = this.myService.findInformationById(idInformation);
        Staff staff = this.myService.findStaffByUsername(username);
        Information information = this.myService.findInformationByStaffId(staff.getId());


        information.setName(user.getStaff().getInformation().getName());
        information.setAddress(user.getStaff().getInformation().getAddress());
        information.setGender(user.getStaff().getInformation().getGender());
        information.setDate(user.getStaff().getInformation().getDate());
        information.setHobby(user.getStaff().getInformation().getHobby());
        information.setPhoneNumber(user.getStaff().getInformation().getPhoneNumber());
        information.setAvatar(user.getStaff().getInformation().getAvatar());
        this.myService.updateInformation(information);

        staff.setInformation(information);
        this.myService.updateStaff(staff);

        user1.setStaff(staff);
        this.myService.updateUser(user1);
        model.addAttribute("success","Cập nhật thông tin thành công !");
        return "user/user-information";
    }

    @GetMapping("/change-password")
    public String changePassword(Authentication authentication, Model model){
        User user = this.myService.findUserByUsername(authentication.getName());
        Password password = new Password();
        model.addAttribute("user",user);
        model.addAttribute("password", password);
        return "user/password-form";
    }

    @PostMapping("/update-password")
    public String updatePassword(@RequestParam("username")String username, @ModelAttribute("password")Password password, Model model){
        User user = this.myService.findUserByUsername(username);
        model.addAttribute("user",user);
        String p = user.getPassword();
        String pCheck = p.substring(8,p.length());


        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();

        if(!bCrypt.matches(password.getOldPassword(),pCheck)){
            model.addAttribute("error1","Mật khẩu cũ không chính xác !");
            return "user/password-form";
        }
        if(!password.getNewPassword().equals(password.getReNewPassword())){
            model.addAttribute("error2","Mật khẩu mới không khớp !");
            return "user/password-form";
        }

        String newPassword = "{bcrypt}"+bCrypt.encode(password.getNewPassword());
        user.setPassword(newPassword);
        this.myService.updateUser(user);
        model.addAttribute("success","Đổi mật khẩu thành công !");
        return "user/password-form";
    }
}
