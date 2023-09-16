
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 受取人指定区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_UktsiteiKbn</td><td colspan="3">受取人指定区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBONAZI}</td><td>&quot;1&quot;</td><td>死亡返還金受取人と同じ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBBETUZIN}</td><td>&quot;2&quot;</td><td>死亡返還金受取人と別人</td></tr>
 * </table>
 */
public class C_UktsiteiKbn extends Classification<C_UktsiteiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_UktsiteiKbn BLNK = new C_UktsiteiKbn("0");

    public static final C_UktsiteiKbn SBONAZI = new C_UktsiteiKbn("1");

    public static final C_UktsiteiKbn SBBETUZIN = new C_UktsiteiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SBONAZI, "SBONAZI", false);
        addPattern(PATTERN_DEFAULT, SBBETUZIN, "SBBETUZIN", false);


        lock(C_UktsiteiKbn.class);
    }

    private C_UktsiteiKbn(String value) {
        super(value);
    }

    public static C_UktsiteiKbn valueOf(String value) {
        return valueOf(C_UktsiteiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_UktsiteiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_UktsiteiKbn.class, patternId, value);
    }
}
