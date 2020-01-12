package com.da.web;

import com.da.service.BlogService;
import com.da.service.TagService;
import com.da.service.TypeService;
import com.da.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class indexController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;

    @GetMapping("/")
    public String index(@PageableDefault(size = 4, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable, Model model){
        model.addAttribute("page",blogService.listBlog(pageable));
        model.addAttribute("types",typeService.listType(6));
        model.addAttribute("tags",tagService.listTagTop(10));
        model.addAttribute("recommendBlogs",blogService.listRecommentBlogTop(8));
        return  "index";
    }
    @PostMapping("/search")
    public  String search(@PageableDefault(size = 8 , sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable, Model model,@RequestParam String query){
        model.addAttribute("page",blogService.listBlog("%"+query+"%",pageable));
        return "search";
    }
    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id,Model model){
        model.addAttribute("blog",blogService.getAndConvert(id));
        return "blog";
    }

    @GetMapping("/footer/newblog")
    public  String newblogs(Model model){
        model.addAttribute("newblogs",blogService.listRecommentBlogTop(3));
        return "_fragments :: newblogList";
    }
}
