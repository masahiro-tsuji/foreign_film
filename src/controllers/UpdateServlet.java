package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Foreign;
import utils.DBUtil;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String _token = (String) request.getParameter("_token");
        if (_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            // セッションスコープから洋画データを取得して
            // 該当のIDの洋画1件のみをデータベースから取得
            Foreign f = em.find(Foreign.class, (Integer) (request.getSession().getAttribute("foreign_id")));

            // フォームの内容を各プロパティに上書き
            f.setTitle(request.getParameter("title"));
            //f.setImg(request.getParameter("img"));
            f.setContents(request.getParameter("contents"));
            f.setLocation(request.getParameter("location"));
            f.setLat(Double.parseDouble(request.getParameter("lat")));
            f.setLng(Double.parseDouble(request.getParameter("lng")));

            // データベースを更新
            em.getTransaction().begin();
            em.getTransaction().commit();
            em.close();

            // セッションスコープ上の不要になったデータを削除
            request.getSession().removeAttribute("foreign_id");

            // indexページへリダイレクト
            response.sendRedirect(request.getContextPath() + "/index");
        }

    }
}
