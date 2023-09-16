
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 控除証明選択区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KoujyosyoumeisentakuKbn</td><td colspan="3">控除証明選択区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLANK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HAGAKI}</td><td>&quot;1&quot;</td><td>控除証明書（はがき）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DENSI}</td><td>&quot;2&quot;</td><td>電子的控除証明データ</td></tr>
 * </table>
 */
public class C_KoujyosyoumeisentakuKbn extends Classification<C_KoujyosyoumeisentakuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KoujyosyoumeisentakuKbn BLANK = new C_KoujyosyoumeisentakuKbn("0");

    public static final C_KoujyosyoumeisentakuKbn HAGAKI = new C_KoujyosyoumeisentakuKbn("1");

    public static final C_KoujyosyoumeisentakuKbn DENSI = new C_KoujyosyoumeisentakuKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLANK, "BLANK", true);
        addPattern(PATTERN_DEFAULT, HAGAKI, "HAGAKI", false);
        addPattern(PATTERN_DEFAULT, DENSI, "DENSI", false);


        lock(C_KoujyosyoumeisentakuKbn.class);
    }

    private C_KoujyosyoumeisentakuKbn(String value) {
        super(value);
    }

    public static C_KoujyosyoumeisentakuKbn valueOf(String value) {
        return valueOf(C_KoujyosyoumeisentakuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KoujyosyoumeisentakuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KoujyosyoumeisentakuKbn.class, patternId, value);
    }
}
