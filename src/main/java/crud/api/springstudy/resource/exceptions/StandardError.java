package crud.api.springstudy.resource.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
public class StandardError {

    private LocalDateTime timeStamp;
    private Integer Status;
    private String error;
    private String path;

}
