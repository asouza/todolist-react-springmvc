package br.com.caelum.todolistreact.controllers;

import java.net.URI;
import java.net.URISyntaxException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.caelum.todolistreact.daos.CommentDao;
import br.com.caelum.todolistreact.models.Comment;

@RestController
@RequestMapping("/api")
public class CommentsController {

	@Autowired
	private CommentDao commentDao;

	@RequestMapping(value = "/comments", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity create(@Valid @RequestBody Comment comment) throws URISyntaxException {

		commentDao.save(comment);
		return ResponseEntity.status(302).header("Location", "/api/comments").build();
	}
	
	@RequestMapping(value= "/comments", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Comment> lista(){
		return commentDao.findAll();
	}
}
