package pkg.deepCurse.pandora.core.objects;

public class Pair<T, R> {
	T t;
	R r;

	public Pair(T t, R r) {
		this.t = t;
		this.r = r;
	}

	public T getFirst() {
		return t;
	}

	public R getSecond() {
		return r;
	}
}