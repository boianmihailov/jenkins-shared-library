#!/usr/bin/env groovy

def call(String buildResult, tokenID, baseUrl) {
  if ( buildResult == "SUCCESS" ) {
    slackSend color: "good", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was successful", baseUrl: baseUrl, tokenCredentialId: tokenID
  }
  else if( buildResult == "FAILURE" ) { 
    slackSend color: "danger", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was failed", baseUrl: baseUrl, tokenCredentialId: tokenID
  }
  else if( buildResult == "UNSTABLE" ) { 
    slackSend color: "warning", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was unstable", baseUrl: baseUrl, tokenCredentialId: tokenID
  }
  else {
    slackSend color: "danger", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} its resulat was unclear", baseUrl: baseUrl, tokenCredentialId: tokenID
  }
}
