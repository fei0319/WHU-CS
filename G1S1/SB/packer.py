import argparse
import zipfile
import os

parser = argparse.ArgumentParser(description = 'A program that helps you to pack your tasks.')
parser.add_argument('taskname', metavar = 'taskname', help = 'the folder to pack')
args = parser.parse_args()

info = open('info.private', 'r', encoding = 'utf-8').read().splitlines()

taskname = args.taskname
name = info[0]
student_id = info[1]
class_id = info[2]

if taskname.find('hw') != -1:
    task_id = 'Z-'
elif taskname.find('lab') != -1:
    task_id = 'S-'
while not taskname.isdigit():
    taskname = taskname[1:]
task_id += taskname

packname = '-'.join([student_id, name, class_id, task_id])

f = zipfile.ZipFile(packname + '.zip', 'w', zipfile.ZIP_DEFLATED)

dir = args.taskname
for path, dirnames, filenames in os.walk(dir):
    for filename in filenames:
        f.write(os.path.join(path, filename), os.path.join(path.replace(dir, ''), filename))