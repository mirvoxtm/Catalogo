package com.fatec.trabalhoPOO.model;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;


@Repository
public class CategoryDAO {
    
    @Autowired
    DataSource DataSource;
    
    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize() {
        jdbc = new JdbcTemplate(DataSource);
    }

    // inserir produto
    public void inserirCategoria(Category category) {
        String sql = "INSERT INTO categoria(name)" +
                    " VALUES (?)";

        // recebendo os VALUES
        Object[] obj = new Object[1];
        obj[0] = category.getName();

        jdbc.update(sql, obj);
    }

    public List<Map<String, Object>> listarCategorias() {
        String sql = "SELECT id, name FROM categoria";
        return jdbc.queryForList(sql);
    }
}