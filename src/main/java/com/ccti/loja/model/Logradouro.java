package com.ccti.loja.model;

//import com.bedatadriven.jackson.datatype.jts.serialization.GeometryDeserializer;
//import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.vividsolutions.jts.geom.MultiLineString;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "logradouro", schema = "loja")
public class Logradouro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "geom", nullable = false, columnDefinition = "geometry(MultiLineString,32622)")
//    @Type(type = "org.hibernate.spatial.GeometryType")
    //@Column(columnDefinition = "Geometry", nullable = false)
    @Type(type = "org.hibernate.spatial.GeometryType")
    private MultiLineString geom;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cep")
    private String cep;

    @ManyToOne
    private Bairro bairro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MultiLineString getGeom() {
        return geom;
    }

    public void setGeom(MultiLineString geom) {
        this.geom = geom;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

}
