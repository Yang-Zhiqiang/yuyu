
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 有効状態チェック結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_YuukoujyotaichkKbn</td><td colspan="3">有効状態チェック結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #KA}</td><td>&quot;0&quot;</td><td>可</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYUUITRATKIKA}</td><td>&quot;1&quot;</td><td>注意取扱可</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKA}</td><td>&quot;2&quot;</td><td>不可</td></tr>
 * </table>
 */
public class C_YuukoujyotaichkKbn extends Classification<C_YuukoujyotaichkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_YuukoujyotaichkKbn KA = new C_YuukoujyotaichkKbn("0");

    public static final C_YuukoujyotaichkKbn TYUUITRATKIKA = new C_YuukoujyotaichkKbn("1");

    public static final C_YuukoujyotaichkKbn HUKA = new C_YuukoujyotaichkKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, KA, "KA", true);
        addPattern(PATTERN_DEFAULT, TYUUITRATKIKA, "TYUUITRATKIKA", false);
        addPattern(PATTERN_DEFAULT, HUKA, "HUKA", false);


        lock(C_YuukoujyotaichkKbn.class);
    }

    private C_YuukoujyotaichkKbn(String value) {
        super(value);
    }

    public static C_YuukoujyotaichkKbn valueOf(String value) {
        return valueOf(C_YuukoujyotaichkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_YuukoujyotaichkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_YuukoujyotaichkKbn.class, patternId, value);
    }
}
