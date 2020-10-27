/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kazuo
 */
public class ClienteDAO implements Persistencia<Cliente> {

    private static ClienteDAO dao = null;

    public static ClienteDAO getInstance() {
        if (dao == null) {
            dao = new ClienteDAO();
        }
        return dao;

    }

    @Override
    public int create(Cliente c) {
        int id = 0;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "INSERT INTO Clientes (Nome,CPF,Fone,Celular,Email) values(?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, c.getNome());
            pst.setString(2, c.getCpf());
            pst.setString(3, c.getFone());
            pst.setString(4, c.getCelular());
            pst.setString(5, c.getEmail());
            pst.execute();
            rs = pst.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            id = 0;
        } finally {
            ConnectionFactory.closeConnetion(con, pst, rs);
        }
        return id;
    }

    @Override
    public List<Cliente> read() {
        int lista = 0;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<Cliente> clientes = new ArrayList();

        try {
            pst = con.prepareStatement("SELECT * FROM Clientes ORDER BY Nome");
            rs = pst.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setNome(rs.getString("Nome"));
                cliente.setCpf(rs.getString("CPF"));
                cliente.setFone(rs.getString("fone"));
                cliente.setCelular(rs.getString("Celular"));
                cliente.setEmail(rs.getString("Email"));
                clientes.add(cliente);
            }
            if (rs.next()) {
                lista = rs.getInt(1);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro no select.");
        } finally {
            ConnectionFactory.closeConnetion(con, pst, rs);
        }
        return clientes;
    }

    @Override
    public boolean update(Cliente obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Cliente obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente findByCodigo(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
