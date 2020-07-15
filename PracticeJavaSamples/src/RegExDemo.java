import java.util.regex.Pattern;


public class RegExDemo {

	public static void main(String[] args) {
		//int count = 0;
		//Pattern P = Pattern.compile("ab");
		//Pattern is compiled version of RE and equivalent java object of RE
		//Matcher m = P.matcher("abbbaababa");
		//Pattern P = Pattern.compile("[^a-z0-9A-Z]"); //replace this with below character classes		
		//Matcher m = P.matcher("a7cB@2#Zt");
		//Pattern P = Pattern.compile("\s"); // this will treated as escape character, so add another '\' to avoid complie time error
		//Pattern P = Pattern.compile("\\S"); // replace this with below mentioned pre-defined character classes.
		//Matcher m = P.matcher("a7c B@2 #Zt");
		//Pattern P = Pattern.compile("a*");
		//Matcher m = P.matcher("abaabaaab");
		Pattern P = Pattern.compile("[.]"); // also we can use ("\\.")
		String[] s = P.split("Sagarsoft.Inida.Limited"); // except '.' o/p we get
		
		for(String s1:s)
		{
			//count++;
			//System.out.println(m.start()+"...."+m.end()+"...."+m.group());
			//System.out.println(m.start()+"......."+m.group());
			System.out.println(s1);
		}
		//System.out.println("Occurance is : " + count);

	}

}
/* Matcher -- we can use matcher object to match the given pattern in the target string.
 matcher method is present in pattern class
we can create Matcher object by usgin matcher() method

Important methods of Matcher :
1) boolena find()
2) int start()
3) int end()   -- returnd end+1 index
4) string group()

character classes:

[abc] = either a,b,c
[^abc] = except a,b,c
[a-z] = any lower from a to z
[A-Z] = any UPPER from A to Z
[a-zA-Z] = any lower and UPPER from a-z
[0-9] = any digit from 0-9
[a-zA-Z0-9]= any alpha numeric characters
[^a-zA-Z0-9] = except alpha numeric i.e special characters
 
 
pre-defined characters classes:

\s = space character
\S = except space character, any character
\d = any digit from [0-9]
\D = except digits any characters
\w = any word character [a-zA-Z]
\W = except word character i.e special characters
. = any character i.e alpha numeric or special characters

Quantifiers: 
	we can use to specify number of occurences 
	
a+ = searching for atleast one 'a'
a* = any number of a's including zero number also.
a? = Atmost one 'a'


phone nuber: start num is 7 or 8 or 9 

[7-9][0-9]{9}   or [789][0-9]{9}
0?[0-9]{9}
(0|91)?[0-9]{9}

Gmail:
rajesh.kondapi123@gmail.com

[a-zA-Z0-9][a-zA0-9_.]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+
	|
first character

only sagarsoft mail:
[a-zA-Z0-9][a-zA-Z0-9_.]*@sagarsoft[.]in
*/