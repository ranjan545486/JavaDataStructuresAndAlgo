package tryingsomething.TRies;

/**
 * Created by rmukherj on 9/19/16.
 */
import java.util.HashMap;
import java.util.Map;

public class ReverseDNSLookup
{
    public void insert(Trie node, String[] ipAdd, String[] urls)
    {
        for(int i=0;i<ipAdd.length;i++)
            this.insertUtil(node, ipAdd[i], urls[i], 0);
    }

    public void insertUtil(Trie node, String ipAddr, String url, int pos)
    {
        Trie temp = null;
        if(node.child.containsKey(ipAddr.charAt(pos)))
        {
            temp = node.child.get(ipAddr.charAt(pos));
        }
        else
        {
            temp = new Trie();
            node.child.put(ipAddr.charAt(pos), temp);
        }
        if(pos==ipAddr.length()-1)
        {
            temp.url = url;
            return;
        }
        this.insertUtil(temp, ipAddr, url, pos+1);
    }

    public String search(Trie node, String ipAddr, int pos)
    {
        Trie temp = null;
        if(pos==ipAddr.length()-1)
        {
            temp = node.child.get(ipAddr.charAt(pos));
            if(temp!=null)
                return temp.url;
        }
        if(node.child.containsKey(ipAddr.charAt(pos)))
        {
            temp = node.child.get(ipAddr.charAt(pos));
            return this.search(temp, ipAddr, pos+1);
        }
        return "No url associated/Invalid IP address";
    }

    public static void main(String []args)
    {
        ReverseDNSLookup r = new ReverseDNSLookup();
        String[] ipAdd = {"107.108.11.123", "107.109.123.255", "74.125.200.106"};
        String[] urls = {"www.samsung.com", "www.samsung.net", "www.google.in"};

        Trie root = new Trie();
        r.insert(root, ipAdd, urls);
        //System.out.println(root);
        System.out.println("74.125.200.106 : "+ r.search(root, "74.125.200.106", 0));
        System.out.println("107.109.123.245 : "+ r.search(root, "107.109.123.245", 0));
    }
}

class Trie
{
    Map<Character, Trie> child;
    String url;

    Trie()
    {
        this.child = new HashMap<>();
    }

    public String toString()
    {
        return child.toString()+" : "+url;
    }
}
