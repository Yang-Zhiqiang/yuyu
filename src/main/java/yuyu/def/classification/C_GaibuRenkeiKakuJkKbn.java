
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 外部連携確認状況区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_GaibuRenkeiKakuJkKbn</td><td colspan="3">外部連携確認状況区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MISYORI}</td><td>&quot;0&quot;</td><td>未処理</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUSINZUMI}</td><td>&quot;1&quot;</td><td>送信済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HANEIZUMI}</td><td>&quot;2&quot;</td><td>反映済</td></tr>
 * </table>
 */
public class C_GaibuRenkeiKakuJkKbn extends Classification<C_GaibuRenkeiKakuJkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_GaibuRenkeiKakuJkKbn MISYORI = new C_GaibuRenkeiKakuJkKbn("0");

    public static final C_GaibuRenkeiKakuJkKbn SOUSINZUMI = new C_GaibuRenkeiKakuJkKbn("1");

    public static final C_GaibuRenkeiKakuJkKbn HANEIZUMI = new C_GaibuRenkeiKakuJkKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MISYORI, "MISYORI", true);
        addPattern(PATTERN_DEFAULT, SOUSINZUMI, "SOUSINZUMI", false);
        addPattern(PATTERN_DEFAULT, HANEIZUMI, "HANEIZUMI", false);


        lock(C_GaibuRenkeiKakuJkKbn.class);
    }

    private C_GaibuRenkeiKakuJkKbn(String value) {
        super(value);
    }

    public static C_GaibuRenkeiKakuJkKbn valueOf(String value) {
        return valueOf(C_GaibuRenkeiKakuJkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_GaibuRenkeiKakuJkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_GaibuRenkeiKakuJkKbn.class, patternId, value);
    }
}
