package zerobase.weather.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Dairy {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String weather;

  private String icon;

  private double temperature;

  private String text;

  private LocalDate date;
}
