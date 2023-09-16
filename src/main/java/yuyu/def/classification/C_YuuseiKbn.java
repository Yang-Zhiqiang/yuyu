
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 郵政区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_YuuseiKbn</td><td colspan="3">郵政区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANPO}</td><td>&quot;1&quot;</td><td>かんぽ生命</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUTYO}</td><td>&quot;2&quot;</td><td>ゆうちょ銀行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUBIN}</td><td>&quot;3&quot;</td><td>日本郵便</td></tr>
 * </table>
 */
public class C_YuuseiKbn extends Classification<C_YuuseiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_YuuseiKbn BLNK = new C_YuuseiKbn("0");

    public static final C_YuuseiKbn KANPO = new C_YuuseiKbn("1");

    public static final C_YuuseiKbn YUUTYO = new C_YuuseiKbn("2");

    public static final C_YuuseiKbn YUUBIN = new C_YuuseiKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KANPO, "KANPO", false);
        addPattern(PATTERN_DEFAULT, YUUTYO, "YUUTYO", false);
        addPattern(PATTERN_DEFAULT, YUUBIN, "YUUBIN", false);


        lock(C_YuuseiKbn.class);
    }

    private C_YuuseiKbn(String value) {
        super(value);
    }

    public static C_YuuseiKbn valueOf(String value) {
        return valueOf(C_YuuseiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_YuuseiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_YuuseiKbn.class, patternId, value);
    }
}
