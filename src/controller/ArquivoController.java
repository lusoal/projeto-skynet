package controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import model.Arquivos;
import service.ArquivoService;


@WebServlet("/ArquivoController.do")
@MultipartConfig
public class ArquivoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pAcao = request.getParameter("acao");
		
		if(pAcao.equals("uploadTermosAdmin")) {
			//pegando parametros do frontend
			String pNome = request.getParameter("nome");
			String pDocumento = request.getParameter("idAdm");
			Part filePart = request.getPart("arquivo");
			
			//transformar file em array de bytes
			//InputStream filecontent = filePart.getInputStream();
			//byte[] file = IOUtils.toByteArray(filecontent);
			
			Arquivos arquivo = new Arquivos();
			arquivo.setNome(pNome);
			arquivo.setDocumento(Long.parseLong(pDocumento));
			
			try {
				ArquivoService service = new ArquivoService();
				boolean retorno =service.inserirArquivoDownload(arquivo, filePart);
				System.out.println(retorno);
				response.sendRedirect("perfil/administrador/index.jsp");
			}catch(Exception e) {
				System.out.println(e);
			}
		
		}if(pAcao.equals("uploadTermos")) {
				//pegando parametros do frontend
				String pNome = request.getParameter("nome");
				String pDocumento = request.getParameter("documento");
				Part filePart = request.getPart("arquivo");
				
				String pTipo = request.getParameter("tipo");
				
				//transformar file em array de bytes
				//InputStream filecontent = filePart.getInputStream();
				//byte[] file = IOUtils.toByteArray(filecontent);
				
				Arquivos arquivo = new Arquivos();
				arquivo.setNome(pNome);
				arquivo.setDocumento(Long.parseLong(pDocumento));
				
				try {
					ArquivoService service = new ArquivoService();
					boolean retorno =service.inserirArquivoUpload(arquivo, filePart);
					System.out.println(retorno);
					if(pTipo.equals("cartorio")) {
						response.sendRedirect("perfil/cartorio/index.jsp");
					}else if(pTipo.equals("empresa")) {
						response.sendRedirect("perfil/empresa/index.jsp");
					}
				}catch(Exception e) {
					System.out.println(e);
				}	
			
			}if(pAcao.equals("listarTermosAdminEmpresa")) {
			String tipo = "Admin";
			String perfil="Empresa";
			ArquivoService service = new ArquivoService();
			try {
				ArrayList<Arquivos> arquivos = service.listarArquivosDownload(tipo, perfil);
				request.setAttribute("arquivo", arquivos);
				RequestDispatcher view = request.getRequestDispatcher("perfil/administrador/termosEmpresa.jsp");
				view.forward(request, response);
			} catch (SQLException e) {
				System.out.println("erro "+e);
			}
			
		}if(pAcao.equals("listarTermosAdminCartorio")) {
			String tipo = "Admin";
			String perfil="Cartorio";
			ArquivoService service = new ArquivoService();
			try {
				ArrayList<Arquivos> arquivos = service.listarArquivosDownload(tipo, perfil);
				request.setAttribute("arquivo", arquivos);
				RequestDispatcher view = request.getRequestDispatcher("perfil/administrador/termosCartorio.jsp");
				view.forward(request, response);
			} catch (SQLException e) {
				System.out.println("erro "+e);
			}
		
		}if(pAcao.equals("listarTermosCartorio")) {
			String tipo = "Admin";
			String perfil="Cartorio";
			ArquivoService service = new ArquivoService();
			try {
				ArrayList<Arquivos> arquivos = service.listarArquivosDownload(tipo, perfil);
				request.setAttribute("arquivo", arquivos);
				RequestDispatcher view = request.getRequestDispatcher("perfil/cartorio/termosCartorio.jsp");
				view.forward(request, response);
			} catch (SQLException e) {
				System.out.println("erro "+e);
			}
			
		}if(pAcao.equals("listarTermosEmpresa")) {
			String tipo = "Admin";
			String perfil="Empresa";
			ArquivoService service = new ArquivoService();
			try {
				ArrayList<Arquivos> arquivos = service.listarArquivosDownload(tipo, perfil);
				request.setAttribute("arquivo", arquivos);
				RequestDispatcher view = request.getRequestDispatcher("perfil/empresa/termosEmpresa.jsp");
				view.forward(request, response);
			} catch (SQLException e) {
				System.out.println("erro "+e);
			}
			
		}if(pAcao.equals("listarTermos")) {
			String tipo = request.getParameter("tipo");
			String documento = request.getParameter("documento");
			Arquivos arquivo = new Arquivos();
			
			arquivo.setDocumento(Long.parseLong(documento));
			ArquivoService service = new ArquivoService();
			
			try {
				ArrayList<Arquivos> arquivos = service.listarArquivosUpload(arquivo);
				request.setAttribute("arquivo", arquivos);
				//implementar o tipo empresa
				if(tipo.equals("cartorio")) {
					RequestDispatcher view = request.getRequestDispatcher("perfil/cartorio/uploadTermos.jsp");
					view.forward(request, response);
				}else if(tipo.equals("empresa")) {
					RequestDispatcher view = request.getRequestDispatcher("perfil/empresa/uploadTermos.jsp");
					view.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

}