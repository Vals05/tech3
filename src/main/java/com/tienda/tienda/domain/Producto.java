package com.tienda.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="categoria")
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L; // Cambiado de 'serialVersion' a 'serialVersionUID'
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    
    private Long idProducto;
    @Column(name = "descripcion") // Actualiza el nombre de la columna aquí
    private String description;
    @Column(name = "ruta_imagen")
    private String rutaImagen;
    private boolean activo;
    
    public Producto() {
        // Constructor vacío
    }

    public Producto(String categoria, boolean activo) {
        this.description = categoria;
        this.activo = activo;
    }
}
