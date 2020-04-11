package pe.oh29oh29.ourlunch.model;

import lombok.Data;
import pe.oh29oh29.ourlunch.constants.ResponseCode;

@Data
public class Response<T> {

    private ResponseCode code;

    private String message;

    private T body;

    private Response() {
        this(null);
    }

    public Response(T body) {
        this.code = ResponseCode.WJ0000;
        this.message = code.getMessage();
        this.body = body;
    }

    public static Response ok() {
        return new Response();
    }
}
