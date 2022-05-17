package com.unidad4_paw.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter@Getter
@Entity
@Table(name = "clientes")
public class Cliente  implements Serializable{
    
    private static final long serialVersionUID = 3283444068336136587L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String email;

    @Column(name =  "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;


    @PrePersist
    public void prePersist(){
        createAt = new Date();
    }
}
