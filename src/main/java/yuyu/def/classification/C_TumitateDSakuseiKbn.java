
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 積立Ｄ作成区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TumitateDSakuseiKbn</td><td colspan="3">積立Ｄ作成区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RISOKUKURIIRE}</td><td>&quot;1&quot;</td><td>利息繰入</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEISIKI}</td><td>&quot;2&quot;</td><td>正式割当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTHNKSEISIKI}</td><td>&quot;3&quot;</td><td>円建変更時正式割当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENHIKIDASI}</td><td>&quot;10&quot;</td><td>全額引出</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIBUHIKIDASI}</td><td>&quot;11&quot;</td><td>一部引出</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENHIKIDASI}</td><td>&quot;10&quot;</td><td>全額引出</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIBUHIKIDASI}</td><td>&quot;11&quot;</td><td>一部引出</td></tr>
 * </table>
 */
public class C_TumitateDSakuseiKbn extends Classification<C_TumitateDSakuseiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TumitateDSakuseiKbn BLNK = new C_TumitateDSakuseiKbn("0");

    public static final C_TumitateDSakuseiKbn RISOKUKURIIRE = new C_TumitateDSakuseiKbn("1");

    public static final C_TumitateDSakuseiKbn SEISIKI = new C_TumitateDSakuseiKbn("2");

    public static final C_TumitateDSakuseiKbn YENDTHNKSEISIKI = new C_TumitateDSakuseiKbn("3");

    public static final C_TumitateDSakuseiKbn ZENHIKIDASI = new C_TumitateDSakuseiKbn("10");

    public static final C_TumitateDSakuseiKbn ITIBUHIKIDASI = new C_TumitateDSakuseiKbn("11");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, RISOKUKURIIRE, "RISOKUKURIIRE", false);
        addPattern(PATTERN_DEFAULT, SEISIKI, "SEISIKI", false);
        addPattern(PATTERN_DEFAULT, YENDTHNKSEISIKI, "YENDTHNKSEISIKI", false);
        addPattern(PATTERN_DEFAULT, ZENHIKIDASI, "ZENHIKIDASI", false);
        addPattern(PATTERN_DEFAULT, ITIBUHIKIDASI, "ITIBUHIKIDASI", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, ZENHIKIDASI, "ZENHIKIDASI", false);
        addPattern(PATTERN_SELECT, ITIBUHIKIDASI, "ITIBUHIKIDASI", false);


        lock(C_TumitateDSakuseiKbn.class);
    }

    private C_TumitateDSakuseiKbn(String value) {
        super(value);
    }

    public static C_TumitateDSakuseiKbn valueOf(String value) {
        return valueOf(C_TumitateDSakuseiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TumitateDSakuseiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TumitateDSakuseiKbn.class, patternId, value);
    }
}
