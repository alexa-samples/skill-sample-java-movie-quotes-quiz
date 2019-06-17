/*
      Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 
      Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
      except in compliance with the License. A copy of the License is located at
 
          http://aws.amazon.com/apache2.0/
 
      or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
      the specific language governing permissions and limitations under the License.
 */

package com.amazon.ask.moviequiz.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.impl.IntentRequestHandler;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.moviequiz.utils.Constants;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.moviequiz.utils.SkillUtils.breakDownSentence;
import static com.amazon.ask.moviequiz.utils.SkillUtils.getJsonString;
import static com.amazon.ask.moviequiz.utils.SkillUtils.pickSentence;
import static com.amazon.ask.moviequiz.utils.SkillUtils.supportsAPL;
import static com.amazon.ask.request.Predicates.intentName;

public class MoviesIntentHandler implements IntentRequestHandler {

    @Override
    public boolean canHandle(HandlerInput input, IntentRequest intentRequest) {
        return input.matches(intentName("MovieNameIntent")
                .or(intentName("NextQuoteIntent")));
    }

    @Override
    public Optional<Response> handle(HandlerInput input, IntentRequest intentRequest) {
        String currentMovie;
        String speechText;
        final Map<String, Object> dataModel = new HashMap<>();
        if (input.matches(intentName("MovieNameIntent"))) {
            currentMovie = intentRequest.getIntent().getSlots().get("movieName").getResolutions().getResolutionsPerAuthority().get(0).getValues().get(0).getValue().getName();
            input.getAttributesManager().getSessionAttributes().put("currentMovie", currentMovie);
            speechText = String.format(Constants.MOVIE_TEST_SPEECH, currentMovie);
        } else {
            speechText = Constants.QUOTE_TEXT_SPEECH;
            currentMovie = (String) input.getAttributesManager().getSessionAttributes().get("currentMovie");
            if (currentMovie == null) {
                dataModel.put("outputSpeech", "Something went wrong. Try saying, Alexa, help!");
                return input.generateTemplateResponse("simplecard_response", dataModel);
            }
        }
        String quote = breakDownSentence(pickSentence(currentMovie), input);
        speechText += quote.replace(Constants.BLANK, Constants.STRONG_BLANK);
        dataModel.put("outputSpeech", speechText);
        dataModel.put("supportsAPL", supportsAPL(input));
        dataModel.put("quoteTitle", quote);
        dataModel.put("backgroundImageRound", Constants.MOVIE_BACKGROUND_IMAGE_ROUND);
        dataModel.put("backgroundImageLandscape", Constants.MOVIE_BACKGROUND_IMAGE_LANDSCAPE);
        dataModel.put("shouldEndSession", false);
        dataModel.put("aplDocument", getJsonString("/quote.json", MoviesIntentHandler.class));
        return input.generateTemplateResponse("movie_response", dataModel);
    }
}