
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 端末種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TanmatuSyuruiKbn</td><td colspan="3">端末種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RAY}</td><td>&quot;R&quot;</td><td>ＲＡＹ</td></tr>
 * </table>
 */
public class C_TanmatuSyuruiKbn extends Classification<C_TanmatuSyuruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TanmatuSyuruiKbn BLNK = new C_TanmatuSyuruiKbn("0");

    public static final C_TanmatuSyuruiKbn RAY = new C_TanmatuSyuruiKbn("R");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, RAY, "RAY", false);


        lock(C_TanmatuSyuruiKbn.class);
    }

    private C_TanmatuSyuruiKbn(String value) {
        super(value);
    }

    public static C_TanmatuSyuruiKbn valueOf(String value) {
        return valueOf(C_TanmatuSyuruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TanmatuSyuruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TanmatuSyuruiKbn.class, patternId, value);
    }
}
