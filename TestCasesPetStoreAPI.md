Test Cases for POST /pet/{petId}/uploadImage

Description
The endpoint allows uploading an image for a specified pet. The possible parameters include:

petId (integer, path): ID of the pet to update.
additionalMetadata (string, formData): Additional data to pass to the server.
file (file, formData): The file to upload.


Test Case 1: Happy Path - Upload Image for a Pet
Description: Verify that an image can be successfully uploaded for a specified pet.
Steps:

Send a POST request to /pet/{petId}/uploadImage with a valid petId, additionalMetadata, and file.
petId: 1
additionalMetadata: "Profile picture"
file: [valid image file]
Assertions:
Verify the response status code is 200 (OK).
Verify the response body contains a message indicating that the image was uploaded successfully.
Confirm that the image is associated with the correct pet.


Test Case 2: Using Incorrect Method (GET /pet/{petId}/uploadImage)
Description: Verify that using an incorrect method results in an error.
Steps:

Send a GET request to /pet/{petId}/uploadImage with a valid petId.
petId: 1
Assertions:
Verify the response status code is 405 (Method Not Allowed).
Verify the response body contains an error message indicating that the method is not allowed.


Test Case 3: Upload Image Without File
Description: Verify that attempting to upload an image without providing a file results in an error.
Steps:

Send a POST request to /pet/{petId}/uploadImage with a valid petId and additionalMetadata, but without a file.
petId: 1
additionalMetadata: "Profile picture"
Assertions:
Verify the response status code is 400 (Bad Request).
Verify the response body contains an error message indicating that the file is required.


Test Case 4: Upload Image with Tampered petId
Description: Verify that tampering with the petId parameter results in an appropriate error.
Steps:

Send a POST request to /pet/{petId}/uploadImage with an invalid petId.
petId: "invalid_id"
additionalMetadata: "Profile picture"
file: [valid image file]
Assertions:
Verify the response status code is 400 (Bad Request) or 404 (Not Found).
Verify the response body contains an error message indicating that the petId is invalid or the pet was not found.


Test Case 5: Upload Image with Tampered additionalMetadata
Description: Verify that tampering with the additionalMetadata parameter does not break the upload functionality.
Steps:

Send a POST request to /pet/{petId}/uploadImage with a valid petId, tampered additionalMetadata, and file.
petId: 1
additionalMetadata: "<script>alert('hack');</script>"
file: [valid image file]
Assertions:
Verify the response status code is 200 (OK).
Verify the response body does not execute any injected scripts.
Confirm that the image is associated with the correct pet and the additionalMetadata is stored as a string without executing scripts.


Test Case 6: Upload Large Image File
Description: Verify that uploading a very large image file is handled correctly.
Steps:

Send a POST request to /pet/{petId}/uploadImage with a valid petId, additionalMetadata, and a very large file.
petId: 1
additionalMetadata: "Large file"
file: [large image file]
Assertions:
Verify the response status code is 200 (OK) if the upload is successful.
If there are server-side limits, verify the response status code is 413 (Payload Too Large) and an appropriate error message is returned.


Test Case 7: Missing petId Parameter
Description: Verify that missing the petId parameter results in an appropriate error.
Steps:

Send a POST request to /pet/{uploadImage} (omit the petId parameter) with additionalMetadata and file.
additionalMetadata: "Profile picture"
file: [valid image file]
Assertions:
Verify the response status code is 404 (Not Found) or 400 (Bad Request).
Verify the response body contains an error message indicating that the petId is required.


Test Case 8: Invalid Image File Type
Description: Verify that uploading a file that is not an image results in an appropriate error.
Steps:

Send a POST request to /pet/{petId}/uploadImage with a valid petId, additionalMetadata, and an invalid file type.
petId: 1
additionalMetadata: "Invalid file type"
file: [non-image file, e.g., .txt file]
Assertions:
Verify the response status code is 400 (Bad Request).
Verify the response body contains an error message indicating that the file type is invalid.

Test Cases for POST /pet


Test Case 1: Add a New Pet (Happy Path)
Description: Verify that a new pet can be successfully added to the store.
Steps:

Send a POST request to /pet with the following valid pet data:


