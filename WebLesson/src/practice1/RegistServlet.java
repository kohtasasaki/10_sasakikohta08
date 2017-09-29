package practice1;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegistServlet extends HttpServlet{
	protected void service(HttpServletRequest req,HttpServletResponse res)
			throws ServletException,IOException{
		req.setCharacterEncoding("UTF-8");

		String english = req.getParameter("english");
		String japanese = req.getParameter("japanese");

		ArrayList<Word> words = new ArrayList<>();

		Word wd = new Word(english,japanese);
		words.add(wd);

		WordDAO dao = new WordDAO();
		dao.registWords(words);


		req.setAttribute("english", english);
		req.setAttribute("japanese", japanese);

		HttpSession session = req.getSession(true);
		session.setAttribute("english", req.getParameter("english"));
		session.setAttribute("japanese", req.getParameter("japanese"));



		//データベースの総件数を表示する
		java.util.List<Word> wList = new ArrayList<>();
		wList = dao.getWords();
		int saveCount = dao.registWords(words);


		int total = 0;
		for(Word wl : wList){
			total++;
		}

			req.setAttribute("registCount",saveCount);
			req.setAttribute("total",total);
			req.getRequestDispatcher("result.jsp").forward(req, res);

	}
}