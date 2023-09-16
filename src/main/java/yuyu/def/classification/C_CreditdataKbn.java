
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * クレジットデータ区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_CreditdataKbn</td><td colspan="3">クレジットデータ区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YKKAKUNIN}</td><td>&quot;1&quot;</td><td>有効性確認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AUTHORI}</td><td>&quot;2&quot;</td><td>オーソリ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #URIAGE}</td><td>&quot;3&quot;</td><td>売上</td></tr>
 * </table>
 */
public class C_CreditdataKbn extends Classification<C_CreditdataKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_CreditdataKbn BLNK = new C_CreditdataKbn("0");

    public static final C_CreditdataKbn YKKAKUNIN = new C_CreditdataKbn("1");

    public static final C_CreditdataKbn AUTHORI = new C_CreditdataKbn("2");

    public static final C_CreditdataKbn URIAGE = new C_CreditdataKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, YKKAKUNIN, "YKKAKUNIN", false);
        addPattern(PATTERN_DEFAULT, AUTHORI, "AUTHORI", false);
        addPattern(PATTERN_DEFAULT, URIAGE, "URIAGE", false);


        lock(C_CreditdataKbn.class);
    }

    private C_CreditdataKbn(String value) {
        super(value);
    }

    public static C_CreditdataKbn valueOf(String value) {
        return valueOf(C_CreditdataKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_CreditdataKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_CreditdataKbn.class, patternId, value);
    }
}
