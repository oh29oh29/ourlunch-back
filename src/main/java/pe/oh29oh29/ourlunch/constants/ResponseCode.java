package pe.oh29oh29.ourlunch.constants;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ResponseCode {

    WJ0000("정상적으로 처리되었습니다.");

    private final String message;

    public String getMessage() {
        return message;
    }
}
