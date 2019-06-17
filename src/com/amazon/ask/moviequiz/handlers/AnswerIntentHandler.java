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
import com.amazon.ask.request.RequestHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.moviequiz.utils.SkillUtils.capitalizeFirstLetter;
import static com.amazon.ask.moviequiz.utils.SkillUtils.getJsonString;
import static com.amazon.ask.moviequiz.utils.SkillUtils.getSpeechCon;
import static com.amazon.ask.moviequiz.utils.SkillUtils.supportsAPL;
import static com.amazon.ask.request.Predicates.intentName;

public class AnswerIntentHandler implements IntentRequestHandler {

    @Override
    public boolean canHandle(HandlerInput input, IntentRequest intentRequest) {
        return input.matches(intentName("AnswerIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input, IntentRequest intentRequest) {
        String quote = "", roundImage = "", landscapeImage = "", speechText;
        final RequestHelper requestHelper = RequestHelper.forHandlerInput(input);
        final String spokenWord = requestHelper.getSlotValue("word").orElse(Constants.EMPTY_STRING);
        String chosenWord = String.valueOf(input.getAttributesManager().getSessionAttributes().get("chosenWord"));
        final Map<String, Object> dataModel = new HashMap<>();
        if (chosenWord == null) {
            speechText = Constants.QUOTE_HELP_SPEECH;
            dataModel.put("outputSpeech", speechText);
            dataModel.put("aplDocument", getJsonString("/mainscreen.json", AnswerIntentHandler.class));
            dataModel.put("aplDataTitle", speechText);
            dataModel.put("shouldEndSession", false);
            return input.generateTemplateResponse("apl_data_title_response", dataModel);
        }
        if(chosenWord.equals(spokenWord)) {
            speechText = getSpeechCon(true);
            quote = String.format(Constants.CORRECT_ANSWER_NEW_QUOTE_SPEECH, capitalizeFirstLetter(chosenWord));
            roundImage = Constants.CORRECT_ANSWER_IMAGE_ROUND;
            landscapeImage = Constants.CORRECT_ANSWER_IMAGE_LANDSCAPE;
        } else {
            speechText = getSpeechCon(false);
            quote = String.format(Constants.WRONG_ANSWER_NEW_QUOTE_SPEECH, chosenWord);
            roundImage = Constants.WRONG_ANSWER_IMAGE_ROUND;
            landscapeImage = Constants.WRONG_ANSWER_IMAGE_LANDSCAPE;
        }
        dataModel.put("shouldEndSession", false);
        dataModel.put("supportsAPL", supportsAPL(input));
        dataModel.put("outputSpeech", speechText + quote);
        dataModel.put("aplDocument", getJsonString("/quote.json", AnswerIntentHandler.class));
        dataModel.put("quoteTitle", quote);
        dataModel.put("backgroundImageRound", roundImage);
        dataModel.put("backgroundImageLandscape", landscapeImage);
        return input.generateTemplateResponse("movie_response", dataModel);
    }
}