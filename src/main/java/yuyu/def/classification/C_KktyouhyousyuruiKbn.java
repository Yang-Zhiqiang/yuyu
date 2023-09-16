
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 契約管理帳票種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KktyouhyousyuruiKbn</td><td colspan="3">契約管理帳票種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HKNSYKN}</td><td>&quot;1&quot;</td><td>保険証券</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUJYOSYOUMEI}</td><td>&quot;2&quot;</td><td>控除証明書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TTDKKANRYOU}</td><td>&quot;20&quot;</td><td>お手続完了のお知らせ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIMURENRAKU}</td><td>&quot;30&quot;</td><td>事務連絡票</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GSTYSYLIST}</td><td>&quot;52&quot;</td><td>源泉徴収リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKTRKMMISSLIST}</td><td>&quot;91&quot;</td><td>契約情報取込ミスリスト</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TTDKKANRYOU}</td><td>&quot;20&quot;</td><td>お手続完了のお知らせ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GSTYSYLIST}</td><td>&quot;52&quot;</td><td>源泉徴収リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKTRKMMISSLIST}</td><td>&quot;91&quot;</td><td>契約情報取込ミスリスト</td></tr>
 * </table>
 */
public class C_KktyouhyousyuruiKbn extends Classification<C_KktyouhyousyuruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KktyouhyousyuruiKbn BLNK = new C_KktyouhyousyuruiKbn("0");

    public static final C_KktyouhyousyuruiKbn HKNSYKN = new C_KktyouhyousyuruiKbn("1");

    public static final C_KktyouhyousyuruiKbn KOUJYOSYOUMEI = new C_KktyouhyousyuruiKbn("2");

    public static final C_KktyouhyousyuruiKbn TTDKKANRYOU = new C_KktyouhyousyuruiKbn("20");

    public static final C_KktyouhyousyuruiKbn JIMURENRAKU = new C_KktyouhyousyuruiKbn("30");

    public static final C_KktyouhyousyuruiKbn GSTYSYLIST = new C_KktyouhyousyuruiKbn("52");

    public static final C_KktyouhyousyuruiKbn KYKTRKMMISSLIST = new C_KktyouhyousyuruiKbn("91");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HKNSYKN, "HKNSYKN", false);
        addPattern(PATTERN_DEFAULT, KOUJYOSYOUMEI, "KOUJYOSYOUMEI", false);
        addPattern(PATTERN_DEFAULT, TTDKKANRYOU, "TTDKKANRYOU", false);
        addPattern(PATTERN_DEFAULT, JIMURENRAKU, "JIMURENRAKU", false);
        addPattern(PATTERN_DEFAULT, GSTYSYLIST, "GSTYSYLIST", false);
        addPattern(PATTERN_DEFAULT, KYKTRKMMISSLIST, "KYKTRKMMISSLIST", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, TTDKKANRYOU, "TTDKKANRYOU", false);
        addPattern(PATTERN_SELECT, GSTYSYLIST, "GSTYSYLIST", false);
        addPattern(PATTERN_SELECT, KYKTRKMMISSLIST, "KYKTRKMMISSLIST", false);


        lock(C_KktyouhyousyuruiKbn.class);
    }

    private C_KktyouhyousyuruiKbn(String value) {
        super(value);
    }

    public static C_KktyouhyousyuruiKbn valueOf(String value) {
        return valueOf(C_KktyouhyousyuruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KktyouhyousyuruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KktyouhyousyuruiKbn.class, patternId, value);
    }
}
