
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 米国人示唆情報区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BikkjnssinfoKbn</td><td colspan="3">米国人示唆情報区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ARI}</td><td>&quot;1&quot;</td><td>あり</td></tr>
 * </table>
 */
public class C_BikkjnssinfoKbn extends Classification<C_BikkjnssinfoKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BikkjnssinfoKbn BLNK = new C_BikkjnssinfoKbn("0");

    public static final C_BikkjnssinfoKbn ARI = new C_BikkjnssinfoKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ARI, "ARI", false);


        lock(C_BikkjnssinfoKbn.class);
    }

    private C_BikkjnssinfoKbn(String value) {
        super(value);
    }

    public static C_BikkjnssinfoKbn valueOf(String value) {
        return valueOf(C_BikkjnssinfoKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BikkjnssinfoKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BikkjnssinfoKbn.class, patternId, value);
    }
}
