.DEFAULT_GOAL := run_no_cli_in

.PHONY:run_no_cli_in run_sys_cli_in run_env_cli_in

run_no_cli_in:
	./mvnw quarkus:dev

run_env_cli_in:
	GREETING_TEST_NEW="Greeting from the terminale" ./mvnw quarkus:dev

run_sys_cli_in:
	./mvnw quarkus:dev -Dgreeting.test.new="greeting from beyound the grave"
