package com.test.GestionDesEtudiants;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.test.GestionDesEtudiants.models.Etudiant;
import com.test.GestionDesEtudiants.repository.EtudiantRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class  GestionDesEtudiantsApplication {

	public static void main(String[] args) throws ParseException {

		ApplicationContext ctx =SpringApplication.run(GestionDesEtudiantsApplication.class, args);
/**
		EtudiantRepository etudiantRepository = ctx.getBean(EtudiantRepository.class);

		DateFormat df =new SimpleDateFormat("dd/mm/yyyy");
		etudiantRepository.save(new Etudiant("sanae","v357606","sanae@gmail.com",df.parse("01/01/2001"),"sanae.jpg"));
		etudiantRepository.save(new Etudiant("aziz","vb57606","aziz@gmail.com",df.parse("21/01/2000"),"aziz.jpg"));
		etudiantRepository.save(new Etudiant("aya","b15265","aya@gmail.com",df.parse("09/08/1998"),"aya.jpg"));

		etudiantRepository.save(new Etudiant("asmae","vpp57606","asmae@gmail.com",df.parse("01/03/1999"),"asmae.jpg"));

	Page<Etudiant> etd = etudiantRepository.searchEtudiants("hayat",PageRequest.of(0, 4));
	etd.forEach(e -> System.out.println(e.getName()));
 **/

	}

}
