
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 手数料支払区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TsryshrKbn</td><td colspan="3">手数料支払区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #L5}</td><td>&quot;01&quot;</td><td>５年Ｌ字</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #L10}</td><td>&quot;03&quot;</td><td>１０年Ｌ字</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #F10}</td><td>&quot;04&quot;</td><td>１０年平準</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_MEISAI MEISAI}<br />(手数料明細翻訳用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #L5}</td><td>&quot;01&quot;</td><td>５Ｌ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #L10}</td><td>&quot;03&quot;</td><td>１０Ｌ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #F10}</td><td>&quot;04&quot;</td><td>１０平</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_TsryshrKbn extends Classification<C_TsryshrKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TsryshrKbn BLNK = new C_TsryshrKbn("00");

    public static final C_TsryshrKbn L5 = new C_TsryshrKbn("01");

    public static final C_TsryshrKbn L10 = new C_TsryshrKbn("03");

    public static final C_TsryshrKbn F10 = new C_TsryshrKbn("04");

    public static final C_TsryshrKbn SONOTA = new C_TsryshrKbn("99");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_MEISAI = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, L5, "L5", false);
        addPattern(PATTERN_DEFAULT, L10, "L10", false);
        addPattern(PATTERN_DEFAULT, F10, "F10", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        addPattern(PATTERN_MEISAI, BLNK, "BLNK", true);
        addPattern(PATTERN_MEISAI, L5, "L5", false);
        addPattern(PATTERN_MEISAI, L10, "L10", false);
        addPattern(PATTERN_MEISAI, F10, "F10", false);
        addPattern(PATTERN_MEISAI, SONOTA, "SONOTA", false);


        lock(C_TsryshrKbn.class);
    }

    private C_TsryshrKbn(String value) {
        super(value);
    }

    public static C_TsryshrKbn valueOf(String value) {
        return valueOf(C_TsryshrKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TsryshrKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TsryshrKbn.class, patternId, value);
    }
}
