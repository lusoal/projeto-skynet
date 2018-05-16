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
		boolean pAdicional = Boolean.parseBoolean(request.getParameter("adicional"));
		
		//Se a requisicao vir do administrador para alterar alguma informacao de um cadastro
		boolean pRedirect = Boolean.parseBoolean(request.getParameter("redirect"));
		
		System.out.println("Valor Adicional: "+pAdicional);
		
		CadastroService service = new CadastroService();
		Cadastros cad = new Cadastros(Long.parseLong(pDocumento), pNome, null, pEmail, pEndereco, Long.parseLong(pTelefoneFixo), 
				Long.parseLong(pTelefoneCelular), pContPrincNome, Long.parseLong(pContPrincDoc), pContPrincEmail, pSenha, pSite, null );
		try {
			//verificar possibilidade de enviar uma mensagem com cadastro alterado
			service.alterarCadastro(cad);
			
			if(pTipo != null && pTipo.equals("Administrador")) {
				if(pRedirect) {
					AlterarCadastrosComAdm alterar = new AlterarCadastrosComAdm();
					alterar.executar(request, response);
				}else {
					command.ListarUsuario.listarAdministrador(request, response);
				}
			}else if(pTipo != null && pTipo.equals("cartorio")) {
				command.ListarUsuario.listarCartorio(request, response);
			}else if(pTipo != null && pTipo.equals("empresa")) {
				System.out.println("Listar empresa");
				command.ListarUsuario.listarEmpresa(request, response);
			}else if(pAdicional) {
				System.out.println("Listar usuario Adicional");
				ListarCadastroAdcional listar = new ListarCadastroAdcional();
				listar.executar(request, response);
			}
			
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("Erro atualizar cadastro");
		}

	}

}
