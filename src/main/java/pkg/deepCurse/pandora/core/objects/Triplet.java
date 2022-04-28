package pkg.deepCurse.pandora.core.objects;

public class Triplet<T,R,V> extends Pair<T,R> {
	
	V v;
	
	public Triplet(T t, R r, V v) {
		super(t, r);
		this.v = v;
	}
	
	public V getThird() {
		return this.v;
	}
	
}
