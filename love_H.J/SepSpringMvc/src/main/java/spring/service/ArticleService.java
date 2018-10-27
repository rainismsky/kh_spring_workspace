package spring.service;

public class ArticleService {
public void writeArticle(NewArticleCommand command) {
	System.out.println("신규 게시글을 등록한다:"+command);
}
}
