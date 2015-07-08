$( document ).ready(function() {
	var _self = this;
	$(".btn button").click(function(){
		var livroSelecionado = {};
		
		var tituloSelecionado = $(this).parent().parent().find(".tituloLivro");
		livroSelecionado.titulo = $(tituloSelecionado).find("span").text();
		livroSelecionado.posicao = parseInt($(tituloSelecionado).find(".posicao").text());
		$(tituloSelecionado).toggleClass("tituloLivro");
		
		var livroPerdedor = {};
		livroPerdedor.titulo = $(".tituloLivro span").text();
		livroPerdedor.posicao = parseInt($(".tituloLivro .posicao").text());
		$(tituloSelecionado).toggleClass("tituloLivro");
		
		comparaLivros(livroSelecionado, livroPerdedor);
	});
	function comparaLivros(livroSelecionado, livroPerdedor){
		var _self = this;
		if (livroSelecionado.posicao < livroPerdedor.posicao){
			var aux = livroPerdedor;
			_self.lista[currentItem] = livroPerdedor.titulo;
			_self.lista[currentItem+1] = livroSelecionado.titulo;
			_self.ultimaAlteracao = currentItem;
		}
		_self.currentItem++;
		if (_self.currentItem == _self.lista.length -1){  // se for o ultimo item da 
			adicionaCampeao(livroSelecionado.titulo);
			_self.lista.pop();
			if (typeof(_self.ultimaAlteracao) == "undefined"){   //condicao necessaria para o usuário nao comparar livros que já estiverem na ordem.
				_self.adicionaRestoArray();
				acabou();
				return;
			}else{
				_self.currentItem = _self.ultimaAlteracao -1;
				delete _self.ultimaAlteracao;
			}
		}
		if (_self.lista.length == 1){ //ultimo item da lista
			adicionaCampeao(_self.lista[0]);
			acabou();
			return;
		}
		_self.populaTela();
	}
});
function acabou(){
	var _self = this;
	console.log("acabou!");
	_self.createBla(_self.listaCampeao);
	$(".btn button").off();
}
function adicionaRestoArray(){
	var _self = this;
	$.merge(_self.listaCampeao,_self.lista);
}
function adicionaCampeao(campeao){
	var _self = this;
	if (typeof(_self.listaCampeao) == 'undefined'){
		_self.listaCampeao = [];
	}
	_self.listaCampeao.push(campeao);
}
function populaTela(){
	var _self = this;	
	if (_self.currentItem < _self.lista.length -1){
		$(".quadroDentroEsquerda .tituloLivro span").text(_self.lista[_self.currentItem]);
		$(".quadroDentroEsquerda .posicao").text(_self.lista.indexOf(_self.lista[_self.currentItem]));
		$(".quadroDentroDireita .tituloLivro span").text(_self.lista[_self.currentItem+1]);
		$(".quadroDentroDireita .posicao").text(_self.lista.indexOf(_self.lista[_self.currentItem+1]));
	}
}

function saveLivro(){
	var titulo = $('#titulo').val();
	$.ajax({
		url: '/MyWebProject2/index/saveLivro?titulo=' + titulo,
		success: function(result) {
			alert(result);
		},
		error: function(result){
			alert('erro ao cadastrar livro');
		}	
	});
}


function saveClient() {

	var name = $('#nome').val();
	var age = $('#idade').val();
	var profession = $('#profession').val();
	$.ajax({
		url: '/MyWebProject2/index/save?name=' + name + '&age=' + age + '&profession=' + profession,
		method: "POST",
		success: function(result) {
			alert(result);
		},
		error: function(result){
			console.log(result);
		}	
	});
}

function listAll() {
	$.ajax({
		url: '/MyWebProject2/list/',
		success: function(result) {
			alert(result);
		},
		error: function(result){
			console.log(result);
		}
		
	});
}


function createBla(data){
	$.ajax({
	    headers: { 
	        'Accept': 'application/json',
	        'Content-Type': 'application/json' 
	    },
		url: '/MyWebProject2/index/getLirosOrdem',
		 'type': 'POST',
		success: function(result) {
			alert('deu certo');
		},
		data: JSON.stringify(data),
		dataType: 'json',
		error: function(result){
			console.log(result);
		}	
	});
}