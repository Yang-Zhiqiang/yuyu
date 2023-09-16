
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * モバイル募集区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MobilebosyuuKbn</td><td colspan="3">モバイル募集区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOBILEBOSYUU}</td><td>&quot;1&quot;</td><td>モバイル募集</td></tr>
 * </table>
 */
public class C_MobilebosyuuKbn extends Classification<C_MobilebosyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MobilebosyuuKbn BLNK = new C_MobilebosyuuKbn("0");

    public static final C_MobilebosyuuKbn MOBILEBOSYUU = new C_MobilebosyuuKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MOBILEBOSYUU, "MOBILEBOSYUU", false);


        lock(C_MobilebosyuuKbn.class);
    }

    private C_MobilebosyuuKbn(String value) {
        super(value);
    }

    public static C_MobilebosyuuKbn valueOf(String value) {
        return valueOf(C_MobilebosyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MobilebosyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MobilebosyuuKbn.class, patternId, value);
    }
}
