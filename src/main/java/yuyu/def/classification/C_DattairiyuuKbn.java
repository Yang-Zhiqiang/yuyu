
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 脱退理由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DattairiyuuKbn</td><td colspan="3">脱退理由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRHENKIBOU}</td><td>&quot;1&quot;</td><td>払変希望</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKUKIBOU}</td><td>&quot;2&quot;</td><td>解約希望</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CSSKOUHURIIRHUBI}</td><td>&quot;3&quot;</td><td>ＣＳＳ口座振替依頼書不備・整備要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIYAKUHENKOUARI}</td><td>&quot;4&quot;</td><td>契約変更あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OTHER}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #HRHENKIBOU}</td><td>&quot;1&quot;</td><td>払変希望</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CSSKOUHURIIRHUBI}</td><td>&quot;3&quot;</td><td>ＣＳＳ口座振替依頼書不備・整備要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIYAKUHENKOUARI}</td><td>&quot;4&quot;</td><td>契約変更あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKUKIBOU}</td><td>&quot;2&quot;</td><td>解約希望</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OTHER}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_DattairiyuuKbn extends Classification<C_DattairiyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DattairiyuuKbn BLNK = new C_DattairiyuuKbn("0");

    public static final C_DattairiyuuKbn HRHENKIBOU = new C_DattairiyuuKbn("1");

    public static final C_DattairiyuuKbn KAIYAKUKIBOU = new C_DattairiyuuKbn("2");

    public static final C_DattairiyuuKbn CSSKOUHURIIRHUBI = new C_DattairiyuuKbn("3");

    public static final C_DattairiyuuKbn KEIYAKUHENKOUARI = new C_DattairiyuuKbn("4");

    public static final C_DattairiyuuKbn OTHER = new C_DattairiyuuKbn("99");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HRHENKIBOU, "HRHENKIBOU", false);
        addPattern(PATTERN_DEFAULT, KAIYAKUKIBOU, "KAIYAKUKIBOU", false);
        addPattern(PATTERN_DEFAULT, CSSKOUHURIIRHUBI, "CSSKOUHURIIRHUBI", false);
        addPattern(PATTERN_DEFAULT, KEIYAKUHENKOUARI, "KEIYAKUHENKOUARI", false);
        addPattern(PATTERN_DEFAULT, OTHER, "OTHER", false);


        addPattern(PATTERN_SELECT, HRHENKIBOU, "HRHENKIBOU", true);
        addPattern(PATTERN_SELECT, CSSKOUHURIIRHUBI, "CSSKOUHURIIRHUBI", false);
        addPattern(PATTERN_SELECT, KEIYAKUHENKOUARI, "KEIYAKUHENKOUARI", false);
        addPattern(PATTERN_SELECT, KAIYAKUKIBOU, "KAIYAKUKIBOU", false);
        addPattern(PATTERN_SELECT, OTHER, "OTHER", false);


        lock(C_DattairiyuuKbn.class);
    }

    private C_DattairiyuuKbn(String value) {
        super(value);
    }

    public static C_DattairiyuuKbn valueOf(String value) {
        return valueOf(C_DattairiyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DattairiyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DattairiyuuKbn.class, patternId, value);
    }
}
