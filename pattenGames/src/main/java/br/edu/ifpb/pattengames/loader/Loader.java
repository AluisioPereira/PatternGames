/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.loader;

import br.edu.ifpb.pattengames.dao.*;
import br.edu.ifpb.pattengames.dao.ClienteDaoIf;
import br.edu.ifpb.pattengames.entidades.Cliente;
import br.edu.ifpb.pattengames.entidades.Jogo;
import br.edu.ifpb.pattengames.factoy.DaoFactoryDB;
import br.edu.ifpb.pattengames.factoy.DaoFactoryIF;

/**
 *
 * @author José
 */
public class Loader {
//certo
    public static void main(String[] args) {
        Cliente c = new Cliente();
        c.setCPF("132.353.411-21");
        c.setNome("josé ferreira vieira");
        c.setEmail("joseferreira@gmail.com");
        c.setId(1);
        ClienteDaoIf dao = new ClienteDao();
        JogoDaoIf dj = new JogoDao();
       // System.out.println("resut " + dao.buscaPorEmail("jose@gmail.com").getEmail());
        //dao.add(c);
        Jogo j = new Jogo();
        j.setNome("jogo e34");
        j.setId(3);
        DaoFactoryIF fabrica = new DaoFactoryDB();
       c =  fabrica.criaClienteDao().buscaPorId(4);
        System.out.println("jogo "+ c.getNome());
    }

}
