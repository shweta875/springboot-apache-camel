package com.apache.demo;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.AdviceWith;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.apache.camel.test.spring.junit5.UseAdviceWith;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@CamelSpringBootTest
@UseAdviceWith
public class LegacyFileRouteTest {
    @Autowired
    CamelContext camelContext;

    @EndpointInject("mock:result")
    protected MockEndpoint mockEndpoint;

    @Autowired
    ProducerTemplate producerTemplate;

//    @Test
//    public void testFileMove() throws Exception{
//        //set up the mock
//
//
//        String expectedBody="This is input file.";
//        mockEndpoint.expectedBodiesReceived(expectedBody);
//        mockEndpoint.setResultWaitTime(5000);
//        mockEndpoint.expectedMinimumMessageCount(1);
//        //Tweak the route defination
//        AdviceWith.adviceWith(camelContext,"legacyFileId",routeBuilder->routeBuilder.weaveByToUri("file:*").replace().to(mockEndpoint));
//        //Start the Context and Validate the mock is asserted
//        camelContext.start();
//        mockEndpoint.assertIsSatisfied();
//
//
//    }
//@Test
// public void testFileMoveByMockingFromEndpoint() throws Exception {
//        //set up the mock
//        String expectedBody="This is a input data after mocking the from endpoint";
//               mockEndpoint.expectedBodiesReceived(expectedBody);
//               mockEndpoint.expectedMinimumMessageCount(1);
//
//        AdviceWith.adviceWith(camelContext,"legacyFileId",routeBuilder->{
//                routeBuilder.replaceFromWith("direct:mockStart");
//                routeBuilder.weaveByToUri("file:*").replace().to(mockEndpoint);});
//
//        camelContext.start();
//        producerTemplate.sendBody("direct:mockStart",expectedBody);
//        mockEndpoint.assertIsSatisfied();
//    }

    //@Test
// public void testFileMoveByMockingFromEndpoint() throws Exception {
//        //set up the mock
//        String expectedBody="This is a input data after mocking the from endpoint";
//               mockEndpoint.expectedBodiesReceived(expectedBody);
//               mockEndpoint.expectedMinimumMessageCount(1);
//
//        AdviceWith.adviceWith(camelContext,"legacyFileId",routeBuilder->{
//                routeBuilder.replaceFromWith("direct:mockStart");
//                routeBuilder.weaveByToUri("file:*").replace().to(mockEndpoint);});
//
//        camelContext.start();
//        producerTemplate.sendBody("direct:mockStart",expectedBody);
//        mockEndpoint.assertIsSatisfied();
//    }



}
