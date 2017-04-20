package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Pessoa implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @NotBlank(message = "O NOME deve ser INFORMADO")
    @NotNull(message = "O NOME não pode ser NULO")
    @Column(nullable = false)
    private String nome;
    
    @Pattern(regexp = "^\\([1-9]{2}\\) [9][8-9]{1}[0-9]{3}\\-[0-9]{4}$",
            message = "O número INVÁLIDO")
    @NotBlank(message = "O TELEFONE deve ser INFORMADO")
    @NotNull(message = "O TELEFONE não pode ser NULO")
    @Column(nullable = false)
    private String telefone;
    
    @NotBlank(message = "O ENDEREÇO deve ser INFORMADO")
    @NotNull(message = "O ENDEREÇO não pode ser NULO") 
    @Column(nullable = false)
    private String endereco;
    
    @ManyToOne (cascade = CascadeType.REFRESH)
    private Cidade cidade;
    @ManyToMany
    private Collection<Interesse> interesses= new ArrayList<>();
    public Pessoa() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Collection<Interesse> getInteresses() {
        return interesses;
    }

    public void setInteresses(Collection<Interesse> interesses) {
        this.interesses = interesses;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.interesses, other.interesses)) {
            return false;
        }
        return true;
    }

  
    
    

   
    @Override
    public String toString() {
        return "Pessoa{" + "cidade=" + cidade + '}';
    }

   

   
    

}
