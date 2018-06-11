package stack;

public class Application {

	public static <E> void reverse(E[] a) {
	Stack<E> buffer = new LinkedStack<>();
	for(int i=0; i<a.length;i++) {
		buffer.push(a[i]);
	}
	for(int i=0;i<a.length;i++) {
		a[i] = buffer.pop();
	}
    }  
	public static  boolean isMatched(String s) {
		char[] ar = s.toCharArray();
		Stack<Character> list = new LinkedStack<>();
		for(int i =0; i<ar.length;i++) {
			if(ar[i] == '('||ar[i]=='{'||ar[i]=='[') {
				list.push(ar[i]);
			}
			if(ar[i] == ')') {
				if(list.pop()!='(')
					return false;
			}
			if(ar[i] == '}') {
				if(list.pop()!='{') 
					return false;
			}
			if(ar[i] == ']') {
				if(list.pop()!='[')
					return false;
			}
		}
		return list.isEmpty();
	}
	public static boolean isXMLMatched(String s) {
		Stack<String> list = new LinkedStack<>();
		int j = s.indexOf('<');
		while(j!=-1) {
			int k = s.indexOf('>',j+1);
			if(k==-1) {
				return false;
			}
			String tag = s.substring(j+1, k);
			if(!tag.startsWith("!"))
				list.push(tag);
			else if(list.isEmpty())
				return false;
			if(!tag.substring(1).equals(list.pop())) {
				return false;
			}
			j = s.indexOf('<',k+1);
			
		}
		return list.isEmpty();
	}
    
}