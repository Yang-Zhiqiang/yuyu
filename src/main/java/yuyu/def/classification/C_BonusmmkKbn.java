
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ボーナス名目区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BonusmmkKbn</td><td colspan="3">ボーナス名目区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TESURYO1}</td><td>&quot;01&quot;</td><td>手数料１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TESURYO2}</td><td>&quot;02&quot;</td><td>手数料２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TESURYO3}</td><td>&quot;03&quot;</td><td>手数料３</td></tr>
 * </table>
 */
public class C_BonusmmkKbn extends Classification<C_BonusmmkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BonusmmkKbn BLNK = new C_BonusmmkKbn("00");

    public static final C_BonusmmkKbn TESURYO1 = new C_BonusmmkKbn("01");

    public static final C_BonusmmkKbn TESURYO2 = new C_BonusmmkKbn("02");

    public static final C_BonusmmkKbn TESURYO3 = new C_BonusmmkKbn("03");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TESURYO1, "TESURYO1", false);
        addPattern(PATTERN_DEFAULT, TESURYO2, "TESURYO2", false);
        addPattern(PATTERN_DEFAULT, TESURYO3, "TESURYO3", false);


        lock(C_BonusmmkKbn.class);
    }

    private C_BonusmmkKbn(String value) {
        super(value);
    }

    public static C_BonusmmkKbn valueOf(String value) {
        return valueOf(C_BonusmmkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BonusmmkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BonusmmkKbn.class, patternId, value);
    }
}
