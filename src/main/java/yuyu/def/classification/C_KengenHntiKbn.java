
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 権限判定区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KengenHntiKbn</td><td colspan="3">権限判定区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #OK}</td><td>&quot;0&quot;</td><td>処理可</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TANMATUERROR}</td><td>&quot;1&quot;</td><td>処理不可（端末権限エラー）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIYOSYAERROR}</td><td>&quot;2&quot;</td><td>処理不可（使用者権限エラー）</td></tr>
 * </table>
 */
public class C_KengenHntiKbn extends Classification<C_KengenHntiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KengenHntiKbn OK = new C_KengenHntiKbn("0");

    public static final C_KengenHntiKbn TANMATUERROR = new C_KengenHntiKbn("1");

    public static final C_KengenHntiKbn SIYOSYAERROR = new C_KengenHntiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, OK, "OK", true);
        addPattern(PATTERN_DEFAULT, TANMATUERROR, "TANMATUERROR", false);
        addPattern(PATTERN_DEFAULT, SIYOSYAERROR, "SIYOSYAERROR", false);


        lock(C_KengenHntiKbn.class);
    }

    private C_KengenHntiKbn(String value) {
        super(value);
    }

    public static C_KengenHntiKbn valueOf(String value) {
        return valueOf(C_KengenHntiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KengenHntiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KengenHntiKbn.class, patternId, value);
    }
}
