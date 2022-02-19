package flames;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/flame")
public class flame extends HttpServlet{
	static char fl[] = {'F','L','A','M','E','S'};
	static int n = 6;
	static char chx(String m, String f) {
		
		
		
		HashMap<Character,Integer> n1 = new LinkedHashMap<>();
		HashMap<Character,Integer> n2 = new LinkedHashMap<>();
		
		for(int i= 0 ; i < m.length() ; i++){
		    if(n1.containsKey(m.charAt(i))){
		        n1.put(m.charAt(i), n1.get(m.charAt(i))+1);
		    }
		    else{
		        n1.put(m.charAt(i), 1);
		    }
		}
		
		for(int i= 0 ; i < f.length() ; i++){
		    if(n2.containsKey(f.charAt(i))){
		        n2.put(f.charAt(i), n2.get(f.charAt(i))+1);
		    }
		    else{
		        n2.put(f.charAt(i),1);
		    }
		}
		
		int sum=0;
    
		for(char c : n1.keySet()){
            if(n2.get(c) == null){
                sum += n1.get(c);
            }
            else{
                  int m1 = n1.get(c);
                  int m2 = n2.get(c);
                  if(m1 > m2){
                      sum += m1 - m2;
                  }
                  else{
                      sum += m2 - m1;
                  }
            }
        }
      
		for(char c : n2.keySet()){
            if(n1.get(c) == null){
                sum += n2.get(c);
            }
		}
		
		char ans = calculate(sum);
		
		
		return (ans);
		
		
	}
	
	
	static char calculate(int n) {
		
		String str = "flames";
		int i , j, r = 0;
		while(str.length() != 1)	{
			for(i = 0, j = r; i < n; i++, j++) {
				if(j > str.length()-1) {
					j = 0;
				}
				
			}
			r = j-1; 
			str = del(str, j);
		} 
		char k = str.charAt(0);
		return k;
		
	}
	static String del(String str, int n) {
		if(n == 0) {
			return (str.substring(1,str.length()));
		}
		str = str.substring(0,n-1) + str.substring(n,str.length());
		return str;
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		PrintWriter out = res.getWriter();
		String name1 = req.getParameter("name1").toLowerCase();
		String name2 = req.getParameter("name2").toLowerCase();
		int a = name1.length();
		int b = name2.length();
		char k = chx(name1,name2);
		
		if(k == 'f') {
			res.sendRedirect("./f.html");
		}
		else if(k == 'l') {
			res.sendRedirect("./l.html");
		}
		else if(k == 'a') {
			res.sendRedirect("./a.html");
		}
		else if(k == 'm') {
			res.sendRedirect("./m.html");
		}
		else if(k == 'e') {
			res.sendRedirect("./e.html");
		}
		else {
			res.sendRedirect("./s.html");
		}
	}
}