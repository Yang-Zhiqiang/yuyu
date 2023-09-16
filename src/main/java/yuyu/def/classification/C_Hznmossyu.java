
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 保全申込手続き種類 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Hznmossyu</td><td colspan="3">保全申込手続き種類</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #ADRHNK}</td><td>&quot;1&quot;</td><td>住所変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HARAIHK}</td><td>&quot;2&quot;</td><td>払込方法変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIGIHNK}</td><td>&quot;3&quot;</td><td>名義変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUJYOSYOUMEI}</td><td>&quot;4&quot;</td><td>控除証明書再発行</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_HYOUJI HYOUJI}<br />(保全受付画面)</td><td align="center">&nbsp;</td><td>{@link #ADRHNK}</td><td>&quot;1&quot;</td><td>住所変更（電話番号変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HARAIHK}</td><td>&quot;2&quot;</td><td>保険料払込方法・口座の変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIGIHNK}</td><td>&quot;3&quot;</td><td>名義変更・改姓</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUJYOSYOUMEI}</td><td>&quot;4&quot;</td><td>生命保険料控除証明書の再発行</td></tr>
 * </table>
 */
public class C_Hznmossyu extends Classification<C_Hznmossyu> {

    private static final long serialVersionUID = 1L;


    public static final C_Hznmossyu ADRHNK = new C_Hznmossyu("1");

    public static final C_Hznmossyu HARAIHK = new C_Hznmossyu("2");

    public static final C_Hznmossyu MEIGIHNK = new C_Hznmossyu("3");

    public static final C_Hznmossyu KOUJYOSYOUMEI = new C_Hznmossyu("4");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_HYOUJI = "2";


    static {

        addPattern(PATTERN_DEFAULT, ADRHNK, "ADRHNK", true);
        addPattern(PATTERN_DEFAULT, HARAIHK, "HARAIHK", false);
        addPattern(PATTERN_DEFAULT, MEIGIHNK, "MEIGIHNK", false);
        addPattern(PATTERN_DEFAULT, KOUJYOSYOUMEI, "KOUJYOSYOUMEI", false);


        addPattern(PATTERN_HYOUJI, ADRHNK, "ADRHNK", false);
        addPattern(PATTERN_HYOUJI, HARAIHK, "HARAIHK", false);
        addPattern(PATTERN_HYOUJI, MEIGIHNK, "MEIGIHNK", false);
        addPattern(PATTERN_HYOUJI, KOUJYOSYOUMEI, "KOUJYOSYOUMEI", false);


        lock(C_Hznmossyu.class);
    }

    private C_Hznmossyu(String value) {
        super(value);
    }

    public static C_Hznmossyu valueOf(String value) {
        return valueOf(C_Hznmossyu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Hznmossyu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Hznmossyu.class, patternId, value);
    }
}
