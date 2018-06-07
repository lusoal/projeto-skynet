package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/controller.do")
public class LoginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// place your code here
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		String path = req.getContextPath();
		String uri = req.getRequestURI();
		String comando = req.getParameter("command");
		
		System.out.println(session.getAttribute("documento"));
		
		Long logado = null;
		try {
			 logado = (Long) session.getAttribute("documento");
			 System.out.println("Nao e nulo o valor " + logado);
			 
			//Tenta verificar se e um colaborador que esta logado no sistema
			 if(logado == null) {
				 logado = (Long) session.getAttribute("documentoColab");
				 System.out.println("entrou no condicional, colaborador" + logado);
			 }
			 
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		if(comando == null){
			comando = "";
		}

		if (logado == null && !uri.equals(path + "/index.html")
				&& !comando.equals("RealizarLogin") && !comando.equals("DownloadTermos") && !comando.equals("CadastrarPublico")
				&& !comando.equals("LoginColaborador") && !comando.equals("PreCadastroTermos") && !comando.equals("VerificarPre") && !comando.equals("CadastrarUsuario")
				&& !comando.equals("AlterarSenhaAdicional")) {
			((HttpServletResponse) response).sendRedirect(path + "/index.html");
		} else {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}