package fr.dta.persistence;

import java.io.Serializable;
public interface IoEntity extends Serializable {
    public Long getId();
    public void setId(Long id);

}