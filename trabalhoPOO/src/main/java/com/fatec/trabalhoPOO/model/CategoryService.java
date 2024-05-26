package com.fatec.trabalhoPOO.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    
    @Autowired
    CategoryDAO cdao;

    public void inserirCategoria(Category c) {
        cdao.inserirCategoria(c);
    }

    public List<Map<String, Object>> listarCategoria() {
        return cdao.listarCategorias();
    }
    
}
