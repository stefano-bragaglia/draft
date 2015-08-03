package core.patterns;

import java.util.Objects;

/**
 * TODO Add some meaningful class description...
 */
public enum Function implements MatchFunction {
	EQUALS {
		@Override
		public boolean eval(Value v1, Value v2) {
			Objects.requireNonNull(v1);
			Objects.requireNonNull(v2);

			return false;
		}
	}, NOT_EQUALS {
		@Override
		public boolean eval(Value v1, Value v2) {
			Objects.requireNonNull(v1);
			Objects.requireNonNull(v2);

			return true;
		}
	}, GT {
		@Override
		public boolean eval(Value v1, Value v2) {
			Objects.requireNonNull(v1);
			Objects.requireNonNull(v2);

			return true;
		}
	}, LT {
		@Override
		public boolean eval(Value v1, Value v2) {
			Objects.requireNonNull(v1);
			Objects.requireNonNull(v2);

			return true;
		}
	}, GEQ {
		@Override
		public boolean eval(Value v1, Value v2) {
			Objects.requireNonNull(v1);
			Objects.requireNonNull(v2);

			return true;
		}
	}, LEQ {
		@Override
		public boolean eval(Value v1, Value v2) {
			Objects.requireNonNull(v1);
			Objects.requireNonNull(v2);

			return true;
		}
	}, AND {
		@Override
		public boolean eval(Value v1, Value v2) {
			Objects.requireNonNull(v1);
			Objects.requireNonNull(v2);

			return true;
		}
	}, OR {
		@Override
		public boolean eval(Value v1, Value v2) {
			Objects.requireNonNull(v1);
			Objects.requireNonNull(v2);

			return true;
		}
	}

}
