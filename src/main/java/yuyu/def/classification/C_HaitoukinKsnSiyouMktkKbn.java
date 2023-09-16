
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 配当金計算使用目的区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HaitoukinKsnSiyouMktkKbn</td><td colspan="3">配当金計算使用目的区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KESSAN}</td><td>&quot;1&quot;</td><td>決算</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JITUMU}</td><td>&quot;2&quot;</td><td>実務</td></tr>
 * </table>
 */
public class C_HaitoukinKsnSiyouMktkKbn extends Classification<C_HaitoukinKsnSiyouMktkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HaitoukinKsnSiyouMktkKbn BLNK = new C_HaitoukinKsnSiyouMktkKbn("0");

    public static final C_HaitoukinKsnSiyouMktkKbn KESSAN = new C_HaitoukinKsnSiyouMktkKbn("1");

    public static final C_HaitoukinKsnSiyouMktkKbn JITUMU = new C_HaitoukinKsnSiyouMktkKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KESSAN, "KESSAN", false);
        addPattern(PATTERN_DEFAULT, JITUMU, "JITUMU", false);


        lock(C_HaitoukinKsnSiyouMktkKbn.class);
    }

    private C_HaitoukinKsnSiyouMktkKbn(String value) {
        super(value);
    }

    public static C_HaitoukinKsnSiyouMktkKbn valueOf(String value) {
        return valueOf(C_HaitoukinKsnSiyouMktkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HaitoukinKsnSiyouMktkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HaitoukinKsnSiyouMktkKbn.class, patternId, value);
    }
}
