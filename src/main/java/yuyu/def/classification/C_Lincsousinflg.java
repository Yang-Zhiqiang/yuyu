
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＬＩＮＣ送信済フラグ クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Lincsousinflg</td><td colspan="3">ＬＩＮＣ送信済フラグ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ＬＩＮＣ未送信</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAKUNIN_SUMI}</td><td>&quot;1&quot;</td><td>ＬＩＮＣ送信済</td></tr>
 * </table>
 */
public class C_Lincsousinflg extends Classification<C_Lincsousinflg> {

    private static final long serialVersionUID = 1L;


    public static final C_Lincsousinflg BLNK = new C_Lincsousinflg("0");

    public static final C_Lincsousinflg KAKUNIN_SUMI = new C_Lincsousinflg("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KAKUNIN_SUMI, "KAKUNIN_SUMI", false);


        lock(C_Lincsousinflg.class);
    }

    private C_Lincsousinflg(String value) {
        super(value);
    }

    public static C_Lincsousinflg valueOf(String value) {
        return valueOf(C_Lincsousinflg.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Lincsousinflg.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Lincsousinflg.class, patternId, value);
    }
}
