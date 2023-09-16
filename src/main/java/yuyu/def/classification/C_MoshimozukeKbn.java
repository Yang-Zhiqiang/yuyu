
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 申込紐付区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MoshimozukeKbn</td><td colspan="3">申込紐付区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WEBMOS}</td><td>&quot;1&quot;</td><td>Ｗｅｂ申込</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KKANRI}</td><td>&quot;2&quot;</td><td>契約管理</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PAPERLESS}</td><td>&quot;3&quot;</td><td>ペーパーレス</td></tr>
 * </table>
 */
public class C_MoshimozukeKbn extends Classification<C_MoshimozukeKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MoshimozukeKbn BLNK = new C_MoshimozukeKbn("0");

    public static final C_MoshimozukeKbn WEBMOS = new C_MoshimozukeKbn("1");

    public static final C_MoshimozukeKbn KKANRI = new C_MoshimozukeKbn("2");

    public static final C_MoshimozukeKbn PAPERLESS = new C_MoshimozukeKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, WEBMOS, "WEBMOS", false);
        addPattern(PATTERN_DEFAULT, KKANRI, "KKANRI", false);
        addPattern(PATTERN_DEFAULT, PAPERLESS, "PAPERLESS", false);


        lock(C_MoshimozukeKbn.class);
    }

    private C_MoshimozukeKbn(String value) {
        super(value);
    }

    public static C_MoshimozukeKbn valueOf(String value) {
        return valueOf(C_MoshimozukeKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MoshimozukeKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MoshimozukeKbn.class, patternId, value);
    }
}
