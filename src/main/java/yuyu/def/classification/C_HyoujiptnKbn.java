
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 表示パターン区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HyoujiptnKbn</td><td colspan="3">表示パターン区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="15">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #TUUJYOU}</td><td>&quot;0&quot;</td><td>通常</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKAI}</td><td>&quot;1&quot;</td><td>照会</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU}</td><td>&quot;2&quot;</td><td>解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GENGAKU}</td><td>&quot;3&quot;</td><td>減額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKTRKS}</td><td>&quot;4&quot;</td><td>契約取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEINENGAPPISEI}</td><td>&quot;5&quot;</td><td>生年月日・性訂正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKHNK}</td><td>&quot;6&quot;</td><td>契約変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKS}</td><td>&quot;7&quot;</td><td>請求書作成</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIGIHENKOU}</td><td>&quot;8&quot;</td><td>名義変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTHNKHRSHR}</td><td>&quot;9&quot;</td><td>円建変更時返戻金支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MKHGKTTTYENDTHNK}</td><td>&quot;10&quot;</td><td>円建変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DSHR}</td><td>&quot;11&quot;</td><td>配当金支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMNYSYMET_JDSKN_SSNZM}</td><td>&quot;12&quot;</td><td>Ｐ未入消滅（自動送金精算済）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMNYSYMET_MSSN}</td><td>&quot;13&quot;</td><td>Ｐ未入消滅（未精算）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DSEISANTUIBARAI}</td><td>&quot;14&quot;</td><td>Ｄ精算追払</td></tr>
 * </table>
 */
public class C_HyoujiptnKbn extends Classification<C_HyoujiptnKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HyoujiptnKbn TUUJYOU = new C_HyoujiptnKbn("0");

    public static final C_HyoujiptnKbn SYOUKAI = new C_HyoujiptnKbn("1");

    public static final C_HyoujiptnKbn KAIYAKU = new C_HyoujiptnKbn("2");

    public static final C_HyoujiptnKbn GENGAKU = new C_HyoujiptnKbn("3");

    public static final C_HyoujiptnKbn KYKTRKS = new C_HyoujiptnKbn("4");

    public static final C_HyoujiptnKbn SEINENGAPPISEI = new C_HyoujiptnKbn("5");

    public static final C_HyoujiptnKbn KYKHNK = new C_HyoujiptnKbn("6");

    public static final C_HyoujiptnKbn SKS = new C_HyoujiptnKbn("7");

    public static final C_HyoujiptnKbn MEIGIHENKOU = new C_HyoujiptnKbn("8");

    public static final C_HyoujiptnKbn YENDTHNKHRSHR = new C_HyoujiptnKbn("9");

    public static final C_HyoujiptnKbn MKHGKTTTYENDTHNK = new C_HyoujiptnKbn("10");

    public static final C_HyoujiptnKbn DSHR = new C_HyoujiptnKbn("11");

    public static final C_HyoujiptnKbn PMNYSYMET_JDSKN_SSNZM = new C_HyoujiptnKbn("12");

    public static final C_HyoujiptnKbn PMNYSYMET_MSSN = new C_HyoujiptnKbn("13");

    public static final C_HyoujiptnKbn DSEISANTUIBARAI = new C_HyoujiptnKbn("14");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, TUUJYOU, "TUUJYOU", true);
        addPattern(PATTERN_DEFAULT, SYOUKAI, "SYOUKAI", false);
        addPattern(PATTERN_DEFAULT, KAIYAKU, "KAIYAKU", false);
        addPattern(PATTERN_DEFAULT, GENGAKU, "GENGAKU", false);
        addPattern(PATTERN_DEFAULT, KYKTRKS, "KYKTRKS", false);
        addPattern(PATTERN_DEFAULT, SEINENGAPPISEI, "SEINENGAPPISEI", false);
        addPattern(PATTERN_DEFAULT, KYKHNK, "KYKHNK", false);
        addPattern(PATTERN_DEFAULT, SKS, "SKS", false);
        addPattern(PATTERN_DEFAULT, MEIGIHENKOU, "MEIGIHENKOU", false);
        addPattern(PATTERN_DEFAULT, YENDTHNKHRSHR, "YENDTHNKHRSHR", false);
        addPattern(PATTERN_DEFAULT, MKHGKTTTYENDTHNK, "MKHGKTTTYENDTHNK", false);
        addPattern(PATTERN_DEFAULT, DSHR, "DSHR", false);
        addPattern(PATTERN_DEFAULT, PMNYSYMET_JDSKN_SSNZM, "PMNYSYMET_JDSKN_SSNZM", false);
        addPattern(PATTERN_DEFAULT, PMNYSYMET_MSSN, "PMNYSYMET_MSSN", false);
        addPattern(PATTERN_DEFAULT, DSEISANTUIBARAI, "DSEISANTUIBARAI", false);


        lock(C_HyoujiptnKbn.class);
    }

    private C_HyoujiptnKbn(String value) {
        super(value);
    }

    public static C_HyoujiptnKbn valueOf(String value) {
        return valueOf(C_HyoujiptnKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HyoujiptnKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HyoujiptnKbn.class, patternId, value);
    }
}
