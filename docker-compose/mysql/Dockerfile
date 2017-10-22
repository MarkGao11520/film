FROM mysql:5.7

#设置免密登录
ENV MYSQL_ALLOW_EMPTY_PASSWORD yes

#将所需文件放到容器中
COPY setup.sh /mysql/setup.sh
COPY data /mysql/data
COPY privileges.sql /mysql/privileges.sql

CMD ["sh","/mysql/setup.sh"]
# RUN service mysql start && mysql -uroot -p -e "source /mysql/schema.sql"

