
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 休日特定方法区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KyuujituTokutei</td><td colspan="3">休日特定方法区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #YMD}</td><td>&quot;1&quot;</td><td>特定年月日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SETMD}</td><td>&quot;2&quot;</td><td>設定年範囲の特定月日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MD}</td><td>&quot;3&quot;</td><td>特定月日</td></tr>
 * </table>
 */
public class C_KyuujituTokutei extends Classification<C_KyuujituTokutei> {

    private static final long serialVersionUID = 1L;


    public static final C_KyuujituTokutei YMD = new C_KyuujituTokutei("1");

    public static final C_KyuujituTokutei SETMD = new C_KyuujituTokutei("2");

    public static final C_KyuujituTokutei MD = new C_KyuujituTokutei("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, YMD, "YMD", true);
        addPattern(PATTERN_DEFAULT, SETMD, "SETMD", false);
        addPattern(PATTERN_DEFAULT, MD, "MD", false);


        lock(C_KyuujituTokutei.class);
    }

    private C_KyuujituTokutei(String value) {
        super(value);
    }

    public static C_KyuujituTokutei valueOf(String value) {
        return valueOf(C_KyuujituTokutei.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KyuujituTokutei.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KyuujituTokutei.class, patternId, value);
    }
}
