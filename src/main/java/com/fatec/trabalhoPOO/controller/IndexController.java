package com.fatec.trabalhoPOO.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fatec.trabalhoPOO.model.Category;
import com.fatec.trabalhoPOO.model.CategoryService;
import com.fatec.trabalhoPOO.model.Produto;
import com.fatec.trabalhoPOO.model.ProdutoService;


@Controller
@ComponentScan("com.fatec.trabalhoPOO.model")
public class IndexController {
    
    @Autowired
    private ApplicationContext context;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProdutoService produtoService;
    
    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    //catalogo
    @GetMapping("/catalogo")
    public String catalogo(Model model){
        ProdutoService ps = context.getBean(ProdutoService.class);
        List<Map<String, Object>> lista = ps.listarProduto();
        
        model.addAttribute("lista", lista);

        return "catalogo";
    }
    
    @GetMapping("/cadastro-produto")
    public String cadastroProd(Model model) {
        List<Map<String, Object>> categories = categoryService.listarCategoria();
        model.addAttribute("produto", new Produto());
        model.addAttribute("categories", categories);
        return "cadastroProd";
    }

    @PostMapping("/cadastro-produto")
    public String cadastroProd(@ModelAttribute Produto produto) {
        produtoService.inserirProduto(produto);
        return "redirect:/catalogo";
    }

    @GetMapping("/cadastro-categoria")
    public String cadastroCategoria(Model model) {
        model.addAttribute("category", new Category());
        return "cadastroCategoria";
    }

    @PostMapping("/cadastro-categoria")
    public String cadastroCategoria(Model model, @ModelAttribute Category category) {
        CategoryService cs = context.getBean(CategoryService.class);
        
        cs.inserirCategoria(category);
        return "redirect:/catalogo";
    } 

}