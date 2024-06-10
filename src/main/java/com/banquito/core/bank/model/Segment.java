package com.banquito.core.bank.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="SEGMENT")
public class Segment {

    @Id
    @Column(name="CODE_SEGMENT", length = 10, nullable = false )
    private String code;
    @Column(name="NAME", length = 50, nullable = false )
    private String name;
    @Column(name="CLIENT_TYPE", length = 3, nullable = false )
    private String clientType; 
    @Column(name="DESCRIPTION", length = 500, nullable = false )
    private String description;

    public Segment(String code){
        this.code = code;
    }

    @OneToMany(mappedBy = "segment")
    private List<Client> clients;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Segment other = (Segment) obj;
        if (code == null) {
            if (other.code != null)
                return false;
        } else if (!code.equals(other.code))
            return false;
        return true;
    }

}
