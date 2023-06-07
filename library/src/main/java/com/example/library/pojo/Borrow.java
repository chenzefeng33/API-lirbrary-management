package com.example.library.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
/**
 * @author: hxy
 * @date: 2023-06-06 09:40:33
 * @description: (Borrow)实体类
 */
@ApiModel(value = "预约表")
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Borrow extends Model<Borrow> implements Serializable{
    private static final long serialVersionUID = 664785543145999474L;

	@ApiModelProperty(value = "主键id")
	@TableId(type = IdType.AUTO)
    private Integer id;

	@ApiModelProperty(value = "预约图书id")
	private Integer bookId;
    
	@ApiModelProperty(value = "预约用户id")
	private Integer userId;
    
	@ApiModelProperty(value = "预约时间")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date reservationTime;
    
	@ApiModelProperty(value = "预约状态")
	private String status;
    
	@ApiModelProperty(value = "等待位置")
	private Integer waitingPosition;
    
	@ApiModelProperty(value = "用户打分")
	private Integer score;
    
}
