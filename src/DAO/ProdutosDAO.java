/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Model.Cliente;
import Model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author kazuo
 */
public class ProdutosDAO implements Persistencia<Produto>{
   
    @Override
    public int create(Produto p){
        int id = 0;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        
        String sql = "INSERT INTO Clientes (Descricao,Estoque,Custo,Venda) values(?,?,?,?)";
        try{
            pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, p.getDescricao());
            pst.setInt(2,p.getEstoque());
            pst.setDouble(3,p.getCusto());
            pst.setDouble(4,p.getVenda());
          
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
    public List<Produto> read() {
        throw new UnsupportedOperationException("Não implementado ainda."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Produto obj) {
        throw new UnsupportedOperationException("Não implementado ainda."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Produto obj) {
        throw new UnsupportedOperationException("Não implementado ainda."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Produto findByCodigo(int id) {
        throw new UnsupportedOperationException("Não implementado ainda."); //To change body of generated methods, choose Tools | Templates.
    }
}
