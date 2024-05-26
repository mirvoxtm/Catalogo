package com.fatec.trabalhoPOO.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    
    @Autowired
    ProdutoDAO pdao;

    public void inserirProduto(Produto p) {
        pdao.inserirProduto(p);
    }

    public List<Map<String, Object>> listarProduto() {
        return pdao.listarProduto();
    }
}
