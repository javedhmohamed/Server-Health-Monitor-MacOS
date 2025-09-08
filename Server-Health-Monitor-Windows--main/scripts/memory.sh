#!/bin/bash
echo "Memory Usage:"
vm_stat | grep -E 'Pages free|Pages active|Pages inactive|Pages speculative|Pages wired down'