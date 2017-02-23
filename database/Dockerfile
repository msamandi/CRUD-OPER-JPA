FROM    mysql:5.6

ADD     scripts/init_db.sql /docker-entrypoint-initdb.d/
ADD     src/main/resources/db/migration/schema/V20170223_1__jobmanager_schema.sql /docker-entrypoint-initdb.d/
