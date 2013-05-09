package Exercise10;

import java.util.*;

public class Polynomial {

	private static Map<Integer, Double> outcome;

	/*****************************************************************
	 * Polynomial Addition
	 *****************************************************************/
	public static Map<Integer, Double> addition(
			List<Map<Integer, Double>> polynomials) {
		Map<Integer, Double> sum = new TreeMap<Integer, Double>();
		for(Map<Integer, Double> map : polynomials)
		{
			for(Object key : map.keySet().toArray())
			{
				if (sum.keySet().contains(key))
					sum.put((Integer) key, sum.get(key) + map.get(key));
				else
					sum.put((Integer)key, map.get(key));
			}
		}
		return sum;
	}

	/*****************************************************************
	 * Polynomial Multiplication
	 *****************************************************************/
	public static Map<Integer, Double> multiplication(
			List<Map<Integer, Double>> polynomials) {
		outcome = new TreeMap<Integer, Double>();
		recursivePolMult(polynomials, 0, 1, 0);
		return outcome;
	}

	/*****************************************************************
	 * Recursive method for Polynomial Multiplication
	 *****************************************************************/
	private static void recursivePolMult(
			List<Map<Integer, Double>> polynomials, int indexOfNextPolynomial,
			double curr_coeff, int curr_power) {

		Iterator<Map<Integer, Double>> polynomial_it = polynomials
				.listIterator(indexOfNextPolynomial);
		if (!polynomial_it.hasNext()) {
			Double current_value = outcome.get(curr_power);
			outcome.put(curr_power, (current_value == null) ? curr_coeff
					: current_value + curr_coeff);
			return;
		} else {
			Map<Integer, Double> polynomial = polynomial_it.next();
			Iterator<Map.Entry<Integer, Double>> coeff_it = polynomial
					.entrySet().iterator();
			while (coeff_it.hasNext()) {
				double tmp_coeff = curr_coeff;
				int tmp_power = curr_power;
				Map.Entry<Integer, Double> pairs = coeff_it.next();
				tmp_coeff *= pairs.getValue().doubleValue();
				tmp_power += pairs.getKey().intValue();
				recursivePolMult(polynomials, indexOfNextPolynomial + 1,
						tmp_coeff, tmp_power);
			}
		}

	} // multiplication

	public static String toString(Map<Integer, Double> polynomial) {
		StringBuilder sb = new StringBuilder();
		Iterator<Map.Entry<Integer, Double>> it = polynomial.entrySet()
				.iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, Double> pairs = it.next();

			// sign of the coefficient or constant
			if (pairs.getValue().doubleValue() == 0.0)
				continue;
			else if (pairs.getValue().doubleValue() > 0.0) {
				sb.append("+");
			} // if
			else
				sb.append("-");

			// constant
			if (pairs.getKey().intValue() == 0) {
				sb.append(Math.abs(pairs.getValue()) + "\t");
			} // if
			else {
				// coefficient
				if (Math.abs(pairs.getValue().doubleValue()) != 1.0) {
					sb.append(Math.abs(pairs.getValue()));
				}

				// x with its power
				if (pairs.getKey().intValue() == 1) {
					sb.append("x" + "\t");
				} // if
				else {
					sb.append("x^" + pairs.getKey() + "\t");
				} // else
			} // else
		} // while
		return sb.toString();
	} // toString

	public static void main(String[] args) {
		List<Map<Integer, Double>> all_polynomials = new LinkedList<Map<Integer, Double>>();
		// key: power of x, value: coefficient
		Map<Integer, Double> pol1 = new TreeMap<Integer, Double>();
		Map<Integer, Double> pol2 = new TreeMap<Integer, Double>();
		Map<Integer, Double> pol3 = new TreeMap<Integer, Double>();

		// first polynomial
		pol1.put(2, 1.0);
		pol1.put(0, -1.0);
		System.out.println(toString(pol1));
		all_polynomials.add(pol1);

		// second polynomial
		pol2.put(1, 1.0);
		pol2.put(0, 1.0);
		System.out.println(toString(pol2));
		all_polynomials.add(pol2);

		// third polynomial
		pol3.put(1, 1.0);
		pol3.put(0, -1.0);
		System.out.println(toString(pol3));
		all_polynomials.add(pol3);

		System.out.println("==============================");
		System.out.println("Multip.:\t"
				+ toString(multiplication(all_polynomials)));
		System.out.println("sum:\t" + toString(addition(all_polynomials)));
	}
}
