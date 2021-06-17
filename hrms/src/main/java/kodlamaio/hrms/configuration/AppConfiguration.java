package kodlamaio.hrms.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.imageService.ImageService;
import kodlamaio.hrms.core.utilities.imageService.Cloudinary.CloudinaryImageManager;

@Configuration
public class AppConfiguration {
    @Bean
    public Cloudinary cloudinaryService(){
        return new Cloudinary(ObjectUtils.asMap(
        		"cloud_name", "dgocszybq",
				"api_key", "144651824661293",
				"api_secret", "ad1jYeKBrc8vvF7FUJ42g47W7RY"));
    }

    @Bean
    public ImageService imageService(){
        return new CloudinaryImageManager(cloudinaryService());
    }
}