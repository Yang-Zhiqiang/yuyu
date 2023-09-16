
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 契約確認状況区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KykkakjkKbn</td><td colspan="3">契約確認状況区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>未判定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KETMAE_KAKUNIN_TAISY}</td><td>&quot;1&quot;</td><td>決定前契約確認対象外</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KETMAE_KAKUNIN}</td><td>&quot;2&quot;</td><td>決定前契約確認中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KETHORYU_KAKUNIN}</td><td>&quot;3&quot;</td><td>決定保留契約確認中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAKUNIN_SUMI}</td><td>&quot;4&quot;</td><td>契約確認済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIRITUGO_KAK_IRAISU}</td><td>&quot;5&quot;</td><td>成立後契約確認依頼済</td></tr>
 * </table>
 */
public class C_KykkakjkKbn extends Classification<C_KykkakjkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KykkakjkKbn NONE = new C_KykkakjkKbn("0");

    public static final C_KykkakjkKbn KETMAE_KAKUNIN_TAISY = new C_KykkakjkKbn("1");

    public static final C_KykkakjkKbn KETMAE_KAKUNIN = new C_KykkakjkKbn("2");

    public static final C_KykkakjkKbn KETHORYU_KAKUNIN = new C_KykkakjkKbn("3");

    public static final C_KykkakjkKbn KAKUNIN_SUMI = new C_KykkakjkKbn("4");

    public static final C_KykkakjkKbn SEIRITUGO_KAK_IRAISU = new C_KykkakjkKbn("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, KETMAE_KAKUNIN_TAISY, "KETMAE_KAKUNIN_TAISY", false);
        addPattern(PATTERN_DEFAULT, KETMAE_KAKUNIN, "KETMAE_KAKUNIN", false);
        addPattern(PATTERN_DEFAULT, KETHORYU_KAKUNIN, "KETHORYU_KAKUNIN", false);
        addPattern(PATTERN_DEFAULT, KAKUNIN_SUMI, "KAKUNIN_SUMI", false);
        addPattern(PATTERN_DEFAULT, SEIRITUGO_KAK_IRAISU, "SEIRITUGO_KAK_IRAISU", false);


        lock(C_KykkakjkKbn.class);
    }

    private C_KykkakjkKbn(String value) {
        super(value);
    }

    public static C_KykkakjkKbn valueOf(String value) {
        return valueOf(C_KykkakjkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KykkakjkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KykkakjkKbn.class, patternId, value);
    }
}
