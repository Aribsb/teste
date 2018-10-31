/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.model;

import com.br.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ari
 */
public class OrdemServicoDAO {
    
    private Session sessao;
private Transaction transacao;
public boolean salvar(OrdemServico ordemServico){
try{
sessao =
HibernateUtil.getSessionFactory().openSession();
transacao = sessao.beginTransaction();
sessao.save(ordemServico);
transacao.commit();
return true;
} catch(HibernateException erro){
return false;
}
}
    
}
