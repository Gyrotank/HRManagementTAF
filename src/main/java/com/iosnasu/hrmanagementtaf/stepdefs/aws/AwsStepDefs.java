package com.iosnasu.hrmanagementtaf.stepdefs.aws;

import com.iosnasu.hrmanagementtaf.properties.AppProperties;
import io.cucumber.java.en.Given;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.core.sync.ResponseTransformer;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@SpringBootTest
public class AwsStepDefs {
    DynamoDbClient dynamoDbClient;
    S3Client s3Client;

    @Autowired
    private AppProperties appProperties;

    @Given("Get Query is sent to DynamoDB table {string} for partition key {string} with value {string}")
    public void sendDynamoDBGetQuery(final String table,
                                     final String partitionKey,
                                     final String partitionKeyValue) {
        dynamoDbClient = DynamoDbClient.builder()
                .credentialsProvider(DefaultCredentialsProvider.create())
                .region(Region.of(appProperties.getAwsRegion()))
                .build();

        Map<String, AttributeValue> keyToGet = new HashMap<>();
        keyToGet.put(partitionKey, AttributeValue.builder().s(partitionKeyValue).build());

        GetItemRequest getItemRequest = GetItemRequest.builder()
                .tableName(table)
                .key(keyToGet)
                .build();

        try {
            GetItemResponse getItemResponse = dynamoDbClient.getItem(getItemRequest);

            if (getItemResponse.hasItem()) {
                Map<String, AttributeValue> returnedItem = getItemResponse.item();
                System.out.println("Item retrieved: " + returnedItem);
            } else {
                System.out.println("No item found with the specified key.");
            }

        } catch (DynamoDbException e) {
            log.error("Unable to get item for partition key {}: {}",
                    partitionKey, e.getMessage());
        } finally {
            dynamoDbClient.close();
        }
    }

    @Given("Get Query is sent to DynamoDB table {string} for partition key {string} with value {string} and sort key {string} with value {string}")
    public void sendDynamoDBGetQuery(final String table,
                                     final String partitionKey,
                                     final String partitionKeyValue,
                                     final String sortKey,
                                     final String sortKeyValue) {
        dynamoDbClient = DynamoDbClient.builder()
                .credentialsProvider(DefaultCredentialsProvider.create())
                .region(Region.of(appProperties.getAwsRegion()))
                .build();

        Map<String, AttributeValue> keyToGet = new HashMap<>();
        keyToGet.put(partitionKey, AttributeValue.builder().s(partitionKeyValue).build());
        keyToGet.put(sortKey, AttributeValue.builder().s(sortKeyValue).build());

        GetItemRequest getItemRequest = GetItemRequest.builder()
                .tableName(table)
                .key(keyToGet)
                .build();

        try {
            GetItemResponse getItemResponse = dynamoDbClient.getItem(getItemRequest);

            if (getItemResponse.hasItem()) {
                Map<String, AttributeValue> returnedItem = getItemResponse.item();
                System.out.println("Item retrieved: " + returnedItem);
            } else {
                System.out.println("No item found with the specified keys.");
            }

        } catch (DynamoDbException e) {
            log.error("Unable to get item for partition key {} and sort key {}: {}",
                    partitionKey,
                    sortKey,
                    e.getMessage());
        } finally {
            dynamoDbClient.close();
        }
    }

    @Given("Get Query is sent to S3 bucket {string} and key {string}")
    public void sendS3GetQuery(final String bucket,
                               final String key) {
        s3Client = S3Client.builder()
                .credentialsProvider(DefaultCredentialsProvider.create())
                .region(Region.of(appProperties.getAwsRegion()))
                .build();

        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(bucket)
                .key(key)
                .build();

        byte[] objectBytes = s3Client.getObject(getObjectRequest, ResponseTransformer.toBytes())
                .asByteArray();

        String objectContent = new String(objectBytes, StandardCharsets.UTF_8);

        System.out.println(objectContent);

        s3Client.close();
    }
}
