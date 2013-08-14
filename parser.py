import sys
from bs4 import BeautifulSoup

def main():
    parser()
def parser():
    soup=BeautifulSoup(open("Department of Computer Science and Engineering2.htm"))
    list1=soup.find_all('b')
    list2=soup.find_all(id="tddft",align="center",valign="top")
    list3=soup.find_all(id="tdalt",align="center",valign="top")
    list4=soup.find_all('i')
   ## f=open('myfile.txt','w+')
    for i in range(30):
      if(i%2==0):
        print "Name          :%s\nDesignation   :%s\nPhd           :%s\nOffice        :%s\nPhone Off     :%s\nRes           :%s\nRes2          :%s\nE-mail        :%s\nQuarter       :%s\nResearch Areas:%s"%(str(list1[i].string),str(list2[8*i/2].string),str(list2[8*i/2+1].string),str(list2[8*i/2+2].string),(list2[8*i/2+3].string),(list2[8*i/2+4].string),(list2[8*i/2+5].string),str(list2[8*i/2+6].string),str(list2[8*i/2+7].string),str(list4[i].string))
      else:
        print "Name          :%s\nDesignation   :%s\nPhd           :%s\nOffice        :%s\nPhone Off     :%s\nRes           :%s\nRes2          :%s\nE-mail        :%s\nQuarter       :%s\nResearch Areas:%s"%(str(list1[i].string),str(list3[8*(i/2)].string),str(list3[8*(i/2)+1].string),str(list3[8*(i/2)+2].string),(list3[8*(i/2)+3].string),(list3[8*(i/2)+4].string),(list3[8*(i/2)+5].string),str(list3[8*(i/2)+6].string),str(list3[8*(i/2)+7].string),str(list4[i].string))
  ##  f.close()          
if __name__ == '__main__':
    main()
 
