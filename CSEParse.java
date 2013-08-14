/**
 *
 * @author arkanathpathak, Roll No. 12CS10007
 */
import java.util.Arrays.*;
import java.util.regex.*;
import java.text.*;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import java.io.File;
import java.nio.channels.*;
import net.htmlparser.jericho.*;
import java.nio.charset.Charset;

public class CSEParse {

    public static void main(String[] args) throws Exception {


        try {
	 PrintWriter writer = new PrintWriter("faculties.txt", "UTF-8");
writer.println("CSE Department Faculties Data");
writer.println("Arkanath Pathak, Roll No. 12CS10007");

            List<Element> elems = new ArrayList<Element>();

            String url = "http://cse.iitkgp.ac.in/faculty.html";

            URLConnection connection = new URL(url).openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");

            Source src1 = new Source(connection);
            elems = src1.getAllElements();

            Iterator it = elems.iterator();
            Element el;

            String[] posts = {" ", "Name", "Designation", "PhD", "Room No.", "Ph1", "Ph2", "Ph3", "Email", "Quarter", "Webpage", "Research Areas"};
            int iter1 = 0;
            int iter2 = 0;
	    int count=0;
            while (it.hasNext()) {

                el = (Element) it.next();
                String cont = el.getContent().toString();
                String name1 = el.getName();
		String id= el.getAttributeValue("id");
                if (id == null) {


                    if (name1.equals("tr")) {

                        List<Element> elemsInner = el.getChildElements();
                        Iterator it1 = elemsInner.iterator();
                        Element el1;

                        while (it1.hasNext() && count<30) {

                            el1 = (Element) it.next();

                            String temp1 = el1.getName();


                            if (temp1 != null) {

                                if (temp1.equals("td")) {
				    
				    if(iter1==1){
					
					writer.println("\n________Professor No.:"+(count+1)+"________\n");
					writer.flush();
					List<Element> elemsInner2 = el1.getChildElements();
                                        Iterator it2 = elemsInner2.iterator();
                                        Element el2;

                                        while (it2.hasNext()) {

                                            el2 = (Element) it2.next();

                                            String temp2 = el2.getName();


                                            if (temp2 != null) {

                                                if (temp2.equals("b")) {

						    writer.println(posts[iter1] + ": " + el2.getContent().toString().replaceAll("&nbsp;","").replaceAll("<BR>",""));
                                                    writer.flush();
						    break;
                                                }
                                            }

                                        }
				    }
				    else if (iter1 > 1 && iter1<10) {
					if(iter1==4){
					    List<Element> elemsInner2 = el1.getChildElements();
					    Iterator it2 = elemsInner2.iterator();
					    Element el2;

					    while (it2.hasNext()) {

						el2 = (Element) it2.next();

						String temp2 = el2.getName();


						if (temp2 != null) {

						    if (temp2.equals("a")) {

							writer.println(posts[iter1] + ": " + el2.getContent().toString().replaceAll("&nbsp;","").replaceAll("<BR>",""));
							writer.flush();
							break;
						    }
						}

					    }
					    
					}

					else {
					    writer.println(posts[iter1] + ": " +  el1.getContent().toString().replaceAll("&nbsp;","").replaceAll("<BR>",""));
					    writer.flush();
					}
					}

				    else if (iter1 == 10) {
				
                                        List<Element> elemsInner2 = el1.getChildElements();
                                        Iterator it2 = elemsInner2.iterator();
                                        Element el2;

                                        while (it2.hasNext()) {

                                            el2 = (Element) it2.next();

                                            String temp2 = el2.getName();


                                            if (temp2 != null) {

                                                if (temp2.equals("a")) {

                                                    writer.println(posts[iter1] + ": " + el2.getAttributeValue("href"));
                                                    writer.flush();
						    break;
                                                }
                                            }

                                        }
                                    }
				    else if (iter1 == 11) {

                                        List<Element> elemsInner3 = el1.getChildElements();
                                        Iterator it3 = elemsInner3.iterator();
                                        Element el3;

                                        while (it3.hasNext()) {

                                            el3 = (Element) it3.next();

                                            String temp3 = el3.getName();


                                            if (temp3 != null) {

                                                if (temp3.equals("i")) {

                                                    writer.println(posts[iter1] + ": " + el3.getContent().toString());
                                                    writer.flush();
						    break;
                                                }
                                            }

                                        }
                                    }
                                

				    if (iter1 < 11) {
					iter1++;
				    } else {
					iter1 = 0; count++;
				    }

				}

                            }
                        }


                    }
                 
                }

            }
	  
	    writer.close();
	} catch (Exception e) {
        }
	 
    }
}