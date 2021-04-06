#!/usr/bin/env bash
jname=j-test
jarname=jmeter-0.0.1.jar
id=$(ps -ef | grep java | grep ${jname} | grep -v grep | awk '{print$2}')

echo "$(date)"
if [[ "$id" != "" ]]; then
    echo "stop ${jname} pid=$id"
    kill $id

    while [[ true ]]; do
        count=" $(ps -ef | grep java | grep ${jname} | grep -v grep | wc -l) "
        if [[ ${count} -eq "0" ]]; then
            echo "done"
            break
        fi
        sleep 1
        echo "."
    done

else
    echo "done"
fi
