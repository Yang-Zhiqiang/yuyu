
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 検索用原本返却有無 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KensakuyouGenponHnkykumu</td><td colspan="3">検索用原本返却有無</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ARI}</td><td>&quot;1&quot;</td><td>あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;2&quot;</td><td>なし</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_KANJI KANJI}<br />(漢字)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ARI}</td><td>&quot;1&quot;</td><td>有</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;2&quot;</td><td>無</td></tr>
 * </table>
 */
public class C_KensakuyouGenponHnkykumu extends Classification<C_KensakuyouGenponHnkykumu> {

    private static final long serialVersionUID = 1L;


    public static final C_KensakuyouGenponHnkykumu BLNK = new C_KensakuyouGenponHnkykumu("0");

    public static final C_KensakuyouGenponHnkykumu ARI = new C_KensakuyouGenponHnkykumu("1");

    public static final C_KensakuyouGenponHnkykumu NONE = new C_KensakuyouGenponHnkykumu("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_KANJI = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ARI, "ARI", false);
        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);


        addPattern(PATTERN_KANJI, BLNK, "BLNK", true);
        addPattern(PATTERN_KANJI, ARI, "ARI", false);
        addPattern(PATTERN_KANJI, NONE, "NONE", false);


        lock(C_KensakuyouGenponHnkykumu.class);
    }

    private C_KensakuyouGenponHnkykumu(String value) {
        super(value);
    }

    public static C_KensakuyouGenponHnkykumu valueOf(String value) {
        return valueOf(C_KensakuyouGenponHnkykumu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KensakuyouGenponHnkykumu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KensakuyouGenponHnkykumu.class, patternId, value);
    }
}
