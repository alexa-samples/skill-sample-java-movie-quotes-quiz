{
     "outputSpeech": {
         "type": "SSML",
         "ssml": "<speak>${outputSpeech}</speak>"
     }
     <#if supportsAPL>
        ,"directives": [
             {
                 "type": "Alexa.Presentation.APL.RenderDocument",
                 "document": ${aplDocument},
                 "datasources": {
                     "movieQuoteQuizData": {
                         "type": "object",
                         "properties": {
                             "title": "${aplDataTitle}"
                         }
                     }
                 }
             }
        ]
     </#if>
     <#if !shouldEndSession>
         ,"reprompt": {
             "outputSpeech": {
                 "type": "SSML",
                 "ssml": "<speak>${outputSpeech}</speak>"
             }
         },
         "shouldEndSession": ${shouldEndSession?c}
     </#if>
 }