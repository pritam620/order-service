# order-service
SpringBoot sample order service

```dbn-psql
docker run --name order-service-db \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=postgres \
  -e POSTGRES_DB=order_service_db \
  -p 5432:5432 \
  -d postgres:latest

docker ps| grep order-service-db
```
