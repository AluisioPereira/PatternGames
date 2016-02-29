/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.factoy;

import br.edu.ifpb.pattengames.dao.ClienteDao;
import br.edu.ifpb.pattengames.dao.ClienteDaoIf;
import br.edu.ifpb.pattengames.dao.JogoDao;
import br.edu.ifpb.pattengames.dao.JogoDaoIf;

/**
 *
 * @author José
 */
public class DaoFactoryDB implements DaoFactoryIF {

    @Override
    public ClienteDaoIf criaClienteDao() {
        return new ClienteDao();
    }

    @Override
    public JogoDaoIf criaJogoDao() {
        return new JogoDao();
    }

}
