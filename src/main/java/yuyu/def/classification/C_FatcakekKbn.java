
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＦＡＴＣＡ結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_FatcakekKbn</td><td colspan="3">ＦＡＴＣＡ結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAKUNINTYUU}</td><td>&quot;1&quot;</td><td>確認中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUTEIAMERICAN}</td><td>&quot;2&quot;</td><td>対象（特定米国人）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HIKYOURYOKUTEKIKOKYAKU}</td><td>&quot;3&quot;</td><td>対象（非協力的顧客）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TAISYOUGAIYOU}</td><td>&quot;4&quot;</td><td>対象外（定期調査要）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TAISYOUGAIHUYOU}</td><td>&quot;5&quot;</td><td>対象外（定期調査不要）</td></tr>
 * </table>
 */
public class C_FatcakekKbn extends Classification<C_FatcakekKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_FatcakekKbn BLNK = new C_FatcakekKbn("0");

    public static final C_FatcakekKbn KAKUNINTYUU = new C_FatcakekKbn("1");

    public static final C_FatcakekKbn TOKUTEIAMERICAN = new C_FatcakekKbn("2");

    public static final C_FatcakekKbn HIKYOURYOKUTEKIKOKYAKU = new C_FatcakekKbn("3");

    public static final C_FatcakekKbn TAISYOUGAIYOU = new C_FatcakekKbn("4");

    public static final C_FatcakekKbn TAISYOUGAIHUYOU = new C_FatcakekKbn("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KAKUNINTYUU, "KAKUNINTYUU", false);
        addPattern(PATTERN_DEFAULT, TOKUTEIAMERICAN, "TOKUTEIAMERICAN", false);
        addPattern(PATTERN_DEFAULT, HIKYOURYOKUTEKIKOKYAKU, "HIKYOURYOKUTEKIKOKYAKU", false);
        addPattern(PATTERN_DEFAULT, TAISYOUGAIYOU, "TAISYOUGAIYOU", false);
        addPattern(PATTERN_DEFAULT, TAISYOUGAIHUYOU, "TAISYOUGAIHUYOU", false);


        lock(C_FatcakekKbn.class);
    }

    private C_FatcakekKbn(String value) {
        super(value);
    }

    public static C_FatcakekKbn valueOf(String value) {
        return valueOf(C_FatcakekKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_FatcakekKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_FatcakekKbn.class, patternId, value);
    }
}
