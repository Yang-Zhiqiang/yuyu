
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 仮受ペイジー振込用紙入金区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KrkPayEasyHrkmyousiNkKbn</td><td colspan="3">仮受ペイジー振込用紙入金区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #TAISYOUGAI}</td><td>&quot;0&quot;</td><td>対象外（ペイジー未対応）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EGSYOKUIN}</td><td>&quot;1&quot;</td><td>営業職員振込</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OKYKSM_NYUUKIN}</td><td>&quot;2&quot;</td><td>お客さま振込（入金帳票）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OKYKSM_IKKATU}</td><td>&quot;3&quot;</td><td>お客さま振込（センター一括作成）</td></tr>
 * </table>
 */
public class C_KrkPayEasyHrkmyousiNkKbn extends Classification<C_KrkPayEasyHrkmyousiNkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KrkPayEasyHrkmyousiNkKbn TAISYOUGAI = new C_KrkPayEasyHrkmyousiNkKbn("0");

    public static final C_KrkPayEasyHrkmyousiNkKbn EGSYOKUIN = new C_KrkPayEasyHrkmyousiNkKbn("1");

    public static final C_KrkPayEasyHrkmyousiNkKbn OKYKSM_NYUUKIN = new C_KrkPayEasyHrkmyousiNkKbn("2");

    public static final C_KrkPayEasyHrkmyousiNkKbn OKYKSM_IKKATU = new C_KrkPayEasyHrkmyousiNkKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, TAISYOUGAI, "TAISYOUGAI", true);
        addPattern(PATTERN_DEFAULT, EGSYOKUIN, "EGSYOKUIN", false);
        addPattern(PATTERN_DEFAULT, OKYKSM_NYUUKIN, "OKYKSM_NYUUKIN", false);
        addPattern(PATTERN_DEFAULT, OKYKSM_IKKATU, "OKYKSM_IKKATU", false);


        lock(C_KrkPayEasyHrkmyousiNkKbn.class);
    }

    private C_KrkPayEasyHrkmyousiNkKbn(String value) {
        super(value);
    }

    public static C_KrkPayEasyHrkmyousiNkKbn valueOf(String value) {
        return valueOf(C_KrkPayEasyHrkmyousiNkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KrkPayEasyHrkmyousiNkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KrkPayEasyHrkmyousiNkKbn.class, patternId, value);
    }
}
