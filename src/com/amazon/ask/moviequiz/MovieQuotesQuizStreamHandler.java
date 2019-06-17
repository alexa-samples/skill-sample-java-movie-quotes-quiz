/*
      Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 
      Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
      except in compliance with the License. A copy of the License is located at
 
          http://aws.amazon.com/apache2.0/
 
      or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
      the specific language governing permissions and limitations under the License.
 */

package com.amazon.ask.moviequiz;

import com.amazon.ask.Skill;
import com.amazon.ask.Skills;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.moviequiz.handlers.MoviesIntentHandler;
import com.amazon.ask.moviequiz.handlers.AnswerIntentHandler;
import com.amazon.ask.moviequiz.handlers.CancelandStopIntentHandler;
import com.amazon.ask.moviequiz.handlers.ErrorHandler;
import com.amazon.ask.moviequiz.handlers.HelpIntentHandler;
import com.amazon.ask.moviequiz.handlers.SessionEndedHandler;
import com.amazon.ask.moviequiz.handlers.LaunchHandler;
import com.amazon.ask.moviequiz.handlers.YesIntentHandler;

public class MovieQuotesQuizStreamHandler extends SkillStreamHandler {

    private static Skill getSkill() {
        return Skills.standard()
                .withTemplateDirectoryPath(".")
                .addRequestHandlers(
                        new LaunchHandler(),
                        new YesIntentHandler(),
                        new MoviesIntentHandler(),
                        new AnswerIntentHandler(),
                        new HelpIntentHandler(),
                        new CancelandStopIntentHandler(),
                        new SessionEndedHandler())
                .addExceptionHandlers(new ErrorHandler())
                // Add your skill id below
                .withSkillId("")
                .build();
    }

    public MovieQuotesQuizStreamHandler() {
        super(getSkill());
    }
}