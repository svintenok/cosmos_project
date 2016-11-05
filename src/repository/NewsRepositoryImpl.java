package repository;

import models.News;
import singletons.DBSingleton;

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
    public void addNews(News news) {

    }

    @Override
    public void removeNews(int id) {

    }

    @Override
    public void updateNews(News news) {

    }

    @Override
    public List<News> getNewsList() {

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from news ORDER BY \"date\"");
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
