package com.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loja.model.ProdutoModel;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

}
