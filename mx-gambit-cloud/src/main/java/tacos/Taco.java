// tag::all[]
// tag::allButValidation[]
package tacos;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
// end::allButValidation[]
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// tag::allButValidation[]
import lombok.Data;

@Data
@Entity
public class Taco {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;	
  // end::allButValidation[]
  @NotNull
  @Size(min=5, message="Name must be at least 5 characters long")
  // tag::allButValidation[]
  private String name;
  // end::allButValidation[]
  @ManyToMany(targetEntity=Ingredient.class)  
  @Size(min=1, message="You must choose at least 1 ingredient")
  // tag::allButValidation[]
  private List<Ingredient> ingredients = new ArrayList<>();

  private Date createdAt;

  @PrePersist
  void createdAt() {
    this.createdAt = new Date();
  }
}
//end::allButValidation[]
//tag::end[]