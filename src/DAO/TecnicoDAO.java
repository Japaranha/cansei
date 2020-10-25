/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Model.Produto;
import Model.Tecnico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author kazuo
 */
public class TecnicoDAO implements Persistencia<Tecnico> {
    
    
    @Override
    public int create(Tecnico t){
        int id = 0;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        
        String sql = "INSERT INTO Produtos (Nome,Salario,ValorHora) values(?,?,?)";
        try{
            pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, t.getNome());
            pst.setDouble(2,t.getSalario());
            pst.setDouble(3,t.getValorDaHora());
            
            pst.getGeneratedKeys();
            if(rs.next()){
                id = rs.getInt(1);
            }
        }catch(SQLException ex){
            id=0;
        }finally{
           ConnectionFactory.closeConnetion(con, pst, rs);
        }
        return id;
    }

    @Override
    public List<Tecnico> read() {
        throw new UnsupportedOperationException("Não implementado ainda."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Tecnico obj) {
        throw new UnsupportedOperationException("Não implementado ainda."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Tecnico obj) {
        throw new UnsupportedOperationException("Não implementado ainda."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tecnico findByCodigo(int id) {
        throw new UnsupportedOperationException("Não implementado ainda."); //To change body of generated methods, choose Tools | Templates.
    }
}
