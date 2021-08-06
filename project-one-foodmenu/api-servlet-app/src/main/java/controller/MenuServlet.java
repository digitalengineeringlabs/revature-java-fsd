package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import common.model.Menu;
import manager.MenuManager;

@SuppressWarnings("serial")
@WebServlet("/menus")
public class MenuServlet extends HttpServlet {

	private MenuManager manager = new MenuManager();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("application/json");

		List<Menu> menus = manager.findAll();

		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(menus);

		resp.getWriter().print(jsonInString);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuffer jsonStr = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = req.getReader();
			while ((line = reader.readLine()) != null)
				jsonStr.append(line);
		} catch (Exception e) {
			/* report an error */ }

		ObjectMapper mapper = new ObjectMapper();
		Menu menu = mapper.readValue(jsonStr.toString(), Menu.class);

		try {
			manager.create(menu);
			resp.setStatus(200);
			String jsonResponse = mapper.writeValueAsString(menu);
			resp.getWriter().print(jsonResponse);
		} catch (Exception e) {
			resp.setStatus(500);
			resp.getWriter().print("{\"error\":" + e.getMessage() + "}");
		}

		resp.setContentType("application/json");

	}
}
