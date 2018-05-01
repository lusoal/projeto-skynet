
//Script para alterar letras na index do site
 $(function(){
var texto = 1;
var string;

setInterval(function(){
    switch(texto) {
        case 1: string = "Otimize o tempo da sua empresa Conosco!"; break;
        case 2: string = "Nós temos a solução ideal para o seu negócio."; break;
        case 3: string = "Inscreva-se logo abaixo e realize seu Pré-Cadastro!"; break;
    }


    $('.texto').html(string);

    texto != 3 ? texto++ : texto = 1;
}, 1800);
});

 $(function(){
var options = {
    onKeyPress: function (cpf, ev, el, op) {
        var masks = ['000.000.000-000', '00.000.000/0000-00'],
            mask = (cpf.length > 14) ? masks[1] : masks[0];
        el.mask(mask, op);
    }
}

$('#cpfcnpj').mask('000.000.000-000', options);

});


$(function(){
var options = {
   onKeyPress: function (cpf, ev, el, op) {
       var masks = ['000.000.000-000', '00.000.000/0000-00'],
           mask = (cpf.length > 14) ? masks[1] : masks[0];
       el.mask(mask, op);
   }
}

$('#cpfcnpj2').mask('000.000.000-000', options);

});

$(function(){
var options = {
   onKeyPress: function (cpf, ev, el, op) {
       var masks = ['000.000.000-000', '00.000.000/0000-00'],
           mask = (cpf.length > 14) ? masks[1] : masks[0];
       el.mask(mask, op);
   }
}

$('#cpfcnpj3').mask('000.000.000-000', options);

});

$(document).ready(function(){

  $('#phone').mask('(99)9999-9999');
  $('#cellphone').mask('(99) 99999-9999');

});

$(document).ready(function() {

     // set an element
     $("#date").val( moment().format('dd,mm, YYYY') );

     // set a variable
     var today = moment().format('dd,mm, YYYY');

});
