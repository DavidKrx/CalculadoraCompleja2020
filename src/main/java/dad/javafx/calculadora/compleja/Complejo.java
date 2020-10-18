package dad.javafx.calculadora.compleja;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

	public class Complejo {

		private DoubleProperty real = new SimpleDoubleProperty();
		private DoubleProperty imaginario = new SimpleDoubleProperty();
		
		
		public Complejo() {
			
		}
		
		public Complejo(double real, double imaginario) {
			super();
			setReal(real);
			setImaginario(imaginario);
		}

		public final DoubleProperty realProperty() {
			return this.real;
		}

		public final double getReal() {
			return this.realProperty().get();
		}

		public final void setReal(final double real) {
			this.realProperty().set(real);
		}

		public final DoubleProperty imaginarioProperty() {
			return this.imaginario;
		}

		public final double getImaginario() {
			return this.imaginarioProperty().get();
		}

		public final void setImaginario(final double imaginario) {
			this.imaginarioProperty().set(imaginario);
		}
		
		
		public DoubleBinding add(Complejo h) {
			
			return realProperty().add(h.realProperty());
			
		}
		public DoubleBinding addimg(Complejo h) {
			
			return imaginarioProperty().add(h.imaginarioProperty());
			
		}
		
		public DoubleBinding sub(Complejo h) {
			return realProperty().subtract(h.realProperty());
		}
		
		public DoubleBinding subimg(Complejo h) {
			return imaginarioProperty().subtract(h.imaginarioProperty());
			
		}
		
		public DoubleBinding divi(Complejo h) {
			return realProperty().divide(h.realProperty());
		}
		
		public DoubleBinding diviimg(Complejo h) {
			return imaginarioProperty().divide(h.imaginarioProperty());
		}
		
		
		public DoubleBinding multi(Complejo h) {
			return realProperty().multiply(h.realProperty());
			
			
		}
		
		public DoubleBinding multiimg(Complejo h) {
			return imaginarioProperty().multiply(h.imaginarioProperty());
			
		}
		
	}

