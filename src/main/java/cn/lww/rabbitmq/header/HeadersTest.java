package cn.lww.rabbitmq.header;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HeadersTest {

    @Autowired
    private HeaderSender headerSender;

    @Test
    public void sendTest() throws Exception {
        headerSender.sendMessage();
    }
}