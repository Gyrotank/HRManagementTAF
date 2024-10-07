@aws
Feature: AWS infrastructure can be accessed

  @dynamodb
  Scenario: User accesses DynamoDB table by partition key
    Given Get Query is sent to DynamoDB table "CloudNativeApp1Table" for partition key "ImageName" with value "Capture_17f7a271-0a3f-46be-a55e-17070be91b08.PNG"

  @dynamodb
  Scenario: User accesses DynamoDB table by partition key and sort key
    Given Get Query is sent to DynamoDB table "CloudNativeApp1Table" for partition key "ImageName" with value "Capture_17f7a271-0a3f-46be-a55e-17070be91b08.PNG" and sort key "LabelValue" with value "Blue"

  @s3
  Scenario: User accesses S3 bucket
    Given Get Query is sent to S3 bucket "cloudnativeapp1glom" and key "Capture2_09ff570a-bfe6-44aa-a8e6-cc1642c23bed.PNG"