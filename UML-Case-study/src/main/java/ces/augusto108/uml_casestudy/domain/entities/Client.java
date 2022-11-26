package ces.augusto108.uml_casestudy.domain.entities;

import ces.augusto108.uml_casestudy.domain.enums.ClientType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Client implements Serializable {
    private static final long serialVersionUID = -7564570632268951823L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "client_name")
    private String name;

    @Column(name = "client_email")
    private String email;

    @Column(name = "client_identification")
    private String identification;
    private Integer type;

    @ManyToMany(mappedBy = "clients")
    private final List<Address> addresses = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "telephone")
    private final Set<String> telephones = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private final List<Purchase> purchases = new ArrayList<>();

    public Client() {
    }

    public Client(Integer id, String name, String email, String identification, ClientType type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.identification = identification;
        this.type = type.getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public ClientType getType() {
        return ClientType.convertToEnum(type);
    }

    public void setType(ClientType type) {
        this.type = type.getId();
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public Set<String> getTelephones() {
        return telephones;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id.equals(client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
