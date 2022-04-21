package com.guofei.mvc.domain.dto;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2021/10/08/14:05
 * @Description:
 */
@Data
public class UserDTO {

    private String username;
    private String password;
    private Byte sex;
}
