ifneq (,$(wildcard ./.env))
    include .env
    export
endif
COMPOSE=docker compose
CONTAINER_BE = $(PROJECT_NAME)-app
CONTAINER_DB = $(PROJECT_NAME)-database
CONTAINER_NETWORK = $(PROJECT_NAME)-network

# Build the jar and docker containers
build:
	mvn clean package -DskipTests
	$(COMPOSE) build

# Start the container
up:
	$(COMPOSE) up -d

# Stop the containers
down:
	$(COMPOSE) stop

be-logs:
	$(COMPOSE) logs -f

restart:
	$(COMPOSE) restart $(CONTAINER_BE)

be-shell:
	$(COMPOSE) exec $(CONTAINER_BE) bash

db-shell:
	$(COMPOSE) exec $(CONTAINER_DB) bash

clean:
	$(COMPOSE) down -v --remove-orphans
	docker system prune --f
