package code.pragra.learning.spring_api_jugraj.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer nurseId;
    private String nurseFirstName;
    private String nurseLastName;
    private String nursePhoneNo;
    private Integer nurseSalary;
    private String nursePassword;


}
