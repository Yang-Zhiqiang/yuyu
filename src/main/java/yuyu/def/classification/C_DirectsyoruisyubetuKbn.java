
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ダイレクト書類種別区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DirectsyoruisyubetuKbn</td><td colspan="3">ダイレクト書類種別区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="10">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENMOSNAIYOU}</td><td>&quot;1&quot;</td><td>全お申込み内容</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOSNAIYOU}</td><td>&quot;2&quot;</td><td>お申込み内容</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKOKAKNAIYOU}</td><td>&quot;3&quot;</td><td>意向確認内容</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOKNAIYOU}</td><td>&quot;4&quot;</td><td>告知内容</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKGAIYOU}</td><td>&quot;5&quot;</td><td>契約概要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JUYOUJIKOU}</td><td>&quot;6&quot;</td><td>重要事項</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YAKKAN}</td><td>&quot;7&quot;</td><td>約款</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TKJKYKSIORI}</td><td>&quot;8&quot;</td><td>特別条件付契約のしおり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANSYOUTIRASI}</td><td>&quot;9&quot;</td><td>勧奨チラシ</td></tr>
 * </table>
 */
public class C_DirectsyoruisyubetuKbn extends Classification<C_DirectsyoruisyubetuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DirectsyoruisyubetuKbn BLNK = new C_DirectsyoruisyubetuKbn("0");

    public static final C_DirectsyoruisyubetuKbn ZENMOSNAIYOU = new C_DirectsyoruisyubetuKbn("1");

    public static final C_DirectsyoruisyubetuKbn MOSNAIYOU = new C_DirectsyoruisyubetuKbn("2");

    public static final C_DirectsyoruisyubetuKbn IKOKAKNAIYOU = new C_DirectsyoruisyubetuKbn("3");

    public static final C_DirectsyoruisyubetuKbn KOKNAIYOU = new C_DirectsyoruisyubetuKbn("4");

    public static final C_DirectsyoruisyubetuKbn KYKGAIYOU = new C_DirectsyoruisyubetuKbn("5");

    public static final C_DirectsyoruisyubetuKbn JUYOUJIKOU = new C_DirectsyoruisyubetuKbn("6");

    public static final C_DirectsyoruisyubetuKbn YAKKAN = new C_DirectsyoruisyubetuKbn("7");

    public static final C_DirectsyoruisyubetuKbn TKJKYKSIORI = new C_DirectsyoruisyubetuKbn("8");

    public static final C_DirectsyoruisyubetuKbn KANSYOUTIRASI = new C_DirectsyoruisyubetuKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ZENMOSNAIYOU, "ZENMOSNAIYOU", false);
        addPattern(PATTERN_DEFAULT, MOSNAIYOU, "MOSNAIYOU", false);
        addPattern(PATTERN_DEFAULT, IKOKAKNAIYOU, "IKOKAKNAIYOU", false);
        addPattern(PATTERN_DEFAULT, KOKNAIYOU, "KOKNAIYOU", false);
        addPattern(PATTERN_DEFAULT, KYKGAIYOU, "KYKGAIYOU", false);
        addPattern(PATTERN_DEFAULT, JUYOUJIKOU, "JUYOUJIKOU", false);
        addPattern(PATTERN_DEFAULT, YAKKAN, "YAKKAN", false);
        addPattern(PATTERN_DEFAULT, TKJKYKSIORI, "TKJKYKSIORI", false);
        addPattern(PATTERN_DEFAULT, KANSYOUTIRASI, "KANSYOUTIRASI", false);


        lock(C_DirectsyoruisyubetuKbn.class);
    }

    private C_DirectsyoruisyubetuKbn(String value) {
        super(value);
    }

    public static C_DirectsyoruisyubetuKbn valueOf(String value) {
        return valueOf(C_DirectsyoruisyubetuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DirectsyoruisyubetuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DirectsyoruisyubetuKbn.class, patternId, value);
    }
}
