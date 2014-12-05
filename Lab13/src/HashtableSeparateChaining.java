//Valencia, Myles, Ben

import java.util.ArrayList;

public class HashtableSeparateChaining<K, V> implements OurHashtable<K, V> {

	private static final int defaultNumberOfBuckets = 20;
	private int numberOfBuckets;
	private int count;
	private ArrayList[] hashTable;



	public HashtableSeparateChaining() {
		this.numberOfBuckets = defaultNumberOfBuckets;
		this.setup();
	}

	public HashtableSeparateChaining(int numberOfBuckets) {
		this.numberOfBuckets = numberOfBuckets;
		this.setup();
	}

	private void setup() {
		hashTable = new ArrayList[numberOfBuckets];
		count = 0;
		for (int i = 0; i < numberOfBuckets; i++) {
			hashTable[i] = new ArrayList<KVPair>();
		}
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public void put(K key, V value) {
		ArrayList<KVPair<K,V>> Bucket = hashTable[key.hashCode()% numberOfBuckets];
		Bucket.add(new KVPair(key, value));
		count++;
	}

	@Override
	public V get(K key) {
		ArrayList<KVPair<K,V>> Bucket = hashTable[key.hashCode()% numberOfBuckets];
		for (int i = 0; i < Bucket.size(); i++) {
			if (Bucket.get(i).key.equals(key)) {
				return Bucket.get(i).value;
			}
		}
		return null;
	}

	@Override
	public void clear() {
		setup();
	}

}