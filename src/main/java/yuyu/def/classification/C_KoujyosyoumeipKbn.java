
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 控除証明保険料区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KoujyosyoumeipKbn</td><td colspan="3">控除証明保険料区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IPPAN}</td><td>&quot;1&quot;</td><td>一般</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIGOIRYOU}</td><td>&quot;2&quot;</td><td>介護医療</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKIN}</td><td>&quot;3&quot;</td><td>年金</td></tr>
 * </table>
 */
public class C_KoujyosyoumeipKbn extends Classification<C_KoujyosyoumeipKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KoujyosyoumeipKbn BLNK = new C_KoujyosyoumeipKbn("0");

    public static final C_KoujyosyoumeipKbn IPPAN = new C_KoujyosyoumeipKbn("1");

    public static final C_KoujyosyoumeipKbn KAIGOIRYOU = new C_KoujyosyoumeipKbn("2");

    public static final C_KoujyosyoumeipKbn NENKIN = new C_KoujyosyoumeipKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, IPPAN, "IPPAN", false);
        addPattern(PATTERN_DEFAULT, KAIGOIRYOU, "KAIGOIRYOU", false);
        addPattern(PATTERN_DEFAULT, NENKIN, "NENKIN", false);


        lock(C_KoujyosyoumeipKbn.class);
    }

    private C_KoujyosyoumeipKbn(String value) {
        super(value);
    }

    public static C_KoujyosyoumeipKbn valueOf(String value) {
        return valueOf(C_KoujyosyoumeipKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KoujyosyoumeipKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KoujyosyoumeipKbn.class, patternId, value);
    }
}
