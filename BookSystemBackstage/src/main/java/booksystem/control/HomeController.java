package booksystem.control;

import booksystem.bean.UserInfo;
import booksystem.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
//@SessionAttributes("loginInfo")
public class HomeController {

    @Autowired
    private LoginService loginService;

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    //映射一个action
//    @RequestMapping("/index")
//    public ModelAndView index() {
//        //输出日志文件
//        //返回一个index.jsp这个视图
//        return new ModelAndView("index");
//    }

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public ModelAndView index(HttpServletRequest request) {
//        //输出日志文件
//        //返回一个index.jsp这个视图
//        return new ModelAndView("index");
//    }
//    @RequestMapping("/")
//    public String test() {
//        return "index";
//    }

    @RequestMapping(value = "/login", method = RequestMethod.PUT)
    @ResponseBody
    public String Login(HttpServletRequest request, ModelMap model) {
        UserInfo loginInfo = new UserInfo(request.getHeader("studyId"), request.getHeader("password"));
        Boolean isLoginSuccess = loginService.login(loginInfo);
        if (isLoginSuccess) {
            //request.getSession();
            request.getSession().setAttribute("useid", loginInfo.getStudentId());
            //model.addAttribute("loginInfo", loginInfo);
        }
        return Boolean.toString(isLoginSuccess);
    }

    @RequestMapping(value = "/registered", method = RequestMethod.PUT)
    @ResponseBody
    public String regitered(HttpServletRequest request) {
        UserInfo loginInfo = new UserInfo(request.getHeader("studyId"), request.getHeader("password"));
        return Boolean.toString(true);
    }

    @RequestMapping(value = "/sessionTest", method = RequestMethod.GET)
    @ResponseBody
    public String sessionTest(HttpSession httpSession) {
        String loginInfo = (String) httpSession.getAttribute("useid");
        if (loginInfo == null) {
            return Boolean.toString(false);
        }
        return Boolean.toString(true);
    }
}
