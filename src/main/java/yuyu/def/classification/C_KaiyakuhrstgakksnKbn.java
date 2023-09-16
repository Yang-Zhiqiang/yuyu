
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 解約返戻金相当額計算区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KaiyakuhrstgakksnKbn</td><td colspan="3">解約返戻金相当額計算区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KKANRI_KEISANW}</td><td>&quot;1&quot;</td><td>契約管理・医療解約返戻金計算</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RIGENV_5ZILL}</td><td>&quot;2&quot;</td><td>利源Ｖ・５チル</td></tr>
 * </table>
 */
public class C_KaiyakuhrstgakksnKbn extends Classification<C_KaiyakuhrstgakksnKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KaiyakuhrstgakksnKbn BLNK = new C_KaiyakuhrstgakksnKbn("0");

    public static final C_KaiyakuhrstgakksnKbn KKANRI_KEISANW = new C_KaiyakuhrstgakksnKbn("1");

    public static final C_KaiyakuhrstgakksnKbn RIGENV_5ZILL = new C_KaiyakuhrstgakksnKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KKANRI_KEISANW, "KKANRI_KEISANW", false);
        addPattern(PATTERN_DEFAULT, RIGENV_5ZILL, "RIGENV_5ZILL", false);


        lock(C_KaiyakuhrstgakksnKbn.class);
    }

    private C_KaiyakuhrstgakksnKbn(String value) {
        super(value);
    }

    public static C_KaiyakuhrstgakksnKbn valueOf(String value) {
        return valueOf(C_KaiyakuhrstgakksnKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KaiyakuhrstgakksnKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KaiyakuhrstgakksnKbn.class, patternId, value);
    }
}
