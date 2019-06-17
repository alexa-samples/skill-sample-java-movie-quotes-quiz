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
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.moviequiz.utils.Constants;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.moviequiz.utils.SkillUtils.getJsonString;
import static com.amazon.ask.moviequiz.utils.SkillUtils.supportsAPL;
import static com.amazon.ask.request.Predicates.intentName;

public class CancelandStopIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AMAZON.StopIntent").or(intentName("AMAZON.CancelIntent")));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("outputSpeech", Constants.CANCEL_SPEECH);
        dataModel.put("supportsAPL", supportsAPL(input));
        dataModel.put("aplDocument", getJsonString("/mainscreen.json", CancelandStopIntentHandler.class));
        dataModel.put("aplDataTitle", Constants.CANCEL_SPEECH);
        dataModel.put("shouldEndSession", true);
        input.getAttributesManager().getSessionAttributes().clear();
        return input.generateTemplateResponse("apl_data_title_response", dataModel);
    }
}