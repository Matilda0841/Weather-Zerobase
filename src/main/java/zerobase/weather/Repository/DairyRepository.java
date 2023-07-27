package zerobase.weather.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zerobase.weather.Domain.Dairy;

@Repository
public interface DairyRepository extends JpaRepository<Dairy, Integer> {
}