{
  "id": 1,
  "category": {
    "id": 1,
    "name": "Dog"
  },
  "name": "Buddy",
  "photoUrls": [
    "http://example.com/photo1.jpg"
  ],
  "tags": [
    {
      "id": 1,
      "name": "Friendly"
    }
  ],
  "status": "available"
}


Assertions:

Verify the response status code is 200 (OK) or 201 (Created).
Verify the response body contains the details of the newly added pet.
Confirm the pet details match the input data.


Test Case 2: Add a Pet with Invalid ID (Negative Test)
Description: Verify that adding a pet with an invalid ID results in an appropriate error.
Steps:

Send a POST request to /pet with invalid pet data (e.g., invalid ID type).


{
  "id": "invalid_id",
  "category": {
    "id": 1,
    "name": "Dog"
  },
  "name": "Buddy",
  "photoUrls": [
    "http://example.com/photo1.jpg"
  ],
  "tags": [
    {
      "id": 1,
      "name": "Friendly"
    }
  ],
  "status": "available"
}
Assertions:

Verify the response status code is 400 (Invalid ID supplied).
Verify the response body contains an error message indicating the invalid ID.


Test Case 3: Add a Pet with Missing Required Fields (Negative Test)
Description: Verify that adding a pet with missing required fields results in a validation error.
Steps:

Send a POST request to /pet with incomplete pet data (e.g., missing name field).


{
  "id": 1,
  "category": {
    "id": 1,
    "name": "Dog"
  },
  "photoUrls": [
    "http://example.com/photo1.jpg"
  ],
  "tags": [
    {
      "id": 1,
      "name": "Friendly"
    }
  ],
  "status": "available"
}
Assertions:

Verify the response status code is 405 (Validation exception).
Verify the response body contains an error message indicating the validation error.


Test Case 4: Add a Pet with Non-Existing Category (Negative Test)
Description: Verify that adding a pet with a non-existing category results in an appropriate error.
Steps:

Send a POST request to /pet with pet data that includes a non-existing category.


{
  "id": 1,
  "category": {
    "id": 9999,  // Non-existing category ID
    "name": "Unknown"
  },
  "name": "Buddy",
  "photoUrls": [
    "http://example.com/photo1.jpg"
  ],
  "tags": [
    {
      "id": 1,
      "name": "Friendly"
    }
  ],
  "status": "available"
}
Assertions:

Verify the response status code is 404 (Pet not found).
Verify the response body contains an error message indicating the category is not found.


Test Case 5: Add a Pet with Invalid Status (Negative Test)
Description: Verify that adding a pet with an invalid status results in a validation error.
Steps:

Send a POST request to /pet with pet data that includes an invalid status.


{
  "id": 1,
  "category": {
    "id": 1,
    "name": "Dog"
  },
  "name": "Buddy",
  "photoUrls": [
    "http://example.com/photo1.jpg"
  ],
  "tags": [
    {
      "id": 1,
      "name": "Friendly"
    }
  ],
  "status": "unknown_status"  // Invalid status
}
Assertions:

Verify the response status code is 405 (Validation exception).
Verify the response body contains an error message indicating the invalid status.


Test Cases for PUT /pet


Test Case 1: Update an Existing Pet (Happy Path)
Description: Verify that an existing pet's details can be successfully updated.
Steps:

Send a PUT request to /pet with the following valid updated pet data:


{
  "id": 1,
  "category": {
    "id": 1,
    "name": "Dog"
  },
  "name": "Buddy Updated",
  "photoUrls": [
    "http://example.com/photo1.jpg",
    "http://example.com/photo2.jpg"
  ],
  "tags": [
    {
      "id": 1,
      "name": "Friendly"
    },
    {
      "id": 2,
      "name": "Playful"
    }
  ],
  "status": "available"
}
Assertions:

Verify the response status code is 200 (OK).
Verify the response body contains the updated pet details.
Confirm the updated details match the input data.


Test Case 2: Update a Pet with Invalid ID (Negative Test)
Description: Verify that updating a pet with an invalid ID results in an appropriate error.
Steps:

Send a PUT request to /pet with invalid pet data (e.g., invalid ID type).


{
  "id": "invalid_id",
  "category": {
    "id": 1,
    "name": "Dog"
  },
  "name": "Buddy Updated",
  "photoUrls": [
    "http://example.com/photo1.jpg",
    "http://example.com/photo2.jpg"
  ],
  "tags": [
    {
      "id": 1,
      "name": "Friendly"
    },
    {
      "id": 2,
      "name": "Playful"
    }
  ],
  "status": "available"
}
Assertions:

