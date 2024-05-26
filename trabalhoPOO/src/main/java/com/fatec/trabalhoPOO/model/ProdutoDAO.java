package com.fatec.trabalhoPOO.model;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;


@Repository
public class ProdutoDAO {
    
    @Autowired
    DataSource DataSource;
    
    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize() {
        jdbc = new JdbcTemplate(DataSource);
    }

    // inserir produto
    public void inserirProduto(Produto produto) {
        String sql = "INSERT INTO produtos(name,description,price,category_id)" +
                    " VALUES (?,?,?,?)";

        // recebendo os VALUES
        Object[] obj = new Object[4];
        
        obj[0] = produto.getName();
        obj[1] = produto.getDescription();
        obj[2] = produto.getPrice();

        if (produto.getCategoryId() == null) {
            obj[3] = 1;
        } else {
            obj[3] = produto.getCategoryId();
        }

        jdbc.update(sql, obj);
    }

    public List<Map<String, Object>> listarProduto() {
        String sql = "SELECT * FROM produtos";
        return jdbc.queryForList(sql);
    }
}