/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.util;

import java.util.List;

/**
 *
 * @author tatuapu
 */
public interface DAO {

    void atualizar(Object ob) throws Exception;

    void excluir(Object ob) throws Exception;

    List listaTodos() throws Exception;

    List procura(Object ob) throws Exception;

    Object procuraPeloId(Integer id) throws Exception;

    void salvar(Object ob) throws Exception;
    
}
