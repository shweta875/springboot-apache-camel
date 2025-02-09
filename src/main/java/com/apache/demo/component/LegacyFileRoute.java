package com.apache.demo.component;

import com.apache.demo.beans.NameAddress;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.beanio.BeanIODataFormat;
import org.apache.camel.spi.DataFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class LegacyFileRoute extends RouteBuilder {
    private static final Logger logger = LoggerFactory.getLogger(String.class);

    DataFormat inboundDataFormat=new BeanIODataFormat("InboundMessageBeanIOMapping.xml","inputMessageStream");


//    @Override
//    public void configure() throws Exception {
//        from("file:src/data/input?FileName=inputFile.txt")
//                .routeId("legacyFileId")
//                .process(exchange -> {
//                    String body = exchange.getIn().getBody(String.class);
//                    logger.info("process of logging"+body);
//                })
//                .to("file:src/data/output?FileName=outputFile.txt");
//    }

//
//    @Override
//    public void configure() throws Exception {
//        from("file:src/data/input?FileName=sample_data.csv")
//               .routeId("legacyFileId")
//               .process(exchange -> {
//                    String body = exchange.getIn().getBody(String.class);
//                    logger.info("process of logging"+body);
//                })
//                .to("file:src/data/output?FileName=sample_out_data.csv");
//    }

//splitter

//    @Override
//    public void configure() throws Exception {
//        from("file:src/data/input?FileName=sample_data.csv")
//                .routeId("legacyFileId")
//                .split(body().tokenize("\n"))
//                .process(exchange -> {
//                    String body = exchange.getIn().getBody(String.class);
//                    logger.info("process of logging"+body);
//                })
//                .to("file:src/data/output?FileName=sample_out_data.csv&fileExist=append&appendChars=\\n");
//    }

    //pojo
    @Override
    public void configure() throws Exception {
        from("file:src/data/input?FileName=sample_data.csv")
                .routeId("legacyFileId")
                .split(body().tokenize("\n",1,true))
                .unmarshal("inboundDataFormat")
                .process(exchange -> {
                    NameAddress body = exchange.getIn().getBody(NameAddress.class);
                    logger.info("process of logging"+body.toString());
                })
//                .to("file:src/data/output?FileName=sample_out_data.csv&fileExist=append&appendChars=\\n")
                .end();
    }








}

