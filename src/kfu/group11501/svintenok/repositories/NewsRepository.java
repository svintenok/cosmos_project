package kfu.group11501.svintenok.repositories;

import kfu.group11501.svintenok.models.News;

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

    List<News> getNewsList(int page, int limit);
    News getNewsById(int id);
}
