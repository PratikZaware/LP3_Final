
//time o(nlon)
// space o(n)


import java.util.*;


class CustomComparator implements Comparator<Node>
{
	@Override
	public int compare(Node n1,Node n2)
	{
		if(n1.freq<=n2.freq)
		{
			return -1;
		}
		return 1;
	}
}

class Node
{
	char data;
	int freq;
	Node lnode;
	Node rnode;

	Node(char c,int f)
	{
		data=c;
		freq=f;
	}

	public void traverse(ArrayList<Character>code)
	{
		if(lnode!=null)
		{
			code.add('0');
			lnode.traverse(code);
			code.remove(code.size()-1);

			code.add('1');
			rnode.traverse(code);
			code.remove(code.size()-1);
		}
		else
		{
			System.out.println(data+" "+freq+" "+code);
		}
	}
}

class Assignment2Practice1
{
	public static void main(String[] args) 
	{
		String s="Pratikzaware";
		huffman_encode(s);
	}

	public static void huffman_encode(String s)
	{
		HashMap<Character,Integer>freq=new HashMap<Character,Integer>();

		for(int i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			if(freq.containsKey(c))
			{
				freq.put(c,freq.get(c)+1);
			}
			else
			{
				freq.put(c,1);
			}
		}

		PriorityQueue<Node>pq=new PriorityQueue<Node>(new CustomComparator());


		for(char c:freq.keySet())
		{
			pq.add(new Node(c,freq.get(c)));
		}

		while(pq.size()>1)
		{
			Node leftn=pq.poll();
			Node rightn=pq.poll();
			Node parent=new Node(' ',leftn.freq+rightn.freq);
			parent.lnode=leftn;
			parent.rnode=rightn;
			pq.add(parent);
		}

		pq.poll().traverse(new ArrayList<Character>());
	}
}