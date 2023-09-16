
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＰＡＬＰ免区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_PalPmenKbn</td><td colspan="3">ＰＡＬＰ免区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMENNASI}</td><td>&quot;9&quot;</td><td>Ｐ免なし</td></tr>
 *  <tr><td rowspan="1">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #PMENNASI}</td><td>&quot;9&quot;</td><td>９：Ｐ免なし</td></tr>
 * </table>
 */
public class C_PalPmenKbn extends Classification<C_PalPmenKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_PalPmenKbn BLNK = new C_PalPmenKbn("0");

    public static final C_PalPmenKbn PMENNASI = new C_PalPmenKbn("9");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, PMENNASI, "PMENNASI", false);


        addPattern(PATTERN_SELECT, PMENNASI, "PMENNASI", true);


        lock(C_PalPmenKbn.class);
    }

    private C_PalPmenKbn(String value) {
        super(value);
    }

    public static C_PalPmenKbn valueOf(String value) {
        return valueOf(C_PalPmenKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_PalPmenKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_PalPmenKbn.class, patternId, value);
    }
}
