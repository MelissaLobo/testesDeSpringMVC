package br.com.util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ferramentas {

	public static void direcionaParaHtml(HttpServletRequest request, HttpServletResponse response,String pagina)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(pagina);;
		rd.forward(request, response);
	}
}
