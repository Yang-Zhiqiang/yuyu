
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 分割年金額調整処理 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Bnktnktyouseisyori</td><td colspan="3">分割年金額調整処理</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LAST}</td><td>&quot;1&quot;</td><td>最終回差額算入</td></tr>
 * </table>
 */
public class C_Bnktnktyouseisyori extends Classification<C_Bnktnktyouseisyori> {

    private static final long serialVersionUID = 1L;


    public static final C_Bnktnktyouseisyori NONE = new C_Bnktnktyouseisyori("0");

    public static final C_Bnktnktyouseisyori LAST = new C_Bnktnktyouseisyori("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, LAST, "LAST", false);


        lock(C_Bnktnktyouseisyori.class);
    }

    private C_Bnktnktyouseisyori(String value) {
        super(value);
    }

    public static C_Bnktnktyouseisyori valueOf(String value) {
        return valueOf(C_Bnktnktyouseisyori.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Bnktnktyouseisyori.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Bnktnktyouseisyori.class, patternId, value);
    }
}
