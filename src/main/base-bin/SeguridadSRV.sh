#!/bin/sh
#--------FUNCTIONS--------------------------------------------------
say() {
if [ "${args}" ]
    then
        nada=""
    else
        echo ${*}
fi
}
#------END FUNCTIONS-----------------------------------------------------

say "--------------------------------------------------------------------"
export COBDIR=/opt/lib/cobol
export LD_LIBRARY_PATH=/opt/lib/mflmf/coblib
export COBSW=-F

if [ "${INSTALACION}" ]
then
	say "INSTALACION=${INSTALACION}"
else
	export INSTALACION=/usr/local;say "INSTALACION=${INSTALACION}"
fi
say "--------------------------------------------------------------------"


java -jar ${INSTALACION}/seguridad-basica-1.1/seguridad-basica-srv-1.1-Z.jar ${*} &

