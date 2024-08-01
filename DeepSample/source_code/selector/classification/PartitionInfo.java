package selector.classification;

import java.util.ArrayList;
import utility.TestCase;

public class PartitionInfo {
	private String name;
	private String partitionID;
	private double expectedOccurrenceProbability;
	private double realOccurrenceProbability;
	private double expectedFailureLikelihood;
	private ArrayList<TestCase> listOfTests;
	private int numberOfTestCases;

	public PartitionInfo(String name, String partitionID) {
		this.name = name;
		this.partitionID = partitionID;
		this.listOfTests = new ArrayList<>();
	}

	public void addTestCase(TestCase t) {
		listOfTests.add(t);
	}

	public void compute_expectedOccurrenceProbability() {
		expectedOccurrenceProbability = 0;
		for (int i = 0; i < listOfTests.size(); i++) {
			expectedOccurrenceProbability += listOfTests.get(i).getExpectedOccurrenceProbability();
		}
	}

	public void compute_expectedFailureLikelihood() {
		expectedFailureLikelihood = 0;
		for (int i = 0; i < listOfTests.size(); i++) {
			expectedFailureLikelihood += listOfTests.get(i).getExpectedFailureLikelihood();
		}
	}

	public void compute_expectedOccAndFail() {
		expectedOccurrenceProbability = 0;
		expectedFailureLikelihood = 0;
		for (int i = 0; i < listOfTests.size(); i++) {
			expectedOccurrenceProbability += listOfTests.get(i).getExpectedOccurrenceProbability();
			expectedFailureLikelihood += listOfTests.get(i).getExpectedFailureLikelihood();
		}
		expectedFailureLikelihood = expectedFailureLikelihood / (double) listOfTests.size();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPartitionID() {
		return partitionID;
	}

	public void setPartitionID(String partitionID) {
		this.partitionID = partitionID;
	}

	public double getExpectedOccurrenceProbability() {
		return expectedOccurrenceProbability;
	}

	public void setExpectedOccurrenceProbability(double expectedOccurrenceProbability) {
		this.expectedOccurrenceProbability = expectedOccurrenceProbability;
	}

	public double getRealOccurrenceProbability() {
		return realOccurrenceProbability;
	}

	public void setRealOccurrenceProbability(double realOccurrenceProbability) {
		this.realOccurrenceProbability = realOccurrenceProbability;
	}

	public double getExpectedFailureLikelihood() {
		return expectedFailureLikelihood;
	}

	public void setExpectedFailureLikelihood(double expectedFailureLikelihood) {
		this.expectedFailureLikelihood = expectedFailureLikelihood;
	}

	public ArrayList<TestCase> getListOfTests() {
		return listOfTests;
	}

	public void setListOfTests(ArrayList<TestCase> listOfTests) {
		this.listOfTests = listOfTests;
	}

	public int getNumberOfTestCases() {
		return numberOfTestCases;
	}

	public int getNumberOfTestCases_compute() {
		return listOfTests.size();
	}

	public void setNumberOfTestCases(int numberOfTestCases) {
		this.numberOfTestCases = numberOfTestCases;
	}
}