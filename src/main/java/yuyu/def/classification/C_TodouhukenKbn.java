
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 都道府県区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TodouhukenKbn</td><td colspan="3">都道府県区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="48">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKKAIDOU}</td><td>&quot;1&quot;</td><td>北海道</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AOMORI}</td><td>&quot;2&quot;</td><td>青森県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IWATE}</td><td>&quot;3&quot;</td><td>岩手県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIYAGI}</td><td>&quot;4&quot;</td><td>宮城県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AKITA}</td><td>&quot;5&quot;</td><td>秋田県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YAMAGATA}</td><td>&quot;6&quot;</td><td>山形県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKUSIMA}</td><td>&quot;7&quot;</td><td>福島県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IBARAKI}</td><td>&quot;8&quot;</td><td>茨城県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOTIGI}</td><td>&quot;9&quot;</td><td>栃木県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GUNMA}</td><td>&quot;10&quot;</td><td>群馬県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAITAMA}</td><td>&quot;11&quot;</td><td>埼玉県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TIBA}</td><td>&quot;12&quot;</td><td>千葉県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKYO}</td><td>&quot;13&quot;</td><td>東京都</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANAGAWA}</td><td>&quot;14&quot;</td><td>神奈川県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NIGATA}</td><td>&quot;15&quot;</td><td>新潟県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOYAMA}</td><td>&quot;16&quot;</td><td>富山県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ISIKAWA}</td><td>&quot;17&quot;</td><td>石川県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKUI}</td><td>&quot;18&quot;</td><td>福井県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YAMANASI}</td><td>&quot;19&quot;</td><td>山梨県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NAGANO}</td><td>&quot;20&quot;</td><td>長野県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GIHU}</td><td>&quot;21&quot;</td><td>岐阜県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIZUOKA}</td><td>&quot;22&quot;</td><td>静岡県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AITI}</td><td>&quot;23&quot;</td><td>愛知県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIE}</td><td>&quot;24&quot;</td><td>三重県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIGA}</td><td>&quot;25&quot;</td><td>滋賀県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYOTO}</td><td>&quot;26&quot;</td><td>京都府</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OSAKA}</td><td>&quot;27&quot;</td><td>大阪府</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HYOGO}</td><td>&quot;28&quot;</td><td>兵庫県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NARA}</td><td>&quot;29&quot;</td><td>奈良県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WAKAYAMA}</td><td>&quot;30&quot;</td><td>和歌山県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOTTORI}</td><td>&quot;31&quot;</td><td>鳥取県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIMANE}</td><td>&quot;32&quot;</td><td>島根県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OKAYAMA}</td><td>&quot;33&quot;</td><td>岡山県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HIROSIMA}</td><td>&quot;34&quot;</td><td>広島県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YAMAGUTI}</td><td>&quot;35&quot;</td><td>山口県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUSIMA}</td><td>&quot;36&quot;</td><td>徳島県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAGAWA}</td><td>&quot;37&quot;</td><td>香川県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EHIME}</td><td>&quot;38&quot;</td><td>愛媛県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUTI}</td><td>&quot;39&quot;</td><td>高知県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKUOKA}</td><td>&quot;40&quot;</td><td>福岡県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAGA}</td><td>&quot;41&quot;</td><td>佐賀県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NAGASAKI}</td><td>&quot;42&quot;</td><td>長崎県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KUMAMOTO}</td><td>&quot;43&quot;</td><td>熊本県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OITA}</td><td>&quot;44&quot;</td><td>大分県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIYAZAKI}</td><td>&quot;45&quot;</td><td>宮崎県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAGOSIMA}</td><td>&quot;46&quot;</td><td>鹿児島県</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OKINAWA}</td><td>&quot;47&quot;</td><td>沖縄県</td></tr>
 * </table>
 */
