package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Configuration // Indica que a classe contém a configuração de um bean para o Spring.
@Profile("test") //Define que essa configuração só será ativada quando o perfil ativo for "test", permitindo que os dados de teste sejam carregados apenas em ambientes de teste.
public class TestConfig implements CommandLineRunner { //permite executar um código específico assim que a aplicação é iniciada.
	
	@Autowired // Injeta automaticamente uma instância de UserRepository para acessar o banco de dados e salvar objetos User
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2)); //salva as instâncias no banco de dados, armazenando-as na tabela associada a User.
	}
	
	
	

}
