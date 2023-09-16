
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 募集代理店扱形態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BosyuuDairitenAtkiKeitaiKbn</td><td colspan="3">募集代理店扱形態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #TANDOKU}</td><td>&quot;1&quot;</td><td>代理店募集人単独扱</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EISYOKUDAIRITENKYOUDOU}</td><td>&quot;2&quot;</td><td>営業職員と代理店募集人の共同扱</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIRITENKYOUDOU}</td><td>&quot;3&quot;</td><td>代理店募集人と代理店募集人の共同扱</td></tr>
 * </table>
 */
public class C_BosyuuDairitenAtkiKeitaiKbn extends Classification<C_BosyuuDairitenAtkiKeitaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BosyuuDairitenAtkiKeitaiKbn TANDOKU = new C_BosyuuDairitenAtkiKeitaiKbn("1");

    public static final C_BosyuuDairitenAtkiKeitaiKbn EISYOKUDAIRITENKYOUDOU = new C_BosyuuDairitenAtkiKeitaiKbn("2");

    public static final C_BosyuuDairitenAtkiKeitaiKbn DAIRITENKYOUDOU = new C_BosyuuDairitenAtkiKeitaiKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, TANDOKU, "TANDOKU", true);
        addPattern(PATTERN_DEFAULT, EISYOKUDAIRITENKYOUDOU, "EISYOKUDAIRITENKYOUDOU", false);
        addPattern(PATTERN_DEFAULT, DAIRITENKYOUDOU, "DAIRITENKYOUDOU", false);


        lock(C_BosyuuDairitenAtkiKeitaiKbn.class);
    }

    private C_BosyuuDairitenAtkiKeitaiKbn(String value) {
        super(value);
    }

    public static C_BosyuuDairitenAtkiKeitaiKbn valueOf(String value) {
        return valueOf(C_BosyuuDairitenAtkiKeitaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BosyuuDairitenAtkiKeitaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BosyuuDairitenAtkiKeitaiKbn.class, patternId, value);
    }
}
