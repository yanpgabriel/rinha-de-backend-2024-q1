build:
	./mvnw clean package -DskipTests
	docker build -f src/main/docker/Dockerfile.jvm -t yanpgabriel/rinha-quarkus-jvm:latest .

build-nativo:
	./mvnw clean package -DskipTests -Dnative -Dquarkus.native.container-build=true -Dquarkus.container-image.build=true
	docker build -f src/main/docker/Dockerfile.native -t yanpgabriel/rinha-quarkus-native .

build-micro:
	./mvnw clean package -DskipTests -Dnative -Dquarkus.native.container-build=true -Dquarkus.container-image.build=true
	docker build -f src/main/docker/Dockerfile.native-micro -t yanpgabriel/rinha-quarkus-native-micro .

build-final:
	docker buildx build --platform linux/amd64,linux/arm64 --push -f src/main/docker/Dockerfile.native-micro -t yanpgabriel/quarkus-rinha-2024-q1:latest .

build-for-all:
	docker buildx build --platform linux/amd64,linux/arm64,linux/arm64v8 --push -f src/main/docker/Dockerfile.native-micro -t yanpgabriel/quarkus-rinha-2024-q1:latest .

push-iamge:
	docker push yanpgabriel/quarkus-rinha-2024-q1:latest

up:
	docker compose -f infra/docker/docker-compose.yml up -d
down:
	docker compose -f infra/docker/docker-compose.yml down