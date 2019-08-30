package com.loja.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loja.model.ProdutoModel;
import com.loja.repository.ProdutoRepository;

@Service
@Transactional
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	public List<ProdutoModel> listAll() {
		return repository.findAll();
	}

	public ProdutoModel get(long id) {
		return repository.findById(id).get();
	}

	public void save(ProdutoModel produto) {
		repository.save(produto);
	}
	
	public void delete(long id) {
		repository.deleteById(id);
	}

}
