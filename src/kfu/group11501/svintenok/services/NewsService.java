package kfu.group11501.svintenok.services;

import kfu.group11501.svintenok.models.News;

import javax.servlet.http.Part;
import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 05.11.2016
 * Group: 11-501
 * Task: semester project
 */
public interface NewsService {

    int addNews(News news, Part photo);
    void removeNews(int id);
    void updateNews(News news, Part photo);

    News getNewsById(int id);
    List<News> getNewsList(int page);

}
