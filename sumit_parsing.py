from urllib import urlopen

from bs4 import BeautifulSoup
import re
webpage=urlopen('http://cse.iitkgp.ac.in/faculty.html').read()
soup = BeautifulSoup(webpage)
td_tag=soup.findAll('td')
arr=[' ',' Name-',' Designation-','PhD-','office','phone_Off-','phone_Res-','phone_Res2-','email-','Quarter','personal webpage-','research areas-']
output_file=open('output_file.txt','w')
for j in range(0,360,1):
    final=td_tag[j].get_text()
    if(final!='Personal webpage'):
        output_file.write(arr[j%12]+final.encode("windows-1252"))
        output_file.write('\n')

