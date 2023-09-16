
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 商品情報取得区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyouhinJyouhouGetKbn</td><td colspan="3">商品情報取得区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SYOUHININFOARI}</td><td>&quot;1&quot;</td><td>商品情報あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUHININFONASI}</td><td>&quot;2&quot;</td><td>商品情報なし</td></tr>
 * </table>
 */
public class C_SyouhinJyouhouGetKbn extends Classification<C_SyouhinJyouhouGetKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SyouhinJyouhouGetKbn SYOUHININFOARI = new C_SyouhinJyouhouGetKbn("1");

    public static final C_SyouhinJyouhouGetKbn SYOUHININFONASI = new C_SyouhinJyouhouGetKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SYOUHININFOARI, "SYOUHININFOARI", true);
        addPattern(PATTERN_DEFAULT, SYOUHININFONASI, "SYOUHININFONASI", false);


        lock(C_SyouhinJyouhouGetKbn.class);
    }

    private C_SyouhinJyouhouGetKbn(String value) {
        super(value);
    }

    public static C_SyouhinJyouhouGetKbn valueOf(String value) {
        return valueOf(C_SyouhinJyouhouGetKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyouhinJyouhouGetKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyouhinJyouhouGetKbn.class, patternId, value);
    }
}
