package prospertech.desafio.httpException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProdutoNotFoundException extends RuntimeException {
    public ProdutoNotFoundException(Integer id){
        super("Produto não encontrado com o Id: " + id);
    }
}
