package com.imooc.mall.controller.foreend;

import com.imooc.mall.common.Const;
import com.imooc.mall.common.ServerResponse;
import com.imooc.mall.domain.User;
import com.imooc.mall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author 宋艾衡
 * @date 2019/4/4 18:10
 * @desc
 */

@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login(HttpSession session,String username, String password){
        ServerResponse<User> response = iUserService.login(username, password);
        if (response.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }
        return response;
    }

    @RequestMapping(value = "logout.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> logout(HttpSession session){
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }

    @RequestMapping(value = "log_user_info.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> getUserInfo(HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user != null) {
            return ServerResponse.createBySuccess(user);
        }
        return ServerResponse.createByErrorMessage("UserController-->getUserInfo,用户未登陆");
    }

//    @RequestMapping(value = "register.do",method = RequestMethod.POST)
//    @ResponseBody
//    public ServerResponse<String> register(User user){
//        return iUserService.register(user);
//    }
//
//    @RequestMapping(value = "forget_get_question.do",method = RequestMethod.POST)
//    @ResponseBody
//    public ServerResponse<String> forgetGetQuestion(String username){
//        // 忘记密码前端会传过来一个用户名，后端返回注册时候提交的问题
//        return iUserService.selectQuestion();
//    }
//
//    @RequestMapping(value = "forget_check_answer.do",method = RequestMethod.POST)
//    @ResponseBody
//    public ServerResponse<String> forgetCheckAnswer(String username,String question,String answer){
//        return iUserService.checkAnswer(username,question,answer);
//    }
//
//    @RequestMapping(value = "forget_reset_password.do",method = RequestMethod.POST)
//    @ResponseBody
//    public ServerResponse<String> forgetResetPassword(String username,String newPassword,String forgetToken){
//        return iUserService.forgetResetPassword(username,newPassword,forgetToken);
//    }
//
//    @RequestMapping(value = "reset_password.do",method = RequestMethod.POST)
//    @ResponseBody
//    public ServerResponse<String> resetPassword(HttpSession session,String oldPassword,String newPassword){
//        User user = (User) session.getAttribute(Const.CURRENT_USER);
//        if (user == null) {
//            return ServerResponse.createByErrorMessage("用户未登录");
//        }
//        return iUserService.resetPassword(oldPassword, newPassword);
//    }
//
//
//    public ServerResponse<User> updataInformation(HttpSession session,User user){
//        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
//        if (currentUser == null) {
//            return ServerResponse.createByErrorMessage("用户未登录");
//        }
//        user.setId(currentUser.getId());
//        user.setUsername(user.getUsername());
//        ServerResponse<User> response = iUserService.updateInformation(user);
//        if (response.isSuccess()) {
//            response.getData().setUsername(currentUser.getUsername());
//            session.setAttribute(Const.CURRENT_USER,response.getData());
//        }
//
//    }




}
