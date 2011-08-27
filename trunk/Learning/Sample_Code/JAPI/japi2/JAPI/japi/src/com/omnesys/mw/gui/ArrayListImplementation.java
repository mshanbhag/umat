package com.omnesys.mw.gui;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Vector;

/**
 * @author Administrator
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class ArrayListImplementation // extends Observable //extends ArrayList
{
	Vector oArList = new Vector(20, 20);

	// Vector oArList = new Vector();
	public void add(Object element)
	{

		oArList.add(0, element);
		// notify();
		// setChanged();
		// notifyObservers();
		// NotifyClient();

	}

	public Object remove(int iIndex)
	{
		oArList.trimToSize();
		return oArList.remove(iIndex);

	}

	public int size()
	{
		return oArList.size();
	}

}