
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 担当室区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TantousituKbn</td><td colspan="3">担当室区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOZENHENKOUSV}</td><td>&quot;1&quot;</td><td>保全変更サービス室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOZENSIHARAISV}</td><td>&quot;2&quot;</td><td>保全支払サービス室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIRITENJIMUSV}</td><td>&quot;3&quot;</td><td>代理店事務サービス室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUUNOUSV}</td><td>&quot;4&quot;</td><td>個別収納サービス室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIYAKUSINSA}</td><td>&quot;5&quot;</td><td>契約審査室</td></tr>
 * </table>
 */
public class C_TantousituKbn extends Classification<C_TantousituKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TantousituKbn BLNK = new C_TantousituKbn("0");

    public static final C_TantousituKbn HOZENHENKOUSV = new C_TantousituKbn("1");

    public static final C_TantousituKbn HOZENSIHARAISV = new C_TantousituKbn("2");

    public static final C_TantousituKbn DAIRITENJIMUSV = new C_TantousituKbn("3");

    public static final C_TantousituKbn SYUUNOUSV = new C_TantousituKbn("4");

    public static final C_TantousituKbn KEIYAKUSINSA = new C_TantousituKbn("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HOZENHENKOUSV, "HOZENHENKOUSV", false);
        addPattern(PATTERN_DEFAULT, HOZENSIHARAISV, "HOZENSIHARAISV", false);
        addPattern(PATTERN_DEFAULT, DAIRITENJIMUSV, "DAIRITENJIMUSV", false);
        addPattern(PATTERN_DEFAULT, SYUUNOUSV, "SYUUNOUSV", false);
        addPattern(PATTERN_DEFAULT, KEIYAKUSINSA, "KEIYAKUSINSA", false);


        lock(C_TantousituKbn.class);
    }

    private C_TantousituKbn(String value) {
        super(value);
    }

    public static C_TantousituKbn valueOf(String value) {
        return valueOf(C_TantousituKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TantousituKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TantousituKbn.class, patternId, value);
    }
}
