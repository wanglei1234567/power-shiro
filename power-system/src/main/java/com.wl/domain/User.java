package com.wl.domain;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 江苏博沣
 * @since 2018-08-08
 */
@Data
@Accessors(chain = true)
@TableName("user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private String account;
	private String password;
	private String username;
	private String tall;


}
