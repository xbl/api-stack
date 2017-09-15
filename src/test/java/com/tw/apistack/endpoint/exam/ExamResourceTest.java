package com.tw.apistack.endpoint.exam;

import com.tw.apistack.endpoint.hello.HelloResource;
import com.tw.apistack.endpoint.hello.dto.Greeting;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExamResourceTest {
    @Test
    public void greeting() throws Exception {
        HelloResource helloResource = new HelloResource();
        Greeting result = helloResource.greeting("Man");
        assertThat(result.getContent()).isEqualTo("Hello, Man!");
        assertThat(result.getId()).isNotNull();
    }
}
