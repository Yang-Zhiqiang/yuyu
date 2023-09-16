
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 不支払原因区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HushrGeninKbn</td><td colspan="3">不支払原因区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="45">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKMAE}</td><td>&quot;1&quot;</td><td>支払事由非該当（契約前事故・発病）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GNDT}</td><td>&quot;2&quot;</td><td>支払事由非該当（限度到達済）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SZ}</td><td>&quot;3&quot;</td><td>支払事由非該当（支払済）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HG}</td><td>&quot;4&quot;</td><td>支払事由非該当（非該当）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HTNPKKN}</td><td>&quot;5&quot;</td><td>支払事由非該当（不担保期間）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HKKNG}</td><td>&quot;6&quot;</td><td>支払事由非該当（保険期間外）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA_SJ}</td><td>&quot;7&quot;</td><td>支払事由非該当（その他）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOIJKT}</td><td>&quot;8&quot;</td><td>免責（故意・重過失）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YAK}</td><td>&quot;9&quot;</td><td>免責（薬物依存）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SSN}</td><td>&quot;10&quot;</td><td>免責（精神障害・泥酔）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MMK}</td><td>&quot;11&quot;</td><td>免責（無免許運転）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYK}</td><td>&quot;12&quot;</td><td>免責（酒気帯び運転）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA_MS}</td><td>&quot;13&quot;</td><td>免責（その他）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SG}</td><td>&quot;14&quot;</td><td>詐欺取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHST}</td><td>&quot;15&quot;</td><td>不法取得目的無効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KKTIH}</td><td>&quot;16&quot;</td><td>告知義務違反解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JD}</td><td>&quot;17&quot;</td><td>重大事由解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JST}</td><td>&quot;18&quot;</td><td>免責（自殺）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOI}</td><td>&quot;19&quot;</td><td>免責（故意）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MENSEKI_SNDJST}</td><td>&quot;20&quot;</td><td>免責（初年度自殺）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MENSEKI_JNDJST}</td><td>&quot;21&quot;</td><td>免責（次年度自殺）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MENSEKI_TNDJST}</td><td>&quot;22&quot;</td><td>免責（３年目自殺）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIJYO_KKTIH}</td><td>&quot;23&quot;</td><td>解除（告知義務違反）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIJYO_JD}</td><td>&quot;24&quot;</td><td>解除（重大事由解除）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIJYO_SONOTA}</td><td>&quot;25&quot;</td><td>解除（その他）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MUKOU_SG}</td><td>&quot;26&quot;</td><td>無効（詐欺取消）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MUKOU_HHST}</td><td>&quot;27&quot;</td><td>無効（不法取得目的）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MUKOU_SONOTA}</td><td>&quot;28&quot;</td><td>無効（その他）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JTHG}</td><td>&quot;29&quot;</td><td>状態非該当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SMK}</td><td>&quot;30&quot;</td><td>症状未固定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KMAEHB}</td><td>&quot;31&quot;</td><td>契前発病</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KMAEJK}</td><td>&quot;32&quot;</td><td>契前事故</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTAHG}</td><td>&quot;33&quot;</td><td>その他非該当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAI_GR}</td><td>&quot;34&quot;</td><td>災Ｓ非該当（外来性なし）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAI_GH}</td><td>&quot;35&quot;</td><td>災Ｓ非該当（偶発性なし）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAI_JJ}</td><td>&quot;36&quot;</td><td>災Ｓ非該当（除外事由該当）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAI_SONOTA}</td><td>&quot;37&quot;</td><td>災Ｓ非該当（その他）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAI_MENSEKI_JKT}</td><td>&quot;38&quot;</td><td>災Ｓ免責（重過失免責）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAI_MENSEKI_SYK}</td><td>&quot;39&quot;</td><td>災Ｓ免責（酒気帯び運転）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAI_MENSEKI_MMK}</td><td>&quot;40&quot;</td><td>災Ｓ免責（無免許運転）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAI_MENSEKI_SSN}</td><td>&quot;41&quot;</td><td>災Ｓ免責（精神障害中の事故）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAI_MENSEKI_SONOTA}</td><td>&quot;42&quot;</td><td>災Ｓ免責（その他）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA_GANMK}</td><td>&quot;90&quot;</td><td>その他（がん無効）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="20">{@link #PATTERN_KYUUFU KYUUFU}<br />(給付)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKMAE}</td><td>&quot;1&quot;</td><td>支払事由非該当（契約前事故・発病）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GNDT}</td><td>&quot;2&quot;</td><td>支払事由非該当（限度到達済）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SZ}</td><td>&quot;3&quot;</td><td>支払事由非該当（支払済）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HG}</td><td>&quot;4&quot;</td><td>支払事由非該当（非該当）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HTNPKKN}</td><td>&quot;5&quot;</td><td>支払事由非該当（不担保期間）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HKKNG}</td><td>&quot;6&quot;</td><td>支払事由非該当（保険期間外）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA_SJ}</td><td>&quot;7&quot;</td><td>支払事由非該当（その他）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOIJKT}</td><td>&quot;8&quot;</td><td>免責（故意・重過失）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YAK}</td><td>&quot;9&quot;</td><td>免責（薬物依存）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SSN}</td><td>&quot;10&quot;</td><td>免責（精神障害・泥酔）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MMK}</td><td>&quot;11&quot;</td><td>免責（無免許運転）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYK}</td><td>&quot;12&quot;</td><td>免責（酒気帯び運転）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA_MS}</td><td>&quot;13&quot;</td><td>免責（その他）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SG}</td><td>&quot;14&quot;</td><td>詐欺取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHST}</td><td>&quot;15&quot;</td><td>不法取得目的無効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KKTIH}</td><td>&quot;16&quot;</td><td>告知義務違反解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JD}</td><td>&quot;17&quot;</td><td>重大事由解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA_GANMK}</td><td>&quot;90&quot;</td><td>その他（がん無効）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="20">{@link #PATTERN_SIBOU SIBOU}<br />(死亡)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MENSEKI_SNDJST}</td><td>&quot;20&quot;</td><td>免責（初年度自殺）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MENSEKI_JNDJST}</td><td>&quot;21&quot;</td><td>免責（次年度自殺）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MENSEKI_TNDJST}</td><td>&quot;22&quot;</td><td>免責（３年目自殺）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOI}</td><td>&quot;19&quot;</td><td>免責（故意）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA_MS}</td><td>&quot;13&quot;</td><td>免責（その他）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAI_GR}</td><td>&quot;34&quot;</td><td>災Ｓ非該当（外来性なし）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAI_GH}</td><td>&quot;35&quot;</td><td>災Ｓ非該当（偶発性なし）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAI_JJ}</td><td>&quot;36&quot;</td><td>災Ｓ非該当（除外事由該当）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAI_SONOTA}</td><td>&quot;37&quot;</td><td>災Ｓ非該当（その他）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAI_MENSEKI_JKT}</td><td>&quot;38&quot;</td><td>災Ｓ免責（重過失免責）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAI_MENSEKI_SYK}</td><td>&quot;39&quot;</td><td>災Ｓ免責（酒気帯び運転）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAI_MENSEKI_MMK}</td><td>&quot;40&quot;</td><td>災Ｓ免責（無免許運転）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAI_MENSEKI_SSN}</td><td>&quot;41&quot;</td><td>災Ｓ免責（精神障害中の事故）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAI_MENSEKI_SONOTA}</td><td>&quot;42&quot;</td><td>災Ｓ免責（その他）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIJYO_JD}</td><td>&quot;24&quot;</td><td>解除（重大事由解除）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIJYO_SONOTA}</td><td>&quot;25&quot;</td><td>解除（その他）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MUKOU_SG}</td><td>&quot;26&quot;</td><td>無効（詐欺取消）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MUKOU_HHST}</td><td>&quot;27&quot;</td><td>無効（不法取得目的）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MUKOU_SONOTA}</td><td>&quot;28&quot;</td><td>無効（その他）</td></tr>
 *  <tr><td rowspan="14">{@link #PATTERN_KOUSYOU KOUSYOU}<br />((高度障害)査定)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JTHG}</td><td>&quot;29&quot;</td><td>状態非該当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SMK}</td><td>&quot;30&quot;</td><td>症状未固定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KMAEHB}</td><td>&quot;31&quot;</td><td>契前発病</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KMAEJK}</td><td>&quot;32&quot;</td><td>契前事故</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTAHG}</td><td>&quot;33&quot;</td><td>その他非該当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOI}</td><td>&quot;19&quot;</td><td>免責（故意）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA_MS}</td><td>&quot;13&quot;</td><td>免責（その他）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIJYO_KKTIH}</td><td>&quot;23&quot;</td><td>解除（告知義務違反）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIJYO_JD}</td><td>&quot;24&quot;</td><td>解除（重大事由解除）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIJYO_SONOTA}</td><td>&quot;25&quot;</td><td>解除（その他）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MUKOU_SG}</td><td>&quot;26&quot;</td><td>無効（詐欺取消）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MUKOU_HHST}</td><td>&quot;27&quot;</td><td>無効（不法取得目的）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MUKOU_SONOTA}</td><td>&quot;28&quot;</td><td>無効（その他）</td></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_LN LN}<br />((リビングニーズ)査定)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKMAE}</td><td>&quot;1&quot;</td><td>非該当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SSN}</td><td>&quot;10&quot;</td><td>契約者の故意</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MMK}</td><td>&quot;11&quot;</td><td>被保険者の故意</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYK}</td><td>&quot;12&quot;</td><td>被保険者の犯罪行為</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他免責事由該当</td></tr>
 * </table>
 */
public class C_HushrGeninKbn extends Classification<C_HushrGeninKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HushrGeninKbn BLNK = new C_HushrGeninKbn("0");

    public static final C_HushrGeninKbn KYKMAE = new C_HushrGeninKbn("1");

    public static final C_HushrGeninKbn GNDT = new C_HushrGeninKbn("2");

    public static final C_HushrGeninKbn SZ = new C_HushrGeninKbn("3");

    public static final C_HushrGeninKbn HG = new C_HushrGeninKbn("4");

    public static final C_HushrGeninKbn HTNPKKN = new C_HushrGeninKbn("5");

    public static final C_HushrGeninKbn HKKNG = new C_HushrGeninKbn("6");

    public static final C_HushrGeninKbn SONOTA_SJ = new C_HushrGeninKbn("7");

    public static final C_HushrGeninKbn KOIJKT = new C_HushrGeninKbn("8");

    public static final C_HushrGeninKbn YAK = new C_HushrGeninKbn("9");

    public static final C_HushrGeninKbn SSN = new C_HushrGeninKbn("10");

    public static final C_HushrGeninKbn MMK = new C_HushrGeninKbn("11");

    public static final C_HushrGeninKbn SYK = new C_HushrGeninKbn("12");

    public static final C_HushrGeninKbn SONOTA_MS = new C_HushrGeninKbn("13");

    public static final C_HushrGeninKbn SG = new C_HushrGeninKbn("14");

    public static final C_HushrGeninKbn HHST = new C_HushrGeninKbn("15");

    public static final C_HushrGeninKbn KKTIH = new C_HushrGeninKbn("16");

    public static final C_HushrGeninKbn JD = new C_HushrGeninKbn("17");

    public static final C_HushrGeninKbn JST = new C_HushrGeninKbn("18");

    public static final C_HushrGeninKbn KOI = new C_HushrGeninKbn("19");

    public static final C_HushrGeninKbn MENSEKI_SNDJST = new C_HushrGeninKbn("20");

    public static final C_HushrGeninKbn MENSEKI_JNDJST = new C_HushrGeninKbn("21");

    public static final C_HushrGeninKbn MENSEKI_TNDJST = new C_HushrGeninKbn("22");

    public static final C_HushrGeninKbn KAIJYO_KKTIH = new C_HushrGeninKbn("23");

    public static final C_HushrGeninKbn KAIJYO_JD = new C_HushrGeninKbn("24");

    public static final C_HushrGeninKbn KAIJYO_SONOTA = new C_HushrGeninKbn("25");

    public static final C_HushrGeninKbn MUKOU_SG = new C_HushrGeninKbn("26");

    public static final C_HushrGeninKbn MUKOU_HHST = new C_HushrGeninKbn("27");

    public static final C_HushrGeninKbn MUKOU_SONOTA = new C_HushrGeninKbn("28");

    public static final C_HushrGeninKbn JTHG = new C_HushrGeninKbn("29");

    public static final C_HushrGeninKbn SMK = new C_HushrGeninKbn("30");

    public static final C_HushrGeninKbn KMAEHB = new C_HushrGeninKbn("31");

    public static final C_HushrGeninKbn KMAEJK = new C_HushrGeninKbn("32");

    public static final C_HushrGeninKbn SONOTAHG = new C_HushrGeninKbn("33");

    public static final C_HushrGeninKbn SAI_GR = new C_HushrGeninKbn("34");

    public static final C_HushrGeninKbn SAI_GH = new C_HushrGeninKbn("35");

    public static final C_HushrGeninKbn SAI_JJ = new C_HushrGeninKbn("36");

    public static final C_HushrGeninKbn SAI_SONOTA = new C_HushrGeninKbn("37");

    public static final C_HushrGeninKbn SAI_MENSEKI_JKT = new C_HushrGeninKbn("38");

    public static final C_HushrGeninKbn SAI_MENSEKI_SYK = new C_HushrGeninKbn("39");

    public static final C_HushrGeninKbn SAI_MENSEKI_MMK = new C_HushrGeninKbn("40");

    public static final C_HushrGeninKbn SAI_MENSEKI_SSN = new C_HushrGeninKbn("41");

    public static final C_HushrGeninKbn SAI_MENSEKI_SONOTA = new C_HushrGeninKbn("42");

    public static final C_HushrGeninKbn SONOTA_GANMK = new C_HushrGeninKbn("90");

    public static final C_HushrGeninKbn SONOTA = new C_HushrGeninKbn("99");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_KYUUFU = "2";

    public static final String PATTERN_SIBOU = "3";

    public static final String PATTERN_KOUSYOU = "4";

    public static final String PATTERN_LN = "5";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KYKMAE, "KYKMAE", false);
        addPattern(PATTERN_DEFAULT, GNDT, "GNDT", false);
        addPattern(PATTERN_DEFAULT, SZ, "SZ", false);
        addPattern(PATTERN_DEFAULT, HG, "HG", false);
        addPattern(PATTERN_DEFAULT, HTNPKKN, "HTNPKKN", false);
        addPattern(PATTERN_DEFAULT, HKKNG, "HKKNG", false);
        addPattern(PATTERN_DEFAULT, SONOTA_SJ, "SONOTA_SJ", false);
        addPattern(PATTERN_DEFAULT, KOIJKT, "KOIJKT", false);
        addPattern(PATTERN_DEFAULT, YAK, "YAK", false);
        addPattern(PATTERN_DEFAULT, SSN, "SSN", false);
        addPattern(PATTERN_DEFAULT, MMK, "MMK", false);
        addPattern(PATTERN_DEFAULT, SYK, "SYK", false);
        addPattern(PATTERN_DEFAULT, SONOTA_MS, "SONOTA_MS", false);
        addPattern(PATTERN_DEFAULT, SG, "SG", false);
        addPattern(PATTERN_DEFAULT, HHST, "HHST", false);
        addPattern(PATTERN_DEFAULT, KKTIH, "KKTIH", false);
        addPattern(PATTERN_DEFAULT, JD, "JD", false);
        addPattern(PATTERN_DEFAULT, JST, "JST", false);
        addPattern(PATTERN_DEFAULT, KOI, "KOI", false);
        addPattern(PATTERN_DEFAULT, MENSEKI_SNDJST, "MENSEKI_SNDJST", false);
        addPattern(PATTERN_DEFAULT, MENSEKI_JNDJST, "MENSEKI_JNDJST", false);
        addPattern(PATTERN_DEFAULT, MENSEKI_TNDJST, "MENSEKI_TNDJST", false);
        addPattern(PATTERN_DEFAULT, KAIJYO_KKTIH, "KAIJYO_KKTIH", false);
        addPattern(PATTERN_DEFAULT, KAIJYO_JD, "KAIJYO_JD", false);
        addPattern(PATTERN_DEFAULT, KAIJYO_SONOTA, "KAIJYO_SONOTA", false);
        addPattern(PATTERN_DEFAULT, MUKOU_SG, "MUKOU_SG", false);
        addPattern(PATTERN_DEFAULT, MUKOU_HHST, "MUKOU_HHST", false);
        addPattern(PATTERN_DEFAULT, MUKOU_SONOTA, "MUKOU_SONOTA", false);
        addPattern(PATTERN_DEFAULT, JTHG, "JTHG", false);
        addPattern(PATTERN_DEFAULT, SMK, "SMK", false);
        addPattern(PATTERN_DEFAULT, KMAEHB, "KMAEHB", false);
        addPattern(PATTERN_DEFAULT, KMAEJK, "KMAEJK", false);
        addPattern(PATTERN_DEFAULT, SONOTAHG, "SONOTAHG", false);
        addPattern(PATTERN_DEFAULT, SAI_GR, "SAI_GR", false);
        addPattern(PATTERN_DEFAULT, SAI_GH, "SAI_GH", false);
        addPattern(PATTERN_DEFAULT, SAI_JJ, "SAI_JJ", false);
        addPattern(PATTERN_DEFAULT, SAI_SONOTA, "SAI_SONOTA", false);
        addPattern(PATTERN_DEFAULT, SAI_MENSEKI_JKT, "SAI_MENSEKI_JKT", false);
        addPattern(PATTERN_DEFAULT, SAI_MENSEKI_SYK, "SAI_MENSEKI_SYK", false);
        addPattern(PATTERN_DEFAULT, SAI_MENSEKI_MMK, "SAI_MENSEKI_MMK", false);
        addPattern(PATTERN_DEFAULT, SAI_MENSEKI_SSN, "SAI_MENSEKI_SSN", false);
        addPattern(PATTERN_DEFAULT, SAI_MENSEKI_SONOTA, "SAI_MENSEKI_SONOTA", false);
        addPattern(PATTERN_DEFAULT, SONOTA_GANMK, "SONOTA_GANMK", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        addPattern(PATTERN_KYUUFU, BLNK, "BLNK", true);
        addPattern(PATTERN_KYUUFU, KYKMAE, "KYKMAE", false);
        addPattern(PATTERN_KYUUFU, GNDT, "GNDT", false);
        addPattern(PATTERN_KYUUFU, SZ, "SZ", false);
        addPattern(PATTERN_KYUUFU, HG, "HG", false);
        addPattern(PATTERN_KYUUFU, HTNPKKN, "HTNPKKN", false);
        addPattern(PATTERN_KYUUFU, HKKNG, "HKKNG", false);
        addPattern(PATTERN_KYUUFU, SONOTA_SJ, "SONOTA_SJ", false);
        addPattern(PATTERN_KYUUFU, KOIJKT, "KOIJKT", false);
        addPattern(PATTERN_KYUUFU, YAK, "YAK", false);
        addPattern(PATTERN_KYUUFU, SSN, "SSN", false);
        addPattern(PATTERN_KYUUFU, MMK, "MMK", false);
        addPattern(PATTERN_KYUUFU, SYK, "SYK", false);
        addPattern(PATTERN_KYUUFU, SONOTA_MS, "SONOTA_MS", false);
        addPattern(PATTERN_KYUUFU, SG, "SG", false);
        addPattern(PATTERN_KYUUFU, HHST, "HHST", false);
        addPattern(PATTERN_KYUUFU, KKTIH, "KKTIH", false);
        addPattern(PATTERN_KYUUFU, JD, "JD", false);
        addPattern(PATTERN_KYUUFU, SONOTA_GANMK, "SONOTA_GANMK", false);
        addPattern(PATTERN_KYUUFU, SONOTA, "SONOTA", false);


        addPattern(PATTERN_SIBOU, BLNK, "BLNK", true);
        addPattern(PATTERN_SIBOU, MENSEKI_SNDJST, "MENSEKI_SNDJST", false);
        addPattern(PATTERN_SIBOU, MENSEKI_JNDJST, "MENSEKI_JNDJST", false);
        addPattern(PATTERN_SIBOU, MENSEKI_TNDJST, "MENSEKI_TNDJST", false);
        addPattern(PATTERN_SIBOU, KOI, "KOI", false);
        addPattern(PATTERN_SIBOU, SONOTA_MS, "SONOTA_MS", false);
        addPattern(PATTERN_SIBOU, SAI_GR, "SAI_GR", false);
        addPattern(PATTERN_SIBOU, SAI_GH, "SAI_GH", false);
        addPattern(PATTERN_SIBOU, SAI_JJ, "SAI_JJ", false);
        addPattern(PATTERN_SIBOU, SAI_SONOTA, "SAI_SONOTA", false);
        addPattern(PATTERN_SIBOU, SAI_MENSEKI_JKT, "SAI_MENSEKI_JKT", false);
        addPattern(PATTERN_SIBOU, SAI_MENSEKI_SYK, "SAI_MENSEKI_SYK", false);
        addPattern(PATTERN_SIBOU, SAI_MENSEKI_MMK, "SAI_MENSEKI_MMK", false);
        addPattern(PATTERN_SIBOU, SAI_MENSEKI_SSN, "SAI_MENSEKI_SSN", false);
        addPattern(PATTERN_SIBOU, SAI_MENSEKI_SONOTA, "SAI_MENSEKI_SONOTA", false);
        addPattern(PATTERN_SIBOU, KAIJYO_JD, "KAIJYO_JD", false);
        addPattern(PATTERN_SIBOU, KAIJYO_SONOTA, "KAIJYO_SONOTA", false);
        addPattern(PATTERN_SIBOU, MUKOU_SG, "MUKOU_SG", false);
        addPattern(PATTERN_SIBOU, MUKOU_HHST, "MUKOU_HHST", false);
        addPattern(PATTERN_SIBOU, MUKOU_SONOTA, "MUKOU_SONOTA", false);


        addPattern(PATTERN_KOUSYOU, BLNK, "BLNK", true);
        addPattern(PATTERN_KOUSYOU, JTHG, "JTHG", false);
        addPattern(PATTERN_KOUSYOU, SMK, "SMK", false);
        addPattern(PATTERN_KOUSYOU, KMAEHB, "KMAEHB", false);
        addPattern(PATTERN_KOUSYOU, KMAEJK, "KMAEJK", false);
        addPattern(PATTERN_KOUSYOU, SONOTAHG, "SONOTAHG", false);
        addPattern(PATTERN_KOUSYOU, KOI, "KOI", false);
        addPattern(PATTERN_KOUSYOU, SONOTA_MS, "SONOTA_MS", false);
        addPattern(PATTERN_KOUSYOU, KAIJYO_KKTIH, "KAIJYO_KKTIH", false);
        addPattern(PATTERN_KOUSYOU, KAIJYO_JD, "KAIJYO_JD", false);
        addPattern(PATTERN_KOUSYOU, KAIJYO_SONOTA, "KAIJYO_SONOTA", false);
        addPattern(PATTERN_KOUSYOU, MUKOU_SG, "MUKOU_SG", false);
        addPattern(PATTERN_KOUSYOU, MUKOU_HHST, "MUKOU_HHST", false);
        addPattern(PATTERN_KOUSYOU, MUKOU_SONOTA, "MUKOU_SONOTA", false);


        addPattern(PATTERN_LN, BLNK, "BLNK", false);
        addPattern(PATTERN_LN, KYKMAE, "KYKMAE", false);
        addPattern(PATTERN_LN, SSN, "SSN", false);
        addPattern(PATTERN_LN, MMK, "MMK", false);
        addPattern(PATTERN_LN, SYK, "SYK", false);
        addPattern(PATTERN_LN, SONOTA, "SONOTA", false);


        lock(C_HushrGeninKbn.class);
    }

    private C_HushrGeninKbn(String value) {
        super(value);
    }

    public static C_HushrGeninKbn valueOf(String value) {
        return valueOf(C_HushrGeninKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HushrGeninKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HushrGeninKbn.class, patternId, value);
    }
}
