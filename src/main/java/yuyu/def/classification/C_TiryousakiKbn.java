
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 治療先区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TiryousakiKbn</td><td colspan="3">治療先区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BYOUIN}</td><td>&quot;1&quot;</td><td>病院・診療所</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIKOTUIN}</td><td>&quot;2&quot;</td><td>整骨院・接骨院等</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SELECT SELECT}<br />(画面用)</td><td align="center">&nbsp;</td><td>{@link #BYOUIN}</td><td>&quot;1&quot;</td><td>病院・診療所</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIKOTUIN}</td><td>&quot;2&quot;</td><td>整骨院・接骨院等</td></tr>
 * </table>
 */
public class C_TiryousakiKbn extends Classification<C_TiryousakiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TiryousakiKbn BLNK = new C_TiryousakiKbn("0");

    public static final C_TiryousakiKbn BYOUIN = new C_TiryousakiKbn("1");

    public static final C_TiryousakiKbn SEIKOTUIN = new C_TiryousakiKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, BYOUIN, "BYOUIN", false);
        addPattern(PATTERN_DEFAULT, SEIKOTUIN, "SEIKOTUIN", false);


        addPattern(PATTERN_SELECT, BYOUIN, "BYOUIN", false);
        addPattern(PATTERN_SELECT, SEIKOTUIN, "SEIKOTUIN", false);


        lock(C_TiryousakiKbn.class);
    }

    private C_TiryousakiKbn(String value) {
        super(value);
    }

    public static C_TiryousakiKbn valueOf(String value) {
        return valueOf(C_TiryousakiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TiryousakiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TiryousakiKbn.class, patternId, value);
    }
}
