package br.com.caelum.todolistreact.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.caelum.todolistreact.models.Comment;

@Repository
public interface CommentDao extends CrudRepository<Comment, Integer> {
	
}
