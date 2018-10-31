/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.model;

import com.br.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ari
 */
public class ClienteDao {
    
    private Session sessao;
    private Transaction transacao;
    private List<Object[]> listaCliente;
    
    public boolean salvar(Cliente cliente){
        try{
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.save(cliente);
        transacao.commit();
        return true;
        } catch(HibernateException erro){
        return false;
    }
    }
    
    public boolean atualizar(Cliente cliente){
    try{ sessao = HibernateUtil.getSessionFactory().openSession();
transacao = sessao.beginTransaction();
sessao.update(cliente);
transacao.commit();
return true;
} catch(HibernateException erro){
return false;
}
    
}
    
    public Cliente recuperaCliente(int id){
try{
sessao =
HibernateUtil.getSessionFactory().openSession();
transacao = sessao.beginTransaction();
String sql = "SELECT * FROM cliente WHERE id = :id";
SQLQuery consulta = sessao.createSQLQuery(sql);
consulta.setParameter("id", id);
consulta.addEntity(Cliente.class);
Cliente cliente = (Cliente)
consulta.uniqueResult();
transacao.commit();
return cliente;
} catch(HibernateException erro){
return null;
}



}
    
    
public List<Object[]> listaTodosClientes(){
sessao =
HibernateUtil.getSessionFactory().openSession();
transacao = sessao.beginTransaction();
String sql = "SELECT id, nome, rg, tel, endereco FROM cliente ";
SQLQuery consulta = sessao.createSQLQuery(sql);
listaCliente = consulta.list();
transacao.commit();
return listaCliente;
}

public boolean excluir(int id){
try{ sessao = HibernateUtil.getSessionFactory().openSession();
transacao = sessao.beginTransaction();
String sql = "DELETE FROM cliente WHERE id= :id ";
SQLQuery consulta = sessao.createSQLQuery(sql);
consulta.setParameter("id", id);
consulta.executeUpdate();
transacao.commit();
return true;
}catch(HibernateException erro){
return false;
}
    
}
}