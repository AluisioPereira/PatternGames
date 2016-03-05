/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.loader;

import br.edu.ifpb.pattengames.model.ValidaCPF;
import br.edu.ifpb.pattengames.dao.*;
import br.edu.ifpb.pattengames.dao.ClienteDaoIf;
import br.edu.ifpb.pattengames.entidades.Cliente;
import br.edu.ifpb.pattengames.entidades.Jogo;
import br.edu.ifpb.pattengames.factoy.DaoFactoryDB;
import br.edu.ifpb.pattengames.factoy.DaoFactoryIF;
import br.edu.ifpb.pattengames.model.CalculaMulta;
import br.edu.ifpb.pattengames.model.EnviarEmail;
import br.edu.ifpb.pattengames.model.MultaAtrasoLocacaoComum;
import br.edu.ifpb.pattengames.model.MultaAtrasoLocacaoEspecial;

/**
 *
 * @author José
 */
public class Loader {
//certo
    public static void main(String[] args) {
//        Cliente c = new Cliente();
//        c.setCPF("132.353.411-21");
//        c.setNome("josé ferreira vieira");
//        c.setEmail("joseferreira@gmail.com");
//        c.setId(1);
//        ClienteDaoIf dao = new ClienteDao();
        JogoDaoIf dj = new JogoDao();
      // System.out.println("resut " + dao.buscaPorEmail("jose@gmail.com").getEmail());
        //dao.add(c);
        Jogo j = new Jogo();
        j.setNome("FIFA 14");
        j.devolver();
        //j.setId(5);
      //  dj.add(j);
        System.err.println("jogos "+dj.buscaPorNome("FIFA 14").getNome());
      // j.setId(3);
      //  DaoFactoryIF fabrica = new DaoFactoryDB();
        //Cliente c = fabrica.criaClienteDao().buscaPorId(4);
//     //   System.out.println("jogo "+ c.getNome());
//        ValidaCPF x= new ValidaCPF();
//       if( x.validaCPF("210.085.401-10"))
//        System.err.println("CPF valido");
//       else
//        System.err.println("Cliente "+c.getEmail()+", jogo "+dj.buscaPorId(2).getNome());
//        EnviarEmail email= new EnviarEmail();
//        email.enviarEmail(c, dj.buscaPorId(2));
        CalculaMulta xx = new MultaAtrasoLocacaoEspecial();
        
        System.err.println("Valor da multa "+xx.calcularMulta("03/03/2016"));
    }

}
