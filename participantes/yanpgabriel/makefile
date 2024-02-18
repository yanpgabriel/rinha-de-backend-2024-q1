build:
	./mvnw clean package -DskipTests
	docker build -f src/main/docker/Dockerfile.jvm -t yanpgabriel/rinha-quarkus-jvm:latest .

build-final:
	docker buildx build --builder multi-platform-builder --platform linux/amd64,linux/arm64 --push -f src/main/docker/Dockerfile.multistage -t yanpgabriel/quarkus-rinha-2024-q1:latest .

up:
	docker compose -f infra/docker/docker-compose.yml up -d
down:
	docker compose -f infra/docker/docker-compose.yml down
