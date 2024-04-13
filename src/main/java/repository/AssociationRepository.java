package repository;

import model.Association;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssociationRepository extends JpaRepository<Association, String> {
    Optional<Association> findById(int id);
}
