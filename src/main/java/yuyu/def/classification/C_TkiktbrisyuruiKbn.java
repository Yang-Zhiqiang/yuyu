
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 定期一括払種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TkiktbrisyuruiKbn</td><td colspan="3">定期一括払種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;1&quot;</td><td>定期一括なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKI_6MONTHS}</td><td>&quot;6&quot;</td><td>６か月定期一括</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKI_12MONTHS}</td><td>&quot;12&quot;</td><td>１２か月定期一括</td></tr>
 * </table>
 */
public class C_TkiktbrisyuruiKbn extends Classification<C_TkiktbrisyuruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TkiktbrisyuruiKbn BLNK = new C_TkiktbrisyuruiKbn("0");

    public static final C_TkiktbrisyuruiKbn NONE = new C_TkiktbrisyuruiKbn("1");

    public static final C_TkiktbrisyuruiKbn TEIKI_6MONTHS = new C_TkiktbrisyuruiKbn("6");

    public static final C_TkiktbrisyuruiKbn TEIKI_12MONTHS = new C_TkiktbrisyuruiKbn("12");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);
        addPattern(PATTERN_DEFAULT, TEIKI_6MONTHS, "TEIKI_6MONTHS", false);
        addPattern(PATTERN_DEFAULT, TEIKI_12MONTHS, "TEIKI_12MONTHS", false);


        lock(C_TkiktbrisyuruiKbn.class);
    }

    private C_TkiktbrisyuruiKbn(String value) {
        super(value);
    }

    public static C_TkiktbrisyuruiKbn valueOf(String value) {
        return valueOf(C_TkiktbrisyuruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TkiktbrisyuruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TkiktbrisyuruiKbn.class, patternId, value);
    }
}
