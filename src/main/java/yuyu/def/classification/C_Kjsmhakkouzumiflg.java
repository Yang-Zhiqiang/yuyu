
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 控除証明書発行済フラグ クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Kjsmhakkouzumiflg</td><td colspan="3">控除証明書発行済フラグ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI}</td><td>&quot;1&quot;</td><td>控除証明書発行済</td></tr>
 * </table>
 */
public class C_Kjsmhakkouzumiflg extends Classification<C_Kjsmhakkouzumiflg> {

    private static final long serialVersionUID = 1L;


    public static final C_Kjsmhakkouzumiflg BLNK = new C_Kjsmhakkouzumiflg("0");

    public static final C_Kjsmhakkouzumiflg SUMI = new C_Kjsmhakkouzumiflg("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SUMI, "SUMI", false);


        lock(C_Kjsmhakkouzumiflg.class);
    }

    private C_Kjsmhakkouzumiflg(String value) {
        super(value);
    }

    public static C_Kjsmhakkouzumiflg valueOf(String value) {
        return valueOf(C_Kjsmhakkouzumiflg.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Kjsmhakkouzumiflg.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Kjsmhakkouzumiflg.class, patternId, value);
    }
}
