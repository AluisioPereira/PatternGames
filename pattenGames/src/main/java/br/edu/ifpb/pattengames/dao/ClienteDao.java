/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.dao;

import br.edu.ifpb.pattengames.entidades.Cliente;
import br.edu.ifpb.pattengames.conexao.ConexaoIF;
import br.edu.ifpb.pattengames.conexao.DataBaseException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.edu.ifpb.pattengames.conexao.Conexao;

/**
 *
 * @author José
 */
public class ClienteDao implements ClienteDaoIf {

    private ConexaoIF conn;

    @Override
    public boolean add(Cliente cliente) {
        boolean result = false;
        PreparedStatement stat = null;
        String sql = "INSERT INTO CLIENTE (nome,cpf, email)"
                +  "VALUES(?, ?, ?)";
        try {
            conn = new Conexao();
            stat = conn.getConnection().prepareStatement(sql);
            stat.setString(1, cliente.getNome());
            stat.setString(2, cliente.getCPF());
            stat.setString(3, cliente.getEmail());
            if (stat.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException | ClassNotFoundException | IOException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                conn.closeAll(stat);
            } catch (DataBaseException ex) {
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return result;
    }

    @Override
    public boolean remover(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente buscaPorNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente buscaPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterar(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
