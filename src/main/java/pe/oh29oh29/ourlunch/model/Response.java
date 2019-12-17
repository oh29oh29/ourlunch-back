package pe.oh29oh29.ourlunch.model;

import lombok.Data;

@Data
public class Response<T> {

    private int code;

    private String message;

    private T data;

    private Response() {
        this(null);
    }

    public Response(T data) {
        this.code = org.apache.catalina.connector.Response.SC_OK;
        this.message = "SUCCESS";
        this.data = data;
    }

    public static Response ok() {
        return new Response();
    }
}
