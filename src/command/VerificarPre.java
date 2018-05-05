package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Publico;
import service.PublicoService;

public class VerificarPre implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Verificar Pre Cadastro Command");
		PublicoService servicePub = new PublicoService();
		String pDocumento = request.getParameter("documento");
		System.out.println(pDocumento);
		pDocumento = pDocumento.replace(".", "");
		pDocumento = pDocumento.replace("-", "");
		pDocumento = pDocumento.replace("/", "");
		System.out.println(pDocumento);
		Publico pub = new Publico();
		pub.setDocumento(Long.parseLong(pDocumento));
		servicePub.validarPublico(pub);
		
		//retornar para o front os parametros de tipo e documento, jutamente com a sessao
		if (pub.getStatus() == true) {
			System.out.println(pub.getNome());
			HttpSession session=request.getSession();
			session.setAttribute("documento", pDocumento);  
	        session.setAttribute("publico", pub);
			response.sendRedirect("cadastro/cadastro.jsp");
		}else {
			//implementar mensagem de erro no pre cadastro
			response.sendRedirect("index.html");
		}

	}

}
