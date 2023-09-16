
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 手続結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TtdkKekkaKbn</td><td colspan="3">手続結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TETUDUKIKANRYOU}</td><td>&quot;1&quot;</td><td>手続完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TETUDUKITYUUDAN}</td><td>&quot;2&quot;</td><td>手続中断</td></tr>
 * </table>
 */
public class C_TtdkKekkaKbn extends Classification<C_TtdkKekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TtdkKekkaKbn BLNK = new C_TtdkKekkaKbn("0");

    public static final C_TtdkKekkaKbn TETUDUKIKANRYOU = new C_TtdkKekkaKbn("1");

    public static final C_TtdkKekkaKbn TETUDUKITYUUDAN = new C_TtdkKekkaKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TETUDUKIKANRYOU, "TETUDUKIKANRYOU", false);
        addPattern(PATTERN_DEFAULT, TETUDUKITYUUDAN, "TETUDUKITYUUDAN", false);


        lock(C_TtdkKekkaKbn.class);
    }

    private C_TtdkKekkaKbn(String value) {
        super(value);
    }

    public static C_TtdkKekkaKbn valueOf(String value) {
        return valueOf(C_TtdkKekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TtdkKekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TtdkKekkaKbn.class, patternId, value);
    }
}
