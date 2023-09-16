
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 査定完了区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SateikanKbn</td><td colspan="3">査定完了区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KNK}</td><td>&quot;1&quot;</td><td>環境査定完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IMU}</td><td>&quot;2&quot;</td><td>医務査定完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TNK}</td><td>&quot;3&quot;</td><td>申込点検完了</td></tr>
 * </table>
 */
public class C_SateikanKbn extends Classification<C_SateikanKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SateikanKbn BLNK = new C_SateikanKbn("0");

    public static final C_SateikanKbn KNK = new C_SateikanKbn("1");

    public static final C_SateikanKbn IMU = new C_SateikanKbn("2");

    public static final C_SateikanKbn TNK = new C_SateikanKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KNK, "KNK", false);
        addPattern(PATTERN_DEFAULT, IMU, "IMU", false);
        addPattern(PATTERN_DEFAULT, TNK, "TNK", false);


        lock(C_SateikanKbn.class);
    }

    private C_SateikanKbn(String value) {
        super(value);
    }

    public static C_SateikanKbn valueOf(String value) {
        return valueOf(C_SateikanKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SateikanKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SateikanKbn.class, patternId, value);
    }
}
