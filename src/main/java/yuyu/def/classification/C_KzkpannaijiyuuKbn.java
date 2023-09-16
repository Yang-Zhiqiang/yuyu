
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 継続Ｐ案内事由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KzkpannaijiyuuKbn</td><td colspan="3">継続Ｐ案内事由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CSSHUBI}</td><td>&quot;1&quot;</td><td>ＣＳＳ不備</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDITNG_SKEI}</td><td>&quot;2&quot;</td><td>（新）クレカＮＧ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDITNG_KEIZOKU}</td><td>&quot;3&quot;</td><td>（継）クレカＮＧ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YKNSYATUGOU}</td><td>&quot;4&quot;</td><td>預金者都合</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;9&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CSSHUBI}</td><td>&quot;1&quot;</td><td>ＣＳＳ不備</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YKNSYATUGOU}</td><td>&quot;4&quot;</td><td>預金者都合</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;9&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_KzkpannaijiyuuKbn extends Classification<C_KzkpannaijiyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KzkpannaijiyuuKbn BLNK = new C_KzkpannaijiyuuKbn("0");

    public static final C_KzkpannaijiyuuKbn CSSHUBI = new C_KzkpannaijiyuuKbn("1");

    public static final C_KzkpannaijiyuuKbn CREDITNG_SKEI = new C_KzkpannaijiyuuKbn("2");

    public static final C_KzkpannaijiyuuKbn CREDITNG_KEIZOKU = new C_KzkpannaijiyuuKbn("3");

    public static final C_KzkpannaijiyuuKbn YKNSYATUGOU = new C_KzkpannaijiyuuKbn("4");

    public static final C_KzkpannaijiyuuKbn SONOTA = new C_KzkpannaijiyuuKbn("9");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, CSSHUBI, "CSSHUBI", false);
        addPattern(PATTERN_DEFAULT, CREDITNG_SKEI, "CREDITNG_SKEI", false);
        addPattern(PATTERN_DEFAULT, CREDITNG_KEIZOKU, "CREDITNG_KEIZOKU", false);
        addPattern(PATTERN_DEFAULT, YKNSYATUGOU, "YKNSYATUGOU", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, CSSHUBI, "CSSHUBI", false);
        addPattern(PATTERN_SELECT, YKNSYATUGOU, "YKNSYATUGOU", false);
        addPattern(PATTERN_SELECT, SONOTA, "SONOTA", false);


        lock(C_KzkpannaijiyuuKbn.class);
    }

    private C_KzkpannaijiyuuKbn(String value) {
        super(value);
    }

    public static C_KzkpannaijiyuuKbn valueOf(String value) {
        return valueOf(C_KzkpannaijiyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KzkpannaijiyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KzkpannaijiyuuKbn.class, patternId, value);
    }
}
