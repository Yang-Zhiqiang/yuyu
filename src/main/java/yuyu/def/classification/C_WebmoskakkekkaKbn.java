
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * Ｗｅｂ申込確認結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_WebmoskakkekkaKbn</td><td colspan="3">Ｗｅｂ申込確認結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;1&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU}</td><td>&quot;2&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;3&quot;</td><td>保留</td></tr>
 * </table>
 */
public class C_WebmoskakkekkaKbn extends Classification<C_WebmoskakkekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_WebmoskakkekkaKbn BLNK = new C_WebmoskakkekkaKbn("0");

    public static final C_WebmoskakkekkaKbn KANRYOU = new C_WebmoskakkekkaKbn("1");

    public static final C_WebmoskakkekkaKbn TENSOU = new C_WebmoskakkekkaKbn("2");

    public static final C_WebmoskakkekkaKbn HORYUU = new C_WebmoskakkekkaKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_DEFAULT, TENSOU, "TENSOU", false);
        addPattern(PATTERN_DEFAULT, HORYUU, "HORYUU", false);


        lock(C_WebmoskakkekkaKbn.class);
    }

    private C_WebmoskakkekkaKbn(String value) {
        super(value);
    }

    public static C_WebmoskakkekkaKbn valueOf(String value) {
        return valueOf(C_WebmoskakkekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_WebmoskakkekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_WebmoskakkekkaKbn.class, patternId, value);
    }
}
