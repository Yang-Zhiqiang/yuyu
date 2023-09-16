
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 控除証明内容レコード区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KoujyosymnaiyourecKbn</td><td colspan="3">控除証明内容レコード区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HKRNK}</td><td>&quot;1&quot;</td><td>保険料入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKTRKS}</td><td>&quot;2&quot;</td><td>入金取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MKKHKR_SMT}</td><td>&quot;3&quot;</td><td>未経過保険料（消滅）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MKKHKR_KYKHK}</td><td>&quot;4&quot;</td><td>未経過保険料（契約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENKANKIN}</td><td>&quot;5&quot;</td><td>返還金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUITYOUKIN}</td><td>&quot;6&quot;</td><td>追徴金</td></tr>
 * </table>
 */
public class C_KoujyosymnaiyourecKbn extends Classification<C_KoujyosymnaiyourecKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KoujyosymnaiyourecKbn BLNK = new C_KoujyosymnaiyourecKbn("0");

    public static final C_KoujyosymnaiyourecKbn HKRNK = new C_KoujyosymnaiyourecKbn("1");

    public static final C_KoujyosymnaiyourecKbn NKTRKS = new C_KoujyosymnaiyourecKbn("2");

    public static final C_KoujyosymnaiyourecKbn MKKHKR_SMT = new C_KoujyosymnaiyourecKbn("3");

    public static final C_KoujyosymnaiyourecKbn MKKHKR_KYKHK = new C_KoujyosymnaiyourecKbn("4");

    public static final C_KoujyosymnaiyourecKbn HENKANKIN = new C_KoujyosymnaiyourecKbn("5");

    public static final C_KoujyosymnaiyourecKbn TUITYOUKIN = new C_KoujyosymnaiyourecKbn("6");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HKRNK, "HKRNK", false);
        addPattern(PATTERN_DEFAULT, NKTRKS, "NKTRKS", false);
        addPattern(PATTERN_DEFAULT, MKKHKR_SMT, "MKKHKR_SMT", false);
        addPattern(PATTERN_DEFAULT, MKKHKR_KYKHK, "MKKHKR_KYKHK", false);
        addPattern(PATTERN_DEFAULT, HENKANKIN, "HENKANKIN", false);
        addPattern(PATTERN_DEFAULT, TUITYOUKIN, "TUITYOUKIN", false);


        lock(C_KoujyosymnaiyourecKbn.class);
    }

    private C_KoujyosymnaiyourecKbn(String value) {
        super(value);
    }

    public static C_KoujyosymnaiyourecKbn valueOf(String value) {
        return valueOf(C_KoujyosymnaiyourecKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KoujyosymnaiyourecKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KoujyosymnaiyourecKbn.class, patternId, value);
    }
}
