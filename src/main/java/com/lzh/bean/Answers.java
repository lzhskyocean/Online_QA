package com.lzh.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answers {

  private Long id;

  @NotBlank(message = "问题回答不能为空!")
  private String ansContent;

  private Date ansDate;

  @NotNull(message = "qId不能为空!")
  private Long qId;


}
