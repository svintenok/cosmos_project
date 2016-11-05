package services;

import models.News;
import repository.NewsRepository;
import repository.NewsRepositoryImpl;

import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 05.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class NewsServiceImpl implements NewsService{
    private NewsRepository newsRepository = new NewsRepositoryImpl();

    @Override
    public void addNews(News news) {

    }

    @Override
    public News getNewsById(int id) {
        return newsRepository.getNewsById(id);
    }

    @Override
    public List<News> getNewsList() {
        return newsRepository.getNewsList();
    }
}
