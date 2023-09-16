
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 支払事由 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ShrJiyuu</td><td colspan="3">支払事由</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NK}</td><td>&quot;00&quot;</td><td>年金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATU}</td><td>&quot;01&quot;</td><td>年金一括</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBITJKN}</td><td>&quot;11&quot;</td><td>死亡一時金</td></tr>
 * </table>
 */
public class C_ShrJiyuu extends Classification<C_ShrJiyuu> {

    private static final long serialVersionUID = 1L;


    public static final C_ShrJiyuu NK = new C_ShrJiyuu("00");

    public static final C_ShrJiyuu IKKATU = new C_ShrJiyuu("01");

    public static final C_ShrJiyuu SBITJKN = new C_ShrJiyuu("11");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NK, "NK", true);
        addPattern(PATTERN_DEFAULT, IKKATU, "IKKATU", false);
        addPattern(PATTERN_DEFAULT, SBITJKN, "SBITJKN", false);


        lock(C_ShrJiyuu.class);
    }

    private C_ShrJiyuu(String value) {
        super(value);
    }

    public static C_ShrJiyuu valueOf(String value) {
        return valueOf(C_ShrJiyuu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ShrJiyuu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ShrJiyuu.class, patternId, value);
    }
}
