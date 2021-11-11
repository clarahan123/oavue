package com.bioduro.oa.service.impl;

import com.bioduro.oa.entity.Blog;
import com.bioduro.oa.mapper.BlogMapper;
import com.bioduro.oa.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hanh
 * @since 2021-11-02
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
