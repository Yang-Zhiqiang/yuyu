
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * Ｐ免区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_PmenKbn</td><td colspan="3">Ｐ免区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYGI}</td><td>&quot;1&quot;</td><td>障害</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KDSYGI}</td><td>&quot;2&quot;</td><td>高度障害</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAN}</td><td>&quot;3&quot;</td><td>がん</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KSSINKINKSK}</td><td>&quot;4&quot;</td><td>急性心筋梗塞</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NOUSOTTYU}</td><td>&quot;5&quot;</td><td>脳卒中</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #SYGI}</td><td>&quot;1&quot;</td><td>障害</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KDSYGI}</td><td>&quot;2&quot;</td><td>高度障害</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAN}</td><td>&quot;3&quot;</td><td>がん</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KSSINKINKSK}</td><td>&quot;4&quot;</td><td>急性心筋梗塞</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NOUSOTTYU}</td><td>&quot;5&quot;</td><td>脳卒中</td></tr>
 * </table>
 */
public class C_PmenKbn extends Classification<C_PmenKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_PmenKbn BLNK = new C_PmenKbn("0");

    public static final C_PmenKbn SYGI = new C_PmenKbn("1");

    public static final C_PmenKbn KDSYGI = new C_PmenKbn("2");

    public static final C_PmenKbn GAN = new C_PmenKbn("3");

    public static final C_PmenKbn KSSINKINKSK = new C_PmenKbn("4");

    public static final C_PmenKbn NOUSOTTYU = new C_PmenKbn("5");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYGI, "SYGI", false);
        addPattern(PATTERN_DEFAULT, KDSYGI, "KDSYGI", false);
        addPattern(PATTERN_DEFAULT, GAN, "GAN", false);
        addPattern(PATTERN_DEFAULT, KSSINKINKSK, "KSSINKINKSK", false);
        addPattern(PATTERN_DEFAULT, NOUSOTTYU, "NOUSOTTYU", false);


        addPattern(PATTERN_SELECT, SYGI, "SYGI", true);
        addPattern(PATTERN_SELECT, KDSYGI, "KDSYGI", false);
        addPattern(PATTERN_SELECT, GAN, "GAN", false);
        addPattern(PATTERN_SELECT, KSSINKINKSK, "KSSINKINKSK", false);
        addPattern(PATTERN_SELECT, NOUSOTTYU, "NOUSOTTYU", false);


        lock(C_PmenKbn.class);
    }

    private C_PmenKbn(String value) {
        super(value);
    }

    public static C_PmenKbn valueOf(String value) {
        return valueOf(C_PmenKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_PmenKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_PmenKbn.class, patternId, value);
    }
}
