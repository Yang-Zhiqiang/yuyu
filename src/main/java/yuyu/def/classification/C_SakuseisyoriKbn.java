
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 作成処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SakuseisyoriKbn</td><td colspan="3">作成処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #BATCH}</td><td>&quot;1&quot;</td><td>バッチ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ONLINE}</td><td>&quot;2&quot;</td><td>オンライン</td></tr>
 *  <tr><td align="center">○</td><td>{@link #ALL}</td><td>&quot;3&quot;</td><td>すべて</td></tr>
 * </table>
 */
public class C_SakuseisyoriKbn extends Classification<C_SakuseisyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SakuseisyoriKbn BATCH = new C_SakuseisyoriKbn("1");

    public static final C_SakuseisyoriKbn ONLINE = new C_SakuseisyoriKbn("2");

    public static final C_SakuseisyoriKbn ALL = new C_SakuseisyoriKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BATCH, "BATCH", false);
        addPattern(PATTERN_DEFAULT, ONLINE, "ONLINE", false);
        addPattern(PATTERN_DEFAULT, ALL, "ALL", true);


        lock(C_SakuseisyoriKbn.class);
    }

    private C_SakuseisyoriKbn(String value) {
        super(value);
    }

    public static C_SakuseisyoriKbn valueOf(String value) {
        return valueOf(C_SakuseisyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SakuseisyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SakuseisyoriKbn.class, patternId, value);
    }
}
