package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cadastros;
import service.CadastroService;

public class AlterarCadastro implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pTipo = request.getParameter("tipo");
		
		String pDocumento = request.getParameter("documento");
		String pNome = request.getParameter("nome");
		System.out.println(pNome);
		String pEmail = request.getParameter("email");
		String pEndereco = request.getParameter("endereco");
		String pTelefoneFixo = request.getParameter("telefone_fixo");
		String pTelefoneCelular = request.getParameter("telefone_celular");
		String pContPrincNome = request.getParameter("cont_nome");
		String pContPrincDoc = request.getParameter("cont_doc");
		String pContPrincEmail = request.getParameter("cont_email");
		String pSite = request.getParameter("site");
		
		String pSenha = request.getParameter("senha");
		
		CadastroService service = new CadastroService();
		Cadastros cad = new Cadastros(Long.parseLong(pDocumento), pNome, null, pEmail, pEndereco, Long.parseLong(pTelefoneFixo), 
				Long.parseLong(pTelefoneCelular), pContPrincNome, Long.parseLong(pContPrincDoc), pContPrincEmail, pSenha, pSite, null );
		try {
			//verificar possibilidade de enviar uma mensagem com cadastro alterado
			service.alterarCadastro(cad);
			if(pTipo.equals("Administrador")) {
				command.ListarUsuario.listarAdministrador(request, response);
			}else if(pTipo.equals("cartorio")) {
				command.ListarUsuario.listarCartorio(request, response);
			}else if(pTipo.equals("empresa")) {
				System.out.println("Listar empresa");
				command.ListarUsuario.listarEmpresa(request, response);
			}
		}catch(Exception e) {
			System.out.println("Erro atualizar cadastro");
		}

	}

}