Verify the response status code is 400 (Invalid ID supplied).
Verify the response body contains an error message indicating the invalid ID.


Test Case 3: Update a Pet with Missing Required Fields (Negative Test)
Description: Verify that updating a pet with missing required fields results in a validation error.
Steps:

Send a PUT request to /pet with incomplete pet data (e.g., missing name field).


{
  "id": 1,
  "category": {
    "id": 1,
    "name": "Dog"
  },
  "photoUrls": [
    "http://example.com/photo1.jpg",
    "http://example.com/photo2.jpg"
  ],
  "tags": [
    {
      "id": 1,
      "name": "Friendly"
    },
    {
      "id": 2,
      "name": "Playful"
    }
  ],
  "status": "available"
}
Assertions:

Verify the response status code is 405 (Validation exception).
Verify the response body contains an error message indicating the validation error.


Test Case 4: Update a Non-Existing Pet (Negative Test)
Description: Verify that updating a non-existing pet results in an appropriate error.
Steps:

Send a PUT request to /pet with pet data for a non-existing pet.


{
  "id": 9999,  // Non-existing pet ID
  "category": {
    "id": 1,
    "name": "Dog"
  },
  "name": "Buddy",
  "photoUrls": [
    "http://example.com/photo1.jpg",
    "http://example.com/photo2.jpg"
  ],
  "tags": [
    {
      "id": 1,
      "name": "Friendly"
    },
    {
      "id": 2,
      "name": "Playful"
    }
  ],
  "status": "available"
}
Assertions:

Verify the response status code is 404 (Pet not found).
Verify the response body contains an error message indicating that the pet was not found.


Test Case 5: Update a Pet with Invalid Status (Negative Test)
Description: Verify that updating a pet with an invalid status results in a validation error.
Steps:

Send a PUT request to /pet with pet data that includes an invalid status.


{
  "id": 1,
  "category": {
    "id": 1,
    "name": "Dog"
  },
  "name": "Buddy Updated",
  "photoUrls": [
    "http://example.com/photo1.jpg",
    "http://example.com/photo2.jpg"
  ],
  "tags": [
    {
      "id": 1,
      "name": "Friendly"
    },
    {
      "id": 2,
      "name": "Playful"
    }
  ],
  "status": "unknown_status"  // Invalid status
}
Assertions:

Verify the response status code is 405 (Validation exception).
Verify the response body contains an error message indicating the invalid status.

Test Cases for GET /pet/findByStatus


Description
This endpoint retrieves pets based on their status. Multiple status values can be provided as comma-separated strings. The expected response codes are 200 (OK) and 400 (Bad Request).

Test Case 1: Retrieve Pets by Single Status (Happy Path)
Description: Verify that pets can be retrieved by a single status.
Steps:

Send a GET request to /pet/findByStatus with the query parameter status=available.
Assertions:
Verify the response status code is 200 (OK).
Verify the response body contains a list of pets with the status "available".


Test Case 2: Retrieve Pets by Multiple Statuses (Happy Path)
Description: Verify that pets can be retrieved by multiple statuses.
Steps:

Send a GET request to /pet/findByStatus with the query parameter status=available,pending.
Assertions:
Verify the response status code is 200 (OK).
Verify the response body contains a list of pets with the status "available" and "pending".


Test Case 3: Retrieve Pets by All Statuses (Happy Path)
Description: Verify that pets can be retrieved by all available statuses.
Steps:

Send a GET request to /pet/findByStatus with the query parameter status=available,pending,sold.
Assertions:
Verify the response status code is 200 (OK).
Verify the response body contains a list of pets with the status "available", "pending", and "sold".


Test Case 4: Retrieve Pets by Invalid Status (Negative Test)
Description: Verify that retrieving pets with an invalid status results in a bad request error.
Steps:

Send a GET request to /pet/findByStatus with the query parameter status=invalidstatus.
Assertions:
Verify the response status code is 400 (Bad Request).
Verify the response body contains an error message indicating the invalid status value.


Test Case 5: Retrieve Pets by Empty Status (Negative Test)
Description: Verify that retrieving pets with an empty status results in a bad request error.
Steps:

