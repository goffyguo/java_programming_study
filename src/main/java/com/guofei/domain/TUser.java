package com.guofei.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * @Author: GuoFei
 * @Date: 2021/10/04/11:24
 * @Description: 
 */
/**
    * 用户表
    */
@Data
@TableName(value = "t_user")
public class TUser implements Serializable {
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "`password`")
    private String password;

    /**
     * 性别 0=女 1=男
     */
    @TableField(value = "sex")
    private Byte sex;

    /**
     * 删除标志，默认0不删除，1删除
     */
    @TableField(value = "deleted")
    private Byte deleted;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_USERNAME = "username";

    public static final String COL_PASSWORD = "password";

    public static final String COL_SEX = "sex";

    public static final String COL_DELETED = "deleted";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_CREATE_TIME = "create_time";
}