public class C_TodouhukenKbn extends Classification<C_TodouhukenKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TodouhukenKbn BLNK = new C_TodouhukenKbn("0");

    public static final C_TodouhukenKbn HOKKAIDOU = new C_TodouhukenKbn("1");

    public static final C_TodouhukenKbn AOMORI = new C_TodouhukenKbn("2");

    public static final C_TodouhukenKbn IWATE = new C_TodouhukenKbn("3");

    public static final C_TodouhukenKbn MIYAGI = new C_TodouhukenKbn("4");

    public static final C_TodouhukenKbn AKITA = new C_TodouhukenKbn("5");

    public static final C_TodouhukenKbn YAMAGATA = new C_TodouhukenKbn("6");

    public static final C_TodouhukenKbn HUKUSIMA = new C_TodouhukenKbn("7");

    public static final C_TodouhukenKbn IBARAKI = new C_TodouhukenKbn("8");

    public static final C_TodouhukenKbn TOTIGI = new C_TodouhukenKbn("9");

    public static final C_TodouhukenKbn GUNMA = new C_TodouhukenKbn("10");

    public static final C_TodouhukenKbn SAITAMA = new C_TodouhukenKbn("11");

    public static final C_TodouhukenKbn TIBA = new C_TodouhukenKbn("12");

    public static final C_TodouhukenKbn TOKYO = new C_TodouhukenKbn("13");

    public static final C_TodouhukenKbn KANAGAWA = new C_TodouhukenKbn("14");

    public static final C_TodouhukenKbn NIGATA = new C_TodouhukenKbn("15");

    public static final C_TodouhukenKbn TOYAMA = new C_TodouhukenKbn("16");

    public static final C_TodouhukenKbn ISIKAWA = new C_TodouhukenKbn("17");

    public static final C_TodouhukenKbn HUKUI = new C_TodouhukenKbn("18");

    public static final C_TodouhukenKbn YAMANASI = new C_TodouhukenKbn("19");

    public static final C_TodouhukenKbn NAGANO = new C_TodouhukenKbn("20");

    public static final C_TodouhukenKbn GIHU = new C_TodouhukenKbn("21");

    public static final C_TodouhukenKbn SIZUOKA = new C_TodouhukenKbn("22");

    public static final C_TodouhukenKbn AITI = new C_TodouhukenKbn("23");

    public static final C_TodouhukenKbn MIE = new C_TodouhukenKbn("24");

    public static final C_TodouhukenKbn SIGA = new C_TodouhukenKbn("25");

    public static final C_TodouhukenKbn KYOTO = new C_TodouhukenKbn("26");

    public static final C_TodouhukenKbn OSAKA = new C_TodouhukenKbn("27");

    public static final C_TodouhukenKbn HYOGO = new C_TodouhukenKbn("28");

    public static final C_TodouhukenKbn NARA = new C_TodouhukenKbn("29");

    public static final C_TodouhukenKbn WAKAYAMA = new C_TodouhukenKbn("30");

    public static final C_TodouhukenKbn TOTTORI = new C_TodouhukenKbn("31");

    public static final C_TodouhukenKbn SIMANE = new C_TodouhukenKbn("32");

    public static final C_TodouhukenKbn OKAYAMA = new C_TodouhukenKbn("33");

    public static final C_TodouhukenKbn HIROSIMA = new C_TodouhukenKbn("34");

    public static final C_TodouhukenKbn YAMAGUTI = new C_TodouhukenKbn("35");

    public static final C_TodouhukenKbn TOKUSIMA = new C_TodouhukenKbn("36");

    public static final C_TodouhukenKbn KAGAWA = new C_TodouhukenKbn("37");

    public static final C_TodouhukenKbn EHIME = new C_TodouhukenKbn("38");

    public static final C_TodouhukenKbn KOUTI = new C_TodouhukenKbn("39");

    public static final C_TodouhukenKbn HUKUOKA = new C_TodouhukenKbn("40");

    public static final C_TodouhukenKbn SAGA = new C_TodouhukenKbn("41");

    public static final C_TodouhukenKbn NAGASAKI = new C_TodouhukenKbn("42");

    public static final C_TodouhukenKbn KUMAMOTO = new C_TodouhukenKbn("43");

    public static final C_TodouhukenKbn OITA = new C_TodouhukenKbn("44");

    public static final C_TodouhukenKbn MIYAZAKI = new C_TodouhukenKbn("45");

    public static final C_TodouhukenKbn KAGOSIMA = new C_TodouhukenKbn("46");

    public static final C_TodouhukenKbn OKINAWA = new C_TodouhukenKbn("47");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HOKKAIDOU, "HOKKAIDOU", false);
        addPattern(PATTERN_DEFAULT, AOMORI, "AOMORI", false);
        addPattern(PATTERN_DEFAULT, IWATE, "IWATE", false);
        addPattern(PATTERN_DEFAULT, MIYAGI, "MIYAGI", false);
        addPattern(PATTERN_DEFAULT, AKITA, "AKITA", false);
        addPattern(PATTERN_DEFAULT, YAMAGATA, "YAMAGATA", false);
        addPattern(PATTERN_DEFAULT, HUKUSIMA, "HUKUSIMA", false);
        addPattern(PATTERN_DEFAULT, IBARAKI, "IBARAKI", false);
        addPattern(PATTERN_DEFAULT, TOTIGI, "TOTIGI", false);
        addPattern(PATTERN_DEFAULT, GUNMA, "GUNMA", false);
        addPattern(PATTERN_DEFAULT, SAITAMA, "SAITAMA", false);
        addPattern(PATTERN_DEFAULT, TIBA, "TIBA", false);
        addPattern(PATTERN_DEFAULT, TOKYO, "TOKYO", false);
        addPattern(PATTERN_DEFAULT, KANAGAWA, "KANAGAWA", false);
        addPattern(PATTERN_DEFAULT, NIGATA, "NIGATA", false);
        addPattern(PATTERN_DEFAULT, TOYAMA, "TOYAMA", false);
        addPattern(PATTERN_DEFAULT, ISIKAWA, "ISIKAWA", false);
        addPattern(PATTERN_DEFAULT, HUKUI, "HUKUI", false);
        addPattern(PATTERN_DEFAULT, YAMANASI, "YAMANASI", false);
        addPattern(PATTERN_DEFAULT, NAGANO, "NAGANO", false);
        addPattern(PATTERN_DEFAULT, GIHU, "GIHU", false);
        addPattern(PATTERN_DEFAULT, SIZUOKA, "SIZUOKA", false);
        addPattern(PATTERN_DEFAULT, AITI, "AITI", false);
        addPattern(PATTERN_DEFAULT, MIE, "MIE", false);
        addPattern(PATTERN_DEFAULT, SIGA, "SIGA", false);
        addPattern(PATTERN_DEFAULT, KYOTO, "KYOTO", false);
        addPattern(PATTERN_DEFAULT, OSAKA, "OSAKA", false);
        addPattern(PATTERN_DEFAULT, HYOGO, "HYOGO", false);
        addPattern(PATTERN_DEFAULT, NARA, "NARA", false);
        addPattern(PATTERN_DEFAULT, WAKAYAMA, "WAKAYAMA", false);
        addPattern(PATTERN_DEFAULT, TOTTORI, "TOTTORI", false);
        addPattern(PATTERN_DEFAULT, SIMANE, "SIMANE", false);
        addPattern(PATTERN_DEFAULT, OKAYAMA, "OKAYAMA", false);
        addPattern(PATTERN_DEFAULT, HIROSIMA, "HIROSIMA", false);
        addPattern(PATTERN_DEFAULT, YAMAGUTI, "YAMAGUTI", false);
        addPattern(PATTERN_DEFAULT, TOKUSIMA, "TOKUSIMA", false);
        addPattern(PATTERN_DEFAULT, KAGAWA, "KAGAWA", false);
        addPattern(PATTERN_DEFAULT, EHIME, "EHIME", false);
        addPattern(PATTERN_DEFAULT, KOUTI, "KOUTI", false);
        addPattern(PATTERN_DEFAULT, HUKUOKA, "HUKUOKA", false);
        addPattern(PATTERN_DEFAULT, SAGA, "SAGA", false);
        addPattern(PATTERN_DEFAULT, NAGASAKI, "NAGASAKI", false);
        addPattern(PATTERN_DEFAULT, KUMAMOTO, "KUMAMOTO", false);
        addPattern(PATTERN_DEFAULT, OITA, "OITA", false);
        addPattern(PATTERN_DEFAULT, MIYAZAKI, "MIYAZAKI", false);
        addPattern(PATTERN_DEFAULT, KAGOSIMA, "KAGOSIMA", false);
        addPattern(PATTERN_DEFAULT, OKINAWA, "OKINAWA", false);


        lock(C_TodouhukenKbn.class);
    }

    private C_TodouhukenKbn(String value) {
        super(value);
    }

    public static C_TodouhukenKbn valueOf(String value) {
        return valueOf(C_TodouhukenKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TodouhukenKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TodouhukenKbn.class, patternId, value);
    }
}