Send a GET request to /pet/findByStatus with the query parameter status=.
Assertions:
Verify the response status code is 400 (Bad Request).
Verify the response body contains an error message indicating that the status parameter is required.


Test Case 6: Retrieve Pets by No Status Parameter (Negative Test)
Description: Verify that retrieving pets without providing a status parameter results in a bad request error.
Steps:

Send a GET request to /pet/findByStatus without the query parameter.
Assertions:
Verify the response status code is 400 (Bad Request).
Verify the response body contains an error message indicating that the status parameter is required.


Test Case 7: Retrieve Pets by Mixed Valid and Invalid Statuses (Negative Test)
Description: Verify that retrieving pets with a mix of valid and invalid statuses results in a bad request error.
Steps:

Send a GET request to /pet/findByStatus with the query parameter status=available,invalidstatus.
Assertions:
Verify the response status code is 400 (Bad Request).
Verify the response body contains an error message indicating the invalid status value.


Test Case 8: Retrieve Pets by Status with Leading and Trailing Spaces (Negative Test)
Description: Verify that retrieving pets with leading and trailing spaces in status values results in a bad request error.
Steps:

Send a GET request to /pet/findByStatus with the query parameter status= available , pending .
Assertions:
Verify the response status code is 400 (Bad Request).
Verify the response body contains an error message indicating the invalid status value.


Test Case 9: Retrieve Pets by Status with Case Sensitivity (Negative Test)
Description: Verify that retrieving pets with status values having different cases results in a bad request error.
Steps:

Send a GET request to /pet/findByStatus with the query parameter status=Available,PENDING,sOlD.
Assertions:
Verify the response status code is 400 (Bad Request).
Verify the response body contains an error message indicating the invalid status value.


Test Case 10: Retrieve Pets by Status with Special Characters (Negative Test)
Description: Verify that retrieving pets with status values having special characters results in a bad request error.
Steps:

Send a GET request to /pet/findByStatus with the query parameter status=available!,pending@.
Assertions:
Verify the response status code is 400 (Bad Request).
Verify the response body contains an error message indicating the invalid status value.

Test Cases for GET /pet/{petId}


Description
This endpoint retrieves a pet by its ID. The expected response codes are 200 (OK), 400 (Bad Request), and 404 (Not Found).

Test Case 1: Retrieve Pet by Valid ID (Happy Path)
Description: Verify that a pet can be successfully retrieved by a valid ID.
Steps:

Send a GET request to /pet/1 with a valid petId.
Assertions:
Verify the response status code is 200 (OK).
Verify the response body contains the details of the pet with ID 1.
Confirm that the pet details match the expected data.


Test Case 2: Retrieve Pet by Invalid ID (Negative Test)
Description: Verify that retrieving a pet with an invalid ID format results in a bad request error.
Steps:

Send a GET request to /pet/invalid_id with an invalid petId (e.g., non-numeric string).
Assertions:
Verify the response status code is 400 (Bad Request).
Verify the response body contains an error message indicating the invalid ID format.


Test Case 3: Retrieve Pet by Non-Existing ID (Negative Test)
Description: Verify that retrieving a pet with a non-existing ID results in a not found error.
Steps:

Send a GET request to /pet/9999 with a non-existing petId.
Assertions:
Verify the response status code is 404 (Not Found).
Verify the response body contains an error message indicating that the pet was not found.


Test Case 4: Retrieve Pet with No ID (Negative Test)
Description: Verify that retrieving a pet without providing an ID in the path results in a bad request error.
Steps:

Send a GET request to /pet/ without a petId in the path.
Assertions:
Verify the response status code is 400 (Bad Request) or 404 (Not Found).
Verify the response body contains an error message indicating that the ID is required.


Test Case 5: Retrieve Pet with Special Characters in ID (Negative Test)
Description: Verify that retrieving a pet with special characters in the ID results in a bad request error.
Steps:

Send a GET request to /pet/!@#$% with special characters in the petId.
Assertions:
Verify the response status code is 400 (Bad Request).
Verify the response body contains an error message indicating the invalid ID format.


Test Case 6: Retrieve Pet with Large Numeric ID (Edge Case)
Description: Verify that retrieving a pet with a very large numeric ID is handled correctly.
Steps:

