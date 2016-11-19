package kfu.group11501.svintenok.services.impl;

import kfu.group11501.svintenok.models.News;
import kfu.group11501.svintenok.repositories.NewsRepository;
import kfu.group11501.svintenok.repositories.impl.NewsRepositoryImpl;
import kfu.group11501.svintenok.services.NewsService;

import javax.servlet.http.Part;
import java.util.List;

import static kfu.group11501.svintenok.helpers.Helper.downloadPhoto;

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
    public int addNews(News news, Part newsPhoto) {
        int id = newsRepository.addNews(news);
        if (newsPhoto.getSize() !=  0)
            downloadPhoto(newsPhoto, "news_photo/" + id);
        return id;
    }

    @Override
    public void removeNews(int id) {
        newsRepository.removeNews(id);
    }

    @Override
    public void updateNews(News news, Part news_photo) {
        if (news_photo.getSize() !=  0)
            downloadPhoto(news_photo, "news_photo/" + news.getId());

        newsRepository.updateNews(news);
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
