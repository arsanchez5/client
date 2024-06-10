package com.banquito.core.bank.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="CLIENT")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLIENT_ID", nullable = false)
    private Integer id;

    @Column(name = "CODE_SEGMENT", length = 10, nullable = false)
    private String codeSegment;

    @Column(name = "CLIENT_TYPE", length = 3, nullable = false)
    private String clientType;

    @Column(name = "IDENTIFICATION_TYPE", length = 3, nullable = false)
    private String identificationType;

    @Column(name = "IDENTIFICATION", length = 20, nullable = false)
    private String identification;

    @Column(name = "LAST_NAME", length = 50)
    private String lastName;

    @Column(name = "FIRST_NAME", length = 50)
    private String firstName;

    @Column(name = "FULL_NAME", length = 100)
    private String fullName;

    @Column(name = "EMAIL", length = 100, nullable = false)
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @Column(name = "COMPANY_NAME", length = 100)
    private String companyName;

    @Column(name = "COMPANY_TYPE", length = 16)
    private String companyType;

    @Column(name = "STATE", length = 3, nullable = false)
    private String state;

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATE_DATE", nullable = false)
    private Date createDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "LAST_STATUS_DATE", nullable = false)
    private Date lastStatusDate;

    @Column(name = "NATIONALITY", length = 50)
    private String nationality;

    @Column(name = "MARITAL_STATUS", length = 3)
    private String maritalStatus;

    @Column(name = "MONTHLY_AVG_INCOME", precision = 17, scale = 2)
    private BigDecimal monthlyAvgIncome;

    @Column(name = "NOTES",length = 1000)
    private String notes;

    public Client(Integer id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "CODE_SEGMENT", referencedColumnName = "CODE_SEGMENT", insertable = false, updatable = false)
    private Segment segment;

    @OneToMany(mappedBy = "client")
    private List<ClientPhone> phones;

    @OneToMany(mappedBy = "client")
    private List<ClientAddress> addresses;

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
        Client other = (Client) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
