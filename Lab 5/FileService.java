import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import BinaryFile;
import BinaryFileRepository;

@Service
public class FileService {

    @Autowired
    BinaryFileRepository repository;

    public void uploadFile(String name, byte[] data) {

        if (!repository.existsByFileName(name)) {

            BinaryFile file = new BinaryFile(name, data);
            repository.save(file);
        }
    }

    public byte[] downloadFile(String name) {

        BinaryFile binaryFile = repository.findByFileName(name);
        return binaryFile.getFileData();
    }

    public String getMediaType(String name) {

        String getFormat = name.split("\\.")[1];
        String type = null;

        switch (getFormat) {
            case "pdf":
                type = MediaType.APPLICATION_PDF_VALUE;
                break;
            case "txt":
                type = MediaType.TEXT_PLAIN_VALUE;
                break;
            case "jpg":
            case "jpeg":
                type = MediaType.IMAGE_JPEG_VALUE;
                break;
            case "png":
                type = MediaType.IMAGE_PNG_VALUE;
                break;
        }
        return type;
    }
}
