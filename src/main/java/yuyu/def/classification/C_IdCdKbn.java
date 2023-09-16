
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＩＤ区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_IdCdKbn</td><td colspan="3">ＩＤ区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="29">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IDKBN_1}</td><td>&quot;01&quot;</td><td>総合職員／一般職員 等</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IDKBN_2}</td><td>&quot;02&quot;</td><td>集金保全職員</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IDKBN_3}</td><td>&quot;03&quot;</td><td>営業職員／支部長／支所長</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IDKBN_5}</td><td>&quot;05&quot;</td><td>代理店募集人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IDKBN_7}</td><td>&quot;07&quot;</td><td>顧問</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IDKBN_8}</td><td>&quot;08&quot;</td><td>フリー嘱託</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IDKBN_10}</td><td>&quot;10&quot;</td><td>オフィスパートナー６Ｈ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IDKBN_11}</td><td>&quot;11&quot;</td><td>オフィスパートナー拠点／派遣スタッフ用ＩＤ（支部）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IDKBN_21}</td><td>&quot;21&quot;</td><td>オフィスパートナー支社／派遣スタッフ用ＩＤ（支社）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IDKBN_22}</td><td>&quot;22&quot;</td><td>オフィスパートナー東京本社／派遣スタッフ用ＩＤ（東京本社）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IDKBN_23}</td><td>&quot;23&quot;</td><td>オフィスパートナー本社／派遣スタッフ用ＩＤ（本社）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IDKBN_30}</td><td>&quot;30&quot;</td><td>スミセイ保険サービス</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IDKBN_31}</td><td>&quot;31&quot;</td><td>スミセイ保険サービス(東京）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IDKBN_32}</td><td>&quot;32&quot;</td><td>スミセイビジネスサービス</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IDKBN_35}</td><td>&quot;35&quot;</td><td>スミセイ保険サービス(名古屋）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IDKBN_36}</td><td>&quot;36&quot;</td><td>住生物産</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IDKBN_39}</td><td>&quot;39&quot;</td><td>スミセイビルマネージメント  東京本店</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IDKBN_44}</td><td>&quot;44&quot;</td><td>カード発行センター</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IDKBN_46}</td><td>&quot;46&quot;</td><td>いずみライフデザイナーズ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IDKBN_47}</td><td>&quot;47&quot;</td><td>ＮＥＣ運行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IDKBN_48}</td><td>&quot;48&quot;</td><td>ＣＳＳ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IDKBN_49}</td><td>&quot;49&quot;</td><td>トランスコスモス</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IDKBN_50}</td><td>&quot;50&quot;</td><td>大阪西運送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IDKBN_51}</td><td>&quot;51&quot;</td><td>スミセイハーモニー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IDKBN_52}</td><td>&quot;52&quot;</td><td>総合証券事務サービス</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IDKBN_56}</td><td>&quot;56&quot;</td><td>ベルシステム２４</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IDKBN_57}</td><td>&quot;57&quot;</td><td>ベルシステム２４（新契約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IDKBN_59}</td><td>&quot;59&quot;</td><td>メディケア生命保険</td></tr>
 * </table>
 */