Send a GET request to /pet/9223372036854775807 with a very large petId.
Assertions:
Verify the response status code is 404 (Not Found) if the ID does not exist.
If the ID exists, verify the response status code is 200 (OK) and the response body contains the pet details.


Test Case 7: Retrieve Pet with Leading Zeros in ID (Edge Case)
Description: Verify that retrieving a pet with leading zeros in the ID is handled correctly.
Steps:

Send a GET request to /pet/00001 with leading zeros in the petId.
Assertions:
Verify the response status code is 200 (OK).
Verify the response body contains the details of the pet with ID 1, if it exists.
If the pet does not exist, verify the response status code is 404 (Not Found).


Test Cases for DELETE /pet/{petId}


Description
This endpoint deletes a pet by its ID. The expected response codes are 400 (Bad Request) and 404 (Not Found). An api_key may be required in the request header.

Test Case 1: Delete Pet by Valid ID (Happy Path)
Description: Verify that a pet can be successfully deleted by a valid ID.
Steps:

Send a DELETE request to /pet/1 with a valid petId and api_key in the header.
Header: api_key: valid_api_key
Assertions:
Verify the response status code is 200 (OK).
Verify the response body contains a message indicating the pet was successfully deleted.


Test Case 2: Delete Pet by Invalid ID (Negative Test)
Description: Verify that deleting a pet with an invalid ID format results in a bad request error.
Steps:

Send a DELETE request to /pet/invalid_id with an invalid petId and api_key in the header.
Header: api_key: valid_api_key
Assertions:
Verify the response status code is 400 (Bad Request).
Verify the response body contains an error message indicating the invalid ID format.


Test Case 3: Delete Pet by Non-Existing ID (Negative Test)
Description: Verify that deleting a pet with a non-existing ID results in a not found error.
Steps:

Send a DELETE request to /pet/9999 with a non-existing petId and api_key in the header.
Header: api_key: valid_api_key
Assertions:
Verify the response status code is 404 (Not Found).
Verify the response body contains an error message indicating that the pet was not found.


Test Case 4: Delete Pet with No ID (Negative Test)
Description: Verify that deleting a pet without providing an ID in the path results in a bad request error.
Steps:

Send a DELETE request to /pet/ without a petId in the path and api_key in the header.
Header: api_key: valid_api_key
Assertions:
Verify the response status code is 400 (Bad Request).
Verify the response body contains an error message indicating that the ID is required.


Test Case 5: Delete Pet with Special Characters in ID (Negative Test)
Description: Verify that deleting a pet with special characters in the ID results in a bad request error.
Steps:

Send a DELETE request to /pet/!@#$% with special characters in the petId and api_key in the header.
Header: api_key: valid_api_key
Assertions:
Verify the response status code is 400 (Bad Request).
Verify the response body contains an error message indicating the invalid ID format.


Test Case 6: Delete Pet with Large Numeric ID (Edge Case)
Description: Verify that deleting a pet with a very large numeric ID is handled correctly.
Steps:

Send a DELETE request to /pet/9223372036854775807 with a very large petId and api_key in the header.
Header: api_key: valid_api_key
Assertions:
Verify the response status code is 404 (Not Found) if the ID does not exist.
If the ID exists, verify the response status code is 200 (OK) and the response body contains a message indicating the pet was successfully deleted.


Test Case 7: Delete Pet with Leading Zeros in ID (Edge Case)
Description: Verify that deleting a pet with leading zeros in the ID is handled correctly.
Steps:

Send a DELETE request to /pet/00001 with leading zeros in the petId and api_key in the header.
Header: api_key: valid_api_key
Assertions:
Verify the response status code is 200 (OK).
Verify the response body contains a message indicating the pet was successfully deleted, if it exists.
If the pet does not exist, verify the response status code is 404 (Not Found).


Test Case 8: Delete Pet Without API Key (Negative Test)
Description: Verify that deleting a pet without providing the api_key in the header results in an error.
Steps:

Send a DELETE request to /pet/1 with a valid petId but without the api_key in the header.
Assertions:
Verify the response status code is 403 (Forbidden) or 401 (Unauthorized), depending on the implementation.
Verify the response body contains an error message indicating that the API key is required.


Test Cases for POST /pet/{petId}


Description
This endpoint updates a pet's details using form data. The possible parameters include:

