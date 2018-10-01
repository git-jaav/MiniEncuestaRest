package pe.jaav.sistemas.MiniEncuestaRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages={"pe.jaav.sistemas"},exclude = JpaRepositoriesAutoConfiguration.class)
@EnableTransactionManagement
@EnableConfigurationProperties
//@EnableJpaRepositories
public class MiniEcuestaRestApplication {

	public static void main(String[] args) {		
		SpringApplication.run(MiniEcuestaRestApplication.class, args);
	}
}
