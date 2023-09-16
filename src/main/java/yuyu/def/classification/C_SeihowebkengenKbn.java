
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 生保Ｗｅｂ権限区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SeihowebkengenKbn</td><td colspan="3">生保Ｗｅｂ権限区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ARI}</td><td>&quot;1&quot;</td><td>権限あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TANMATUERROR}</td><td>&quot;2&quot;</td><td>端末権限エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIYOUSHAERROR}</td><td>&quot;3&quot;</td><td>使用者権限エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DRTENSYOUKAERROR}</td><td>&quot;4&quot;</td><td>代理店用照会権限エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIYAKUERROR}</td><td>&quot;5&quot;</td><td>銀行代理店募集契約エラー</td></tr>
 * </table>
 */
public class C_SeihowebkengenKbn extends Classification<C_SeihowebkengenKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SeihowebkengenKbn BLNK = new C_SeihowebkengenKbn("0");

    public static final C_SeihowebkengenKbn ARI = new C_SeihowebkengenKbn("1");

    public static final C_SeihowebkengenKbn TANMATUERROR = new C_SeihowebkengenKbn("2");

    public static final C_SeihowebkengenKbn SIYOUSHAERROR = new C_SeihowebkengenKbn("3");

    public static final C_SeihowebkengenKbn DRTENSYOUKAERROR = new C_SeihowebkengenKbn("4");

    public static final C_SeihowebkengenKbn KEIYAKUERROR = new C_SeihowebkengenKbn("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", false);
        addPattern(PATTERN_DEFAULT, ARI, "ARI", false);
        addPattern(PATTERN_DEFAULT, TANMATUERROR, "TANMATUERROR", false);
        addPattern(PATTERN_DEFAULT, SIYOUSHAERROR, "SIYOUSHAERROR", false);
        addPattern(PATTERN_DEFAULT, DRTENSYOUKAERROR, "DRTENSYOUKAERROR", false);
        addPattern(PATTERN_DEFAULT, KEIYAKUERROR, "KEIYAKUERROR", false);


        lock(C_SeihowebkengenKbn.class);
    }

    private C_SeihowebkengenKbn(String value) {
        super(value);
    }

    public static C_SeihowebkengenKbn valueOf(String value) {
        return valueOf(C_SeihowebkengenKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SeihowebkengenKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SeihowebkengenKbn.class, patternId, value);
    }
}
