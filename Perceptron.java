/*
********************************************************************
LINEAR PERCEPTRON by VISHNU NATH
********************************************************************

This is the Java implementation of the standard linear perceptron. All necessary functions to successfully implement a linear 
perceptron have been provided below.

The main function is not provided here and is left to the user to implement as needed. 
The general method of using a Perceptron is as follows:

1) Provide a list of training files to the perceptron so that it can adjust its weight vector.
   Note: The files need to be labelled since the perceptron follows the supervised learning method.
2)Give the perceptron unknown files for it to classify.

The data that needs to be classified can be anything. To classify numbers or letters, I recommend the MNIST database. For anything else,
you will have to provide the training data on your own and run the perceptron on it. 

Also note that I am not to be held responsible for any results that you obtain as a result of using this code. 
This code is provided on an as-is basis, and the author makes no claims about the results that you may obtain.

Good luck with your work! :)


*/

import java.util.Random;
import java.util.Arrays;

public class Perceptron{

	public int percep_w; 
	public double learning_rate;
	public double Ws[];
	public int arrayOfXs[];
	
  public Perceptron(int num_features, double learning_rate) {

	  Ws = new double[num_features + 1]; 
	  this.learning_rate = learning_rate; 
	  arrayOfXs = new int[num_features+1];  
	  for(int i=0;i<num_features;++i){
			Ws[i]=0;
	  }
	  percep_w = 0;
	 //see train()
  }
//Helper function to compute the dot product
  public double dotProduct(double w[], int x[]){
	  	  double dotProduct = 0;
		  for(int i=0;i<w.length;++i){
			  dotProduct = dotProduct + (w[i]*(double)x[i]);
		  }
		  return dotProduct;
  }
  
  public void transfer(int[] example)
  {
  	for(int i=0;i<example.length;++i){
  	arrayOfXs[i] = example[i];
  	}
  	arrayOfXs[arrayOfXs.length - 1] = -1;
  }
  
  public void train(int[] example, int classification) {
	  
	  //this.transfer(example);
		  int err = classification - this.classify(example); //err = t - 0
	double delta_w = 0;	
 for (int i=0;i<arrayOfXs.length;i++){
		  
		  delta_w = learning_rate * (double) err * (double) arrayOfXs[i]; //d_Wi = n(err)Xi
		 //System.out.println(delta_w); 
		  Ws[i] = Ws[i] + delta_w; //Wi <- Wi + d_Wi, update equation
	  }
	  
	
}
	
  public int classify(int[] example) {
this.transfer(example);	
	
	double dotproduct = this.dotProduct(Ws,arrayOfXs);
	if(dotproduct > 0)
		return 1;
	else
	    return 0;
  }

}


