package ua.lviv.lgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ua.lviv.lgs.domain.Univercity;
import ua.lviv.lgs.service.UnivercityService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		UnivercityService service = ctx.getBean(UnivercityService.class);
		
		Univercity univercity1 = new Univercity();
		univercity1.setName("IFDTUNG");
		univercity1.setAddress("Karpatska str 28");
		univercity1.setLevelOfAccreditation(4);
		univercity1.setNumberOfInstitutes(1);
		univercity1.setNumberOfStudents(3250);
		
		Univercity univercity2 = new Univercity();
		univercity2.setName("PedInstitute");
		univercity2.setAddress("Chornovola str 16");
		univercity2.setLevelOfAccreditation(3);
		univercity2.setNumberOfInstitutes(2);
		univercity2.setNumberOfStudents(4504);
		
		Univercity univercity3 = new Univercity();
		univercity3.setName("Med University");
		univercity3.setAddress("Mazepi str 6");
		univercity3.setLevelOfAccreditation(2);
		univercity3.setNumberOfInstitutes(1);
		univercity3.setNumberOfStudents(2041);
		
		Univercity univercity4 = new Univercity();
		univercity4.setName("Ecomomix");
		univercity4.setAddress("Dnistrovska str 11");
		univercity4.setLevelOfAccreditation(1);
		univercity4.setNumberOfInstitutes(3);
		univercity4.setNumberOfStudents(3047);
		
		Univercity univercity5 = new Univercity();
		univercity5.setName("Ecology");		
		univercity5.setLevelOfAccreditation(2);
		univercity5.setNumberOfInstitutes(1);
		univercity5.setNumberOfStudents(3571);
		
		//create 
//		service.save(univercity1);
//		service.save(univercity2);
//		service.save(univercity3);
//		service.save(univercity4);
//		service.save(univercity5);
		
		//read		
		System.out.println(service.findById(1));
		System.out.println(service.findByName("Med University"));
		System.out.println(service.findByAddress("Chornovola str 16"));
		
		//delete
//		service.deleteById(4);
		
		//update
		Univercity univercityForUpdate = service.findByAddress("Chornovola str 16");
		univercityForUpdate.setName("PerUpdate Update");		
		univercityForUpdate.setLevelOfAccreditation(8);
		univercityForUpdate.setNumberOfInstitutes(8);
		univercityForUpdate.setNumberOfStudents(8888);
		
//		service.update(univercityForUpdate);
		
		//readAll
		System.out.println("read all");
		service.findAll().stream().forEach(System.out::println);
		
		System.out.println("Custom");
		System.out.println(service.findByLevelOfAccreditation(3));
		System.out.println(service.findByNumberOfInstitutes(1));
		System.out.println(service.findByNumberOfStudents(4504));
		
		System.out.println(service.findByLevelOfAccreditationLessThan(3));
		System.out.println(service.findByNumberOfStudentsBetween(3000, 4000));
		System.out.println(service.findByAddressIsNull());
		
		
	}

}
