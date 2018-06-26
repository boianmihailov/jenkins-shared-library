#!/usr/bin/env groovy

def call(String buildResult, String tokenID, String slackURL, String targetChannel, String team) {
  echo "sending custom message" 
  echo tokenID
  echo slackURL
  echo targetChannel
  echo "end debug"
  if ( buildResult == "SUCCESS" ) {
    slackSend color: "good", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was successful", baseUrl: slackURL, tokenCredentialId: tokenID, channel: targetChannel, teamDomain: team
  }
  else if( buildResult == "FAILURE" ) { 
    slackSend color: "danger", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was failed", baseUrl: slackURL, tokenCredentialId: tokenID, channel: targetChannel, teamDomain: team
  }
  else if( buildResult == "UNSTABLE" ) { 
    slackSend color: "warning", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was unstable", baseUrl: slackURL, tokenCredentialId: tokenID, channel: targetChannel, teamDomain: team
  }
  else {
    slackSend color: "danger", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} its resulat was unclear", baseUrl: slackURL, tokenCredentialId: tokenID, channel: targetChannel, teamDomain: team
  }
}
