FROM mysql:latest
ENV MYSQL_ROOT_PASSWORD ds1010
ENV MYSQL_DATABASE tecnoimport
ENV MYSQL_USER luiacarr
ENV MYSQL_PASSWORD lc2020
ADD basetecnoimport.sql /docker-entrypoint-initdb.d
EXPOSE 3306