package com.stream.project.src;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="movie_sequence")
	@Column(name="id", updatable=false) 
    private long id;
    @Column(name = "ref_ID", nullable = false )
    private String refID;
    @Column(name = "thumbnail", nullable = false )
    private String thumbnail;
    @Column(name = "description", nullable = false )
    private String description;

    public Movie(){
    }

    public Movie(String refID, String thumbnail, String description){
        this.refID = refID;
        this.thumbnail = thumbnail;
        this.description = description;
    }

    public void setID(long id){
        this.id = id;
    }

    public long getID(){
        return id;
    }

    public void setRefID(String refID){
        this.refID = refID;
    }

    public String getRefID(){
        return refID;
    }

    public void setThumbnail(String thumbnail){
        this.thumbnail = thumbnail;
    }

    public String getThumbnail(){
        return thumbnail;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}


