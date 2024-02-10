build:
	mvnw.cmd clean package -DskipTests
	docker build -f src/main/docker/Dockerfile.jvm -t yanpgabriel/rinha-quarkus-jvm:latest .

build-nativo:
	mvnw.cmd clean package -DskipTests -Dnative -Dquarkus.native.container-build=true -Dquarkus.container-image.build=true
	docker build -f src/main/docker/Dockerfile.native -t yanpgabriel/rinha-quarkus-native .

build-micro:
	mvnw.cmd clean package -DskipTests -Dnative -Dquarkus.native.container-build=true -Dquarkus.container-image.build=true
	docker build -f src/main/docker/Dockerfile.native-micro -t yanpgabriel/rinha-quarkus-native-micro .

build-final:
	docker buildx build --platform linux/amd64 -t yanpgabriel/rinha-quarkus:latest .

up:
	docker compose -f infra/docker/docker-compose.yml up -d
down:
	docker compose -f infra/docker/docker-compose.yml down