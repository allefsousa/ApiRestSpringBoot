package com.project.allef.apirest.Resources;

import com.project.allef.apirest.Repository.TimeRepository;
import com.project.allef.apirest.model.Time;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController // assinatura para dizer que esta classe é a controller da Api
@RequestMapping("/times") // url
public class TimeResources {

    @Autowired // anotação para injeção de dependencia da interface Jpa na classe
    private TimeRepository er;

    /**
     * metodo Get responsavel por buscar as informações no banco de dados e
     * as trazer em formato Json . neste metodo todos os dados sao trazidos de uma vez
     * utilizando uma interface iterable para recuperar  a lista de times e retornala;
     * @return
     */
    @ApiOperation(value = "Retorna uma lista de Times")
    @GetMapping(produces = "application/json") // o tipo de dado que a url recebe o o tipo que ela retorna ou produz neste caso uma requisição GET
    public @ResponseBody
    Iterable<Time> listaTimes()  { // responseBody utilizado pq vai responder com uma lista de eventos
        Iterable<Time> listaEventos = er.findAll();
        return listaEventos;
    }

    /**
     * A assinatura @RequestBody informa que ele vai receber junto ao compo da requisição um time
     * para ser salva no banco de dados
     * já o @Valid executa a validação que ja foi imposta na classe de modelo impedindo que os valores
     * dos atributos sejam nulos
     * @param time
     * @return
     */
    @ApiOperation(value = "Cadastra um Time")
    @PostMapping() // requisição Post
    public Time cadastrarTimes(@RequestBody @Valid Time time){

        er.save(time); // persistindo time com JPA
        long codigo = time.getCodigo();
        return time; // retornandoo time salvo
    }

    /**
     * metodo reponsavel por deletar um time no banco de dados
     * onde é utilizado os metodos Jpa para deletalo.
     * ao final ele retorna o time deletado.
     * @param time
     * @return
     */
    @ApiOperation(value = "Deleta um Time")
    @DeleteMapping() // assinatura do metodo , operação de remoção
    public Time deleteTime(@RequestBody Time time){
        er.delete(time); // deletando no banco
        return time; // retornando o dado deletado
    }





}
