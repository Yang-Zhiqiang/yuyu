
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 数理用共通エラー区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SuuriKyoutuuErrorKbn</td><td colspan="3">数理用共通エラー区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>エラーなし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #INPUTERROR}</td><td>&quot;1&quot;</td><td>与件設定エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAWASERATEGETERROR}</td><td>&quot;2&quot;</td><td>為替レート取得エラー</td></tr>
 * </table>
 */
public class C_SuuriKyoutuuErrorKbn extends Classification<C_SuuriKyoutuuErrorKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SuuriKyoutuuErrorKbn NONE = new C_SuuriKyoutuuErrorKbn("0");

    public static final C_SuuriKyoutuuErrorKbn INPUTERROR = new C_SuuriKyoutuuErrorKbn("1");

    public static final C_SuuriKyoutuuErrorKbn KAWASERATEGETERROR = new C_SuuriKyoutuuErrorKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, INPUTERROR, "INPUTERROR", false);
        addPattern(PATTERN_DEFAULT, KAWASERATEGETERROR, "KAWASERATEGETERROR", false);


        lock(C_SuuriKyoutuuErrorKbn.class);
    }

    private C_SuuriKyoutuuErrorKbn(String value) {
        super(value);
    }

    public static C_SuuriKyoutuuErrorKbn valueOf(String value) {
        return valueOf(C_SuuriKyoutuuErrorKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SuuriKyoutuuErrorKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SuuriKyoutuuErrorKbn.class, patternId, value);
    }
}
