
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 契約保全伝票金額種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KhDengkSyuruiKbn</td><td colspan="3">契約保全伝票金額種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="25">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RYOUSYUP_SYOP}</td><td>&quot;10000&quot;</td><td>領収保険料（初回Ｐ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RYOUSYUP_SYONENDO2KAIMEIKOU}</td><td>&quot;10100&quot;</td><td>領収保険料（初年度２回目以降）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RYOUSYUP_JINENDO}</td><td>&quot;10200&quot;</td><td>領収保険料（次年度以降）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RYOUSYUP}</td><td>&quot;10300&quot;</td><td>領収保険料</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOZEN_RYOUSYUGK}</td><td>&quot;10600&quot;</td><td>保全領収金額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RYOUSYUP_TUITYOU}</td><td>&quot;19000&quot;</td><td>領収保険料（追徴金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHRGK}</td><td>&quot;20000&quot;</td><td>支払金額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIJYOUK_KARIUKEGK}</td><td>&quot;20300&quot;</td><td>計上金（仮受金額）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIJYOUP}</td><td>&quot;20310&quot;</td><td>計上保険料</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEISANK_KARIUKEGK}</td><td>&quot;20600&quot;</td><td>精算金（仮受金額）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HURIKOMIRYOUSYUGK}</td><td>&quot;20700&quot;</td><td>振込領収金額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GENSENTYOUSYU}</td><td>&quot;20900&quot;</td><td>預り金（源泉徴収額）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDITTORIKESIGK}</td><td>&quot;21000&quot;</td><td>クレジット取消金額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEISANK_KAIYAKUHR}</td><td>&quot;40000&quot;</td><td>精算金（解約返戻金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEISANK_PTUMITATEKIN}</td><td>&quot;40100&quot;</td><td>精算金（保険料積立金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEISANK_KIHRKMP}</td><td>&quot;40200&quot;</td><td>精算金（既払込保険料）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHRTIENRSK}</td><td>&quot;40300&quot;</td><td>支払遅延利息</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEISANK_YENDTHNKHR}</td><td>&quot;40400&quot;</td><td>精算金（円建変更時返戻金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEISANK_D}</td><td>&quot;40500&quot;</td><td>精算金（配当金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEISANK_SYONENDOSYOKAIP}</td><td>&quot;40600&quot;</td><td>精算金（初年度初回保険料）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEISANK_SYONENDO2KAIMEIKOUP}</td><td>&quot;40700&quot;</td><td>精算金（初年度２回目以降保険料）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEISANK_JINENDOIKOUP}</td><td>&quot;40800&quot;</td><td>精算金（次年度以降保険料）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEISANK_SONOTAHENREIKIN}</td><td>&quot;40900&quot;</td><td>精算金（その他返戻金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEISANP_HENKAN}</td><td>&quot;49000&quot;</td><td>精算保険料（返還金）</td></tr>
 * </table>
 */
