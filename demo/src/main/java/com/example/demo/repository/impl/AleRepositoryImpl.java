package com.example.demo.repository.impl;

import com.example.demo.model.dto.AleObjeto;
import com.example.demo.repository.AleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class AleRepositoryImpl implements AleRepository {

    private final JdbcTemplate dataSourceMysql;


    public AleRepositoryImpl(JdbcTemplate dataSourceMysql) {
        this.dataSourceMysql = dataSourceMysql;
    }

    @Override
    public List<AleObjeto>obtem() {
        List<AleObjeto> retorno = new ArrayList<>();

        String sql = "SELECT * FROM table_name";
        try{
            retorno = dataSourceMysql.query(sql,new BeanPropertyRowMapper<>(AleObjeto.class));
        }catch (Exception e){
            log.error(e.getMessage());
            log.error("Erro ao consultar tabela");
        }
        return retorno;
    }

    @Override
    public void insere(AleObjeto input) {
        try{
            dataSourceMysql.update(
                    "INSERT INTO table_name ( column1,column2,column3) VALUES (?,?,?)",
                    input.getColumn1(),
                    input.getColumn2(),
                    input.getColumn3()
            );
        }catch (Exception e){
            log.error(e.getMessage());
            log.error("Erro ao inserir tabela");
        }
    }

    @Override
    public void atualiza(AleObjeto input) {
        try{
            dataSourceMysql.update(
                    "UPDATE table_name SET " +
                            " column1 = ?," +
                            " column2 = ? ," +
                            " column3 = ?  WHERE column1 = ? ",
                    input.getColumn1(),
                    input.getColumn2(),
                    input.getColumn3(),
                    input.getColumn1()
            );
        }catch (Exception e){
            log.error(e.getMessage());
            log.error("Erro ao atualizar tabela");
        }
    }

    @Override
    public void deleta(String id) {
        try{
            dataSourceMysql.update("DELETE FROM table_name WHERE column1 = ? ", id);
        }catch (Exception e){
            log.error(e.getMessage());
            log.error("Erro ao deletar tabela");
        }
    }
}
