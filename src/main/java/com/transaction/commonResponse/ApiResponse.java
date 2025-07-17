package com.transaction.commonResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private int statuscode;
    private String message;
    private T result;
    private Long count;

    public void responseMethod(int statuscode, String message, T result, Long count){

        this.statuscode=statuscode;
        this.setMessage(message);
        this.setResult(result);
        this.setCount(count);

    }

}
