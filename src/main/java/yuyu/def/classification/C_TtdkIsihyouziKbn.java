
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 手続意思表示区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TtdkIsihyouziKbn</td><td colspan="3">手続意思表示区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #TYUUDAN}</td><td>&quot;0&quot;</td><td>中断</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TETUZUKIZISSI}</td><td>&quot;1&quot;</td><td>手続実施</td></tr>
 *  <tr><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;9&quot;</td><td>ブランク</td></tr>
 * </table>
 */
public class C_TtdkIsihyouziKbn extends Classification<C_TtdkIsihyouziKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TtdkIsihyouziKbn TYUUDAN = new C_TtdkIsihyouziKbn("0");

    public static final C_TtdkIsihyouziKbn TETUZUKIZISSI = new C_TtdkIsihyouziKbn("1");

    public static final C_TtdkIsihyouziKbn BLNK = new C_TtdkIsihyouziKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, TYUUDAN, "TYUUDAN", false);
        addPattern(PATTERN_DEFAULT, TETUZUKIZISSI, "TETUZUKIZISSI", false);
        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);


        lock(C_TtdkIsihyouziKbn.class);
    }

    private C_TtdkIsihyouziKbn(String value) {
        super(value);
    }

    public static C_TtdkIsihyouziKbn valueOf(String value) {
        return valueOf(C_TtdkIsihyouziKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TtdkIsihyouziKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TtdkIsihyouziKbn.class, patternId, value);
    }
}
