package pe.oh29oh29.ourlunch.model;

import lombok.Data;
import org.apache.catalina.connector.Response;

@Data
public class ResponseDTO<T> {

    private int code;

    private String message;

    private T data;

    public ResponseDTO() {
        this(null);
    }

    public ResponseDTO(T data) {
        this.code = Response.SC_OK;
        this.message = "success";
        this.data = data;
    }

}
