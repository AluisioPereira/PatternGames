/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.loader;

import br.edu.ifpb.pattengames.dao.ClienteDao;
import br.edu.ifpb.pattengames.dao.ClienteDaoIf;
import br.edu.ifpb.pattengames.entidades.Cliente;


/**
 *
 * @author José
 */
public class Loader {

    public static void main(String[] args) {
        Cliente c = new Cliente();
        c.setCPF("132.353.411-24");
        c.setNome("josé ferreira");
        c.setEmail("jose12@gmail.com");
        ClienteDaoIf dao = new ClienteDao();
        dao.add(c);
    }

}