public class C_IdCdKbn extends Classification<C_IdCdKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_IdCdKbn BLNK = new C_IdCdKbn("00");

    public static final C_IdCdKbn IDKBN_1 = new C_IdCdKbn("01");

    public static final C_IdCdKbn IDKBN_2 = new C_IdCdKbn("02");

    public static final C_IdCdKbn IDKBN_3 = new C_IdCdKbn("03");

    public static final C_IdCdKbn IDKBN_5 = new C_IdCdKbn("05");

    public static final C_IdCdKbn IDKBN_7 = new C_IdCdKbn("07");

    public static final C_IdCdKbn IDKBN_8 = new C_IdCdKbn("08");

    public static final C_IdCdKbn IDKBN_10 = new C_IdCdKbn("10");

    public static final C_IdCdKbn IDKBN_11 = new C_IdCdKbn("11");

    public static final C_IdCdKbn IDKBN_21 = new C_IdCdKbn("21");

    public static final C_IdCdKbn IDKBN_22 = new C_IdCdKbn("22");

    public static final C_IdCdKbn IDKBN_23 = new C_IdCdKbn("23");

    public static final C_IdCdKbn IDKBN_30 = new C_IdCdKbn("30");

    public static final C_IdCdKbn IDKBN_31 = new C_IdCdKbn("31");

    public static final C_IdCdKbn IDKBN_32 = new C_IdCdKbn("32");

    public static final C_IdCdKbn IDKBN_35 = new C_IdCdKbn("35");

    public static final C_IdCdKbn IDKBN_36 = new C_IdCdKbn("36");

    public static final C_IdCdKbn IDKBN_39 = new C_IdCdKbn("39");

    public static final C_IdCdKbn IDKBN_44 = new C_IdCdKbn("44");

    public static final C_IdCdKbn IDKBN_46 = new C_IdCdKbn("46");

    public static final C_IdCdKbn IDKBN_47 = new C_IdCdKbn("47");

    public static final C_IdCdKbn IDKBN_48 = new C_IdCdKbn("48");

    public static final C_IdCdKbn IDKBN_49 = new C_IdCdKbn("49");

    public static final C_IdCdKbn IDKBN_50 = new C_IdCdKbn("50");

    public static final C_IdCdKbn IDKBN_51 = new C_IdCdKbn("51");

    public static final C_IdCdKbn IDKBN_52 = new C_IdCdKbn("52");

    public static final C_IdCdKbn IDKBN_56 = new C_IdCdKbn("56");

    public static final C_IdCdKbn IDKBN_57 = new C_IdCdKbn("57");

    public static final C_IdCdKbn IDKBN_59 = new C_IdCdKbn("59");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, IDKBN_1, "IDKBN_1", false);
        addPattern(PATTERN_DEFAULT, IDKBN_2, "IDKBN_2", false);
        addPattern(PATTERN_DEFAULT, IDKBN_3, "IDKBN_3", false);
        addPattern(PATTERN_DEFAULT, IDKBN_5, "IDKBN_5", false);
        addPattern(PATTERN_DEFAULT, IDKBN_7, "IDKBN_7", false);
        addPattern(PATTERN_DEFAULT, IDKBN_8, "IDKBN_8", false);
        addPattern(PATTERN_DEFAULT, IDKBN_10, "IDKBN_10", false);
        addPattern(PATTERN_DEFAULT, IDKBN_11, "IDKBN_11", false);
        addPattern(PATTERN_DEFAULT, IDKBN_21, "IDKBN_21", false);
        addPattern(PATTERN_DEFAULT, IDKBN_22, "IDKBN_22", false);
        addPattern(PATTERN_DEFAULT, IDKBN_23, "IDKBN_23", false);
        addPattern(PATTERN_DEFAULT, IDKBN_30, "IDKBN_30", false);
        addPattern(PATTERN_DEFAULT, IDKBN_31, "IDKBN_31", false);
        addPattern(PATTERN_DEFAULT, IDKBN_32, "IDKBN_32", false);
        addPattern(PATTERN_DEFAULT, IDKBN_35, "IDKBN_35", false);
        addPattern(PATTERN_DEFAULT, IDKBN_36, "IDKBN_36", false);
        addPattern(PATTERN_DEFAULT, IDKBN_39, "IDKBN_39", false);
        addPattern(PATTERN_DEFAULT, IDKBN_44, "IDKBN_44", false);
        addPattern(PATTERN_DEFAULT, IDKBN_46, "IDKBN_46", false);
        addPattern(PATTERN_DEFAULT, IDKBN_47, "IDKBN_47", false);
        addPattern(PATTERN_DEFAULT, IDKBN_48, "IDKBN_48", false);
        addPattern(PATTERN_DEFAULT, IDKBN_49, "IDKBN_49", false);
        addPattern(PATTERN_DEFAULT, IDKBN_50, "IDKBN_50", false);
        addPattern(PATTERN_DEFAULT, IDKBN_51, "IDKBN_51", false);
        addPattern(PATTERN_DEFAULT, IDKBN_52, "IDKBN_52", false);
        addPattern(PATTERN_DEFAULT, IDKBN_56, "IDKBN_56", false);
        addPattern(PATTERN_DEFAULT, IDKBN_57, "IDKBN_57", false);
        addPattern(PATTERN_DEFAULT, IDKBN_59, "IDKBN_59", false);


        lock(C_IdCdKbn.class);
    }

    private C_IdCdKbn(String value) {
        super(value);
    }

    public static C_IdCdKbn valueOf(String value) {
        return valueOf(C_IdCdKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_IdCdKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_IdCdKbn.class, patternId, value);
    }
}
