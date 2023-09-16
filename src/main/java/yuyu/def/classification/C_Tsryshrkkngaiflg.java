
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 手数料支払期間外フラグ クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Tsryshrkkngaiflg</td><td colspan="3">手数料支払期間外フラグ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #KIKANNAI}</td><td>&quot;0&quot;</td><td>期間内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIKANGAI}</td><td>&quot;1&quot;</td><td>期間外</td></tr>
 * </table>
 */
public class C_Tsryshrkkngaiflg extends Classification<C_Tsryshrkkngaiflg> {

    private static final long serialVersionUID = 1L;


    public static final C_Tsryshrkkngaiflg KIKANNAI = new C_Tsryshrkkngaiflg("0");

    public static final C_Tsryshrkkngaiflg KIKANGAI = new C_Tsryshrkkngaiflg("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, KIKANNAI, "KIKANNAI", true);
        addPattern(PATTERN_DEFAULT, KIKANGAI, "KIKANGAI", false);


        lock(C_Tsryshrkkngaiflg.class);
    }

    private C_Tsryshrkkngaiflg(String value) {
        super(value);
    }

    public static C_Tsryshrkkngaiflg valueOf(String value) {
        return valueOf(C_Tsryshrkkngaiflg.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Tsryshrkkngaiflg.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Tsryshrkkngaiflg.class, patternId, value);
    }
}
