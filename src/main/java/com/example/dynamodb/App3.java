package com.example.dynamodb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.Optional;

public class App3 {

    public static void main(String[] args) throws JsonProcessingException {


        ObjectMapper objectMapper = new ObjectMapper();

        String raw = "{\n"
            + "  \"Records\": [\n"
            + "    {\n"
            + "      \"messageId\": \"19dd0b57-b21e-4ac1-bd88-01bbb068cb78\",\n"
            + "      \"receiptHandle\": \"MessageReceiptHandle\",\n"
            + "      \"body\": \"Hello from SQS!\",\n"
            + "      \"attributes\": {\n"
            + "        \"ApproximateReceiveCount\": \"1\",\n"
            + "        \"SentTimestamp\": \"1523232000000\",\n"
            + "        \"SenderId\": \"123456789012\",\n"
            + "        \"ApproximateFirstReceiveTimestamp\": \"1523232000001\"\n"
            + "      },\n"
            + "      \"messageAttributes\": {},\n"
            + "      \"md5OfBody\": \"7b270e59b47ff90a553787216d55d91d\",\n"
            + "      \"eventSource\": \"aws:sqs\",\n"
            + "      \"eventSourceARN\": \"arn:{partition}:sqs:{region}:123456789012:MyQueue\",\n"
            + "      \"awsRegion\": \"{region}\"\n"
            + "    }\n"
            + "  ]\n"
            + "}";


        System.out.println(raw);

        JsonNode jsonNode = objectMapper.readTree(raw);

        System.out.println();

        AttributeValue attributeValue = JsonAttributeValueUtil.toAttributeValue(jsonNode);


        Optional<String> eventSource = attributeValue.getValueForField("eventSource", String.class);




        System.out.println();


    }







}
