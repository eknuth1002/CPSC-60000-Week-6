package com.elliotknuth;

public enum FiringSpeed {
	FAST {
		@Override
		public String toString() {
			return "fast";
		}
	},
	SLOW {
		@Override
		public String toString() {
			return "slow";
		}
	}
}
