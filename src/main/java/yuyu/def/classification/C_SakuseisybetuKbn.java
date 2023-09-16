
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 作成種別区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SakuseisybetuKbn</td><td colspan="3">作成種別区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKNY2}</td><td>&quot;1&quot;</td><td>請求内容２次</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHRGKS}</td><td>&quot;2&quot;</td><td>支払後検証</td></tr>
 * </table>
 */
public class C_SakuseisybetuKbn extends Classification<C_SakuseisybetuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SakuseisybetuKbn BLNK = new C_SakuseisybetuKbn("0");

    public static final C_SakuseisybetuKbn SKNY2 = new C_SakuseisybetuKbn("1");

    public static final C_SakuseisybetuKbn SHRGKS = new C_SakuseisybetuKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SKNY2, "SKNY2", false);
        addPattern(PATTERN_DEFAULT, SHRGKS, "SHRGKS", false);


        lock(C_SakuseisybetuKbn.class);
    }

    private C_SakuseisybetuKbn(String value) {
        super(value);
    }

    public static C_SakuseisybetuKbn valueOf(String value) {
        return valueOf(C_SakuseisybetuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SakuseisybetuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SakuseisybetuKbn.class, patternId, value);
    }
}
