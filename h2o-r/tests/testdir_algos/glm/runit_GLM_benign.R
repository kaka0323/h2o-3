setwd(normalizePath(dirname(R.utils::commandArgs(asValues=TRUE)$"f")))
source("../../../scripts/h2o-r-test-setup.R")



glm2Benign <- function() {

  bhexFV <- h2o.uploadFile(locate("smalldata/logreg/benign.csv"), destination_frame="benignFV.hex")
  maxX <- 11
  Y <- 4
  X   <- 3:maxX
  X   <- X[ X != Y ] 
  
  Log.info("Build the model")
  mFV <- h2o.glm(y = Y, x = colnames(bhexFV)[X],
                 interactions = colnames(bhexFV)[X],
                 training_frame = bhexFV, family = "binomial", alpha = 0, lambda = 1e-5)

}

doTest("GLM: Benign Data", glm2Benign)

