package br.com.helloworld.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.helloworld.dao.DAO;
import br.com.helloworld.model.Livro;
import br.com.helloworld.model.LivroLista;
import br.com.helloworld.model.User;

@Controller
@RequestMapping("index")
public class IndexController {
	
	@Autowired
	private DAO<User> userDAO;
	@Autowired
	private DAO<Livro> livroDAO;
	
	@RequestMapping("/add-client")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("/add-client/profession")
	public ModelAndView indexProfession() {
		List<User> lista = userDAO.selectAll();
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("profession", true);
		mv.addObject(lista);
		//aa
		return mv;
	}
	
	
	
	@RequestMapping("/cadastraLivros")
	public ModelAndView cadastraLivros(){
		return new ModelAndView("cadastraLivros");
	}
	@RequestMapping("/saveLivro")
	@ResponseBody
	public String saveLivro(@RequestParam("titulo") String titulo){
		Livro livro = new Livro(titulo);
		livroDAO.save(livro);
		return "livro cadastrado com sucesso :D";
	}
	
	@RequestMapping("/testehaha")
	public ModelAndView listUsers(){
		ModelAndView mv = new ModelAndView("list");
		List<User> lista = userDAO.selectAll(); 
		mv.addObject("lista",lista	);
		return mv;
	}
	@RequestMapping("/escolheLivro")
	public ModelAndView escolheLivro(){
		ModelAndView mv = new ModelAndView("escolhas");
		List<Livro> listaLivros = livroDAO.selectAllLivros();
		mv.addObject("listaLivros",listaLivros);
		return mv;
	}
	
	@RequestMapping(value = "/getLirosOrdem", 
            method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
	@ResponseBody
	public String getLirosOrdem(@RequestBody String []livroLista) {
		System.out.print(livroLista);
		return "";
	}
	
	
	@RequestMapping("/save")
	@ResponseBody
	public String saveClient(@RequestParam("name") String name, @RequestParam("age") int age, @RequestParam("profession") String profession) {
		User user = new User(name, age, profession);
		userDAO.save(user);
		return "Cliente cadastrado com sucesso!";
	}

}