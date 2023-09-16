
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 代申フラグ クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Dsnflg</td><td colspan="3">代申フラグ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAISIN}</td><td>&quot;1&quot;</td><td>代申</td></tr>
 * </table>
 */
public class C_Dsnflg extends Classification<C_Dsnflg> {

    private static final long serialVersionUID = 1L;


    public static final C_Dsnflg BLNK = new C_Dsnflg("0");

    public static final C_Dsnflg DAISIN = new C_Dsnflg("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, DAISIN, "DAISIN", false);


        lock(C_Dsnflg.class);
    }

    private C_Dsnflg(String value) {
        super(value);
    }

    public static C_Dsnflg valueOf(String value) {
        return valueOf(C_Dsnflg.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Dsnflg.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Dsnflg.class, patternId, value);
    }
}
