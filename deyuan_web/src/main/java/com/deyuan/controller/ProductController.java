package com.deyuan.controller;

import com.deyuan.pojo.Product;
import com.deyuan.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @RequestMapping("/findAll")
    @RolesAllowed("ROLE_ADMIN")
    public ModelAndView findAll(){
        List<Product> list = productService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productList",list);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }
    @RequestMapping("/save")
    public String save(Product product){
        productService.save(product);

        return "redirect:findAll.do";
    }
}
