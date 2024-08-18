package com.tienda.tienda.controller;

import com.tienda.tienda.Service.CategoriaService;
import com.tienda.tienda.Service.ProductoService;
import com.tienda.tienda.domain.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pruebas")
public class PruebasController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = productoService.getProductos(false);
        model.addAttribute("productos", lista);
        model.addAttribute("totalProductos", lista.size());

        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        return "/pruebas/listado";
    }

    @GetMapping("/listado/{idCategoria}")
    public String listado(Model model, Categoria categoria) {
        var lista = categoriaService.getCategoria(categoria).getProductos();
        model.addAttribute("productos", lista);
        model.addAttribute("totalProductos", lista.size());

        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        return "/pruebas/listado";

    }
    
    @GetMapping("/listado2")
    public String listado2(Model model) {
        var lista = productoService.getProductos(false);
        model.addAttribute("productos", lista);
        model.addAttribute("totalProductos", lista.size());
        return "/pruebas/listado2";
    }
    @PostMapping("/queryl")
    public String consultaQueryl(
            @RequestParam(value="precioInf") double precioInf,
            @RequestParam(value="precioSup") double precioSup,
            
            Model model) {
        var lista = productoService.findByPrecioDetweenOrderByDescripcion(precioInf, precioSup);
        model.addAttribute("productos", lista);
        model.addAttribute("totalProductos", lista.size());
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "/pruebas/listado2";
    }    
    @PostMapping("/query2")
    public String consultaQuery2(
            @RequestParam(value="precioInf") double precioInf,
            @RequestParam(value="precioSup") double precioSup,
            
            Model model) {
        var lista = productoService.metodoJPQL(precioInf, precioSup);
        model.addAttribute("productos", lista);
        model.addAttribute("totalProductos", lista.size());
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "/pruebas/listado2";
    }    
    @PostMapping("/query3")
    public String consultaQuery3(
            @RequestParam(value="precioInf") double precioInf,
            @RequestParam(value="precioSup") double precioSup,
            
            Model model) {
        var lista = productoService.metodoSQL(precioInf, precioSup);
        model.addAttribute("productos", lista);
        model.addAttribute("totalProductos", lista.size());
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "/pruebas/listado2";
    }    
}
