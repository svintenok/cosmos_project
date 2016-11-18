package kfu.group11501.svintenok.services.impl;

import kfu.group11501.svintenok.models.News;
import kfu.group11501.svintenok.repositories.NewsRepository;
import kfu.group11501.svintenok.repositories.impl.NewsRepositoryImpl;
import kfu.group11501.svintenok.services.NewsService;

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
