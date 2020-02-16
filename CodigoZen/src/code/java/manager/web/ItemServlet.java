package code.java.manager.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import code.java.manager.dao.ItemDao;
import code.java.manager.model.Item;

/**
 * Servlet implementation class ItemServlet
 */
@WebServlet(name = "ItemServlet", urlPatterns = "/")
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ItemDao itemDao;

	public void init() {
		itemDao = new ItemDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/new":
			formCadastro(request, response);
			break;
		case "/insert":
			insertItem(request, response);
			break;
		case "/update":
			formUpdate(request, response);
			break;
		case "/deletar":
			formDelete(request, response);
			break;
		case "/editar":
			formEdicao(request, response);
			break;
		default:
			listItem(request, response);
			break;
		}
	}

	/**
	 * Formulario para deletar um item
	 * 
	 * @throws SQLException
	 * @throws IOException
	 * @throws ServletException
	 */
	private void formDelete(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		itemDao.deleteItem(id);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/lista");
		dispatcher.forward(request, response);
	}

	/**
	 * Formulario para atualizar um item
	 * 
	 * @throws SQLException
	 * @throws IOException
	 * @throws ServletException
	 */
	private void formUpdate(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String vehicleAply = request.getParameter("vehicle");
		Float pesoLiquido = Float.parseFloat(request.getParameter("netWeight"));
		Float pesoBruto = Float.parseFloat(request.getParameter("grossWeight"));
		itemDao.updateItem(new Item(id, name, vehicleAply, pesoLiquido, pesoBruto));
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/lista");
		dispatcher.forward(request, response);

	}

	/**
	 * Formulario para editar um item
	 * 
	 * @throws ServletException
	 * @throws IOException
	 */
	private void formEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Item itemExisting = itemDao.selectItem(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/formCadastro.jsp");
		request.setAttribute("item", itemExisting);
		dispatcher.forward(request, response);

	}

	/**
	 * Formulario para inserir novo item
	 * 
	 * @throws IOException
	 * @throws ServletException
	 */
	private void insertItem(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String name = request.getParameter("name");
		String vehicleAply = request.getParameter("vehicle");
		Float pesoLiquido = Float.parseFloat(request.getParameter("netWeight"));
		Float pesoBruto = Float.parseFloat(request.getParameter("grossWeight"));
		
		if (pesoLiquido >= pesoBruto) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/formCadastro.jsp");
			dispatcher.forward(request, response);
		}else {
			Item novoItem = new Item(name, vehicleAply, pesoLiquido, pesoBruto);
			itemDao.insertItem(novoItem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/lista");
			dispatcher.forward(request, response);
	
		}
		
	}

	/**
	 * Formulario de Cadastro
	 * 
	 * @throws IOException
	 * @throws ServletException
	 */
	private void formCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/formCadastro.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * Retorna a lista de itens para o tela
	 */
	private void listItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Item> itens = new ArrayList<>();
		itens = itemDao.selectItens();
		request.setAttribute("listItem", itens);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/itemList.jsp");
		dispatcher.forward(request, response);
	}

}
