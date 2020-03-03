package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Foreign;
import utils.DBUtil;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        //該当のIDの洋画１件をデータベースから取得
        Foreign f = em.find(Foreign.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        // 洋画情報とセッションIDをリクエストスコープに登録
        request.setAttribute("foreign", f);
        request.setAttribute("_token", request.getSession().getId());

        // 洋画データが存在しているときのみ
        // 洋画のIDをセッションスコープに登録
        if (f != null) {
            request.getSession().setAttribute("foreign_id", f.getId());
        }

        //洋画のIDをセッションスコープに登録
        request.getSession().setAttribute("foreign_id", f.getId());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/foreigns/edit.jsp");
        rd.forward(request, response);
    }

}
