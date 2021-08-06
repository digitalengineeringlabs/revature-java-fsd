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
import common.util.AppConstants;
import common.util.JSONUtil;
import manager.MenuManager;

@SuppressWarnings("serial")
@WebServlet("/menus")
public class MenuServlet extends HttpServlet {

	private MenuManager manager = new MenuManager();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//get data from backend
		List<Menu> menus = manager.findAll();
		//transform java object to JSON string
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(menus);
		//send success response to client
		resp.getWriter().print(jsonInString);
		resp.setContentType(AppConstants.HTTP_JSON_CONTENT);
		resp.setStatus(AppConstants.HTTP_OK);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			//get JSON data from HTTP body
			ObjectMapper mapper = new ObjectMapper();
			Menu menu = mapper.readValue(JSONUtil.getJSONData(req), Menu.class);
			//persist data to backend
			manager.create(menu);
			//send success response to client
			String jsonResponse = mapper.writeValueAsString(menu);
			resp.getWriter().print(jsonResponse);
			resp.setStatus(AppConstants.HTTP_OK);
		} catch (Exception e) {
			//send failure response to client
			resp.getWriter().print(JSONUtil.getErrorMessage(e.getMessage()));
			resp.setStatus(AppConstants.HTTP_ERROR);
		}

		resp.setContentType(AppConstants.HTTP_JSON_CONTENT);

	}
}
