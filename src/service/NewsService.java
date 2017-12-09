package service;

import dao.NewsDao;
import dto.ViewAllNewsDto;
import entity.News;
import sun.jvm.hotspot.utilities.ReversePtrs;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class NewsService {
    private static NewsService INSTANCE = null;

    private NewsService() {}

    public static NewsService getInstance() {
        if (INSTANCE == null) {
            synchronized (NewsService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new NewsService();
                }
            }
        }
        return INSTANCE;
    }

    public List<ViewAllNewsDto> getAllNews() {
        return NewsDao.getInstance().findAllNews().stream()
                .map(newsEntity -> new ViewAllNewsDto(newsEntity.getId(),
                        newsEntity.getHeadline(),
                        newsEntity.getText(),
                        newsEntity.getReleaseDate().format(DateTimeFormatter.ofPattern("HH:mm dd MMMM yyyy"))))
                .collect(Collectors.toList());
    }

    public void createNews(String headline, String text) {
        NewsDao.getInstance().create(new News(headline, text, LocalDateTime.now()));
    }

    public void deleteNews(long newsId) {
        News news = new News();
        news.setId(newsId);
        NewsDao.getInstance().delete(news);
    }
}
