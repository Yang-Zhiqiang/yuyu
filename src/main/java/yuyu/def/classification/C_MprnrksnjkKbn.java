
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * マイページ連絡承認状況区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MprnrksnjkKbn</td><td colspan="3">マイページ連絡承認状況区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUNINMATI}</td><td>&quot;1&quot;</td><td>承認待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SASHIMODOSHI}</td><td>&quot;2&quot;</td><td>差し戻し</td></tr>
 * </table>
 */
public class C_MprnrksnjkKbn extends Classification<C_MprnrksnjkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MprnrksnjkKbn BLNK = new C_MprnrksnjkKbn("0");

    public static final C_MprnrksnjkKbn SYOUNINMATI = new C_MprnrksnjkKbn("1");

    public static final C_MprnrksnjkKbn SASHIMODOSHI = new C_MprnrksnjkKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYOUNINMATI, "SYOUNINMATI", false);
        addPattern(PATTERN_DEFAULT, SASHIMODOSHI, "SASHIMODOSHI", false);


        lock(C_MprnrksnjkKbn.class);
    }

    private C_MprnrksnjkKbn(String value) {
        super(value);
    }

    public static C_MprnrksnjkKbn valueOf(String value) {
        return valueOf(C_MprnrksnjkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MprnrksnjkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MprnrksnjkKbn.class, patternId, value);
    }
}
