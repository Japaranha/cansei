/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.ClienteDAO;
import DAO.ProdutosDAO;

/**
 *
 * @author kazuo
 */
public class Produto {
    private int codigoProduto = 0;
    private String descricao = null;
    private int estoque ;
    private boolean ativo = false;
    private double custo = 0;
    private double venda = 0;
    
    
    /**
     * @return the codigoProduto
     */
    public int getCodigoProduto() {
        return codigoProduto;
    }

    /**
     * @param codigoProduto the codigoProduto to set
     */
    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public double getVenda() {
        return venda;
    }

    public void setVenda(double venda) {
        this.venda = venda;
    }
    
    public Produto(String descricao, int estoque, boolean ativo, double custo, double venda){
        setDescricao(descricao);
        setEstoque(estoque);
        setCusto(custo);
        setAtivo(ativo);
        setVenda(venda);
        gravar();
    }
    @Override
    public String toString(){
        String ret = null;
        if(isAtivo()) ret = "[Ativo] = ";
        else ret ="[Fora de linha] - ";
        ret = ret + "Descrição.: [" + getDescricao() + "]\n"+
                "Estoque.....: [" + getEstoque() + "]\n"+
                "Custo.: [" + getCusto() + "]\n"+
                "Venda...: [" + getVenda() + "]\n";
        return ret;
    }

    private void gravar(){
        ProdutosDAO dao = new ProdutosDAO();
        int codigo = dao.create(this);
        if(codigo > 0) setCodigoProduto(codigo);      
    }
}
