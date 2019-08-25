package com.velone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velone.entity.Membre;
import com.velone.entity.Message;
import com.velone.entity.Statistique;
import com.velone.repository.MessageRepository;

@Service
public class MessageService {

	@Autowired
	MessageRepository repository;
	
	public void add(Message message) {
		repository.save(message);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public List<Message> getMessages() {
		return repository.findAll();
	}
	
	public void update(Integer id, Message mess) {
		Message messToUpdate = repository.getOne(id);
		messToUpdate.setTexte(mess.getTexte());
		repository.save(messToUpdate);
	}
	
	public Optional<Message> getMessageById(Integer id) {
		return repository.findById(id);
	}
}
