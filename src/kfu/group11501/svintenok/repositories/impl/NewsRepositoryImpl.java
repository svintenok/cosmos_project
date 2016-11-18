package kfu.group11501.svintenok.repositories.impl;

import kfu.group11501.svintenok.models.News;
import kfu.group11501.svintenok.repositories.NewsRepository;
import kfu.group11501.svintenok.singletons.DBSingleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class NewsRepositoryImpl implements NewsRepository {
    private Connection con = DBSingleton.getConnection();

    @Override
    public int addNews(News news) {
        try {
            PreparedStatement psmt = con.prepareStatement("insert into news(title, description, \"text\", \"date\") values(?,?,?,'now') returning id");
            psmt.setString(1, news.getTitle());
            psmt.setString(2, news.getDescription());
            psmt.setString(3, news.getText());

            psmt.execute();
            ResultSet resultId = psmt.getResultSet();
            if (resultId.next())
                return resultId.getInt("id");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public void removeNews(int id) {
        try {
            PreparedStatement psmt = con.prepareStatement("delete from news cascade where id=?");
            psmt.setInt(1, id);
            psmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateNews(News news) {
        try {
            PreparedStatement psmt = con.prepareStatement("update news set title=?, description=?, \"text\"=? where id=?");
            psmt.setString(1, news.getTitle());
            psmt.setString(2, news.getDescription());
            psmt.setString(3, news.getText());
            psmt.setInt(4, news.getId());

            psmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<News> getNewsList(int page, int limit) {

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                    "select * from news ORDER BY \"date\" desc limit " + limit + " offset " + (page-1)*limit);
            List<News> news_list = new ArrayList<>();

            while (rs.next()) {
                News news = new News(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("text"),
                        rs.getTimestamp("date"));
                news_list.add(news);
            }
            return  news_list;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public News getNewsById(int id) {
        try {
            PreparedStatement psmt = con.prepareStatement("select * from news where id=?");
            psmt.setInt(1, id);
            ResultSet rs = psmt.executeQuery();


            if (rs.next()) {
                News news = new News(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("text"),
                        rs.getTimestamp("date"));
                return news;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
