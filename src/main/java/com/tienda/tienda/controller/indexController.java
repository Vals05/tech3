
package com.tienda.tienda.controller;

import com.tienda.tienda.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/categoria")
public class indexController {
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/listado")
    public String inicio(Model model){
       var categorias = categoriaService.getCategorias(false);
       model.addAttribute("categorias", categorias);
       model.addAttribute("totalCategorias", categorias.size());
       return "/categoria/listado";
        
    }
}
