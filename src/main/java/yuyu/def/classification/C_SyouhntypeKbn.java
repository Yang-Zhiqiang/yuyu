
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 商品形式区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyouhntypeKbn</td><td colspan="3">商品形式区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #HYOA}</td><td>&quot;01&quot;</td><td>標準Ａパターン</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HYOB}</td><td>&quot;02&quot;</td><td>標準Bパターン</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRYOUA}</td><td>&quot;11&quot;</td><td>医療Ａパターン</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRYOUB}</td><td>&quot;12&quot;</td><td>医療Ｂパターン</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRYOUC}</td><td>&quot;13&quot;</td><td>医療Cパターン</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRYOUD}</td><td>&quot;14&quot;</td><td>医療Dパターン</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRYOUE}</td><td>&quot;15&quot;</td><td>医療Eパターン</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRYOUF}</td><td>&quot;16&quot;</td><td>医療Fパターン</td></tr>
 * </table>
 */
public class C_SyouhntypeKbn extends Classification<C_SyouhntypeKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SyouhntypeKbn HYOA = new C_SyouhntypeKbn("01");

    public static final C_SyouhntypeKbn HYOB = new C_SyouhntypeKbn("02");

    public static final C_SyouhntypeKbn IRYOUA = new C_SyouhntypeKbn("11");

    public static final C_SyouhntypeKbn IRYOUB = new C_SyouhntypeKbn("12");

    public static final C_SyouhntypeKbn IRYOUC = new C_SyouhntypeKbn("13");

    public static final C_SyouhntypeKbn IRYOUD = new C_SyouhntypeKbn("14");

    public static final C_SyouhntypeKbn IRYOUE = new C_SyouhntypeKbn("15");

    public static final C_SyouhntypeKbn IRYOUF = new C_SyouhntypeKbn("16");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, HYOA, "HYOA", true);
        addPattern(PATTERN_DEFAULT, HYOB, "HYOB", false);
        addPattern(PATTERN_DEFAULT, IRYOUA, "IRYOUA", false);
        addPattern(PATTERN_DEFAULT, IRYOUB, "IRYOUB", false);
        addPattern(PATTERN_DEFAULT, IRYOUC, "IRYOUC", false);
        addPattern(PATTERN_DEFAULT, IRYOUD, "IRYOUD", false);
        addPattern(PATTERN_DEFAULT, IRYOUE, "IRYOUE", false);
        addPattern(PATTERN_DEFAULT, IRYOUF, "IRYOUF", false);


        lock(C_SyouhntypeKbn.class);
    }

    private C_SyouhntypeKbn(String value) {
        super(value);
    }

    public static C_SyouhntypeKbn valueOf(String value) {
        return valueOf(C_SyouhntypeKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyouhntypeKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyouhntypeKbn.class, patternId, value);
    }
}
