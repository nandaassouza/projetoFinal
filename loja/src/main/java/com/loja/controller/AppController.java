package com.loja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.loja.dao.ProdutoService;
import com.loja.model.ProdutoModel;

@Controller
public class AppController {

	@Autowired
	private ProdutoService service;

	@RequestMapping("/")
	public String viewHomPage(Model model) {
		List<ProdutoModel> listProduto = service.listAll();
		model.addAttribute("listProduto", listProduto);
		return "index";
	}

	@RequestMapping("/cadastro_produto")
	public String showNewProductPage(Model model) {
		ProdutoModel produto = new ProdutoModel();
		model.addAttribute("produto", produto);
		return "cadastro_produto";
	}
	
	@RequestMapping("/save")
	public String save(ProdutoModel produto) {
		service.save(produto);
		return "redirect:/";
	}

	@RequestMapping("/edit_produto/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id")long id) {
		ModelAndView mav = new ModelAndView("edit_produto");
		ProdutoModel produto = service.get(id);
		mav.addObject("produto", produto);
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable(name = "id")long id, Model model) {
		service.delete(id);
		return "redirect:/";
	}

}
