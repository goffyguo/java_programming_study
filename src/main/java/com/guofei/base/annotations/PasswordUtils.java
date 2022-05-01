package com.guofei.base.annotations;

import java.lang.annotation.ElementType;
import java.util.List;

/**
 * @author: GuoFei
 * @date: 2022-05-01 15:46
 */

/**
 * @author guogoffy
 * @Target  用来标注"被标注的注解"可以使使用到什么地方
 * @see ElementType
 *
 *
 *
 *
 *
 *
 */



public class PasswordUtils {

  @UserCase(id=47,description = "Password must contain at east one numeric")
  public boolean validatePassword(String passwd){
    return passwd.matches("\\w*\\d\\w*");
  }

  @UserCase(id=48)
  public String encryptPassword(String  passwd){
    return new StringBuilder(passwd).reverse().toString();
  }

  @UserCase(id = 49,description = "New passwords can't equals previously used one")
  public boolean checkForNewPassword(List<String> pre,String passwd){
    return  !pre.contains(passwd);
  }

}
