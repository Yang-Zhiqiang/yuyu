
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 工程制御有無区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KouteiSeigyoUmuKbn</td><td colspan="3">工程制御有無区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>制御なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HIMODUKE}</td><td>&quot;1&quot;</td><td>紐付け</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HIMODUKE_AUTO}</td><td>&quot;2&quot;</td><td>紐付け自動作成</td></tr>
 * </table>
 */
public class C_KouteiSeigyoUmuKbn extends Classification<C_KouteiSeigyoUmuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KouteiSeigyoUmuKbn NONE = new C_KouteiSeigyoUmuKbn("0");

    public static final C_KouteiSeigyoUmuKbn HIMODUKE = new C_KouteiSeigyoUmuKbn("1");

    public static final C_KouteiSeigyoUmuKbn HIMODUKE_AUTO = new C_KouteiSeigyoUmuKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, HIMODUKE, "HIMODUKE", false);
        addPattern(PATTERN_DEFAULT, HIMODUKE_AUTO, "HIMODUKE_AUTO", false);


        lock(C_KouteiSeigyoUmuKbn.class);
    }

    private C_KouteiSeigyoUmuKbn(String value) {
        super(value);
    }

    public static C_KouteiSeigyoUmuKbn valueOf(String value) {
        return valueOf(C_KouteiSeigyoUmuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KouteiSeigyoUmuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KouteiSeigyoUmuKbn.class, patternId, value);
    }
}
