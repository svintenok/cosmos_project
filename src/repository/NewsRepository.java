package repository;

import models.News;

import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task: semester project
 */

public interface NewsRepository {
    int addNews(News news);
    void removeNews(int id);
    void updateNews(News news);

    List<News> getNewsList();
    News getNewsById(int id);
}
