package com.example.demo;



import java.sql.Date;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@SpringBootApplication
public class JwtSpringAngularApplication implements CommandLineRunner{

	@Autowired
	EtudiantRepository etudiantRepository;
	
	@Autowired
	FormationRepository formationRepository;
	 
	@Autowired
	RepositoryRestConfiguration repositoryRestConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(JwtSpringAngularApplication.class, args);
		
	}
	@Override
	public void run(String... args) throws Exception {
		
		
		repositoryRestConfiguration.exposeIdsFor(Formation.class,Etudiant.class);
		/*Formation f1 = formationRepository.save(new Formation("formation1", 2,null));
		Formation f2 = formationRepository.save(new Formation("formation2", 4,null));*/
		Formation f3 = formationRepository.save(new Formation("formation3", 5,null));
		Formation f4 = formationRepository.save(new Formation("formation3", 4,null));
		etudiantRepository.save(new Etudiant("nom3","prenom3",new Date(Calendar.getInstance().getTime().getTime()),f3));
		etudiantRepository.save(new Etudiant("nom2","prenom2",new Date(Calendar.getInstance().getTime().getTime()),f4));
		/*etudiantRepository.save(new Etudiant("nom1","prenom1",new Date(Calendar.getInstance().getTime().getTime()),f1));
		etudiantRepository.save(new Etudiant("nom2","prenom2",new Date(Calendar.getInstance().getTime().getTime()),f2));
		
		etudiantRepository.save(new Etudiant("nom4","prenom4",new Date(Calendar.getInstance().getTime().getTime()),f1));
		
		*/
		
	}

}

