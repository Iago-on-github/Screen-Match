package br.com.alura.ScreenMatch;

import br.com.alura.ScreenMatch.Service.ConsumoAPI;
import br.com.alura.ScreenMatch.Service.ConverteDados;
import br.com.alura.ScreenMatch.model.DadosSerie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenMatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumoAPI consumoapi = new ConsumoAPI();
		var json = consumoapi.obterDados("https://www.omdbapi.com/?t=Breaking+Bad&apikey=833d85b2");
		System.out.println(json);
		//json = consumoapi.obterDados("https://coffee.alexflipnote.dev/random.json");
		//System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
	}
}
