#!/bin/sh
row=150

for i in `seq 1 $row`
do
	echo sfirst${i} slast${i} pfirst${i} $i >> regInfo
done
