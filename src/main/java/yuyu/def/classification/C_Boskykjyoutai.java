
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 募集契約状態 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Boskykjyoutai</td><td colspan="3">募集契約状態</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUUJYOUKYK}</td><td>&quot;1&quot;</td><td>通常契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIKOKYK}</td><td>&quot;2&quot;</td><td>自己契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKKYK}</td><td>&quot;3&quot;</td><td>特定契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUSEIINKYK}</td><td>&quot;4&quot;</td><td>構成員契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HEIGAIBOUSISOTIKYK}</td><td>&quot;5&quot;</td><td>弊害防止措置契約</td></tr>
 * </table>
 */
public class C_Boskykjyoutai extends Classification<C_Boskykjyoutai> {

    private static final long serialVersionUID = 1L;


    public static final C_Boskykjyoutai BLNK = new C_Boskykjyoutai("0");

    public static final C_Boskykjyoutai TUUJYOUKYK = new C_Boskykjyoutai("1");

    public static final C_Boskykjyoutai JIKOKYK = new C_Boskykjyoutai("2");

    public static final C_Boskykjyoutai TOKKYK = new C_Boskykjyoutai("3");

    public static final C_Boskykjyoutai KOUSEIINKYK = new C_Boskykjyoutai("4");

    public static final C_Boskykjyoutai HEIGAIBOUSISOTIKYK = new C_Boskykjyoutai("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TUUJYOUKYK, "TUUJYOUKYK", false);
        addPattern(PATTERN_DEFAULT, JIKOKYK, "JIKOKYK", false);
        addPattern(PATTERN_DEFAULT, TOKKYK, "TOKKYK", false);
        addPattern(PATTERN_DEFAULT, KOUSEIINKYK, "KOUSEIINKYK", false);
        addPattern(PATTERN_DEFAULT, HEIGAIBOUSISOTIKYK, "HEIGAIBOUSISOTIKYK", false);


        lock(C_Boskykjyoutai.class);
    }

    private C_Boskykjyoutai(String value) {
        super(value);
    }

    public static C_Boskykjyoutai valueOf(String value) {
        return valueOf(C_Boskykjyoutai.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Boskykjyoutai.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Boskykjyoutai.class, patternId, value);
    }
}
