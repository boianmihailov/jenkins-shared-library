#!/usr/bin/env groovy

def call(String buildResult, String tokenID, String baseUrl, String channel) {
  if ( buildResult == "SUCCESS" ) {
    slackSend color: "good", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was successful", baseUrl: baseUrl, tokenCredentialId: tokenID, channel: channel
  }
  else if( buildResult == "FAILURE" ) { 
    slackSend color: "danger", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was failed", baseUrl: baseUrl, tokenCredentialId: tokenID, channel: channel
  }
  else if( buildResult == "UNSTABLE" ) { 
    slackSend color: "warning", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was unstable", baseUrl: baseUrl, tokenCredentialId: tokenID, channel: channel
  }
  else {
    slackSend color: "danger", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} its resulat was unclear", baseUrl: baseUrl, tokenCredentialId: tokenID, channel: channel
  }
}
