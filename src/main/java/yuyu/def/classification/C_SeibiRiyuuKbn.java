
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 整備理由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SeibiRiyuuKbn</td><td colspan="3">整備理由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLANK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIRITU}</td><td>&quot;1&quot;</td><td>成立</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIGI_HENKOU}</td><td>&quot;2&quot;</td><td>名義変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JYUUSYO_HENKOU}</td><td>&quot;3&quot;</td><td>住所変更</td></tr>
 * </table>
 */
public class C_SeibiRiyuuKbn extends Classification<C_SeibiRiyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SeibiRiyuuKbn BLANK = new C_SeibiRiyuuKbn("0");

    public static final C_SeibiRiyuuKbn SEIRITU = new C_SeibiRiyuuKbn("1");

    public static final C_SeibiRiyuuKbn MEIGI_HENKOU = new C_SeibiRiyuuKbn("2");

    public static final C_SeibiRiyuuKbn JYUUSYO_HENKOU = new C_SeibiRiyuuKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLANK, "BLANK", true);
        addPattern(PATTERN_DEFAULT, SEIRITU, "SEIRITU", false);
        addPattern(PATTERN_DEFAULT, MEIGI_HENKOU, "MEIGI_HENKOU", false);
        addPattern(PATTERN_DEFAULT, JYUUSYO_HENKOU, "JYUUSYO_HENKOU", false);


        lock(C_SeibiRiyuuKbn.class);
    }

    private C_SeibiRiyuuKbn(String value) {
        super(value);
    }

    public static C_SeibiRiyuuKbn valueOf(String value) {
        return valueOf(C_SeibiRiyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SeibiRiyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SeibiRiyuuKbn.class, patternId, value);
    }
}
