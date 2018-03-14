package com.kodilla.patterns.strategy.predictors;

public class AgressivePredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy(){
        return "[Agressive predictor] Buy stock of XYZ";
    }
}
