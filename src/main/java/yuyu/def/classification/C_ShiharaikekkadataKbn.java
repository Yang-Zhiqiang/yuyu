
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 支払結果データ区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ShiharaikekkadataKbn</td><td colspan="3">支払結果データ区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SYOUMETU}</td><td>&quot;1&quot;</td><td>消滅情報</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMEN}</td><td>&quot;2&quot;</td><td>Ｐ免情報</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TSNGNDTYOUKA}</td><td>&quot;3&quot;</td><td>通算限度超過</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GANSINDAN90INAI}</td><td>&quot;4&quot;</td><td>90日以内がん診断</td></tr>
 * </table>
 */
public class C_ShiharaikekkadataKbn extends Classification<C_ShiharaikekkadataKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ShiharaikekkadataKbn SYOUMETU = new C_ShiharaikekkadataKbn("1");

    public static final C_ShiharaikekkadataKbn PMEN = new C_ShiharaikekkadataKbn("2");

    public static final C_ShiharaikekkadataKbn TSNGNDTYOUKA = new C_ShiharaikekkadataKbn("3");

    public static final C_ShiharaikekkadataKbn GANSINDAN90INAI = new C_ShiharaikekkadataKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SYOUMETU, "SYOUMETU", true);
        addPattern(PATTERN_DEFAULT, PMEN, "PMEN", false);
        addPattern(PATTERN_DEFAULT, TSNGNDTYOUKA, "TSNGNDTYOUKA", false);
        addPattern(PATTERN_DEFAULT, GANSINDAN90INAI, "GANSINDAN90INAI", false);


        lock(C_ShiharaikekkadataKbn.class);
    }

    private C_ShiharaikekkadataKbn(String value) {
        super(value);
    }

    public static C_ShiharaikekkadataKbn valueOf(String value) {
        return valueOf(C_ShiharaikekkadataKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ShiharaikekkadataKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ShiharaikekkadataKbn.class, patternId, value);
    }
}
