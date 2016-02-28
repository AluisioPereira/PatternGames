/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.dao;

import br.edu.ifpb.pattengames.entidades.Cliente;



/**
 *
 * @author José
 */
public interface ClienteDaoIf {

    public boolean add(Cliente cliente);

    public boolean remover(Cliente cliente);

    public Cliente buscaPorNome(String nome);

    public Cliente buscaPorId(int id);
    
    public boolean alterar(Cliente cliente);
     public Cliente buscaPorEmail(String email);

}
