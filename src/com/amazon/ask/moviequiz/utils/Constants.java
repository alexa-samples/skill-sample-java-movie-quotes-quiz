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

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Constants {

    public static final String WONDER_WHEEL_NAME = "wonder wheel";

    public static final List<String> WONDER_WHEEL_SENTENCES = Collections.unmodifiableList(Arrays.asList(
            "What a sheltered life I've led. I have book knowledge but you've really tasted life.",
            "Nothing you could tell me could put the slightest shadow on this evening.",
            "The kid makes fires. And not such little ones.",
            "Yeah, but you've been around the block. You think you'll always be looking over your shoulder?",
            "Everybody dies, you can't walk around thinking about it.",
            "You people would never try to hide her, would you?",
            "Let me get to the story in which I am a character, so, be warned, as a poet, I use symbols, and as a budding dramatist, I relish melodrama and larger-than-life characters.",
            "A writer of truly great plays, so I can one day surprise everyone and turn out a profound masterpiece.",
            "I'm Mickey Rubin. Poetic by nature. I harbor dreams of being a writer.",
            "The beach, the boardwalk. Once a luminous jewel, but growing relentlessly seedier as the tides roll in and out.",
            "Is it the eternal power of the universe? The conversion of mass into energy? The Furies at work? Whatever his motive, it is not appreciated."
    ));

    public static final String GRINGO_NAME = "gringo";

    public static final List<String> GRINGO_SENTENCES = Collections.unmodifiableList(Arrays.asList(
            "What kind of a man does not believe in God?",
            "Why do I always get screwed for doing my job?",
            "I know I'm not supposed to touch the mini-bar but I'm going to do it. ",
            "You know, I don't even care anymore, I'm doing it. I'm having the merlot!",
            "One was a man who had a crisis of faith and the other was a man who sold his soul for personal gain. So, you have to decide which one you want to be."
    ));

    public static final String THE_WALL_NAME = "the wall";

    public static final List<String> THE_WALL_SENTENCES = Collections.unmodifiableList(Arrays.asList(
            "You Americans. You think you know it all.",
            "Tear up the planks! Here, here! It is the beating of his hideous heart.",
            "From a place you will not see comes a sound you will not hear.",
            "We got no movement, not a sign of a shadow.",
            "Shakespeare? Is that the only poet you know?",
            "You minor in sniping or something?",
            "American. Tell Tale Heart.",
            "You think it's simple. That I am your enemy. But we are not so different, you and I.",
            "You are the one who has come to another man's country. ",
            "Camouflaged yourself in his land, in his soil. From where I'm sitting, you look very much like the terrorist.",
            "Whoever it was they're gone. War's over, he got the memo.",
            "Just a flash of light. Boom."
    ));

    public static final String LAST_FLAG_FLYING_NAME = "last flag flying";

    public static final List<String> LAST_FLAG_FLYING_SENTENCES = Collections.unmodifiableList(Arrays.asList(
            "Hey, at least we're not drug addicts.",
            "I'm not going to bury a marine. I'm just going to bury my son.",
            "Every generation has their war. Men make the wars and wars make the men. It never ends!",
            "We are going to a funeral. Just looks like it's going to take a little longer to get there.",
            "With all due respect, sir, you're cutting off your nose to spite your face.",
            "I got more time in the chow line than you got in the corps.",
            "Man, I would've loved to run into you in the field in my younger days.",
            "I'd rather be fighting them over there than in our own backyard.",
            "Sal, if you had any more manners, you would be a dog.",
            "You put this somewhere and you let it remind you what was in your son's heart",
            "Urine. I love it. It's like the official scent of the city.",
            "Colonels don't scare me. Never have, never will."
    ));

    public static final String PATERSON_NAME = "paterson";

    public static final List<String> PATERSON_SENTENCES = Collections.unmodifiableList(Arrays.asList(
            "Sometimes an empty page presents more possibilities",
            "You're up late, honey. Your silent magic watch didn't wake you up.",
            "Poetry in translations is like taking a shower with a raincoat on.",
            "Without love what reason is there for anything?",
            "I was dreaming that we were in ancient Persia. And... you were riding on an elephant. A big, silver elephant.",
            "Yeah, I guess if it's for you, it's a love poem. It's kind of inspired by our Ohio Blue Tip Matches.",
            "My guitar should arrive today. My harlequin guitar direct from Esteban.",
            "Do you think there are any other anarchists still around in Paterson?",
            "I always say don't try to change things or you'll make them even worse.",
            "Speaking of secret pie, I wanted to tell you something about your secret notebook."
    ));

    public static final Map<String, List<String>> MOVIE_DATA_MAP = new HashMap<String, List<String>>() {
        {
            put(Constants.WONDER_WHEEL_NAME, Constants.WONDER_WHEEL_SENTENCES);
            put(Constants.GRINGO_NAME, Constants.GRINGO_SENTENCES);
            put(Constants.THE_WALL_NAME, Constants.THE_WALL_SENTENCES);
            put(Constants.LAST_FLAG_FLYING_NAME, Constants.LAST_FLAG_FLYING_SENTENCES);
            put(Constants.PATERSON_NAME, Constants.PATERSON_SENTENCES);
        }
    };

    public static final String WELCOME_MESSAGE = "Welcome to How Well Do You Know, the hottest movie quote quiz game in the world. Are you ready to play?";

    public static final String HELP_MESSAGE = "Name the movie you would like to be tested on, and then say the missing word in the quote!";

    public static final List<String> SPEECH_CONS_CORRECT = Collections.unmodifiableList(Arrays.asList("Booya", "All righty", "Bam", "Bazinga", "Bingo", "Boom", "Bravo", "Cha Ching", "Cheers", "Dynomite", "Hip hip hooray", "Hurrah", "Hurray", "Huzzah", "Oh dear. Just kidding. Hurray", "Kaboom", "Kaching", "Oh snap", "Phew", "Righto", "Way to go", "Well done", "Whee", "Woo hoo", "Yay", "Wowza", "Yowsa"));

    public static final List<String> SPEECH_CONS_WRONG = Collections.unmodifiableList(Arrays.asList("Argh", "Aw man", "Blarg", "Blast", "Boo", "Bummer", "Darn", "D'oh", "Dun dun dun", "Eek", "Honk", "Le sigh", "Mamma mia", "Oh boy", "Oh dear", "Oof", "Ouch", "Ruh roh", "Shucks", "Uh oh", "Wah wah", "Whoops a daisy", "Yikes"));

    public static final String SPEECH_CONS_SAY_AS = "<say-as interpret-as='interjection'>%s </say-as><break strength='strong'/>";

    public static final Set<String> BORING_WORDS = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            "know",
            "there",
            "then",
            "I'll",
            "it's",
            "here",
            "wait",
            "some",
            "like",
            "mean",
            "you",
            "with",
            "seem",
            "about",
            "they're",
            "that",
            "I've",
            "have"
    )));

    public static final String EMPTY_STRING = "";

    // 5 underscores
    public static final String BLANK = "_____";

    public static final String PICK_MOVIE_SPEECH = "Let's test your knowledge. Pick a movie!";

    public static final String NEXT_MOVIE_SPEECH = "Okie dokie, now what movie would you like to try?";

    public static final String CANCEL_SPEECH = "Thanks for playing! Goodbye!";

    public static final String MOVIE_TEST_SPEECH = "Okie dokie, let's test you on %s. Complete this quote: ";

    public static final String QUOTE_TEXT_SPEECH = "Onward! Try completing this quote: ";

    public static final String STRONG_BLANK = "<emphasis level='strong'>blank</emphasis>";

    public static final String MOVIE_BACKGROUND_IMAGE_ROUND = "https://i.imgur.com/prffOgH.png";

    public static final String MOVIE_BACKGROUND_IMAGE_LANDSCAPE = "https://i.imgur.com/sjREu6G.png";

    public static final String QUOTE_HELP_SPEECH = "Say Help if you aren't sure what to do!";

    public static final String CORRECT_ANSWER_NEW_QUOTE_SPEECH = "%s is correct! Say New Quote or New Movie!";

    public static final String CORRECT_ANSWER_IMAGE_ROUND = "https://i.imgur.com/GOsI1RN.png";

    public static final String CORRECT_ANSWER_IMAGE_LANDSCAPE = "https://i.imgur.com/yHBbX4l.png";

    public static final String WRONG_ANSWER_NEW_QUOTE_SPEECH = "The correct answer is %s. Say New Quote or New Movie!";

    public static final String WRONG_ANSWER_IMAGE_ROUND = "https://i.imgur.com/qkiABIN.png";

    public static final String WRONG_ANSWER_IMAGE_LANDSCAPE = "https://i.imgur.com/sfXjUK1.png";

    public static final String ERROR_MESSAGE = "Sorry, I can't understand the command. Please try again or say Help.";
}