public class C_KhDengkSyuruiKbn extends Classification<C_KhDengkSyuruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KhDengkSyuruiKbn BLNK = new C_KhDengkSyuruiKbn("0");

    public static final C_KhDengkSyuruiKbn RYOUSYUP_SYOP = new C_KhDengkSyuruiKbn("10000");

    public static final C_KhDengkSyuruiKbn RYOUSYUP_SYONENDO2KAIMEIKOU = new C_KhDengkSyuruiKbn("10100");

    public static final C_KhDengkSyuruiKbn RYOUSYUP_JINENDO = new C_KhDengkSyuruiKbn("10200");

    public static final C_KhDengkSyuruiKbn RYOUSYUP = new C_KhDengkSyuruiKbn("10300");

    public static final C_KhDengkSyuruiKbn HOZEN_RYOUSYUGK = new C_KhDengkSyuruiKbn("10600");

    public static final C_KhDengkSyuruiKbn RYOUSYUP_TUITYOU = new C_KhDengkSyuruiKbn("19000");

    public static final C_KhDengkSyuruiKbn SHRGK = new C_KhDengkSyuruiKbn("20000");

    public static final C_KhDengkSyuruiKbn KEIJYOUK_KARIUKEGK = new C_KhDengkSyuruiKbn("20300");

    public static final C_KhDengkSyuruiKbn KEIJYOUP = new C_KhDengkSyuruiKbn("20310");

    public static final C_KhDengkSyuruiKbn SEISANK_KARIUKEGK = new C_KhDengkSyuruiKbn("20600");

    public static final C_KhDengkSyuruiKbn HURIKOMIRYOUSYUGK = new C_KhDengkSyuruiKbn("20700");

    public static final C_KhDengkSyuruiKbn GENSENTYOUSYU = new C_KhDengkSyuruiKbn("20900");

    public static final C_KhDengkSyuruiKbn CREDITTORIKESIGK = new C_KhDengkSyuruiKbn("21000");

    public static final C_KhDengkSyuruiKbn SEISANK_KAIYAKUHR = new C_KhDengkSyuruiKbn("40000");

    public static final C_KhDengkSyuruiKbn SEISANK_PTUMITATEKIN = new C_KhDengkSyuruiKbn("40100");

    public static final C_KhDengkSyuruiKbn SEISANK_KIHRKMP = new C_KhDengkSyuruiKbn("40200");

    public static final C_KhDengkSyuruiKbn SHRTIENRSK = new C_KhDengkSyuruiKbn("40300");

    public static final C_KhDengkSyuruiKbn SEISANK_YENDTHNKHR = new C_KhDengkSyuruiKbn("40400");

    public static final C_KhDengkSyuruiKbn SEISANK_D = new C_KhDengkSyuruiKbn("40500");

    public static final C_KhDengkSyuruiKbn SEISANK_SYONENDOSYOKAIP = new C_KhDengkSyuruiKbn("40600");

    public static final C_KhDengkSyuruiKbn SEISANK_SYONENDO2KAIMEIKOUP = new C_KhDengkSyuruiKbn("40700");

    public static final C_KhDengkSyuruiKbn SEISANK_JINENDOIKOUP = new C_KhDengkSyuruiKbn("40800");

    public static final C_KhDengkSyuruiKbn SEISANK_SONOTAHENREIKIN = new C_KhDengkSyuruiKbn("40900");

    public static final C_KhDengkSyuruiKbn SEISANP_HENKAN = new C_KhDengkSyuruiKbn("49000");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, RYOUSYUP_SYOP, "RYOUSYUP_SYOP", false);
        addPattern(PATTERN_DEFAULT, RYOUSYUP_SYONENDO2KAIMEIKOU, "RYOUSYUP_SYONENDO2KAIMEIKOU", false);
        addPattern(PATTERN_DEFAULT, RYOUSYUP_JINENDO, "RYOUSYUP_JINENDO", false);
        addPattern(PATTERN_DEFAULT, RYOUSYUP, "RYOUSYUP", false);
        addPattern(PATTERN_DEFAULT, HOZEN_RYOUSYUGK, "HOZEN_RYOUSYUGK", false);
        addPattern(PATTERN_DEFAULT, RYOUSYUP_TUITYOU, "RYOUSYUP_TUITYOU", false);
        addPattern(PATTERN_DEFAULT, SHRGK, "SHRGK", false);
        addPattern(PATTERN_DEFAULT, KEIJYOUK_KARIUKEGK, "KEIJYOUK_KARIUKEGK", false);
        addPattern(PATTERN_DEFAULT, KEIJYOUP, "KEIJYOUP", false);
        addPattern(PATTERN_DEFAULT, SEISANK_KARIUKEGK, "SEISANK_KARIUKEGK", false);
        addPattern(PATTERN_DEFAULT, HURIKOMIRYOUSYUGK, "HURIKOMIRYOUSYUGK", false);
        addPattern(PATTERN_DEFAULT, GENSENTYOUSYU, "GENSENTYOUSYU", false);
        addPattern(PATTERN_DEFAULT, CREDITTORIKESIGK, "CREDITTORIKESIGK", false);
        addPattern(PATTERN_DEFAULT, SEISANK_KAIYAKUHR, "SEISANK_KAIYAKUHR", false);
        addPattern(PATTERN_DEFAULT, SEISANK_PTUMITATEKIN, "SEISANK_PTUMITATEKIN", false);
        addPattern(PATTERN_DEFAULT, SEISANK_KIHRKMP, "SEISANK_KIHRKMP", false);
        addPattern(PATTERN_DEFAULT, SHRTIENRSK, "SHRTIENRSK", false);
        addPattern(PATTERN_DEFAULT, SEISANK_YENDTHNKHR, "SEISANK_YENDTHNKHR", false);
        addPattern(PATTERN_DEFAULT, SEISANK_D, "SEISANK_D", false);
        addPattern(PATTERN_DEFAULT, SEISANK_SYONENDOSYOKAIP, "SEISANK_SYONENDOSYOKAIP", false);
        addPattern(PATTERN_DEFAULT, SEISANK_SYONENDO2KAIMEIKOUP, "SEISANK_SYONENDO2KAIMEIKOUP", false);
        addPattern(PATTERN_DEFAULT, SEISANK_JINENDOIKOUP, "SEISANK_JINENDOIKOUP", false);
        addPattern(PATTERN_DEFAULT, SEISANK_SONOTAHENREIKIN, "SEISANK_SONOTAHENREIKIN", false);
        addPattern(PATTERN_DEFAULT, SEISANP_HENKAN, "SEISANP_HENKAN", false);


        lock(C_KhDengkSyuruiKbn.class);
    }

    private C_KhDengkSyuruiKbn(String value) {
        super(value);
    }

    public static C_KhDengkSyuruiKbn valueOf(String value) {
        return valueOf(C_KhDengkSyuruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KhDengkSyuruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KhDengkSyuruiKbn.class, patternId, value);
    }
}
