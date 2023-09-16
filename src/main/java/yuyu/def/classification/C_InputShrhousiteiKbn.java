
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 入力用支払方法指定区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_InputShrhousiteiKbn</td><td colspan="3">入力用支払方法指定区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FBSOUKIN}</td><td>&quot;1&quot;</td><td>ＦＢ送金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KARIUKE_RISOKU_ARI}</td><td>&quot;2&quot;</td><td>仮受計上（遅延利息あり）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KARIUKE_RISOKU_NASI}</td><td>&quot;3&quot;</td><td>仮受計上（遅延利息なし）</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_KHOZEN KHOZEN}<br />(契約保全)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FBSOUKIN}</td><td>&quot;1&quot;</td><td>ＦＢ送金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KARIUKE_RISOKU_NASI}</td><td>&quot;3&quot;</td><td>仮受計上（遅延利息なし）</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_NOFBSOUKIN NOFBSOUKIN}<br />(FB送金無し)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KARIUKE_RISOKU_ARI}</td><td>&quot;2&quot;</td><td>仮受計上（遅延利息あり）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KARIUKE_RISOKU_NASI}</td><td>&quot;3&quot;</td><td>仮受計上（遅延利息なし）</td></tr>
 * </table>
 */
public class C_InputShrhousiteiKbn extends Classification<C_InputShrhousiteiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_InputShrhousiteiKbn BLNK = new C_InputShrhousiteiKbn("0");

    public static final C_InputShrhousiteiKbn FBSOUKIN = new C_InputShrhousiteiKbn("1");

    public static final C_InputShrhousiteiKbn KARIUKE_RISOKU_ARI = new C_InputShrhousiteiKbn("2");

    public static final C_InputShrhousiteiKbn KARIUKE_RISOKU_NASI = new C_InputShrhousiteiKbn("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_KHOZEN = "2";

    public static final String PATTERN_NOFBSOUKIN = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, FBSOUKIN, "FBSOUKIN", false);
        addPattern(PATTERN_DEFAULT, KARIUKE_RISOKU_ARI, "KARIUKE_RISOKU_ARI", false);
        addPattern(PATTERN_DEFAULT, KARIUKE_RISOKU_NASI, "KARIUKE_RISOKU_NASI", false);


        addPattern(PATTERN_KHOZEN, BLNK, "BLNK", true);
        addPattern(PATTERN_KHOZEN, FBSOUKIN, "FBSOUKIN", false);
        addPattern(PATTERN_KHOZEN, KARIUKE_RISOKU_NASI, "KARIUKE_RISOKU_NASI", false);


        addPattern(PATTERN_NOFBSOUKIN, BLNK, "BLNK", true);
        addPattern(PATTERN_NOFBSOUKIN, KARIUKE_RISOKU_ARI, "KARIUKE_RISOKU_ARI", false);
        addPattern(PATTERN_NOFBSOUKIN, KARIUKE_RISOKU_NASI, "KARIUKE_RISOKU_NASI", false);


        lock(C_InputShrhousiteiKbn.class);
    }

    private C_InputShrhousiteiKbn(String value) {
        super(value);
    }

    public static C_InputShrhousiteiKbn valueOf(String value) {
        return valueOf(C_InputShrhousiteiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_InputShrhousiteiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_InputShrhousiteiKbn.class, patternId, value);
    }
}
