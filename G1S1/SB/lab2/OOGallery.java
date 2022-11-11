import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * @homework_id G1S1.SB.Lab2
 */

public class OOGallery extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter o = response.getWriter();
		String theme = request.getParameter("theme"), bgrnd = request.getParameter("bgrnd");
		HtmlPage page = new HtmlPage();
		page.addText(new HtmlImage(theme + "One.jpg", "pic1").buildHtml());
		page.addText(new HtmlImage(theme + "Two.jpg", "pic2").buildHtml());
		page.setTitle("Fei Pan");
		page.setBackgroundImage(bgrnd + ".gif");
		page.setBackgroundColor("#aff835");
		o.println(page.buildHtml());
	}
}