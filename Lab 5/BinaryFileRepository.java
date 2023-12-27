import org.springframework.data.jpa.repository.JpaRepository;
import models.BinaryFile;

public interface BinaryFileRepository extends JpaRepository<BinaryFile, Integer> {

    BinaryFile findByFileName(String fileName);

    Boolean existsByFileName(String fileName);
}
