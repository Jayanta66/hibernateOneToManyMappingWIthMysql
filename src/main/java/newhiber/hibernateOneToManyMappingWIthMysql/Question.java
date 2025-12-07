package newhiber.hibernateOneToManyMappingWIthMysql;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table
public class Question {
	
	@Id
	private int questionId;
	private String question;
	
	
	@OneToMany(mappedBy = "question")
//	@JoinColumn(name="a_id")
	private List<Answer> answer;
	


}
