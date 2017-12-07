package service;

import dao.NewsDao;
import dto.ViewAllNewsDto;
import entity.News;

import java.time.LocalDateTime;
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
                .peek(news -> System.out.println(news.getReleaseDate() + " " + news.getText()))
                .map(newsEntity -> new ViewAllNewsDto(newsEntity.getId(), newsEntity.getText(), newsEntity.getReleaseDate()))
                .collect(Collectors.toList());
    }

    public void createNews(String text) {
        NewsDao.getInstance().create(new News(text, LocalDateTime.now()));
    }
}
