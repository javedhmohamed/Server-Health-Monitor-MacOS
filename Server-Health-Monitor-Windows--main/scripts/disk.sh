#!/bin/bash
# Show disk usage for root (you can change "/" to another mount if needed)
df -h / | awk 'NR==2{printf "Disk Usage: %s/%s (%s used)\n", $3, $2, $5}'