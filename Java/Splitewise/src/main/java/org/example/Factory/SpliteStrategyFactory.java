package org.example.Factory;

import org.example.Exception.StrategyNotFound;
import org.example.Strategy.EqualSplit;
import org.example.Strategy.SplitStrategy;

public class SpliteStrategyFactory {
    public  static SplitStrategy createStrategyForSplit(String strategy){
        if(strategy.equals("Equal")){
            return new EqualSplit();
        }
        throw  new StrategyNotFound(strategy);
    }
}
