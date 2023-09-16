
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 円建変更時税務情報補足区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_YendthnkzeimuinfohskKbn</td><td colspan="3">円建変更時税務情報補足区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHRTYSYTSG_KYKHNKNASI}</td><td>&quot;1&quot;</td><td>支払調書対象外（契約者変更なし）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHRTYSYTSG_KYKHNKARI}</td><td>&quot;2&quot;</td><td>支払調書対象外（契約者変更あり）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHRTYSYTS_KYKHNKNASI}</td><td>&quot;3&quot;</td><td>支払調書対象（契約者変更なし）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHRTYSYTS_KYKHNKARI}</td><td>&quot;4&quot;</td><td>支払調書対象（契約者変更あり）</td></tr>
 * </table>
 */
public class C_YendthnkzeimuinfohskKbn extends Classification<C_YendthnkzeimuinfohskKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_YendthnkzeimuinfohskKbn BLNK = new C_YendthnkzeimuinfohskKbn("0");

    public static final C_YendthnkzeimuinfohskKbn SHRTYSYTSG_KYKHNKNASI = new C_YendthnkzeimuinfohskKbn("1");

    public static final C_YendthnkzeimuinfohskKbn SHRTYSYTSG_KYKHNKARI = new C_YendthnkzeimuinfohskKbn("2");

    public static final C_YendthnkzeimuinfohskKbn SHRTYSYTS_KYKHNKNASI = new C_YendthnkzeimuinfohskKbn("3");

    public static final C_YendthnkzeimuinfohskKbn SHRTYSYTS_KYKHNKARI = new C_YendthnkzeimuinfohskKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SHRTYSYTSG_KYKHNKNASI, "SHRTYSYTSG_KYKHNKNASI", false);
        addPattern(PATTERN_DEFAULT, SHRTYSYTSG_KYKHNKARI, "SHRTYSYTSG_KYKHNKARI", false);
        addPattern(PATTERN_DEFAULT, SHRTYSYTS_KYKHNKNASI, "SHRTYSYTS_KYKHNKNASI", false);
        addPattern(PATTERN_DEFAULT, SHRTYSYTS_KYKHNKARI, "SHRTYSYTS_KYKHNKARI", false);


        lock(C_YendthnkzeimuinfohskKbn.class);
    }

    private C_YendthnkzeimuinfohskKbn(String value) {
        super(value);
    }

    public static C_YendthnkzeimuinfohskKbn valueOf(String value) {
        return valueOf(C_YendthnkzeimuinfohskKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_YendthnkzeimuinfohskKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_YendthnkzeimuinfohskKbn.class, patternId, value);
    }
}
