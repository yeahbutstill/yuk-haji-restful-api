# API Spec (Yuk Haji) 

## Setup Database

* Run postgreSQL di docker

    ```bashpro shell script
    docker run --rm \
    --name restful-yuk-haji \
    -e POSTGRES_DB=yukhajidb \
    -e POSTGRES_USER=yukhaji \
    -e POSTGRES_PASSWORD=PNSJkxXvVNDAhePMuExTBuRR \
    -e PGDATA=/var/lib/postgresql/data/pgdata \
    -v "$PWD/yukhajidb-data:/var/lib/postgresql/data" \
    -p 5432:5432 \
    postgres:12
   ```

  Or docker-compose
    ```yml
    # docker-compose.yml  
    version: '3.9'
      services:
        # container apps
        api-yuk-haji:
          container_name: api-yukhaji
          image: kotlin-restful-api-yukhaji:0.0.1
          ports:
            - "8080:8080"
          environment:
            DATABASE_USERNAME: yukhaji
            DATABASE_PASSWORD: PNSJkxXvVNDAhePMuExTBuRR
            DATABASE_URL: jdbc:postgresql://restful-yuk-haji:5432/yukhajidb
        # container database
        restful-api-yuk-haji:
          container_name: "restful-yuk-haji"
          image: postgres:12
          ports:
            - "5432:5432"
          environment:
            POSTGRES_PASSWORD: PNSJkxXvVNDAhePMuExTBuRR
            POSTGRES_USER: yukhaji
            POSTGRES_DB: yukhajidb
    ```

## Docker Image

```dockerfile

# Dockerfile
FROM adoptopenjdk:11-jdk-hotspot
COPY build/libs/kotlin-resful-api-0.0.1-SNAPSHOT.jar /app/application-yuk-haji.jar
CMD ["java", "-jar", "/app/application-yuk-haji.jar"]

```

## Create Container And Running App
```bashpro shell script

docker-compose -f docker-compose.yml up -d

```

## Check Logs
```bashpro shell script
# check running container
docker container ls
# check log apps
docker container logs api-yukhaji

```

## API KEY

* Request :
    - Header :
        - X-Api-Key : "api key"

## Create Jamaah

* Request:
    - Method : POST
    - Endpoint : `/main-api/jamaah`
    - Header :
        - Content-Type: application/json
        - Accept: application/json
        - X-Api-Key: api_keys
    - Body : ``json``
  ```json
  {
      "id" : "string, unique",
      "nama_lengkap" : "string" ,
      "nama_ayah_kandung" : "string",
      "tempat_lahir" : "string",
      "tgl_lahir" : "string",
      "ktp": "int, unique",
      "nik": "int, unique",
      "paspor" : "int, unique",
      "jenis_kelamin" : "string",
      "kewarganegaraan" : "string",
      "alamat_lengkap" : "string",
      "pekerjaan" : "string",
      "pendidikan" : "string",
      "status_calon_jamaah_haji" : "string",
      "status_perkawinan" : "string"
  } 
  ```

* Response :
  ```json
  {
      "code" : "number",
      "status" : "string",
      "data" : {
        "id" : "string, unique",
        "nama_lengkap" : "string" ,
        "nama_ayah_kandung" : "string",
        "tempat_lahir" : "string",
        "tgl_lahir" : "date",
        "ktp": "int, unique",
        "nik": "int, unique",
        "paspor" : "int, unique",
        "jenis_kelamin" : "string",
        "kewarganegaraan" : "string",
        "alamat_lengkap" : "string",
        "pekerjaan" : "string",
        "pendidikan" : "string",
        "status_calon_jamaah_haji" : "string",
        "status_perkawinan" : "string",
        "createdAt" : "date",
        "updatedAt" : "date"
      }
  } 
  ```

## Get Jamaah

* Request:
    - Method : GET
    - Endpoint : `/main-api/jamaah/{idJamaah}`
    - Header :
        - Accept: application/json
        - X-Api-Key: api_keys

