
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 数理配当金集計パターン区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SrHaitoukinSyuukeiPtnKbn</td><td colspan="3">数理配当金集計パターン区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="11">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIJI}</td><td>&quot;01&quot;</td><td>一時払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HARAIMAN}</td><td>&quot;02&quot;</td><td>払満</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HARAIZUMI}</td><td>&quot;03&quot;</td><td>払済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ENTYOU}</td><td>&quot;04&quot;</td><td>延長</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KODOMOPMEN}</td><td>&quot;05&quot;</td><td>こどもＰ免</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYGIPMEN}</td><td>&quot;06&quot;</td><td>障害Ｐ免</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENBARAI}</td><td>&quot;07&quot;</td><td>年払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HANNENBARAI}</td><td>&quot;08&quot;</td><td>半年払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DANTUKI}</td><td>&quot;09&quot;</td><td>団月</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TIZUKI}</td><td>&quot;10&quot;</td><td>地月</td></tr>
 * </table>
 */
public class C_SrHaitoukinSyuukeiPtnKbn extends Classification<C_SrHaitoukinSyuukeiPtnKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SrHaitoukinSyuukeiPtnKbn BLNK = new C_SrHaitoukinSyuukeiPtnKbn("00");

    public static final C_SrHaitoukinSyuukeiPtnKbn ITIJI = new C_SrHaitoukinSyuukeiPtnKbn("01");

    public static final C_SrHaitoukinSyuukeiPtnKbn HARAIMAN = new C_SrHaitoukinSyuukeiPtnKbn("02");

    public static final C_SrHaitoukinSyuukeiPtnKbn HARAIZUMI = new C_SrHaitoukinSyuukeiPtnKbn("03");

    public static final C_SrHaitoukinSyuukeiPtnKbn ENTYOU = new C_SrHaitoukinSyuukeiPtnKbn("04");

    public static final C_SrHaitoukinSyuukeiPtnKbn KODOMOPMEN = new C_SrHaitoukinSyuukeiPtnKbn("05");

    public static final C_SrHaitoukinSyuukeiPtnKbn SYGIPMEN = new C_SrHaitoukinSyuukeiPtnKbn("06");

    public static final C_SrHaitoukinSyuukeiPtnKbn NENBARAI = new C_SrHaitoukinSyuukeiPtnKbn("07");

    public static final C_SrHaitoukinSyuukeiPtnKbn HANNENBARAI = new C_SrHaitoukinSyuukeiPtnKbn("08");

    public static final C_SrHaitoukinSyuukeiPtnKbn DANTUKI = new C_SrHaitoukinSyuukeiPtnKbn("09");

    public static final C_SrHaitoukinSyuukeiPtnKbn TIZUKI = new C_SrHaitoukinSyuukeiPtnKbn("10");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ITIJI, "ITIJI", false);
        addPattern(PATTERN_DEFAULT, HARAIMAN, "HARAIMAN", false);
        addPattern(PATTERN_DEFAULT, HARAIZUMI, "HARAIZUMI", false);
        addPattern(PATTERN_DEFAULT, ENTYOU, "ENTYOU", false);
        addPattern(PATTERN_DEFAULT, KODOMOPMEN, "KODOMOPMEN", false);
        addPattern(PATTERN_DEFAULT, SYGIPMEN, "SYGIPMEN", false);
        addPattern(PATTERN_DEFAULT, NENBARAI, "NENBARAI", false);
        addPattern(PATTERN_DEFAULT, HANNENBARAI, "HANNENBARAI", false);
        addPattern(PATTERN_DEFAULT, DANTUKI, "DANTUKI", false);
        addPattern(PATTERN_DEFAULT, TIZUKI, "TIZUKI", false);


        lock(C_SrHaitoukinSyuukeiPtnKbn.class);
    }

    private C_SrHaitoukinSyuukeiPtnKbn(String value) {
        super(value);
    }

    public static C_SrHaitoukinSyuukeiPtnKbn valueOf(String value) {
        return valueOf(C_SrHaitoukinSyuukeiPtnKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SrHaitoukinSyuukeiPtnKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SrHaitoukinSyuukeiPtnKbn.class, patternId, value);
    }
}
