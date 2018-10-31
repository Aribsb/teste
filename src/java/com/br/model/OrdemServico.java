/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ari
 */

@Entity
@Table

public class OrdemServico implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    private int numOS;
    private String dataIni;
    private String dataFim;
    private String descricao;
    private boolean valor;

    public int getNumOS() {
        return numOS;
    }

    public void setNumOS(int numOS) {
        this.numOS = numOS;
    }

    public String getDataIni() {
        return dataIni;
    }

    public void setDataIni(String dataIni) {
        this.dataIni = dataIni;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isValor() {
        return valor;
    }

    public void setValor(boolean valor) {
        this.valor = valor;
    }
    
    
    
}
