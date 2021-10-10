package hu.me.iit.webalk.first;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "article/")
public class MainController {
	private List<ArticleDto> articles = new ArrayList<>();
	private ArticleRepository articleRepository;

	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	List<ArticleDto> allArticles() {
		return articles;
	}

	@PostMapping(path = "")
	public void newArticle(@RequestBody @Valid ArticleDto articleDto) {
		articles.add(articleDto);

	}
	
	private int findArticleById(Long id) {
		int found = -1;
		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).getTitle().equals(id)) {
				found = i;
				break;
			}
		}
		return found;
	}

	@DeleteMapping(path = "/id")
	public void deleteArticle(@PathVariable("id") String id) {
		int found = -1;
		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).getTitle().equals(id)) {
				found = i;
				break;
			}
		}

		if (found != -1) {
			articles.remove(found);
		}
	}
	
	@PutMapping(path = "/id")
	public void replaceArticle(@PathVariable("id") Long id, @RequestBody @Valid ArticleDto articleDto) {
		
		int found = findArticleById(id);
		
		if (found!=-1) {
			ArticleDto foundArticle = articles.get(found);
			foundArticle.setAuthor(articleDto.getAuthor());
			foundArticle.setPages(articleDto.getPages());
		} else {
			articles.add(articleDto);
		}
		
	}
		
		

}
