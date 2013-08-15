from bs4 import BeautifulSoup
import codecs

file=open('input.html','r')
file1=codecs.open('output.txt','w','utf-8')
soup=BeautifulSoup(file)
soup.tr.decompose()
soup.tr.decompose()
tag=soup.table
for k in range(1,91):
    if(k%3==1):
       tag1=tag.contents[k]
       tag3=tag.contents[k+2]
       
       j=3

       tag2=tag1.contents[j].b.string 
       print("Name: %s\n"%tag2)
       file1.write("Name: %s\n"%tag2)
             
       j=j+2
       tag2=tag1.contents[j].string
       print("Designation: %s\n"%tag2)
       file1.write("Designation: %s\n"%tag2)
       
       j=j+2              
       tag2=tag1.contents[j].string
       print("phD: %s\n"%tag2 )      
       file1.write("phD: %s\n"%tag2) 
      
       j=j+2
       tag2=tag1.contents[j].a.string
       print("office room number: %s\n"%tag2)
       file1.write("office room number: %s\n"%tag2)             
             
       j=j+2           
       print("phone numbers  :\n")
       file1.write("phone numbers : \n")
       tag2=tag1.contents[j].string
       print("  %s"%tag2)
       file1.write("  %s"%tag2 )

       j=j+2
       tag2=tag1.contents[j].string
       print("  %s"%tag2)
       file1.write("  %s"%tag2 )


       j=j+2
       tag2=tag1.contents[j].string
       print("  %s\n"%tag2)
       file1.write("  %s\n"%tag2 )

       j=j+2
       tag2=tag1.contents[j].string
       print("email : %s\n"%tag2)
       file1.write("email : %s\n"%tag2) 

       j=j+2
       tag2=tag1.contents[j].string
       print("Quartes : %s\n"%tag2)
       file1.write("Quartes : %s\n"%tag2) 
              
       j=j+2
       tag2=tag1.contents[j].a
       print("%s :"%tag2.string)
       print(tag2['href'])
       print("\n")
       file1.write("%s :"%tag2.string)
       file1.write(tag2['href'])
       file1.write("\n")

            
       tag4=tag3.contents[0].i.string
       print("Research areas : %s\n"%tag4)
       file1.write("Research areas : %s\n"%tag4)


       print("..................................................................................................................\n")
            
       file1.write("..................................................................................................................\n")    
