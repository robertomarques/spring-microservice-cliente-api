sh build.sh
sh run-mongodb.sh
docker run --rm -p 8080:8080 --link mongo-container:mongo-container cliente-api:1.0
