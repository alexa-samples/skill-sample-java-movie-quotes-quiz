{
     "outputSpeech": {
         "type": "SSML",
         "ssml": "<speak>${outputSpeech}</speak>"
     },
     "card": {
         "type": "Simple",
         "title": "Oops!",
         "content": "${outputSpeech}"
     },
     "reprompt": {
          "outputSpeech": {
              "type": "SSML",
              "ssml": "<speak>${outputSpeech}</speak>"
          }
     }
 }