petId (integer, path): ID of the pet that needs to be updated.
name (string, formData): Updated name of the pet.
status (string, formData): Updated status of the pet.
The expected response code for validation exceptions is 405 (Method Not Allowed).

Test Case 1: Update Pet with Valid Name and Status (Happy Path)
Description: Verify that a pet's name and status can be successfully updated using form data.
Steps:

Send a POST request to /pet/1 with valid petId, name, and status.
petId: 1
name: "Buddy"
status: "available"
Assertions:
Verify the response status code is 200 (OK).
Verify the response body contains the updated details of the pet.
Confirm that the pet's name and status are updated correctly.


Test Case 2: Update Pet with Only Name
Description: Verify that a pet's name can be successfully updated using form data.
Steps:

Send a POST request to /pet/1 with valid petId and name, but without status.
petId: 1
name: "Buddy"
Assertions:
Verify the response status code is 200 (OK).
Verify the response body contains the updated details of the pet.
Confirm that the pet's name is updated correctly.


Test Case 3: Update Pet with Only Status
Description: Verify that a pet's status can be successfully updated using form data.
Steps:

Send a POST request to /pet/1 with valid petId and status, but without name.
petId: 1
status: "sold"
Assertions:
Verify the response status code is 200 (OK).
Verify the response body contains the updated details of the pet.
Confirm that the pet's status is updated correctly.


Test Case 4: Update Pet with Invalid ID (Negative Test)
Description: Verify that updating a pet with an invalid ID results in a method not allowed error.
Steps:

Send a POST request to /pet/invalid_id with invalid petId, name, and status.
petId: "invalid_id"
name: "Buddy"
status: "available"
Assertions:
Verify the response status code is 405 (Method Not Allowed).
Verify the response body contains an error message indicating the invalid ID.


Test Case 5: Update Pet with Non-Existing ID (Negative Test)
Description: Verify that updating a pet with a non-existing ID results in a method not allowed error.
Steps:

Send a POST request to /pet/9999 with a non-existing petId, name, and status.
petId: 9999
name: "Buddy"
status: "available"
Assertions:
Verify the response status code is 405 (Method Not Allowed).
Verify the response body contains an error message indicating that the pet was not found.


Test Case 6: Update Pet with Invalid Status (Negative Test)
Description: Verify that updating a pet with an invalid status results in a method not allowed error.
Steps:

Send a POST request to /pet/1 with valid petId, name, and invalid status.
petId: 1
name: "Buddy"
status: "unknown_status"
Assertions:
Verify the response status code is 405 (Method Not Allowed).
Verify the response body contains an error message indicating the invalid status.


Test Case 7: Update Pet with Special Characters in Name (Edge Case)
Description: Verify that updating a pet's name with special characters is handled correctly.
Steps:

Send a POST request to /pet/1 with valid petId, status, and a name containing special characters.
petId: 1
name: "Buddy@#"
status: "available"
Assertions:
Verify the response status code is 200 (OK).
Verify the response body contains the updated details of the pet.
Confirm that the pet's name with special characters is updated correctly.


Test Case 8: Update Pet with Large Numeric ID (Edge Case)
Description: Verify that updating a pet with a very large numeric ID is handled correctly.
Steps:

Send a POST request to /pet/9223372036854775807 with a very large petId, name, and status.
petId: 9223372036854775807
name: "Buddy"
status: "available"
Assertions:
Verify the response status code is 405 (Method Not Allowed).
Verify the response body contains an error message indicating the invalid ID or that the pet was not found.


Test Case 9: Update Pet with Leading Zeros in ID (Edge Case)
Description: Verify that updating a pet with leading zeros in the ID is handled correctly.
Steps:

Send a POST request to /pet/00001 with leading zeros in the petId, name, and status.
petId: 00001
name: "Buddy"
status: "available"
Assertions:
Verify the response status code is 200 (OK).
Verify the response body contains the updated details of the pet.
Confirm that the pet with ID 1 is updated correctly.


Test Case 10: Update Pet with Empty Name and Status (Negative Test)
Description: Verify that updating a pet with empty name and status results in a method not allowed error.
Steps:

Send a POST request to /pet/1 with valid petId, but empty name and status.
petId: 1
name: ""
status: ""
Assertions:
Verify the response status code is 405 (Method Not Allowed).
Verify the response body contains an error message indicating the validation error.
