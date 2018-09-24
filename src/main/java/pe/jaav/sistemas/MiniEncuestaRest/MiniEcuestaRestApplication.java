package pe.jaav.sistemas.MiniEncuestaRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages={"pe.jaav.sistemas"})
@EnableTransactionManagement
@EnableJpaRepositories
public class MiniEcuestaRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniEcuestaRestApplication.class, args);
	}
}
