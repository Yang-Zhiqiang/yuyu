
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 非該当理由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HigaitouRiyuuKbn</td><td colspan="3">非該当理由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="18">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKMAE}</td><td>&quot;1&quot;</td><td>Ｐ免事由非該当（契約前事故・発病）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SMK}</td><td>&quot;2&quot;</td><td>Ｐ免事由非該当（症状未固定）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRY}</td><td>&quot;3&quot;</td><td>Ｐ免事由非該当（不慮の事故に非ず）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HG}</td><td>&quot;4&quot;</td><td>Ｐ免事由非該当（非該当）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA_PMJ}</td><td>&quot;5&quot;</td><td>Ｐ免事由非該当（その他）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOI}</td><td>&quot;6&quot;</td><td>免責（故意・重過失）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YAK}</td><td>&quot;7&quot;</td><td>免責（薬物依存）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SSN}</td><td>&quot;8&quot;</td><td>免責（精神障害・泥酔）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MMK}</td><td>&quot;9&quot;</td><td>免責（無免許運転）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYK}</td><td>&quot;10&quot;</td><td>免責（酒気帯び運転）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA_MS}</td><td>&quot;11&quot;</td><td>免責（その他）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SG}</td><td>&quot;12&quot;</td><td>詐欺取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHST}</td><td>&quot;13&quot;</td><td>不法取得目的無効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KKTIH}</td><td>&quot;14&quot;</td><td>告知義務違反解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JD}</td><td>&quot;15&quot;</td><td>重大事由解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PM90INAISINDAN}</td><td>&quot;16&quot;</td><td>Ｐ免事由非該当（９０日以内診断確定）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="18">{@link #PATTERN_PM PM}<br />(Ｐ免)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKMAE}</td><td>&quot;1&quot;</td><td>Ｐ免事由非該当（契約前事故・発病）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SMK}</td><td>&quot;2&quot;</td><td>Ｐ免事由非該当（症状未固定）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRY}</td><td>&quot;3&quot;</td><td>Ｐ免事由非該当（不慮の事故に非ず）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HG}</td><td>&quot;4&quot;</td><td>Ｐ免事由非該当（非該当）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA_PMJ}</td><td>&quot;5&quot;</td><td>Ｐ免事由非該当（その他）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PM90INAISINDAN}</td><td>&quot;16&quot;</td><td>Ｐ免事由非該当（９０日以内診断確定）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOI}</td><td>&quot;6&quot;</td><td>免責（故意・重過失）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YAK}</td><td>&quot;7&quot;</td><td>免責（薬物依存）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SSN}</td><td>&quot;8&quot;</td><td>免責（精神障害・泥酔）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MMK}</td><td>&quot;9&quot;</td><td>免責（無免許運転）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYK}</td><td>&quot;10&quot;</td><td>免責（酒気帯び運転）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA_MS}</td><td>&quot;11&quot;</td><td>免責（その他）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SG}</td><td>&quot;12&quot;</td><td>詐欺取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHST}</td><td>&quot;13&quot;</td><td>不法取得目的無効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KKTIH}</td><td>&quot;14&quot;</td><td>告知義務違反解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JD}</td><td>&quot;15&quot;</td><td>重大事由解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_HigaitouRiyuuKbn extends Classification<C_HigaitouRiyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HigaitouRiyuuKbn BLNK = new C_HigaitouRiyuuKbn("0");

    public static final C_HigaitouRiyuuKbn KYKMAE = new C_HigaitouRiyuuKbn("1");

    public static final C_HigaitouRiyuuKbn SMK = new C_HigaitouRiyuuKbn("2");

    public static final C_HigaitouRiyuuKbn HRY = new C_HigaitouRiyuuKbn("3");

    public static final C_HigaitouRiyuuKbn HG = new C_HigaitouRiyuuKbn("4");

    public static final C_HigaitouRiyuuKbn SONOTA_PMJ = new C_HigaitouRiyuuKbn("5");

    public static final C_HigaitouRiyuuKbn KOI = new C_HigaitouRiyuuKbn("6");

    public static final C_HigaitouRiyuuKbn YAK = new C_HigaitouRiyuuKbn("7");

    public static final C_HigaitouRiyuuKbn SSN = new C_HigaitouRiyuuKbn("8");

    public static final C_HigaitouRiyuuKbn MMK = new C_HigaitouRiyuuKbn("9");

    public static final C_HigaitouRiyuuKbn SYK = new C_HigaitouRiyuuKbn("10");

    public static final C_HigaitouRiyuuKbn SONOTA_MS = new C_HigaitouRiyuuKbn("11");

    public static final C_HigaitouRiyuuKbn SG = new C_HigaitouRiyuuKbn("12");

    public static final C_HigaitouRiyuuKbn HHST = new C_HigaitouRiyuuKbn("13");

    public static final C_HigaitouRiyuuKbn KKTIH = new C_HigaitouRiyuuKbn("14");

    public static final C_HigaitouRiyuuKbn JD = new C_HigaitouRiyuuKbn("15");

    public static final C_HigaitouRiyuuKbn PM90INAISINDAN = new C_HigaitouRiyuuKbn("16");

    public static final C_HigaitouRiyuuKbn SONOTA = new C_HigaitouRiyuuKbn("99");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_PM = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KYKMAE, "KYKMAE", false);
        addPattern(PATTERN_DEFAULT, SMK, "SMK", false);
        addPattern(PATTERN_DEFAULT, HRY, "HRY", false);
        addPattern(PATTERN_DEFAULT, HG, "HG", false);
        addPattern(PATTERN_DEFAULT, SONOTA_PMJ, "SONOTA_PMJ", false);
        addPattern(PATTERN_DEFAULT, KOI, "KOI", false);
        addPattern(PATTERN_DEFAULT, YAK, "YAK", false);
        addPattern(PATTERN_DEFAULT, SSN, "SSN", false);
        addPattern(PATTERN_DEFAULT, MMK, "MMK", false);
        addPattern(PATTERN_DEFAULT, SYK, "SYK", false);
        addPattern(PATTERN_DEFAULT, SONOTA_MS, "SONOTA_MS", false);
        addPattern(PATTERN_DEFAULT, SG, "SG", false);
        addPattern(PATTERN_DEFAULT, HHST, "HHST", false);
        addPattern(PATTERN_DEFAULT, KKTIH, "KKTIH", false);
        addPattern(PATTERN_DEFAULT, JD, "JD", false);
        addPattern(PATTERN_DEFAULT, PM90INAISINDAN, "PM90INAISINDAN", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        addPattern(PATTERN_PM, BLNK, "BLNK", true);
        addPattern(PATTERN_PM, KYKMAE, "KYKMAE", false);
        addPattern(PATTERN_PM, SMK, "SMK", false);
        addPattern(PATTERN_PM, HRY, "HRY", false);
        addPattern(PATTERN_PM, HG, "HG", false);
        addPattern(PATTERN_PM, SONOTA_PMJ, "SONOTA_PMJ", false);
        addPattern(PATTERN_PM, PM90INAISINDAN, "PM90INAISINDAN", false);
        addPattern(PATTERN_PM, KOI, "KOI", false);
        addPattern(PATTERN_PM, YAK, "YAK", false);
        addPattern(PATTERN_PM, SSN, "SSN", false);
        addPattern(PATTERN_PM, MMK, "MMK", false);
        addPattern(PATTERN_PM, SYK, "SYK", false);
        addPattern(PATTERN_PM, SONOTA_MS, "SONOTA_MS", false);
        addPattern(PATTERN_PM, SG, "SG", false);
        addPattern(PATTERN_PM, HHST, "HHST", false);
        addPattern(PATTERN_PM, KKTIH, "KKTIH", false);
        addPattern(PATTERN_PM, JD, "JD", false);
        addPattern(PATTERN_PM, SONOTA, "SONOTA", false);


        lock(C_HigaitouRiyuuKbn.class);
    }

    private C_HigaitouRiyuuKbn(String value) {
        super(value);
    }

    public static C_HigaitouRiyuuKbn valueOf(String value) {
        return valueOf(C_HigaitouRiyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HigaitouRiyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HigaitouRiyuuKbn.class, patternId, value);
    }
}
