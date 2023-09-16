
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 更新内容反映区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KousinNaiyouHaneiKbn</td><td colspan="3">更新内容反映区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #KINOU_MODE}</td><td>&quot;1&quot;</td><td>選択中の機能モード</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KINOU}</td><td>&quot;2&quot;</td><td>選択中の機能</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CATEGORY}</td><td>&quot;3&quot;</td><td>選択中のカテゴリ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUBSYSTEM}</td><td>&quot;4&quot;</td><td>選択中のサブシステム</td></tr>
 * </table>
 */
public class C_KousinNaiyouHaneiKbn extends Classification<C_KousinNaiyouHaneiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KousinNaiyouHaneiKbn KINOU_MODE = new C_KousinNaiyouHaneiKbn("1");

    public static final C_KousinNaiyouHaneiKbn KINOU = new C_KousinNaiyouHaneiKbn("2");

    public static final C_KousinNaiyouHaneiKbn CATEGORY = new C_KousinNaiyouHaneiKbn("3");

    public static final C_KousinNaiyouHaneiKbn SUBSYSTEM = new C_KousinNaiyouHaneiKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, KINOU_MODE, "KINOU_MODE", true);
        addPattern(PATTERN_DEFAULT, KINOU, "KINOU", false);
        addPattern(PATTERN_DEFAULT, CATEGORY, "CATEGORY", false);
        addPattern(PATTERN_DEFAULT, SUBSYSTEM, "SUBSYSTEM", false);


        lock(C_KousinNaiyouHaneiKbn.class);
    }

    private C_KousinNaiyouHaneiKbn(String value) {
        super(value);
    }

    public static C_KousinNaiyouHaneiKbn valueOf(String value) {
        return valueOf(C_KousinNaiyouHaneiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KousinNaiyouHaneiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KousinNaiyouHaneiKbn.class, patternId, value);
    }
}
