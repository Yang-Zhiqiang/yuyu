
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 仮受精算済フラグ クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Krkseisanzumiflg</td><td colspan="3">仮受精算済フラグ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI}</td><td>&quot;1&quot;</td><td>仮受金精算済</td></tr>
 * </table>
 */
public class C_Krkseisanzumiflg extends Classification<C_Krkseisanzumiflg> {

    private static final long serialVersionUID = 1L;


    public static final C_Krkseisanzumiflg BLNK = new C_Krkseisanzumiflg("0");

    public static final C_Krkseisanzumiflg SUMI = new C_Krkseisanzumiflg("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SUMI, "SUMI", false);


        lock(C_Krkseisanzumiflg.class);
    }

    private C_Krkseisanzumiflg(String value) {
        super(value);
    }

    public static C_Krkseisanzumiflg valueOf(String value) {
        return valueOf(C_Krkseisanzumiflg.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Krkseisanzumiflg.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Krkseisanzumiflg.class, patternId, value);
    }
}
