/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.contole;

import br.edu.ifpb.pattengames.entidades.Cliente;
import br.edu.ifpb.pattengames.entidades.Jogo;
import br.edu.ifpb.pattengames.entidades.Locacao;
import br.edu.ifpb.pattengames.exception.LocacaoExistenteException;
import br.edu.ifpb.pattengames.factoy.DaoFactory;
import br.edu.ifpb.pattengames.factoy.FactoyLocacao;
import br.edu.ifpb.pattengames.model.CadastroLocacaoBo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José
 */
@WebServlet(name = "ServletCadastroLocacao", urlPatterns = {"/Cadastro_Locacao"})
public class ServletCadastroLocacao extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, LocacaoExistenteException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Locacao locacao = montarLocacao(request);
        out.print("cpf "+request.getParameter("cpf"));
        out.print("nome jogo "+request.getParameter("nomejogo"));
        out.print("-------------------------------------------------- ");
        out.print("locaçao  "+locacao);
        CadastroLocacaoBo bo = new CadastroLocacaoBo();
        boolean cadastrou = false;
        if (locacao != null) {
            cadastrou = bo.cadastrar(locacao);
        }

        if (cadastrou) {
            request.getRequestDispatcher("paginaadequada").forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (LocacaoExistenteException ex) {
            Logger.getLogger(ServletCadastroLocacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (LocacaoExistenteException ex) {
            Logger.getLogger(ServletCadastroLocacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private Locacao montarLocacao(HttpServletRequest request) {
        Cliente cliente = DaoFactory.createFactory(DaoFactory.DAO_BD).criaClienteDao().buscaPorCPF(request.getParameter("cpf"));
        Jogo jogo = DaoFactory.createFactory(DaoFactory.DAO_BD).criaJogoDao().buscaPorNome(request.getParameter("nomejogo"));
        Locacao l = FactoyLocacao.createFactory(FactoyLocacao.LOCACAO).criarLocacao();
        l.setCliente(cliente);
        l.setJogo(jogo);

        return l;
    }
}