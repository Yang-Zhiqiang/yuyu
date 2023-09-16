
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 新契約手続連絡区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SkeittdkrenrakuKbn</td><td colspan="3">新契約手続連絡区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TTDK_TRATKITYUUIINFO}</td><td>&quot;1&quot;</td><td>手続取扱注意情報</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TTDK_SONOTATYUUIINFO}</td><td>&quot;2&quot;</td><td>手続その他注意情報</td></tr>
 * </table>
 */
public class C_SkeittdkrenrakuKbn extends Classification<C_SkeittdkrenrakuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SkeittdkrenrakuKbn BLNK = new C_SkeittdkrenrakuKbn("0");

    public static final C_SkeittdkrenrakuKbn TTDK_TRATKITYUUIINFO = new C_SkeittdkrenrakuKbn("1");

    public static final C_SkeittdkrenrakuKbn TTDK_SONOTATYUUIINFO = new C_SkeittdkrenrakuKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TTDK_TRATKITYUUIINFO, "TTDK_TRATKITYUUIINFO", false);
        addPattern(PATTERN_DEFAULT, TTDK_SONOTATYUUIINFO, "TTDK_SONOTATYUUIINFO", false);


        lock(C_SkeittdkrenrakuKbn.class);
    }

    private C_SkeittdkrenrakuKbn(String value) {
        super(value);
    }

    public static C_SkeittdkrenrakuKbn valueOf(String value) {
        return valueOf(C_SkeittdkrenrakuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SkeittdkrenrakuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SkeittdkrenrakuKbn.class, patternId, value);
    }
}
