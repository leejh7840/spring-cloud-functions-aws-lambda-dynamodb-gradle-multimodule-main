AWS DynamoDB Multimodule Project
----------------------------------------------------------------------------------------------------------------------------

This is a model project with sample implementation of Spring Cloud Funcitons with AWS DynamoDB and Aws Lambda.

----------------------------------------------------------------------------------------------------------------------------
Requirements for building and running the application you need:

JDK 17<br />
Gradle 7.3.2<br />
AWS accesskey<br />
AWS secretkey<br />

----------------------------------------------------------------------------------------------------------------------------
Building the application

Gradle is the main tool for build & dependency management.<br />
You will be able to run gradle commands via the gradle wrapper in the root of this project, e.g. ./gradlew tasks

Enter your AWS region, accesskey and secretkey in aws-dynamodb-multimodule-api-web\src\main\resources\aws-credentials.properties.

./gradlew clean - Deletes the build directory.<br />
./gradlew build - Assembles and tests this project.<br />

Start application

./gradlew bootRun --> Starts the application on your local environment as a normal SpringBoot app.


----------------------------------------------------------------------------------------------------------------------------

AWS CLI installation and Pre-requiste:

1. You will need to install Amazon CLI for windows refer to: 
	[https://docs.aws.amazon.com/cli/latest/userguide/getting-started-install.html]
	
2. After installing Amazon CLI you will need to configure your Access Key, Security key, and profile set up refer to: 
	[https://docs.aws.amazon.com/cli/latest/userguide/getting-started-quickstart.html]
	
	Sample:
		$ aws configure
		AWS Access Key ID : AKIAIOSFODNN7EXAMPLE
		AWS Secret Access Key : wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY
		Default region name [us-east-1]: us-east-1
		Default output format [None]: json
		
3. You will now have to set up your environment variables refer to:
	[https://docs.aws.amazon.com/cli/latest/userguide/cli-configure-envvars.html]

4. A useful tool is enabling the auto-prompt for AWS-CLI copy the command: 
	aws_cli_auto_prompt=on
		
----------------------------------------------------------------------------------------------------------------------------

Dynamo DB table insert and item insert ReadMe Instructions:

1. Open command prompt and go to where you have your IntelliJ project saved for example:
	cd C:\Users\<YOUR USERNAME>\IdeaProjects\spring-dynamodb-multimodule\aws-Dynamodb-Table Script
	
2. Now you need to go to the folder where the AWS-CLI commands and Json files are stored:
	cd aws-Dynamodb-Table Script
	
3. In command prompt you will need to copy the AWS-CLI command to create a table:
	aws dynamodb create-table --cli-input-json file://Order_Table_Creation_JSON_Script.json
	(Notice we are using the stored Json file named: Order_Table_Creation_JSON_Script)
	
4. Now we need to populate the "Orders" table you just created. Copy the AWS-CLI command to write multiple entries into command prompt:
	aws dynamodb batch-write-item --request-items file://dynamodb_table_value_insert_dml_JSON_Script.json
	(Notice we are using the stored Json file named: dynamodb_table_value_insert_dml_JSON_Script)

5. There are two AWS-CLI Fetch commands that you can test out in command prompt that are stored in the "aws-cli commands" file.

6. When you're done with this tutorial you need to run the AWS-CLI Delete command in command prompt:
	aws dynamodb delete-table --table-name Orders
	
To run Spring Cloud Functions locally 
  
Open Command Prompt . Add path to root Directory.Follow below curl commands to execute CRUD Operations

    1.getAllOrder Method :curl -H "Content-Type:application/json" http://localhost:8080/getAllOrder

    2. getOrderById : curl -H "Content-Type:application/json" http://localhost:8080/getOrderById -d "idno"

    3. saveOrder : curl -i -X POST -H "Content-Type: application/json" -d "{\"id\":\"T101\",\"item\":\"Test\",\"qty\":\"2\",\"price\":\"20\"}" http://localhost:8080/saveOrder

    4. deleteOrder : curl -H "Content-Type:application/json" http://localhost:8080/deleteOrder -d "T101"
	

To Invoke Spring Cloud Functions in AWS Lambda . Follow the Documentation inside Root Folder
