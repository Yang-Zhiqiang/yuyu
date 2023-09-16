
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＤＳ加入経路区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DsKanyuuKeiroKbn</td><td colspan="3">ＤＳ加入経路区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKEIYAKUDOUJI}</td><td>&quot;1&quot;</td><td>新契約同時</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYUUTOKANYUU}</td><td>&quot;2&quot;</td><td>中途加入</td></tr>
 * </table>
 */
public class C_DsKanyuuKeiroKbn extends Classification<C_DsKanyuuKeiroKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DsKanyuuKeiroKbn BLNK = new C_DsKanyuuKeiroKbn("0");

    public static final C_DsKanyuuKeiroKbn SINKEIYAKUDOUJI = new C_DsKanyuuKeiroKbn("1");

    public static final C_DsKanyuuKeiroKbn TYUUTOKANYUU = new C_DsKanyuuKeiroKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SINKEIYAKUDOUJI, "SINKEIYAKUDOUJI", false);
        addPattern(PATTERN_DEFAULT, TYUUTOKANYUU, "TYUUTOKANYUU", false);


        lock(C_DsKanyuuKeiroKbn.class);
    }

    private C_DsKanyuuKeiroKbn(String value) {
        super(value);
    }

    public static C_DsKanyuuKeiroKbn valueOf(String value) {
        return valueOf(C_DsKanyuuKeiroKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DsKanyuuKeiroKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DsKanyuuKeiroKbn.class, patternId, value);
    }
}
