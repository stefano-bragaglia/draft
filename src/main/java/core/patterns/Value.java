package core.patterns;

/**
 * TODO Add some meaningful class description...
 */
public class Value {

	private final Class<? extends Object> aClass;

	private final Object value;

	public Value(Object value) {
		this.aClass = null != value ? value.getClass() : null;
		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Value value1 = (Value) o;

		if (aClass != null ? !aClass.equals(value1.aClass) : value1.aClass != null) return false;
		return !(value != null ? !value.equals(value1.value) : value1.value != null);
	}

	public Class<? extends Object> getAClass() {
		return null;
	}

	public Object getValue() {
		return null;
	}

	@Override
	public int hashCode() {
		int result = aClass != null ? aClass.hashCode() : 0;
		result = 31 * result + (value != null ? value.hashCode() : 0);
		return result;
	}

	public boolean isNull() {
		return null == aClass && null == value;
	}

	public boolean match(Object property) {
		if (null == property) {
			return null == aClass && null == value;
		}
		return aClass.isInstance(property) && property.equals(value);
	}

	@Override
	public String toString() {
		return "Value{" + "aClass=" + aClass + ", value=" + value + '}';
	}

}
