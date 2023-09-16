
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 支払方法指定区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ShrhousiteiKbn</td><td colspan="3">支払方法指定区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FB_YOKUJITU}</td><td>&quot;1&quot;</td><td>ＦＢ送金（翌営業日着金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FB_2EIGYOUBI}</td><td>&quot;2&quot;</td><td>ＦＢ送金（２営業日後着金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FB_3EIGYOUBI}</td><td>&quot;3&quot;</td><td>ＦＢ送金（３営業日後着金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KARIUKE_RISOKU_ARI}</td><td>&quot;4&quot;</td><td>仮受計上（遅延利息あり）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KARIUKE_RISOKU_NASI}</td><td>&quot;5&quot;</td><td>仮受計上（遅延利息なし）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FB_SOUDAIKAI_YOKUEI}</td><td>&quot;6&quot;</td><td>ＦＢ送金（総代会翌営業日着金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KARIUKE_RISOKU_ARI_SOUDAIKAI_YOKUEI}</td><td>&quot;7&quot;</td><td>仮受計上（遅延利息あり：総代会翌営業日）</td></tr>
 * </table>
 */
public class C_ShrhousiteiKbn extends Classification<C_ShrhousiteiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ShrhousiteiKbn BLNK = new C_ShrhousiteiKbn("0");

    public static final C_ShrhousiteiKbn FB_YOKUJITU = new C_ShrhousiteiKbn("1");

    public static final C_ShrhousiteiKbn FB_2EIGYOUBI = new C_ShrhousiteiKbn("2");

    public static final C_ShrhousiteiKbn FB_3EIGYOUBI = new C_ShrhousiteiKbn("3");

    public static final C_ShrhousiteiKbn KARIUKE_RISOKU_ARI = new C_ShrhousiteiKbn("4");

    public static final C_ShrhousiteiKbn KARIUKE_RISOKU_NASI = new C_ShrhousiteiKbn("5");

    public static final C_ShrhousiteiKbn FB_SOUDAIKAI_YOKUEI = new C_ShrhousiteiKbn("6");

    public static final C_ShrhousiteiKbn KARIUKE_RISOKU_ARI_SOUDAIKAI_YOKUEI = new C_ShrhousiteiKbn("7");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, FB_YOKUJITU, "FB_YOKUJITU", false);
        addPattern(PATTERN_DEFAULT, FB_2EIGYOUBI, "FB_2EIGYOUBI", false);
        addPattern(PATTERN_DEFAULT, FB_3EIGYOUBI, "FB_3EIGYOUBI", false);
        addPattern(PATTERN_DEFAULT, KARIUKE_RISOKU_ARI, "KARIUKE_RISOKU_ARI", false);
        addPattern(PATTERN_DEFAULT, KARIUKE_RISOKU_NASI, "KARIUKE_RISOKU_NASI", false);
        addPattern(PATTERN_DEFAULT, FB_SOUDAIKAI_YOKUEI, "FB_SOUDAIKAI_YOKUEI", false);
        addPattern(PATTERN_DEFAULT, KARIUKE_RISOKU_ARI_SOUDAIKAI_YOKUEI, "KARIUKE_RISOKU_ARI_SOUDAIKAI_YOKUEI", false);


        lock(C_ShrhousiteiKbn.class);
    }

    private C_ShrhousiteiKbn(String value) {
        super(value);
    }

    public static C_ShrhousiteiKbn valueOf(String value) {
        return valueOf(C_ShrhousiteiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ShrhousiteiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ShrhousiteiKbn.class, patternId, value);
    }
}
