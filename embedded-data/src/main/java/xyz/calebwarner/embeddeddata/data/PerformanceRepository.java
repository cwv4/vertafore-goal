package xyz.calebwarner.embeddeddata.data;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.calebwarner.embeddeddata.model.Performance;

public interface PerformanceRepository extends JpaRepository<Performance, Long> {

}
