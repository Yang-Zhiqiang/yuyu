
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 定期一括案内月数 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Tkiktannaitukisuu</td><td colspan="3">定期一括案内月数</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIXMONTHS}</td><td>&quot;6&quot;</td><td>６ヶ月一括</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TWELVEMONTHS}</td><td>&quot;12&quot;</td><td>１２ヶ月一括</td></tr>
 * </table>
 */
public class C_Tkiktannaitukisuu extends Classification<C_Tkiktannaitukisuu> {

    private static final long serialVersionUID = 1L;


    public static final C_Tkiktannaitukisuu BLNK = new C_Tkiktannaitukisuu("0");

    public static final C_Tkiktannaitukisuu SIXMONTHS = new C_Tkiktannaitukisuu("6");

    public static final C_Tkiktannaitukisuu TWELVEMONTHS = new C_Tkiktannaitukisuu("12");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SIXMONTHS, "SIXMONTHS", false);
        addPattern(PATTERN_DEFAULT, TWELVEMONTHS, "TWELVEMONTHS", false);


        lock(C_Tkiktannaitukisuu.class);
    }

    private C_Tkiktannaitukisuu(String value) {
        super(value);
    }

    public static C_Tkiktannaitukisuu valueOf(String value) {
        return valueOf(C_Tkiktannaitukisuu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Tkiktannaitukisuu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Tkiktannaitukisuu.class, patternId, value);
    }
}
