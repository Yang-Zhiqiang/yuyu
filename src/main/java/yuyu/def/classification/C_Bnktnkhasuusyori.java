
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 分割年金額端数処理 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Bnktnkhasuusyori</td><td colspan="3">分割年金額端数処理</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ROUNDUP}</td><td>&quot;1&quot;</td><td>切り上げ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ROUNDDOWN}</td><td>&quot;2&quot;</td><td>切り捨て</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ROUND}</td><td>&quot;3&quot;</td><td>四捨五入</td></tr>
 * </table>
 */
public class C_Bnktnkhasuusyori extends Classification<C_Bnktnkhasuusyori> {

    private static final long serialVersionUID = 1L;


    public static final C_Bnktnkhasuusyori BLNK = new C_Bnktnkhasuusyori("0");

    public static final C_Bnktnkhasuusyori ROUNDUP = new C_Bnktnkhasuusyori("1");

    public static final C_Bnktnkhasuusyori ROUNDDOWN = new C_Bnktnkhasuusyori("2");

    public static final C_Bnktnkhasuusyori ROUND = new C_Bnktnkhasuusyori("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ROUNDUP, "ROUNDUP", false);
        addPattern(PATTERN_DEFAULT, ROUNDDOWN, "ROUNDDOWN", false);
        addPattern(PATTERN_DEFAULT, ROUND, "ROUND", false);


        lock(C_Bnktnkhasuusyori.class);
    }

    private C_Bnktnkhasuusyori(String value) {
        super(value);
    }

    public static C_Bnktnkhasuusyori valueOf(String value) {
        return valueOf(C_Bnktnkhasuusyori.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Bnktnkhasuusyori.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Bnktnkhasuusyori.class, patternId, value);
    }
}
