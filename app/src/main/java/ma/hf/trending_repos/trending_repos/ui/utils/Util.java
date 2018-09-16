package ma.hf.trending_repos.trending_repos.ui.utils;

import java.text.DecimalFormat;

/**
 * Created by THINKPAD T450 on 15/09/2018.
 */

public class Util {
    public static String formatStarNumbers(double starsNumber){
        return new DecimalFormat("##.#").format(starsNumber/1000);
    }
}
