
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 預り金備金決算区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_AzukarikinBknkessanKbn</td><td colspan="3">預り金備金決算区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KESSAN}</td><td>&quot;1&quot;</td><td>決算</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAI1SHNK}</td><td>&quot;2&quot;</td><td>第１四半期</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HNK}</td><td>&quot;3&quot;</td><td>半期</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAI3SHNK}</td><td>&quot;4&quot;</td><td>第３四半期</td></tr>
 * </table>
 */
public class C_AzukarikinBknkessanKbn extends Classification<C_AzukarikinBknkessanKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_AzukarikinBknkessanKbn BLNK = new C_AzukarikinBknkessanKbn("0");

    public static final C_AzukarikinBknkessanKbn KESSAN = new C_AzukarikinBknkessanKbn("1");

    public static final C_AzukarikinBknkessanKbn DAI1SHNK = new C_AzukarikinBknkessanKbn("2");

    public static final C_AzukarikinBknkessanKbn HNK = new C_AzukarikinBknkessanKbn("3");

    public static final C_AzukarikinBknkessanKbn DAI3SHNK = new C_AzukarikinBknkessanKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KESSAN, "KESSAN", false);
        addPattern(PATTERN_DEFAULT, DAI1SHNK, "DAI1SHNK", false);
        addPattern(PATTERN_DEFAULT, HNK, "HNK", false);
        addPattern(PATTERN_DEFAULT, DAI3SHNK, "DAI3SHNK", false);


        lock(C_AzukarikinBknkessanKbn.class);
    }

    private C_AzukarikinBknkessanKbn(String value) {
        super(value);
    }

    public static C_AzukarikinBknkessanKbn valueOf(String value) {
        return valueOf(C_AzukarikinBknkessanKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_AzukarikinBknkessanKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_AzukarikinBknkessanKbn.class, patternId, value);
    }
}
