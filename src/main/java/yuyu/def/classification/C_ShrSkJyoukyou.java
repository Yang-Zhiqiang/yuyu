
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 支払請求状況 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ShrSkJyoukyou</td><td colspan="3">支払請求状況</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SHRSMSK}</td><td>&quot;1&quot;</td><td>支払済請求に対する取込</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKSTTYKMTSK}</td><td>&quot;2&quot;</td><td>請求書到着待ち請求に対する取込</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KTTRKSSK}</td><td>&quot;3&quot;</td><td>工程取消請求に対する取込</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKSTRKMYMD_SOUI}</td><td>&quot;4&quot;</td><td>請求書取込日と異なる取込</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKSHKS}</td><td>&quot;5&quot;</td><td>請求書複数取込</td></tr>
 * </table>
 */
public class C_ShrSkJyoukyou extends Classification<C_ShrSkJyoukyou> {

    private static final long serialVersionUID = 1L;


    public static final C_ShrSkJyoukyou SHRSMSK = new C_ShrSkJyoukyou("1");

    public static final C_ShrSkJyoukyou SKSTTYKMTSK = new C_ShrSkJyoukyou("2");

    public static final C_ShrSkJyoukyou KTTRKSSK = new C_ShrSkJyoukyou("3");

    public static final C_ShrSkJyoukyou SKSTRKMYMD_SOUI = new C_ShrSkJyoukyou("4");

    public static final C_ShrSkJyoukyou SKSHKS = new C_ShrSkJyoukyou("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SHRSMSK, "SHRSMSK", true);
        addPattern(PATTERN_DEFAULT, SKSTTYKMTSK, "SKSTTYKMTSK", false);
        addPattern(PATTERN_DEFAULT, KTTRKSSK, "KTTRKSSK", false);
        addPattern(PATTERN_DEFAULT, SKSTRKMYMD_SOUI, "SKSTRKMYMD_SOUI", false);
        addPattern(PATTERN_DEFAULT, SKSHKS, "SKSHKS", false);


        lock(C_ShrSkJyoukyou.class);
    }

    private C_ShrSkJyoukyou(String value) {
        super(value);
    }

    public static C_ShrSkJyoukyou valueOf(String value) {
        return valueOf(C_ShrSkJyoukyou.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ShrSkJyoukyou.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ShrSkJyoukyou.class, patternId, value);
    }
}
