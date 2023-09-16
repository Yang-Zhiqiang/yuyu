
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 利率種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_RirituSyuruiKbn</td><td colspan="3">利率種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOTEIRIRITU}</td><td>&quot;1&quot;</td><td>予定利率</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SJKKKTYOUSEIYOURIRITU}</td><td>&quot;2&quot;</td><td>市場価格調整用利率</td></tr>
 * </table>
 */
public class C_RirituSyuruiKbn extends Classification<C_RirituSyuruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_RirituSyuruiKbn BLNK = new C_RirituSyuruiKbn("0");

    public static final C_RirituSyuruiKbn YOTEIRIRITU = new C_RirituSyuruiKbn("1");

    public static final C_RirituSyuruiKbn SJKKKTYOUSEIYOURIRITU = new C_RirituSyuruiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, YOTEIRIRITU, "YOTEIRIRITU", false);
        addPattern(PATTERN_DEFAULT, SJKKKTYOUSEIYOURIRITU, "SJKKKTYOUSEIYOURIRITU", false);


        lock(C_RirituSyuruiKbn.class);
    }

    private C_RirituSyuruiKbn(String value) {
        super(value);
    }

    public static C_RirituSyuruiKbn valueOf(String value) {
        return valueOf(C_RirituSyuruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_RirituSyuruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_RirituSyuruiKbn.class, patternId, value);
    }
}
