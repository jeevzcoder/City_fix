package org.project.city_fix.Services;
import org.apache.commons.lang3.exception.ContextedRuntimeException;
import org.project.city_fix.Models.Image;
import org.project.city_fix.Repositories.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;

@Service
public class ImageService {

    @Autowired
    public ImageService(ImageRepo imageRepository) {
        this.imageRepository = imageRepository;
    }

    private final ImageRepo imageRepository;

    public Image uploadImage(MultipartFile imageFile) throws IOException {
        var imageToSave = new Image(imageFile.getOriginalFilename(), imageFile.getContentType(), ImageUtils.compressImage(imageFile.getBytes()));
        return imageRepository.save(imageToSave);
    }

    public byte[] downloadImage(String imageName) {
        Optional<Image> dbImage = imageRepository.findByName(imageName);

        return dbImage.map(image -> {
            try {
                return ImageUtils.decompressImage(image.getImageData());
            } catch (DataFormatException | IOException exception) {
                throw new ContextedRuntimeException("Error downloading an image", exception)
                        .addContextValue("Image ID",  image.getId())
                        .addContextValue("Image name", imageName);
            }
        }).orElse(null);
    }
}
