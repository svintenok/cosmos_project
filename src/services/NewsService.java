package services;

import models.News;

import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 05.11.2016
 * Group: 11-501
 * Task: semester project
 */
public interface NewsService {

    int addNews(News news);

    News getNewsById(int id);
    List<News> getNewsList(int page);

}
