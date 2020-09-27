package com.test.project.service.impl;

import com.test.project.entity.OdsUser;
import com.test.project.mapper.OdsUserMapper;
import com.test.project.service.IOdsUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhengqiang.tan
 * @since 2020-09-27
 */
@Service
public class OdsUserServiceImpl extends ServiceImpl<OdsUserMapper, OdsUser> implements IOdsUserService {

}
