public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
	int totalLength = a.size() + b.size();
	int overallMedian = (totalLength - 1) / 2;

	if (a.size() == 0) {
		if (b.size() == 0) {
			return 0.0;
		} else {
			return totalLength % 2 == 0
					? (b.get(overallMedian) + b.get(overallMedian + 1)) / 2
					: b.get(overallMedian);
		}
	} else if (b.size() == 0) {
		return totalLength % 2 == 0
				? (a.get(overallMedian) + a.get(overallMedian + 1)) / 2
				: a.get(overallMedian);
	}

	int medianIndex = getMedianIndexOfTwoArrays(a, b, totalLength, overallMedian);
	double median;
	if (medianIndex != -1) {
		median = calculateMedian(a, b, totalLength, medianIndex);
	} else {
		medianIndex = getMedianIndexOfTwoArrays(b, a, totalLength, overallMedian);
		median = calculateMedian(b, a, totalLength, medianIndex);
	}
	return median;
}

private double calculateMedian(final List<Integer> A, final List<Integer> B,
							   int totalLength, int medianIndex) {
	if (totalLength % 2 == 0) {
		int secondMedianA = medianIndex + 1 < A.size() ? A.get(medianIndex + 1) : Integer.MAX_VALUE;
		int secondMedianB = medianIndex + 1 < B.size() ? B.get(medianIndex + 1) : Integer.MAX_VALUE;
		return (double) (A.get(medianIndex) + Math.min(secondMedianA, secondMedianB)) / 2;
	}
	return (double) A.get(medianIndex);
}

private int getMedianIndexOfTwoArrays(final List<Integer> A, final List<Integer> B,
									  int totalLength, int overallMedian) {
	int to_right_of_median = totalLength - 1 - overallMedian;
	int low = 0;
	int high = A.size();

	while (low <= high) {
		int guessIndex = (low + high) / 2;
		int to_right_of_guess_in_A = A.size() - 1 - guessIndex;
		int to_right_of_guess_in_B = to_right_of_median - to_right_of_guess_in_A;
		int i_to_right_of_guess_in_b = B.size() - to_right_of_guess_in_B;

		// Two checks:
		// 1) B.get(i_to_right_of_guess_in_b - 1) <= A.get(guessIndex)
		// 2) A.get(guessIndex) <= B.get(i_to_right_of_guess_in_b)
		if (i_to_right_of_guess_in_b <= 0) {
			if (i_to_right_of_guess_in_b == 0 && A.get(guessIndex) <= B.get(0)) {
				return guessIndex;
			} else {
				high = overallMedian - 1;
			}
		} else if (i_to_right_of_guess_in_b  > B.size() - 1) {
			if (i_to_right_of_guess_in_b - 1 == B.size() - 1 &&  B.get(B.size() - 1) <= A.get(guessIndex)) {
				return guessIndex;
			} else {
				low = overallMedian + 1;
			}
		} else if (B.get(i_to_right_of_guess_in_b - 1) <= A.get(guessIndex)) {
			if (A.get(guessIndex) <= B.get(i_to_right_of_guess_in_b)) {
				return guessIndex;
			} else {
				high = overallMedian - 1;
			}
		} else {
			low = overallMedian + 1;
		}
	}

	return -1; // No median found in this array
}

private int getMedianOfTwoArrays(int[] A, int[] B) {
	int totalLength = A.length + B.length;
	int overallMedian = (totalLength - 1) / 2;
	int to_right_of_median = totalLength - 1 - overallMedian;

	int low = 0;
	int high = A.length;

	while (low <= high) {
		int guessIndex = (low + high) / 2;
		int to_right_of_guess_in_A = A.length - 1 - guessIndex;
		int to_right_of_guess_in_B = to_right_of_median - to_right_of_guess_in_A;
		int i_to_right_of_guess_in_b = B.length - to_right_of_guess_in_B;

		// Two checks:
		// 1) B[i_to_right_of_guess_in_b - 1] <= A[guessIndex]
		// 2) A[guessIndex] <= B[i_to_right_of_guess_in_b] 
		if (i_to_right_of_guess_in_b <= 0) {
			if (i_to_right_of_guess_in_b == 0 && A[guessIndex] <= B[0]) {
				return guessIndex;
			} else {
				high = overallMedian - 1;
			}
		} else if (i_to_right_of_guess_in_b  > B.length - 1) {
			if (i_to_right_of_guess_in_b - 1 == B.length - 1 &&  B[B.length - 1] <= A[guessIndex]) {
				return guessIndex;
			} else {
				low = overallMedian + 1;
			}
		} else if (B[i_to_right_of_guess_in_b - 1] <= A[guessIndex]) {
			if (A[guessIndex] <= B[i_to_right_of_guess_in_b]) {
				return guessIndex;
			} else {
				high = overallMedian - 1;
			}
		} else {
			low = overallMedian + 1;
		}
	}

	return -1; // No median found in this array
}