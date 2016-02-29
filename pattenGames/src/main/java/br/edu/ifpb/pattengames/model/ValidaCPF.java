/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.model;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;

/**
 *
 * @author José
 */
public class ValidaCPF {
    public boolean validaCPF(String cpf){
        CPFValidator validator = new CPFValidator();
        try {
    // lógica de negócio ...
            new CPFValidator().assertValid(cpf);
   // validator.assertValid(cpf);
    
} catch (InvalidStateException e) { // exception lançada quando o documento é inválido
    System.out.println(e.getInvalidMessages());
    return false;
}
        return true;
    }
    
}
