package pe.oh29oh29.ourlunch.model;

import lombok.Data;

@Data
public class ResponseBody {

    private int code;

    private String message;

    private Object data;

}
