package com.test.project.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhengqiang.tan
 * @since 2020-09-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OdsUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String email;

    private String mobile;


}
