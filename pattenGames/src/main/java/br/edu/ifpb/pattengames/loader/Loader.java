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
import br.edu.ifpb.pattengames.entidades.Locacao;
import br.edu.ifpb.pattengames.exception.LocacaoExistenteException;
import br.edu.ifpb.pattengames.factoy.DaoFactoryDB;
import br.edu.ifpb.pattengames.factoy.DaoFactoryIF;
import br.edu.ifpb.pattengames.factoy.FactoyLocacao;
import br.edu.ifpb.pattengames.model.CadastroLocacaoBo;
import br.edu.ifpb.pattengames.model.CalculaMulta;
import br.edu.ifpb.pattengames.model.EnviarEmail;
import br.edu.ifpb.pattengames.model.MultaAtrasoLocacaoComum;
import br.edu.ifpb.pattengames.model.MultaAtrasoLocacaoEspecial;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javafx.util.converter.LocalDateStringConverter;
import javax.mail.internet.MailDateFormat;

/**
 *
 * @author José
 */
public class Loader {
//certo
    public static void main(String[] args) throws ParseException, LocacaoExistenteException {
//        Cliente c = new Cliente();
//        c.setCPF("132.353.411-21");
//        c.setNome("josé ferreira vieira");
//        c.setEmail("joseferreira@gmail.com");
//        c.setId(1);
        ClienteDaoIf dao = new ClienteDao();
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
//       if( x.validaCPF("210.085.401-10"))cl
//        System.err.println("CPF valido");
//       else
//        System.err.println("Cliente "+c.getEmail()+", jogo "+dj.buscaPorId(2).getNome());
//        EnviarEmail email= new EnviarEmail();
//        email.enviarEmail(c, dj.buscaPorId(2));
        // CalculaMulta xx = new MultaAtrasoLocacaoEspecial();
        LocalDate dataAtual = LocalDate.now(); 
        System.out.println("Data: " + dataAtual);


        Jogo cj = dj.buscaPorNome("FIFA 17");
        System.err.println("=========="+cj.getNome());
//        Cliente cl = dao.buscaPorCPF("132.353.411-21");
//         Locacao l = FactoyLocacao.createFactory(FactoyLocacao.LOCACAO).criarLocacao();
//         System.err.println("cccccccccccccccc"+l.getClass().getSimpleName());
//         System.err.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"+cl.getCPF()+"zzzzzzzzz  "+cj.getNome());
//         l.setCliente(cl);
//         l.setJogo(cj);
//         System.err.println("\\\\\\\\"+l.getDataDevolucao()+"qqq "+l.getDataLocacao());
//         CadastroLocacaoBo ddd = new CadastroLocacaoBo();
//        boolean d = ddd.cadastrar(l);
//        System.err.println("============="+d);
//        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//      ;//  Locacao l = new Locacao();
//        //l.setCliente(dao.buscaPorId(4));
//        //l.setDataDevolucao(LocalDate.of(2016, 2, 6));
//        //l.setJogo(dj.buscaPorId(1));
//        
//        //l.setDataLocacao(LocalDate.parse("2016-03-04", DateTimeFormatter.ISO_DATE));
        //l.setTipo("comum");
        // l.setId(1);
        //  boolean xx = dl.add(l);
        // xx=  dl.remover(l);
       // Locacao xx = dl.buscaPorIdCliente(dao.buscaPorId(4).getNome());
       // System.err.println("Valor da multa "+xx.getDataDevolucao());
        ValidaCPF s = new ValidaCPF();
        boolean cc = s.validaCPF("185.302.491-0");
        System.err.println(cc);
    }

}
