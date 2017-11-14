package com.project.allef.apirest.Resources;

import com.project.allef.apirest.Repository.eventoRepository;
import com.project.allef.apirest.model.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController // assinatura para dizer que esta classe é a controller da Api
@RequestMapping("/times") // url
public class eventoResources {

    @Autowired // anotação para injeção de dependencia da interface Jpa na classe
    private eventoRepository er;

    /**
     * metodo Get responsavel por buscar as informações no banco de dados e
     * as trazer em formato Json . neste metodo todos os dados sao trazidos de uma vez
     * utilizando uma interface iterable para recuperar  a lista de eventos e retornala;
     * @return
     */
   // @ApiOperation(value = "Retorna uma lista de eventos")
    @GetMapping(produces = "application/json") // o tipo de dado que a url recebe o o tipo que ela retorna ou produz neste caso uma requisição GET
    public @ResponseBody
    Iterable<Evento> listaEventos()  { // responseBody utilizado pq vai responder com uma lista de eventos
        Iterable<Evento> listaEventos = er.findAll();
        return listaEventos;
    }

    /**
     * A assinatura @RequestBody informa que ele vai receber junto ao compo da requisição um evento
     * para ser salva no banco de dados
     * já o @Valid executa a validação que ja foi imposta na classe de modelo impedindo que os valores
     * dos atributos sejam nulos
     * @param evento
     * @return
     */
    //@ApiOperation(value = "Cadastra um eventos")
    @PostMapping() // requisição Post
    public  Evento cadastrarEvento(@RequestBody @Valid Evento evento){

        er.save(evento); // persistindo evento com JPA
        long codigo = evento.getCodigo();
        return evento; // retornandoo evento salvo
    }





}
