import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "binary_file")
@Data
@NoArgsConstructor
public class BinaryFile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "file_name")
    String fileName;

    @Column(name = "file_data")
    byte[] fileData;

    public BinaryFile() {
    }

    public BinaryFile(String name, byte[] data) {
        this.fileData = data;
        this.fileName = name;
    }
}
