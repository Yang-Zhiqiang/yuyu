
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 契約状態 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Kykjyoutai</td><td colspan="3">契約状態</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRKMTYUU}</td><td>&quot;1&quot;</td><td>払込中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HARAIMAN}</td><td>&quot;2&quot;</td><td>払満</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HARAIZUMI}</td><td>&quot;3&quot;</td><td>払済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ENTYOU}</td><td>&quot;4&quot;</td><td>延長</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMEN}</td><td>&quot;5&quot;</td><td>Ｐ免</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENNOU}</td><td>&quot;6&quot;</td><td>前納</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATUNK}</td><td>&quot;7&quot;</td><td>一括入金中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIJIBARAI}</td><td>&quot;9&quot;</td><td>一時払い</td></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_NOBLNK NOBLNK}<br />(ブランクなし)</td><td align="center">&nbsp;</td><td>{@link #HRKMTYUU}</td><td>&quot;1&quot;</td><td>払込中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HARAIMAN}</td><td>&quot;2&quot;</td><td>払満</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HARAIZUMI}</td><td>&quot;3&quot;</td><td>払済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ENTYOU}</td><td>&quot;4&quot;</td><td>延長</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMEN}</td><td>&quot;5&quot;</td><td>Ｐ免</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENNOU}</td><td>&quot;6&quot;</td><td>前納</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATUNK}</td><td>&quot;7&quot;</td><td>一括入金中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIJIBARAI}</td><td>&quot;9&quot;</td><td>一時払い</td></tr>
 * </table>
 */
public class C_Kykjyoutai extends Classification<C_Kykjyoutai> {

    private static final long serialVersionUID = 1L;


    public static final C_Kykjyoutai BLNK = new C_Kykjyoutai("0");

    public static final C_Kykjyoutai HRKMTYUU = new C_Kykjyoutai("1");

    public static final C_Kykjyoutai HARAIMAN = new C_Kykjyoutai("2");

    public static final C_Kykjyoutai HARAIZUMI = new C_Kykjyoutai("3");

    public static final C_Kykjyoutai ENTYOU = new C_Kykjyoutai("4");

    public static final C_Kykjyoutai PMEN = new C_Kykjyoutai("5");

    public static final C_Kykjyoutai ZENNOU = new C_Kykjyoutai("6");

    public static final C_Kykjyoutai IKKATUNK = new C_Kykjyoutai("7");

    public static final C_Kykjyoutai ITIJIBARAI = new C_Kykjyoutai("9");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOBLNK = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HRKMTYUU, "HRKMTYUU", false);
        addPattern(PATTERN_DEFAULT, HARAIMAN, "HARAIMAN", false);
        addPattern(PATTERN_DEFAULT, HARAIZUMI, "HARAIZUMI", false);
        addPattern(PATTERN_DEFAULT, ENTYOU, "ENTYOU", false);
        addPattern(PATTERN_DEFAULT, PMEN, "PMEN", false);
        addPattern(PATTERN_DEFAULT, ZENNOU, "ZENNOU", false);
        addPattern(PATTERN_DEFAULT, IKKATUNK, "IKKATUNK", false);
        addPattern(PATTERN_DEFAULT, ITIJIBARAI, "ITIJIBARAI", false);


        addPattern(PATTERN_NOBLNK, HRKMTYUU, "HRKMTYUU", false);
        addPattern(PATTERN_NOBLNK, HARAIMAN, "HARAIMAN", false);
        addPattern(PATTERN_NOBLNK, HARAIZUMI, "HARAIZUMI", false);
        addPattern(PATTERN_NOBLNK, ENTYOU, "ENTYOU", false);
        addPattern(PATTERN_NOBLNK, PMEN, "PMEN", false);
        addPattern(PATTERN_NOBLNK, ZENNOU, "ZENNOU", false);
        addPattern(PATTERN_NOBLNK, IKKATUNK, "IKKATUNK", false);
        addPattern(PATTERN_NOBLNK, ITIJIBARAI, "ITIJIBARAI", false);


        lock(C_Kykjyoutai.class);
    }

    private C_Kykjyoutai(String value) {
        super(value);
    }

    public static C_Kykjyoutai valueOf(String value) {
        return valueOf(C_Kykjyoutai.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Kykjyoutai.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Kykjyoutai.class, patternId, value);
    }
}
