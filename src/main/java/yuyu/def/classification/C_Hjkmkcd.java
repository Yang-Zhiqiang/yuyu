
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 補助科目コード クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Hjkmkcd</td><td colspan="3">補助科目コード</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="16">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0000000&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KZNKFKTSRY}</td><td>&quot;1000100&quot;</td><td>口座入金振込手数料</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PFKTSRY}</td><td>&quot;1000200&quot;</td><td>保険料振込手数料</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIHONTYOUS}</td><td>&quot;9104200&quot;</td><td>基本調整</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SDSYOSTKHIY}</td><td>&quot;2000100&quot;</td><td>診断書取得費用</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TSRY_NEWP}</td><td>&quot;9101100&quot;</td><td>手数料・新Ｐ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYSTSRY}</td><td>&quot;9102100&quot;</td><td>調整手数料</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KURKOSBUN}</td><td>&quot;9104100&quot;</td><td>繰越分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TSRY_KEIP}</td><td>&quot;9104900&quot;</td><td>手数料・継Ｐ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BONUSTYOUS}</td><td>&quot;9104300&quot;</td><td>ボーナス調整</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOBKEIYTYOUS}</td><td>&quot;9104400&quot;</td><td>個別契約調整</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHISKSHIK}</td><td>&quot;9104500&quot;</td><td>施策支給</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #REINYUU}</td><td>&quot;9104600&quot;</td><td>戻入</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAHRIHENK}</td><td>&quot;9104700&quot;</td><td>過払返還</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHISKHOKHENK}</td><td>&quot;9104800&quot;</td><td>施策補給返還</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BONUS}</td><td>&quot;9103100&quot;</td><td>ボーナス</td></tr>
 * </table>
 */
public class C_Hjkmkcd extends Classification<C_Hjkmkcd> {

    private static final long serialVersionUID = 1L;


    public static final C_Hjkmkcd BLNK = new C_Hjkmkcd("0000000");

    public static final C_Hjkmkcd KZNKFKTSRY = new C_Hjkmkcd("1000100");

    public static final C_Hjkmkcd PFKTSRY = new C_Hjkmkcd("1000200");

    public static final C_Hjkmkcd KIHONTYOUS = new C_Hjkmkcd("9104200");

    public static final C_Hjkmkcd SDSYOSTKHIY = new C_Hjkmkcd("2000100");

    public static final C_Hjkmkcd TSRY_NEWP = new C_Hjkmkcd("9101100");

    public static final C_Hjkmkcd TYSTSRY = new C_Hjkmkcd("9102100");

    public static final C_Hjkmkcd KURKOSBUN = new C_Hjkmkcd("9104100");

    public static final C_Hjkmkcd TSRY_KEIP = new C_Hjkmkcd("9104900");

    public static final C_Hjkmkcd BONUSTYOUS = new C_Hjkmkcd("9104300");

    public static final C_Hjkmkcd KOBKEIYTYOUS = new C_Hjkmkcd("9104400");

    public static final C_Hjkmkcd SHISKSHIK = new C_Hjkmkcd("9104500");

    public static final C_Hjkmkcd REINYUU = new C_Hjkmkcd("9104600");

    public static final C_Hjkmkcd KAHRIHENK = new C_Hjkmkcd("9104700");

    public static final C_Hjkmkcd SHISKHOKHENK = new C_Hjkmkcd("9104800");

    public static final C_Hjkmkcd BONUS = new C_Hjkmkcd("9103100");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KZNKFKTSRY, "KZNKFKTSRY", false);
        addPattern(PATTERN_DEFAULT, PFKTSRY, "PFKTSRY", false);
        addPattern(PATTERN_DEFAULT, KIHONTYOUS, "KIHONTYOUS", false);
        addPattern(PATTERN_DEFAULT, SDSYOSTKHIY, "SDSYOSTKHIY", false);
        addPattern(PATTERN_DEFAULT, TSRY_NEWP, "TSRY_NEWP", false);
        addPattern(PATTERN_DEFAULT, TYSTSRY, "TYSTSRY", false);
        addPattern(PATTERN_DEFAULT, KURKOSBUN, "KURKOSBUN", false);
        addPattern(PATTERN_DEFAULT, TSRY_KEIP, "TSRY_KEIP", false);
        addPattern(PATTERN_DEFAULT, BONUSTYOUS, "BONUSTYOUS", false);
        addPattern(PATTERN_DEFAULT, KOBKEIYTYOUS, "KOBKEIYTYOUS", false);
        addPattern(PATTERN_DEFAULT, SHISKSHIK, "SHISKSHIK", false);
        addPattern(PATTERN_DEFAULT, REINYUU, "REINYUU", false);
        addPattern(PATTERN_DEFAULT, KAHRIHENK, "KAHRIHENK", false);
        addPattern(PATTERN_DEFAULT, SHISKHOKHENK, "SHISKHOKHENK", false);
        addPattern(PATTERN_DEFAULT, BONUS, "BONUS", false);


        lock(C_Hjkmkcd.class);
    }

    private C_Hjkmkcd(String value) {
        super(value);
    }

    public static C_Hjkmkcd valueOf(String value) {
        return valueOf(C_Hjkmkcd.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Hjkmkcd.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Hjkmkcd.class, patternId, value);
    }
}
