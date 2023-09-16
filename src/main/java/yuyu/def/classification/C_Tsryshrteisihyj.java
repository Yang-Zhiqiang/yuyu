
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 手数料支払停止表示 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Tsryshrteisihyj</td><td colspan="3">手数料支払停止表示</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIHARAITEISI}</td><td>&quot;1&quot;</td><td>支払停止</td></tr>
 * </table>
 */
public class C_Tsryshrteisihyj extends Classification<C_Tsryshrteisihyj> {

    private static final long serialVersionUID = 1L;


    public static final C_Tsryshrteisihyj BLNK = new C_Tsryshrteisihyj("0");

    public static final C_Tsryshrteisihyj SIHARAITEISI = new C_Tsryshrteisihyj("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SIHARAITEISI, "SIHARAITEISI", false);


        lock(C_Tsryshrteisihyj.class);
    }

    private C_Tsryshrteisihyj(String value) {
        super(value);
    }

    public static C_Tsryshrteisihyj valueOf(String value) {
        return valueOf(C_Tsryshrteisihyj.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Tsryshrteisihyj.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Tsryshrteisihyj.class, patternId, value);
    }
}
