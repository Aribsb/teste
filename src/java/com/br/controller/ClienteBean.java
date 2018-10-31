/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.controller;

import com.br.model.Cliente;
import com.br.model.ClienteDao;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Ari
 */
@ManagedBean
@SessionScoped
public class ClienteBean {
    
    private List<Object[]> listaCliente;

    public List<Object[]> getListaCliente() {
        listaCliente = clienteDao.listaTodosClientes();
return listaCliente;
    }

    public void setListaCliente(List<Object[]> listaCliente) {
        this.listaCliente = listaCliente;
    }
    Cliente cliente = new Cliente();

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ClienteDao getClienteDao() {
        return clienteDao;
    }

    public void setClienteDao(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }
    ClienteDao clienteDao = new ClienteDao();
    
    public String salvar() throws
    NoSuchAlgorithmException,UnsupportedEncodingException{
        if (clienteDao.salvar(cliente))
            return "sucesso";
        else
            return "erro";
}
    
    public String atualizar(){
if (clienteDao.atualizar(cliente))
return "listarCliente";
else
return "erro";
}
public void carregarCliente(int id){
cliente = clienteDao.recuperaCliente(id);
}

public String excluir(int id){
if (clienteDao.excluir(id))
return "listarCliente";
else
return "erro";
}    
      
}
