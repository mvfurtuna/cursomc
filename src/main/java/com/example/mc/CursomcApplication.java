package com.example.mc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.mc.domain.Categoria;
import com.example.mc.domain.Cidade;
import com.example.mc.domain.Cliente;
import com.example.mc.domain.Endereco;
import com.example.mc.domain.Estado;
import com.example.mc.domain.Produto;
import com.example.mc.domain.enums.TipoCliente;
import com.example.mc.repositories.CategoriaRepository;
import com.example.mc.repositories.CidadeRepository;
import com.example.mc.repositories.ClienteRepository;
import com.example.mc.repositories.EnderecoRepository;
import com.example.mc.repositories.EstadoRepository;
import com.example.mc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired 
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Categorias e produtos
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritórilo");
						
		Produto prod1 = new Produto(null,"Computador",2000.00);
		Produto prod2 = new Produto(null,"Impressora",800.00);
		Produto prod3 = new Produto(null,"Mouse",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(prod1,prod2,prod3));
		cat2.getProdutos().addAll(Arrays.asList(prod2));
		
		prod1.getCategorias().addAll(Arrays.asList(cat1));
		prod2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		prod3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(prod1,prod2,prod3));
		
		//Estado e cidades
		Estado e1 = new Estado(null,"São Paulo");
		Estado e2 = new Estado(null,"Minas Gerais");
		
		Cidade  c1 = new Cidade(null,"Campinas");
		Cidade  c2 = new Cidade(null,"São Paulo");
		Cidade  c3 = new Cidade(null,"Uberlândia");
		
		e1.getCidades().addAll(Arrays.asList(c1,c2));
		e2.getCidades().addAll(Arrays.asList(c3));
		
		c1.setEstado(e1);
		c2.setEstado(e1);
		c3.setEstado(e2);
		
		estadoRepository.saveAll(Arrays.asList(e1,e2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail","33333333",TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("1111111","222222"));
		
		Cliente cli2 = new Cliente(null, "Carlos", "maria@gmail","33333333",TipoCliente.PESSOAFISICA);
		cli2.getTelefones().addAll(Arrays.asList("33333333","4444444"));
		
		
		Endereco end1 = new Endereco(null, "Rua A","3300","apto 103","Jardim","111111",cli1,c1);
		Endereco end2 = new Endereco(null, "Rua b","4400","apto 104","Jardim","2222",cli1,c2);
		Endereco end3 = new Endereco(null, "Rua b","5500","apto 105","Jardim","5555",cli2,c2);
		cli1.getEnderecos().addAll(Arrays.asList(end1,end2));
		cli2.getEnderecos().addAll(Arrays.asList(end3));
		
		clienteRepository.saveAll(Arrays.asList(cli1,cli2));
		enderecoRepository.saveAll(Arrays.asList(end1,end2,end3));
		
	
	}

}