* Response :
  ```json
  {
      "code" : "number",
      "status" : "string",
      "data" : {
        "id" : "string, unique",
        "nama_lengkap" : "string" ,
        "nama_ayah_kandung" : "string",
        "tempat_lahir" : "string",
        "tgl_lahir" : "date",
        "ktp": "int, unique",
        "nik": "int, unique",
        "paspor" : "int, unique",
        "jenis_kelamin" : "string",
        "kewarganegaraan" : "string",
        "alamat_lengkap" : "string",
        "pekerjaan" : "string",
        "pendidikan" : "string",
        "status_calon_jamaah_haji" : "string",
        "status_perkawinan" : "string",
        "createdAt" : "date",
        "updatedAt" : "date"
      }
  } 
  ```

## Update Jamaah

* Request:
    - Method : PUT
    - Endpoint : `/main-api/jamaah/{idJamaah}`
    - Header :
        - Content-Type: application/json
        - Accept: application/json
        - X-Api-Key: api_keys
    - Body : ``json``
  ```json
  {
      "nama_lengkap" : "string" ,
      "nama_ayah_kandung" : "string",
      "tempat_lahir" : "string",
      "tgl_lahir" : "string",
      "ktp": "int, unique",
      "nik": "int, unique",
      "paspor" : "int, unique",
      "jenis_kelamin" : "string",
      "kewarganegaraan" : "string",
      "alamat_lengkap" : "string",
      "pekerjaan" : "string",
      "pendidikan" : "string",
      "status_calon_jamaah_haji" : "string",
      "status_perkawinan" : "string"
  } 
  ```
* Response :
  ```json
  {
      "code" : "number",
      "status" : "string",
      "data" : {
        "id" : "string, unique",
        "nama_lengkap" : "string" ,
        "nama_ayah_kandung" : "string",
        "tempat_lahir" : "string",
        "tgl_lahir" : "date",
        "ktp": "int, unique",
        "nik": "int, unique",
        "paspor" : "int, unique",
        "jenis_kelamin" : "string",
        "kewarganegaraan" : "string",
        "alamat_lengkap" : "string",
        "pekerjaan" : "string",
        "pendidikan" : "string",
        "status_calon_jamaah_haji" : "string",
        "status_perkawinan" : "string",
        "createdAt" : "date",
        "updatedAt" : "date"
      }
  } 
  ```

## List Jamaah

* Request:
    - Method : GET
    - Endpoint : `main-api/jamaahs/`
    - Header :
        - Accept: application/json
        - X-Api-Key: api_keys
    - Query Param :
        - size : number,
        - page : number

* Response :
  ```json
  {
      "code" : "number",
      "status" : "string",
      "data" : [
        {
          "id" : "string, unique",
          "nama_lengkap" : "string" ,
          "nama_ayah_kandung" : "string",
          "tempat_lahir" : "string",
          "tgl_lahir" : "date",
          "ktp": "int, unique",
          "nik": "int, unique",
          "paspor" : "int, unique",
          "jenis_kelamin" : "string",
          "kewarganegaraan" : "string",
          "alamat_lengkap" : "string",
          "pekerjaan" : "string",
          "pendidikan" : "string",
          "status_calon_jamaah_haji" : "string",
          "status_perkawinan" : "string",
          "createdAt" : "date",
          "updatedAt" : "date"
        },
        {
          "id" : "string, unique",
          "nama_lengkap" : "string" ,
          "nama_ayah_kandung" : "string",
          "tempat_lahir" : "string",
          "tgl_lahir" : "date",
          "ktp": "int, unique",
          "nik": "int, unique",
          "paspor" : "int, unique",
          "jenis_kelamin" : "string",
          "kewarganegaraan" : "string",
          "alamat_lengkap" : "string",
          "pekerjaan" : "string",
          "pendidikan" : "string",
          "status_calon_jamaah_haji" : "string",
          "status_perkawinan" : "string",
          "createdAt" : "date",
          "updatedAt" : "date"
        }
      ] 
  } 
  ```

## Delete Jamaah

* Request:
    - Method : DELETE
    - Endpoint : `main-api/jamaah/{id_jamaah}`
    - Header :
        - Accept: application/json
        - X-Api-Key: api_keys

* Response :
  ```json
  {
    "code" : "number",
    "status" : "string",
    "data" : "string"
  } 
  ```
