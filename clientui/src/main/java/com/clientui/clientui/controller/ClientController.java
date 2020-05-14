package com.clientui.clientui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clientui.clientui.beans.ProductBean;
import com.clientui.clientui.proxies.MicroserviceProduitsProxy;

@Controller
public class ClientController {
	
	@Autowired
	MicroserviceProduitsProxy mProduitsProxy;
	
	@RequestMapping("/")
	public String accueil(Model model) {
		
		List<ProductBean> produits = mProduitsProxy.listeDesProduits();
		
		model.addAttribute("produits", produits);
		
		return "Accueil";
		
	}
	
	@RequestMapping("/details-produit/{id}")
	public String ficheProduits(@PathVariable int id, Model model) {
		
		ProductBean produit = mProduitsProxy.recupererUnProduit(id);
		
		model.addAttribute("produit", produit);
		
		return "FicheProduit";
	}

}
