package hu.me.iit.webalk.first;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ArticleDto {

	@Override
	public String toString() {
		return "ArticleDto [author=" + author + ", title=" + title + ", pages=" + pages + ", id=" + id
				+ ", getAuthor()=" + getAuthor() + ", getTitle()=" + getTitle() + ", getPages()=" + getPages()
				+ ", getId()=" + getId() + "]";
	}
	
	@NotNull
	@NotBlank
	private String author;
	@NotBlank
	private Integer title;
	@Min(10)
	private Integer pages;
	
	@NotNull
	private Long id;
	
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getTitle() {
		return title;
	}
	public void setTitle(Integer title) {
		this.title = title;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
	
	}
	
	

