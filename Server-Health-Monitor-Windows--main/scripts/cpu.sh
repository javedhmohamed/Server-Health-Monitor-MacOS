#!/bin/bash
echo "CPU Usage:"
top -l 1 | grep "CPU usage"

echo ""
echo "Number of processors:"
sysctl -n hw.ncpu