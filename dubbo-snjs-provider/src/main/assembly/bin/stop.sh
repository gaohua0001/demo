#!/bin/bash
cd `dirname $0`
BIN_DIR=`pwd`
cd ..
DEPLOY_DIR=`pwd`
CONF_DIR=$DEPLOY_DIR/conf
LOGS_DIR=$DEPLOY_DIR/logs

if [ ! -d $LOGS_DIR ]; then
    mkdir $LOGS_DIR
fi

PIDS=`ps -ef | grep java | grep "$CONF_DIR" |awk '{print $2}'`
if [ -z "$PIDS" ]; then
    echo "ERROR: The system does not started!"
    exit 1
fi

echo "Stopping..."
echo "  Stopping at `date +'%Y-%m-%d %H:%M'`" >> $LOGS_DIR/admin.log
for PID in $PIDS ; do
    kill -9 $PID > /dev/null 2>&1
done

echo "OK!"
echo "PID: $PIDS"
