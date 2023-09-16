
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 端末使用区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TanmatuSiyouKbn</td><td colspan="3">端末使用区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUGOU_IPPAN}</td><td>&quot;1&quot;</td><td>総合・一般</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;2&quot;</td><td>その他</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WITHKANRISYSTEM}</td><td>&quot;3&quot;</td><td>Ｗｉｔｈ管理システム</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIKANJIMU}</td><td>&quot;5&quot;</td><td>機関事務</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHIBUTYOU}</td><td>&quot;6&quot;</td><td>支部長</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EIGYOUSYOKUIN}</td><td>&quot;7&quot;</td><td>営業職員</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIRITENBOSYUUNIN}</td><td>&quot;8&quot;</td><td>代理店募集人</td></tr>
 * </table>
 */
public class C_TanmatuSiyouKbn extends Classification<C_TanmatuSiyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TanmatuSiyouKbn BLNK = new C_TanmatuSiyouKbn("0");

    public static final C_TanmatuSiyouKbn SOUGOU_IPPAN = new C_TanmatuSiyouKbn("1");

    public static final C_TanmatuSiyouKbn SONOTA = new C_TanmatuSiyouKbn("2");

    public static final C_TanmatuSiyouKbn WITHKANRISYSTEM = new C_TanmatuSiyouKbn("3");

    public static final C_TanmatuSiyouKbn KIKANJIMU = new C_TanmatuSiyouKbn("5");

    public static final C_TanmatuSiyouKbn SHIBUTYOU = new C_TanmatuSiyouKbn("6");

    public static final C_TanmatuSiyouKbn EIGYOUSYOKUIN = new C_TanmatuSiyouKbn("7");

    public static final C_TanmatuSiyouKbn DAIRITENBOSYUUNIN = new C_TanmatuSiyouKbn("8");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SOUGOU_IPPAN, "SOUGOU_IPPAN", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);
        addPattern(PATTERN_DEFAULT, WITHKANRISYSTEM, "WITHKANRISYSTEM", false);
        addPattern(PATTERN_DEFAULT, KIKANJIMU, "KIKANJIMU", false);
        addPattern(PATTERN_DEFAULT, SHIBUTYOU, "SHIBUTYOU", false);
        addPattern(PATTERN_DEFAULT, EIGYOUSYOKUIN, "EIGYOUSYOKUIN", false);
        addPattern(PATTERN_DEFAULT, DAIRITENBOSYUUNIN, "DAIRITENBOSYUUNIN", false);


        lock(C_TanmatuSiyouKbn.class);
    }

    private C_TanmatuSiyouKbn(String value) {
        super(value);
    }

    public static C_TanmatuSiyouKbn valueOf(String value) {
        return valueOf(C_TanmatuSiyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TanmatuSiyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TanmatuSiyouKbn.class, patternId, value);
    }
}
