package context;

import enums.ContextKey;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

	private final Map<ContextKey, Object> context = new HashMap<>();

	public void set(ContextKey key, Object value) {
		context.put(key, value);
	}
	@SuppressWarnings("unchecked")
	public <T> T get(ContextKey key) {

		return (T) context.get(key);
	}
	public boolean contains(ContextKey key) {

		return context.containsKey(key);

	}
	public void remove(ContextKey key) {

		context.remove(key);
	}
	public void clear() {

		context.clear();
	}
}