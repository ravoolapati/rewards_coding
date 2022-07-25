package com.java.retailer.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trans {
	@ApiModelProperty(required = true)
	private LocalDateTime transDate;
	@ApiModelProperty(required = true)
	private Integer spentAmount;
	@Override
	public String toString() {
		return String.format("Trans [transDate=%s, spentAmount=%s]", transDate, spentAmount);
	}
}
