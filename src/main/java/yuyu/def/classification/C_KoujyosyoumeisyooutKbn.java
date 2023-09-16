
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 控除証明書出力区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KoujyosyoumeisyooutKbn</td><td colspan="3">控除証明書出力区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLANK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PDF}</td><td>&quot;1&quot;</td><td>PDF</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HAGAKI}</td><td>&quot;2&quot;</td><td>外部印刷（見開きはがき）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DENSI}</td><td>&quot;3&quot;</td><td>電子的控除証明書受付</td></tr>
 * </table>
 */
public class C_KoujyosyoumeisyooutKbn extends Classification<C_KoujyosyoumeisyooutKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KoujyosyoumeisyooutKbn BLANK = new C_KoujyosyoumeisyooutKbn("0");

    public static final C_KoujyosyoumeisyooutKbn PDF = new C_KoujyosyoumeisyooutKbn("1");

    public static final C_KoujyosyoumeisyooutKbn HAGAKI = new C_KoujyosyoumeisyooutKbn("2");

    public static final C_KoujyosyoumeisyooutKbn DENSI = new C_KoujyosyoumeisyooutKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLANK, "BLANK", true);
        addPattern(PATTERN_DEFAULT, PDF, "PDF", false);
        addPattern(PATTERN_DEFAULT, HAGAKI, "HAGAKI", false);
        addPattern(PATTERN_DEFAULT, DENSI, "DENSI", false);


        lock(C_KoujyosyoumeisyooutKbn.class);
    }

    private C_KoujyosyoumeisyooutKbn(String value) {
        super(value);
    }

    public static C_KoujyosyoumeisyooutKbn valueOf(String value) {
        return valueOf(C_KoujyosyoumeisyooutKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KoujyosyoumeisyooutKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KoujyosyoumeisyooutKbn.class, patternId, value);
    }
}
