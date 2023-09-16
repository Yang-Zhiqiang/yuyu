
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＤＳメール送信状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DsMailSousinJyoutaiKbn</td><td colspan="3">ＤＳメール送信状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUKOU}</td><td>&quot;1&quot;</td><td>有効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEISI}</td><td>&quot;2&quot;</td><td>停止</td></tr>
 * </table>
 */
public class C_DsMailSousinJyoutaiKbn extends Classification<C_DsMailSousinJyoutaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DsMailSousinJyoutaiKbn BLNK = new C_DsMailSousinJyoutaiKbn("0");

    public static final C_DsMailSousinJyoutaiKbn YUUKOU = new C_DsMailSousinJyoutaiKbn("1");

    public static final C_DsMailSousinJyoutaiKbn TEISI = new C_DsMailSousinJyoutaiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, YUUKOU, "YUUKOU", false);
        addPattern(PATTERN_DEFAULT, TEISI, "TEISI", false);


        lock(C_DsMailSousinJyoutaiKbn.class);
    }

    private C_DsMailSousinJyoutaiKbn(String value) {
        super(value);
    }

    public static C_DsMailSousinJyoutaiKbn valueOf(String value) {
        return valueOf(C_DsMailSousinJyoutaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DsMailSousinJyoutaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DsMailSousinJyoutaiKbn.class, patternId, value);
    }
}
