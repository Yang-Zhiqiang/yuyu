
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＭＦ連動済フラグ クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Mfrenflg</td><td colspan="3">ＭＦ連動済フラグ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>ＭＦ未連動</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI}</td><td>&quot;1&quot;</td><td>ＭＦ連動済</td></tr>
 * </table>
 */
public class C_Mfrenflg extends Classification<C_Mfrenflg> {

    private static final long serialVersionUID = 1L;


    public static final C_Mfrenflg NONE = new C_Mfrenflg("0");

    public static final C_Mfrenflg SUMI = new C_Mfrenflg("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, SUMI, "SUMI", false);


        lock(C_Mfrenflg.class);
    }

    private C_Mfrenflg(String value) {
        super(value);
    }

    public static C_Mfrenflg valueOf(String value) {
        return valueOf(C_Mfrenflg.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Mfrenflg.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Mfrenflg.class, patternId, value);
    }
}
