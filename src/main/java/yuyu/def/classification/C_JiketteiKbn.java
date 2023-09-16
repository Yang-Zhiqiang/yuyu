
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 事業一括決定状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_JiketteiKbn</td><td colspan="3">事業一括決定状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;99&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>未決定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KETTEI_SUMI}</td><td>&quot;1&quot;</td><td>決定済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KETTEI_MATI}</td><td>&quot;2&quot;</td><td>決定待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TKJYSYDK_MATI}</td><td>&quot;3&quot;</td><td>特条承諾書待ち</td></tr>
 * </table>
 */
public class C_JiketteiKbn extends Classification<C_JiketteiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_JiketteiKbn BLNK = new C_JiketteiKbn("99");

    public static final C_JiketteiKbn NONE = new C_JiketteiKbn("0");

    public static final C_JiketteiKbn KETTEI_SUMI = new C_JiketteiKbn("1");

    public static final C_JiketteiKbn KETTEI_MATI = new C_JiketteiKbn("2");

    public static final C_JiketteiKbn TKJYSYDK_MATI = new C_JiketteiKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);
        addPattern(PATTERN_DEFAULT, KETTEI_SUMI, "KETTEI_SUMI", false);
        addPattern(PATTERN_DEFAULT, KETTEI_MATI, "KETTEI_MATI", false);
        addPattern(PATTERN_DEFAULT, TKJYSYDK_MATI, "TKJYSYDK_MATI", false);


        lock(C_JiketteiKbn.class);
    }

    private C_JiketteiKbn(String value) {
        super(value);
    }

    public static C_JiketteiKbn valueOf(String value) {
        return valueOf(C_JiketteiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_JiketteiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_JiketteiKbn.class, patternId, value);
    }
}
