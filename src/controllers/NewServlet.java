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
 * Servlet implementation class NewServlet
 */
@WebServlet("/new")
public class NewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();
        em.getTransaction().begin();

        //Foreignのインスタンス生成
        Foreign f = new Foreign();

        // fの各プロパティにデータを代入
        String title = "SUPERNATURAL";
        f.setTitle(title);

        String contents = "兄弟が悪魔退治をしていく物語";
        f.setContents(contents);

        double lat = 49.20678;
        f.setLat(lat);

        double lng = -122.91092;
        f.setLng(lng);

        String location = "カナダ　ニューウエストミンター";
        f.setLocation(location);

        //データベースに保存
        em.persist(f);
        em.getTransaction().commit();

        //自動採番されたIDの値を表示
        response.getWriter().append(Integer.valueOf(f.getId()).toString());

        em.close();
    }

}