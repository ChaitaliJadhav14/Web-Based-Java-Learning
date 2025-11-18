package example.servlet;
//all this library files under Tomcat
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class GreetingServlet
 */
@WebServlet(name = "myGreetingServlet", urlPatterns = { "/doGreet" })
public class GreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void init() {
		System.out.println("Inside init()");
	}
	
	@Override
	public void destroy() {
		System.out.println("Inside destroy()");
	}
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//When a request is made to the servlet,this doGet() method is invoked
		//It provides logic for handling the request.
		System.out.println("Request Received");
		response.setContentType("text/html");  //MIME -Multipurpose Internet Mail Extension
		String responseText = 
				"<h1 style='color:red'>Welcome to Servlets</h1>";
		
		PrintWriter out = response.getWriter();  //Server can write the response using PrintWriter class
		out.println(responseText);
	}

}
