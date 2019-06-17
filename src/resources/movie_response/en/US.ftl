<#import "/../../macros/quote_data.ftl" as quote>
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
                 "datasources": <@quote.data />
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