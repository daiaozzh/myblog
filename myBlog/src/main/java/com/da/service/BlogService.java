package com.da.service;

import com.da.po.Blog;
import com.da.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface BlogService {
    Blog getBlog(Long id);
    Page<Blog> listBlog(Pageable pageable,BlogQuery blog);
    Blog saveBlog(Blog blog);

    Page<Blog> listBlog(Pageable pageable);
    Page<Blog> listBlog(String query,Pageable pageable);
    Page<Blog> listBlog(Long id,Pageable pageable);
    Blog getAndConvert(Long id);
    List<Blog> listRecommentBlogTop(Integer size);

    Map<String,List<Blog>> archiveBlog();
    Long countBlog();
    Blog updateBlog(Long id,Blog blog);
    void  deleteBlog(Long id);

}
