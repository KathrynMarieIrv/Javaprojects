package Structure;

import collection.MyArrayList;

/**
 * My Set Class
 * 
 * @author KathrynIrving
 * @version 3.28.2023_1112
 */
public class MySet implements Cloneable {

	private MyArrayList setContainer;

	/** Default constructor */
	public MySet() {
		setContainer = new MyArrayList();
	}

	/**
	 * Defines Cardinality
	 * 
	 * @return the number of elements in the set
	 */
	public int cardinality() {
		return setContainer.size();
	}

	/**
	 * Find elements in container
	 * 
	 * @param element
	 * @return element contained in setContainer
	 */
	public boolean contains(Object element) {
		return setContainer.contains(element);
	}

	/**
	 * Creates a new set to complement set B
	 * 
	 * @param B
	 * @return a new set - this set B
	 */
	public MySet complement(MySet B) {
		MySet C = new MySet();
		for (int i = 0; i < this.cardinality(); ++i) {
			if (!B.contains(this.setContainer.elementAt(i)))
				C.add(this.setContainer.elementAt(i));
		}
		return C;
	}

	/**
	 * adds a new element to this set - excludes duplicates
	 * 
	 * @param element
	 */
	public void add(Object element) {
		if (setContainer.contains(element) == false) {
			setContainer.append(element);
		}
	}

	/**
	 * Creates an intersection between two sets
	 * 
	 * @param B
	 * @return a new set = this set ∩ B
	 */
	public MySet intersection(MySet B) {
		MySet C = new MySet();
		for (int i = 0; i < cardinality(); ++i) {
			Object currentNum = this.setContainer.elementAt(i);
			if (B.contains(currentNum)) {
				C.add(currentNum);
			}
		}
		return C;

	}

	/**
	 * check if this set is a subset of set B
	 * 
	 * @return false if it is not a subset, true
	 */
	public boolean subsetOf(MySet B) {
		for (int i = 0; i < this.cardinality(); ++i) {
			if (B.contains(this.setContainer.elementAt(i)))
				return false;
		}
		return true;
	}

	/**
	 * Creates a symmetric difference between two sets
	 * 
	 * @param B
	 * @return a new set = (this set – B) U (B – this set)
	 */
	public MySet symmetricDifference(MySet B) throws CloneNotSupportedException {
		MySet C = this.complement(B);
		MySet D = B.complement(this);
		C.union(D);
		return C;
	}

	/**
	 * Creates a union between two sets
	 * 
	 * @param B
	 * @return a new set = this set U B
	 */
	public MySet union(MySet B) throws CloneNotSupportedException {
		MySet E = (MySet) B.clone();
		for (int i = 0; i < this.cardinality(); i++) {
			E.add(this.setContainer.elementAt(i));
		}
		return E;
	}

	/**
	 * toString to override MyArrayList toString
	 */
	public String toString() {
		return setContainer.toString();
	}

}