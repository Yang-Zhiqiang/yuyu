
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 控除証明作成処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KoujyosyoumeisakuseisyoriKbn</td><td colspan="3">控除証明作成処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENSYOUKEN}</td><td>&quot;1&quot;</td><td>保険証券</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUJYOSYOUMEISYO_PDF}</td><td>&quot;2&quot;</td><td>控除証明書（ＰＤＦ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUJYOSYOUMEISYO_GAIBU}</td><td>&quot;3&quot;</td><td>控除証明書（外部印刷）</td></tr>
 * </table>
 */
public class C_KoujyosyoumeisakuseisyoriKbn extends Classification<C_KoujyosyoumeisakuseisyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KoujyosyoumeisakuseisyoriKbn BLNK = new C_KoujyosyoumeisakuseisyoriKbn("0");

    public static final C_KoujyosyoumeisakuseisyoriKbn HOKENSYOUKEN = new C_KoujyosyoumeisakuseisyoriKbn("1");

    public static final C_KoujyosyoumeisakuseisyoriKbn KOUJYOSYOUMEISYO_PDF = new C_KoujyosyoumeisakuseisyoriKbn("2");

    public static final C_KoujyosyoumeisakuseisyoriKbn KOUJYOSYOUMEISYO_GAIBU = new C_KoujyosyoumeisakuseisyoriKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HOKENSYOUKEN, "HOKENSYOUKEN", false);
        addPattern(PATTERN_DEFAULT, KOUJYOSYOUMEISYO_PDF, "KOUJYOSYOUMEISYO_PDF", false);
        addPattern(PATTERN_DEFAULT, KOUJYOSYOUMEISYO_GAIBU, "KOUJYOSYOUMEISYO_GAIBU", false);


        lock(C_KoujyosyoumeisakuseisyoriKbn.class);
    }

    private C_KoujyosyoumeisakuseisyoriKbn(String value) {
        super(value);
    }

    public static C_KoujyosyoumeisakuseisyoriKbn valueOf(String value) {
        return valueOf(C_KoujyosyoumeisakuseisyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KoujyosyoumeisakuseisyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KoujyosyoumeisakuseisyoriKbn.class, patternId, value);
    }
}
