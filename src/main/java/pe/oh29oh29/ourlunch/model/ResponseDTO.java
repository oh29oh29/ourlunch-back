package pe.oh29oh29.ourlunch.model;

import lombok.Data;
import org.apache.catalina.connector.Response;

@Data
public class ResponseDTO {

    private int code;

    private String message;

    private Object data;

    public ResponseDTO(Object data) {
        this.code = Response.SC_OK;
        this.message = "success";
        this.data = data;
    }

}
