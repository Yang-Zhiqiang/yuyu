
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * Ｐ免現価計算対象区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_PmengnkksntisyKbn</td><td colspan="3">Ｐ免現価計算対象区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #PMENGNK}</td><td>&quot;1&quot;</td><td>Ｐ免現価</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMENGNK_YTRSK}</td><td>&quot;2&quot;</td><td>Ｐ免現価（予定利息）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMENGNK_PMENJI}</td><td>&quot;3&quot;</td><td>Ｐ免現価（Ｐ免発生時）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMENGNK_TOUGETU}</td><td>&quot;4&quot;</td><td>Ｐ免現価（当月末）</td></tr>
 * </table>
 */
public class C_PmengnkksntisyKbn extends Classification<C_PmengnkksntisyKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_PmengnkksntisyKbn PMENGNK = new C_PmengnkksntisyKbn("1");

    public static final C_PmengnkksntisyKbn PMENGNK_YTRSK = new C_PmengnkksntisyKbn("2");

    public static final C_PmengnkksntisyKbn PMENGNK_PMENJI = new C_PmengnkksntisyKbn("3");

    public static final C_PmengnkksntisyKbn PMENGNK_TOUGETU = new C_PmengnkksntisyKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, PMENGNK, "PMENGNK", true);
        addPattern(PATTERN_DEFAULT, PMENGNK_YTRSK, "PMENGNK_YTRSK", false);
        addPattern(PATTERN_DEFAULT, PMENGNK_PMENJI, "PMENGNK_PMENJI", false);
        addPattern(PATTERN_DEFAULT, PMENGNK_TOUGETU, "PMENGNK_TOUGETU", false);


        lock(C_PmengnkksntisyKbn.class);
    }

    private C_PmengnkksntisyKbn(String value) {
        super(value);
    }

    public static C_PmengnkksntisyKbn valueOf(String value) {
        return valueOf(C_PmengnkksntisyKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_PmengnkksntisyKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_PmengnkksntisyKbn.class, patternId, value);
    }
}
