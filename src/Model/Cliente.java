/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.ClienteDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * eu sou o mario
 *
 */
/**
 *
 * @author kazuo
 */
public class Cliente {

    private int codigo = 0;
    private String nome = null;
    private String cpf = null;
    private String fone = null;
    private String celular = null;
    private String email = null;

    public Cliente() {

    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getFone() {
        return fone;
    }

    public String getCelular() {
        return celular;
    }

    public String getEmail() {
        return email;
    }

    public Cliente(String nome, String cpf, String fone, String celular, String email) {
        setNome(nome);
        setCpf(cpf);
        setFone(fone);
        setCelular(celular);
        setEmail(email);
        gravar();

    }

    public Cliente(int codigo, String nome, String cpf, String fone, String celular, String email) {
        setCodigo(codigo);
        setNome(nome);
        setCpf(cpf);
        setFone(fone);
        setCelular(celular);
        setEmail(email);
        gravar();

    }

    @Override
    public String toString() {
        String ret = null;
        ret = "Cliente.: [" + getNome() + "]\n"
                + "CPF.....: [" + getCpf() + "]\n"
                + "Telefone: [" + getFone() + "]\n"
                + "Celular.: [" + getCelular() + "]\n"
                + "Email...: [" + getEmail() + "]\n";
        return ret;
    }

    private void gravar() {
        ClienteDAO dao = new ClienteDAO();
        int codigo = dao.create(this);
        if (codigo > 0) {
            setCodigo(codigo);
        }

    }
    public static DefaultTableModel getTableModel(){
        List<Cliente> lista = ClienteDAO.getInstance().read();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nome");
        modelo.addColumn("Telefone");
        modelo.addColumn("Celular");
        modelo.addColumn("Email");
        for (Cliente c : lista) {
            String[] reg = {c.getNome(), c.getFone(), c.getCelular(), c.getEmail()};
            modelo.addRow(reg);
        }
        return modelo;
    }
}
