
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 契被区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KeihiKbn</td><td colspan="3">契被区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYK}</td><td>&quot;1&quot;</td><td>契約者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN}</td><td>&quot;2&quot;</td><td>被保険者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIHIDOUITU}</td><td>&quot;3&quot;</td><td>契被同一</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYK}</td><td>&quot;1&quot;</td><td>契約者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN}</td><td>&quot;2&quot;</td><td>被保険者</td></tr>
 * </table>
 */
public class C_KeihiKbn extends Classification<C_KeihiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KeihiKbn BLNK = new C_KeihiKbn("0");

    public static final C_KeihiKbn KYK = new C_KeihiKbn("1");

    public static final C_KeihiKbn HHKN = new C_KeihiKbn("2");

    public static final C_KeihiKbn KEIHIDOUITU = new C_KeihiKbn("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KYK, "KYK", false);
        addPattern(PATTERN_DEFAULT, HHKN, "HHKN", false);
        addPattern(PATTERN_DEFAULT, KEIHIDOUITU, "KEIHIDOUITU", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, KYK, "KYK", false);
        addPattern(PATTERN_SELECT, HHKN, "HHKN", false);


        lock(C_KeihiKbn.class);
    }

    private C_KeihiKbn(String value) {
        super(value);
    }

    public static C_KeihiKbn valueOf(String value) {
        return valueOf(C_KeihiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KeihiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KeihiKbn.class, patternId, value);
    }
}
