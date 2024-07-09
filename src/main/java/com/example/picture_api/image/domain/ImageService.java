import java.awt.Image;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.picture_api.image.entity.Image;
import com.example.picture_api.image.repository.ImageRepository;

@Service

public class ImageService {

    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    public void saveImage(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getOriginalFilename());
        image.setData(file.getBytes());
        imageRepository.save(image);
    }

    public Optional<Image> findById(Long id) {
        return imageRepository.findById(id);
    }
}
