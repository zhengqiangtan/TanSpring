package com.test.project.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhengqiang.tan
 * @Date 2020-09-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OdsUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String email;

    private String mobile;


}
