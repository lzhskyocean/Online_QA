package com.lzh.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Questions {

  private Long id;

  @NotBlank(message = "标题不能为空!")
  private String title;
  @NotBlank(message = "问题描述不能为空!")
  private String detailDesc;

  private Integer answerCount;

  private Date lastModified;

}
