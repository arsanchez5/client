package com.banquito.core.bank.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "CLIENT_ADDRESS")
public class ClientAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLIENT_ADDRESS_ID", nullable = false)
    private Integer id;

    @Column(name = "CLIENT_ID")
    private Integer clientId;

    @Column(name = "TYPE_ADDRESS", length = 3, nullable = false)
    private String typeAddress;

    @Column(name = "LINE1", length = 100, nullable = false)
    private String line1;

    @Column(name = "LINE2", length = 100)
    private String line2;

    @Column(name = "LATITUDE")
    private Float latitude;

    @Column(name = "LONGITUDE")
    private Float longitude;

    @Column(name = "IS_DEFAULT", nullable = false)
    private Boolean isDefault;

    @Column(name = "STATE", length = 3, nullable = false)
    private String state;

    public ClientAddress(Integer id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID", referencedColumnName ="CLIENT_ID")
    private Client client;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        ClientAddress other = (ClientAddress) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
}
