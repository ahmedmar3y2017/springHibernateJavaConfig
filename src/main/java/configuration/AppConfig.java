package configuration;

/**
 * Created by ahmed on 5/27/2017.
 */
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"configuration","Entities","dao" , "service" })
public class AppConfig {

}
