package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.LoginService;
import model.Login;

public class AlterarSenhaAdicional implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pSenha = request.getParameter("senha");
		String pSenha1 = request.getParameter("senha1");
		String pDocumento = request.getParameter("documento");
		
		if(pSenha.equals(pSenha1)) {
			Login login = new Login(Long.parseLong(pDocumento), pSenha);
			LoginService service = new LoginService();
			service.alterarSenhaAssociado(login, pSenha);
			response.sendRedirect("../../index.jsp");
		}else {
			System.out.println("Nao consegui alterar");
		}
		
		
		
		

	}

}
