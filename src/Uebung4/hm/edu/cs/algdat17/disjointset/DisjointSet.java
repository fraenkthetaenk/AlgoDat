package Uebung4.hm.edu.cs.algdat17.disjointset;

import java.util.ArrayList;


public class DisjointSet {	
	
	ArrayList<ArrayList<Integer>> myList;
	
	
	/**
	 * Erzeugt eine Disjoint-Set Datenstruktur für die Zahlen 0 bis size-1.
	 * 
	 * @param size
	 *            Größe der Datenstruktur.
	 */
	public DisjointSet(int size) {
		myList= new ArrayList<ArrayList<Integer>>();
		for(int i =0; i<size; i++)
		{
			ArrayList<Integer> toAdd =  new ArrayList<Integer>();
			toAdd.add(i);
			myList.add(toAdd);
		}
	}

	/**
	 * Liefert zur Zahl a die kleinste Zahl, die in derselben Gruppe ist wie a
	 * 
	 * @param a
	 *            Eingabe
	 * @return Kleinste Zahl (Repräsentant) in der Gruppe von a.
	 */
	public int find(int a) {
		// TODO Aufgabe 1
		
		for (ArrayList<Integer> arrayList : myList) {
			if(arrayList.contains(a))
			{
				int smallest = arrayList.get(0);
				for (Integer integer : arrayList) {
					if(smallest > integer)
					{
						smallest = integer;
					}
				}
				return smallest;
			}
		}
		return -1;
	}

	/**
	 * Verschmilzt die Gruppen von a und b
	 * @param a verwaltete Zahl
	 * @param b verwaltete Zahl
	 */
	public void union(int a, int b) {
		ArrayList<Integer> one = null;
		ArrayList<Integer> two = null;
		
		for (ArrayList<Integer> arrayList : myList) {
			if(arrayList.contains(a))
			{
				one=arrayList;
			}
			if(arrayList.contains(b))
			{
				two=arrayList;
			}
		}
		
		if(!one.equals(two))
		{
			one.addAll(two);
			myList.remove(two);
		}
	}

}
