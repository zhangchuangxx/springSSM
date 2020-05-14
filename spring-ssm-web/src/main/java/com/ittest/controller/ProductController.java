package com.ittest.controller;

import com.ittest.domain.Product;
import com.ittest.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 张闯
 * @create 2020-04-23 13:43
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> products = productService.findAll();
        mv.addObject("productList", products);
        mv.setViewName("product-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String productAdd(Product product) throws Exception {
        productService.save(product);
        return "redirect:findAll.do";
    }
}
