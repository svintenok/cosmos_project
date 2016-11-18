package services.impl;

import models.News;
import repository.NewsRepository;
import repository.impl.NewsRepositoryImpl;
import services.NewsService;

import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 05.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class NewsServiceImpl implements NewsService {
    final static int newsLimit = 8;
    private NewsRepository newsRepository = new NewsRepositoryImpl();

    @Override
    public int addNews(News news) {
        return newsRepository.addNews(news);
    }

    @Override
    public News getNewsById(int id) {
        return newsRepository.getNewsById(id);
    }

    @Override
    public List<News> getNewsList(int page) {
        return newsRepository.getNewsList(page, newsLimit);
    }

    public static int getNewsLimit() {
        return newsLimit;
    }
}
