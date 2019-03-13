package com.qudian.similarity;

import java.io.File;

/**
 * SimilarityCompare
 */
public class SimilarityCompare {

    private final SimpleTextTokenizer token;
    private final EasyCompare eCompare;
    private final CosineSimilarity cSimilarity;
    private final LevenshteinDistance lDistance;

    public SimilarityCompare() {
        token = new SimpleTextTokenizer();
        eCompare = new EasyCompare(token);
        cSimilarity = new CosineSimilarity(token);
        lDistance = new LevenshteinDistance(token);
    }

    public SimilarityCompare(File filterFile) {
        token = new SimpleTextTokenizer(filterFile);
        eCompare = new EasyCompare(token);
        cSimilarity = new CosineSimilarity(token);
        lDistance = new LevenshteinDistance(token);
    }

    public double comparaEasyWay(String originStr, String resultStr) {

        double similar_rate = eCompare.compareSentence(originStr, resultStr);
        return similar_rate;

    }

    public double compareLevenshteinDistance(String originStr, String resultStr) {

        double similar_rate = lDistance.comparaSentence(originStr, resultStr);
        return similar_rate;

    }

    public double compareCosineSimilarity(String originStr, String resultStr) {

        double similar_rate = cSimilarity.compareSentence(originStr, resultStr);
        return similar_rate;

    }

}