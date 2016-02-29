/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.dao;

import br.edu.ifpb.pattengames.entidades.Jogo;
import java.sql.PreparedStatement;
import br.edu.ifpb.pattengames.conexao.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José
 */
public class JogoDao implements JogoDaoIf {

    private ConexaoIF conn = null;
    private PreparedStatement stat = null;

    @Override
    public boolean add(Jogo jogo) {
        boolean result = false;
        String sql = "INSERT INTO jogo(nome) VALUES(?)";
        try {
            conn = new Conexao();
            stat = conn.getConnection().prepareStatement(sql);
            stat.setString(1, jogo.getNome());
            if (stat.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException | IOException | ClassNotFoundException e) {
            Logger.getLogger(JogoDao.class.getName()).log(Level.SEVERE, null, e);
        } catch (URISyntaxException ex) {
            Logger.getLogger(JogoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.closeAll(stat);
            } catch (DataBaseException ex) {
                Logger.getLogger(JogoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    @Override
    public boolean remover(Jogo jogo) {
        // certo
        boolean result = false;
        PreparedStatement ps = null;

        try {
            conn = new Conexao();
            String sql = "DELETE FROM Jogo WHERE id = ?";
            ps = conn.getConnection().prepareStatement(sql);
            ps.setInt(1, jogo.getId());
            if (ps.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException | IOException | ClassNotFoundException e) {
            System.err.println("Erro " + e.getMessage());
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, e);
        } catch (URISyntaxException ex) {
            Logger.getLogger(JogoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.closeAll(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result;
    }

    @Override
    public Jogo buscaPorNome(String nome) {
          Jogo jogo = null;
        PreparedStatement pst;
        String consulta = "SELECT * FROM Jogo WHERE nome = ?";

        try {
            conn = new Conexao();
            pst = conn.getConnection().prepareStatement(consulta);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                jogo = montarJogo(rs);
            }

            conn.closeAll(pst);
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(JogoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return jogo;
    }

    @Override
    public Jogo buscaPorId(int id) {
          Jogo jogo = null;
        PreparedStatement pst;
        String consulta = "SELECT * FROM Jogo WHERE id = ?";

        try {
            conn = new Conexao();
            pst = conn.getConnection().prepareStatement(consulta);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                jogo = montarJogo(rs);
            }

            conn.closeAll(pst);
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(JogoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return jogo;
    }

    @Override
    public boolean alterar(Jogo jogo) {
         boolean result = false;
        PreparedStatement stat = null;
        try {
            conn = new Conexao();
            String sql = "UPDATE JOGO SET nome = ?"
                    + "WHERE id = ?";
            stat = conn.getConnection().prepareStatement(sql);
            stat.setString(1, jogo.getNome());
            stat.setInt(2, jogo.getId());

            if (stat.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException | IOException | ClassNotFoundException e) {
            System.err.println("Erro " + e.getMessage());
        } catch (URISyntaxException ex) {
            Logger.getLogger(JogoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    private Jogo montarJogo(ResultSet rs) throws SQLException {
        Jogo j = new Jogo();
        j.setId(rs.getInt("id"));
        j.setNome(rs.getString("nome"));
        return j;
    }

}
