# Final Exam – Backend Software Development

You are joining the backend software developer team in charge of creating a RESTful API that supports operations for **HIGN**. The **HIGN Platform** ecosystem requires the **HIGN Medical Exams Management Web Application** to have endpoints in the RESTful API for managing the following information:

### **Entities:**
#### **Examiners**
Attributes:
- **id**: Long, Primary Key, Auto-generated.
- **firstName**: String, Mandatory, Not empty.
- **lastName**: String, Mandatory, Not empty.
- **nationalProviderIdentifier**: Business identifier, Mandatory, Not empty, must be a valid UUID.

#### **Mental State Exams**
Attributes:
- **id**: Long, Primary Key, Auto-generated.
- **patientId**: Long, Mandatory, Not empty.
- **examinerNationalProviderIdentifier**: Embedded type, Mandatory, Not empty.
- **examDate**: Date, Mandatory, Not empty.
- **orientationScore**: Integer, Mandatory.
- **registrationScore**: Integer, Mandatory.
- **attentionAndCalculationScore**: Integer, Mandatory.
- **recallScore**: Integer, Mandatory.
- **languageScore**: Integer, Mandatory.

### **Business Rules**
1. The `nationalProviderIdentifier`:
   - Must be an embedded type.
   - Can only contain a valid UUID value provided at registration (not auto-generated).
   - Is an internal business identifier and must be unique for each Examiner in the database.

2. The `examinerNationalProviderIdentifier`:
   - Must be embedded and correspond to the `nationalProviderIdentifier` of a previously registered Examiner.

3. The `examDate`:
   - Cannot be greater than the current date.

4. Score constraints:
   - `orientationScore`: Integer between 0 and 10.
   - `registrationScore`: Integer between 0 and 3.
   - `attentionAndCalculationScore`: Integer between 0 and 5.
   - `recallScore`: Integer between 0 and 3.
   - `languageScore`: Integer between 0 and 9.

5. Relationships:
   - An Examiner can evaluate multiple Mental State Exams.
   - A specific Mental State Exam can only be evaluated by one Examiner.

6. Both **Examiner** and **Mental State Exam** belong to different bounded contexts. Therefore, an **Anti-Corruption Layer (ACL)** is required to access capabilities exposed by one bounded context for use in another.

7. Both **Examiner** and **Mental State Exam** are **Aggregate Roots** in their respective bounded contexts and require the following audit attributes:
   - **createdAt**: Date and time of record creation.
   - **updatedAt**: Date and time of last record update.
   - Populated automatically during creation or update operations.

---

### **Endpoints**
#### **Examiners Endpoint (/api/v1/examiners)**
- Implements a **POST** operation to add an Examiner.
- The `id` is auto-generated and not requested during submission.
- The `nationalProviderIdentifier` is provided as a `String` and must be converted into a valid UUID version 4.
- Returns:
  - **Status**: `201 Created`.
  - **Response Body**: Includes the generated `id`, all submitted attributes (with `nationalProviderIdentifier` as a String). Audit attributes are excluded.

#### **Mental State Exams Endpoint (/api/v1/mental-state-exams)**
- Implements a **POST** operation to add a Mental State Exam.
- The `id` is auto-generated and not requested during submission.
- The `examDate` is submitted as a `String` in the format `YYYY-MM-DD` (e.g., "2024-04-13").
- The `examinerNationalProviderIdentifier` is provided as a `String`.
- Returns:
  - **Status**: `201 Created`.
  - **Response Body**: Includes the generated `id`, all submitted attributes (with `examinerNationalProviderIdentifier` as a String). Audit attributes are excluded.

---

### **Technical Constraints**
1. Use **Java 22** and **Spring Boot Framework 3.X**.
2. Name the project: `si729ebu<student-code>` (e.g., `si729ebu201621873`).
3. Use a **relational database (MySQL)** with schema `hign`.
4. Root package name: `org.hign.platform.u<student-code>` (e.g., `org.hign.platform.u201621873`).
5. **Bounded Contexts**:
   - **Personnel**: Contains the Examiner concept.
   - **Assessment**: Contains the Mental State Exam concept.
   - **Shared**: Contains reusable/common base elements for other bounded contexts.
6. Apply **good software architecture practices**:
   - Domain-Driven Design (DDD).
   - Bounded contexts.
   - Layered architecture (domain, application, interfaces, infrastructure).
   - Strategic and tactical DDD patterns.
   - CQRS pattern.
   - Anti-Corruption Layer (ACL).
   - Software design principles and object-oriented design patterns.
7. Naming conventions:
   - URLs: Lowercase, use hyphen-separated terms for compound words.
   - Java: 
     - **UpperCamelCase** for classes.
     - **lowerCamelCase** for attributes and methods.
   - Database: 
     - **snake_case** for naming.
     - Tables: Use plural names without mnemonics.
8. Use **Lombok** for constructors and access methods.
9. Use **records** for immutable value storage.
10. Audit attributes `createdAt` and `updatedAt`:
    - Automatically populated using Spring Boot during creation or update.
11. Use the **Assembler pattern** for Object Mapping in the interfaces layer.
12. Document code with **JavaDoc**:
    - Include purpose for major programming objects.
    - Include purpose, parameters, and return values for relevant classes and methods.
    - Add author tag with full name.
13. Document endpoints with **OpenAPI**.
14. Include **exception handling**.
15. Package the solution as a `.zip` file with the name format: `upc-pre-202401-si729-<section>-eb-u<student-code>.zip` (e.g., `upc-pre-202401-si729-sw51-eb-u201621873.zip`).
16. Submit the solution to the designated activity.

---

### **Out of Scope**
1. CORS support.
2. Security.
3. Testing.

---

# Appendices

## Appendix A: References

1. **Compress and Decompress Files**  
   [https://support.microsoft.com/es-es/windows/comprimir-y-descomprimir-archivos-8d28fa72-f2f9-712f-67df-f80cf89fd4e5](https://support.microsoft.com/es-es/windows/comprimir-y-descomprimir-archivos-8d28fa72-f2f9-712f-67df-f80cf89fd4e5)

2. **REST API Tutorial**  
   [https://restfulapi.net/](https://restfulapi.net/)

3. **Project Lombok**  
   [https://projectlombok.org/](https://projectlombok.org/)

4. **springdoc-openapi**  
   [https://springdoc.org/](https://springdoc.org/)

5. **Spring Data JPA - Reference Documentation**  
   [https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference)

6. **Class UUID**  
   [https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/util/UUID.html](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/util/UUID.html)

7. **Online UUID Generator**  
   [https://www.uuidgenerator.net/version4](https://www.uuidgenerator.net/version4)

8. **How to Write Doc Comments for the Javadoc Tool**  
   [https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html](https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html)

9. **Formats for Date and DateTime in JSON Payloads**  
   [https://www.geeksforgeeks.org/formats-for-date-and-datetime-in-json-payloads/](https://www.geeksforgeeks.org/formats-for-date-and-datetime-in-json-payloads/)

10. **Spring Data JPA Auditing**  
    [https://docs.spring.io/spring-data/jpa/reference/auditing.html#auditing.annotations](https://docs.spring.io/spring-data/jpa/reference/auditing.html#auditing.annotations)
