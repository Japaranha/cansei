/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.ProdutosDAO;
import DAO.TecnicoDAO;

/**
 *
 * @author kazuo
 */
public class Tecnico {
    private int codigoTecnico = 0;
    private String nome = null;
    private double salario = 0 ;
    private double valorDaHora = 0;

    
     /**
     * @return the codigoTecnico
     */
    public int getCodigoTecnico() {
        return codigoTecnico;
    }

    /**
     * @param codigoTecnico the codigoTecnico to set
     */
    public void setCodigoTecnico(int codigoTecnico) {
        this.codigoTecnico = codigoTecnico;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getValorDaHora() {
        return valorDaHora;
    }

    public void setValorDaHora(double valorDaHora) {
        this.valorDaHora = valorDaHora;
    }
    
    
    public Tecnico(String nome, double salario,double valorDaHora){
        setNome(nome);
        setSalario(salario);
        setValorDaHora(valorDaHora);
        gravar();
    }

    @Override
    public String toString(){
        String ret = null;
        
        ret = "Nome...: ["+getNome()+"]" +"\n"+ "Salario: [" + getSalario() + "]"
                +"\n" + "Valor da Hora: [" + getValorDaHora() + "]"+ "\n";
        
        return ret;
        
    }
        private void gravar(){
        TecnicoDAO dao = new TecnicoDAO();
        int codigo = dao.create(this);
        if(codigo > 0) setCodigoTecnico(codigo);      
    }


}
