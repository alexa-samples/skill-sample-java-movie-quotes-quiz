/*
      Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 
      Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
      except in compliance with the License. A copy of the License is located at
 
          http://aws.amazon.com/apache2.0/
 
      or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
      the specific language governing permissions and limitations under the License.
 */

package com.amazon.ask.moviequiz.utils;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.exception.AskSdkException;
import com.amazon.ask.model.SupportedInterfaces;
import com.amazon.ask.model.interfaces.alexa.presentation.apl.AlexaPresentationAplInterface;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SkillUtils {

    private static final Random random = new Random();

    public static String getJsonString(String resourcePath, Class c) {
        try (InputStream is = c.getResourceAsStream(resourcePath)) {
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            return new String(bytes, Charset.defaultCharset());
        } catch(IOException e) {
            throw new AskSdkException(String.format("Unable to read data from file at %s", resourcePath));
        }
    }

    public static String getSpeechCon(boolean isAnswerCorrect) {
        return isAnswerCorrect ? String.format(Constants.SPEECH_CONS_SAY_AS, getRandomElement(Constants.SPEECH_CONS_CORRECT)) :
                String.format(Constants.SPEECH_CONS_SAY_AS, getRandomElement(Constants.SPEECH_CONS_WRONG));
    }

    public static String capitalizeFirstLetter(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    public static String pickSentence(String movieName) {
        final String movie = movieName.toLowerCase();
        if (Constants.MOVIE_DATA_MAP.containsKey(movie)) {
            List<String> sentences = Constants.MOVIE_DATA_MAP.get(movie);
            return getRandomElement(sentences);
        }
        throw new AskSdkException("Movie name provided is invalid");
    }

    public static String breakDownSentence(String sentence, HandlerInput handlerInput) {
        final List<String> sentenceList = Arrays.asList(sentence.split(" "));
        final List<String> legalWords = sentenceList.stream()
                .filter(x -> x.length() > 3 && !Constants.BORING_WORDS.contains(x))
                .collect(Collectors.toList());
        final String chosenWord = getRandomElement(legalWords);
        handlerInput.getAttributesManager().getSessionAttributes().put("chosenWord", chosenWord.replaceAll("[^a-zA-Z0-9_-]", "").toLowerCase());
        Collections.replaceAll(sentenceList, chosenWord, Constants.BLANK);
        return String.join(" ", sentenceList);
    }

    public static boolean supportsAPL(HandlerInput input) {
        SupportedInterfaces supportedInterfaces = input.getRequestEnvelope().getContext().getSystem().getDevice().getSupportedInterfaces();
        AlexaPresentationAplInterface alexaPresentationAplInterface = supportedInterfaces.getAlexaPresentationAPL();
        return alexaPresentationAplInterface != null;
    }

    private static String getRandomElement(List<String> words) {
        return words.get(getRandomIndex(words.size()));
    }

    private static int getRandomIndex(int size) {
        return random.nextInt(size);
    }
}