package com.sherold.web.controllers;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Instatiates session
		HttpSession session = request.getSession(false);
		
		// Checks to see if randNum value is null, if so set value to 0
		if(session == null) {
			// Instantiate a new session
			session = request.getSession();
			
			// Instantiate the Random class
			Random r = new Random();
			
			// Generates a random number between 1 and 100;
			int n = r.nextInt(100) + 1;
			
			// Sets session attributes
			session.setAttribute("randNum", n);
			
			// // Sets model properties
			request.setAttribute("result", null);
		// else capture session data for the view
		} else {
			int n = (int) session.getAttribute("randNum");
			// Sets model properties
			request.setAttribute("result", null);
		}			
		
		// Let the view handle the request
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
		view.forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Instantiates session
		HttpSession session = request.getSession();	
		
		// Grabs 'guess' / session data
		int g = Integer.parseInt(request.getParameter("guess"));
		int n = (int) session.getAttribute("randNum");	
		
		// Even modifiers for result attribute on model property
		if (g == n) {
			// result equals success
			request.setAttribute("result", "success");
			request.setAttribute("randNum", n);
			
			// if guess is higher than random number
		} else if (g > n) {			
			// result equals higher
			request.setAttribute("result", "higher");
			
			// if guess is lower than random number
		} else if (g < n) {
			// result equals lower
			request.setAttribute("result", "lower");
			
			// else, result is null
		} else {
			request.setAttribute("result", null);
		}

		// Let the view handle the request
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
		view.forward(request,  response);
	}

}
