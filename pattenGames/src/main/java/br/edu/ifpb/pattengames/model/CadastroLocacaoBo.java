/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.model;

import br.edu.ifpb.pattengames.entidades.Locacao;
import br.edu.ifpb.pattengames.exception.LocacaoExistenteException;
import br.edu.ifpb.pattengames.factoy.DaoFactory;
import br.edu.ifpb.pattengames.factoy.DaoFactoryIF;

/**
 *
 * @author José
 */
public class CadastroLocacaoBo {

    public CadastroLocacaoBo() {
    }
    

    public boolean cadastrar(Locacao locacao) throws LocacaoExistenteException {
        DaoFactoryIF factory = DaoFactory.createFactory(DaoFactory.DAO_BD);

        if (locacao.getDataDevolucao() == null) {
            return false;
        }
        if (locacao.getDataLocacao() == null) {
            return false;
        }
        if (locacao.getJogo() == null) {
            return false;
        }
        if (locacao.getCliente() == null) {
            return false;
        }
        if (locacao.getTipo() == null) {
            return false;
        }

        Locacao buscarExistente = factory.criaLocacaoDao().buscaPorId(locacao.getId());
        if (buscarExistente != null) {
            throw new LocacaoExistenteException(locacao.getDataDevolucao());
        }
        return factory.criaLocacaoDao().add(locacao);
    }
}
