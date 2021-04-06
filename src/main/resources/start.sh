#!/bin/bash

jname=j-test
jarname=jmeter-0.0.1.jar

id=$(ps -ef | grep java | grep ${jname} | grep -v grep | awk '{print$2}')

if [ "$id" != "" ]; then
    echo "${jname} web is running, pid=$id"
else
    if [ ! -d "logs" ]; then
        echo "mkdir"
        mkdir logs
    fi
    nohup java -Dname=${jname} \
        -Xms256M -Xmx256M \
        -XX:ErrorFile=logs/hs_err_pid%p.log \
        -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=logs/ \
        -XX:+PrintGCDateStamps -XX:+PrintGCDetails \
        -jar ${jarname} >>logs/start.log 2>&1 &
    echo "start ok"
fi
