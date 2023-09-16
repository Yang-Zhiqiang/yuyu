
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 財務局コード区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ZaimucdKbn</td><td colspan="3">財務局コード区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="54">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;ZZ&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANTOU_HON}</td><td>&quot;00&quot;</td><td>00:関東財務局（本局）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANTOU_YOKOHAMA}</td><td>&quot;01&quot;</td><td>01:関東財務局（横浜）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANTOU_CHIBA}</td><td>&quot;02&quot;</td><td>02:関東財務局（千葉）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANTOU_KOFU}</td><td>&quot;03&quot;</td><td>03:関東財務局（甲府）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANTOU_TOKYO}</td><td>&quot;04&quot;</td><td>04:関東財務局（東京）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANTOU_MITO}</td><td>&quot;05&quot;</td><td>05:関東財務局（水戸）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANTOU_UTUNOMIYA}</td><td>&quot;06&quot;</td><td>06:関東財務局（宇都宮）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANTOU_MAEBASI}</td><td>&quot;07&quot;</td><td>07:関東財務局（前橋）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANTOU_NAGANO}</td><td>&quot;08&quot;</td><td>08:関東財務局（長野）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANTOU_NIIGATA}</td><td>&quot;09&quot;</td><td>09:関東財務局（新潟）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KINKI_HON}</td><td>&quot;10&quot;</td><td>10:近畿財務局（本局）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KINKI_KYOTO}</td><td>&quot;11&quot;</td><td>11:近畿財務局（京都）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KINKI_KOUBE}</td><td>&quot;12&quot;</td><td>12:近畿財務局（神戸）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KINKI_NARA}</td><td>&quot;13&quot;</td><td>13:近畿財務局（奈良）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KINKI_WAKAYAMA}</td><td>&quot;14&quot;</td><td>14:近畿財務局（和歌山）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KINKI_OOTU}</td><td>&quot;15&quot;</td><td>15:近畿財務局（大津）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKKAIDO_HON}</td><td>&quot;20&quot;</td><td>20:北海道財務局（本局）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKKAIDO_HAKODATE}</td><td>&quot;21&quot;</td><td>21:北海道財務局（函館）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKKAIDO_OTARU}</td><td>&quot;22&quot;</td><td>22:北海道財務局（小樽出張所）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKKAIDO_ASAHIKAWA}</td><td>&quot;23&quot;</td><td>23:北海道財務局（旭川）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKKAIDO_OBIHIRO}</td><td>&quot;24&quot;</td><td>24:北海道財務局（帯広）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKKAIDO_KUSIRO}</td><td>&quot;25&quot;</td><td>25:北海道財務局（釧路）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKKAIDO_KITAMI}</td><td>&quot;26&quot;</td><td>26:北海道財務局（北見出張所）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUHOKU_HON}</td><td>&quot;30&quot;</td><td>30:東北財務局（本局）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUHOKU_MORIOKA}</td><td>&quot;31&quot;</td><td>31:東北財務局（盛岡）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUHOKU_HUKUSIMA}</td><td>&quot;32&quot;</td><td>32:東北財務局（福島）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUHOKU_AKITA}</td><td>&quot;33&quot;</td><td>33:東北財務局（秋田）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUHOKU_AOMORI}</td><td>&quot;34&quot;</td><td>34:東北財務局（青森）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUHOKU_YAMAGATA}</td><td>&quot;35&quot;</td><td>35:東北財務局（山形）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUKAI_HON}</td><td>&quot;40&quot;</td><td>40:東海財務局（本局）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUKAI_SIZUOKA}</td><td>&quot;41&quot;</td><td>41:東海財務局（静岡）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUKAI_TU}</td><td>&quot;42&quot;</td><td>42:東海財務局（津）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUKAI_GIFU}</td><td>&quot;43&quot;</td><td>43:東海財務局（岐阜）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKURIKU_HON}</td><td>&quot;50&quot;</td><td>50:北陸財務局（本局）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKURIKU_HUKUI}</td><td>&quot;51&quot;</td><td>51:北陸財務局（福井）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKURIKU_TOYAMA}</td><td>&quot;52&quot;</td><td>52:北陸財務局（富山）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYUGOKU_HON}</td><td>&quot;60&quot;</td><td>60:中国財務局（本局）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYUGOKU_YAMAGUTI}</td><td>&quot;61&quot;</td><td>61:中国財務局（山口）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYUGOKU_OKAYAMA}</td><td>&quot;62&quot;</td><td>62:中国財務局（岡山）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYUGOKU_TOTTORI}</td><td>&quot;63&quot;</td><td>63:中国財務局（鳥取）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYUGOKU_MATUE}</td><td>&quot;64&quot;</td><td>64:中国財務局（松江）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIKOKU_HON}</td><td>&quot;70&quot;</td><td>70:四国財務局（本局）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIKOKU_MATUYAMA}</td><td>&quot;71&quot;</td><td>71:四国財務局（松山）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIKOKU_TOKUSIMA}</td><td>&quot;72&quot;</td><td>72:四国財務局（徳島）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIKOKU_KOUTI}</td><td>&quot;73&quot;</td><td>73:四国財務局（高知）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKUOKA_HON}</td><td>&quot;80&quot;</td><td>80:福岡財務局（本局）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKUOKA_SAGA}</td><td>&quot;81&quot;</td><td>81:福岡財務局（佐賀）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKUOKA_NAGASAKI}</td><td>&quot;82&quot;</td><td>82:福岡財務局（長崎）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYUSYU_HON}</td><td>&quot;90&quot;</td><td>90:九州財務局（本局）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYUSYU_OOITA}</td><td>&quot;91&quot;</td><td>91:九州財務局（大分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYUSYU_KAGOSIMA}</td><td>&quot;92&quot;</td><td>92:九州財務局（鹿児島）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYUSYU_MIYAZAKI}</td><td>&quot;93&quot;</td><td>93:九州財務局（宮崎）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OKINAWA_HON}</td><td>&quot;99&quot;</td><td>99:沖縄総合事務局（本局）</td></tr>
 * </table>
 */
public class C_ZaimucdKbn extends Classification<C_ZaimucdKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ZaimucdKbn BLNK = new C_ZaimucdKbn("ZZ");

    public static final C_ZaimucdKbn KANTOU_HON = new C_ZaimucdKbn("00");

    public static final C_ZaimucdKbn KANTOU_YOKOHAMA = new C_ZaimucdKbn("01");

    public static final C_ZaimucdKbn KANTOU_CHIBA = new C_ZaimucdKbn("02");

    public static final C_ZaimucdKbn KANTOU_KOFU = new C_ZaimucdKbn("03");

    public static final C_ZaimucdKbn KANTOU_TOKYO = new C_ZaimucdKbn("04");

    public static final C_ZaimucdKbn KANTOU_MITO = new C_ZaimucdKbn("05");

    public static final C_ZaimucdKbn KANTOU_UTUNOMIYA = new C_ZaimucdKbn("06");

    public static final C_ZaimucdKbn KANTOU_MAEBASI = new C_ZaimucdKbn("07");

    public static final C_ZaimucdKbn KANTOU_NAGANO = new C_ZaimucdKbn("08");

    public static final C_ZaimucdKbn KANTOU_NIIGATA = new C_ZaimucdKbn("09");

    public static final C_ZaimucdKbn KINKI_HON = new C_ZaimucdKbn("10");

    public static final C_ZaimucdKbn KINKI_KYOTO = new C_ZaimucdKbn("11");

    public static final C_ZaimucdKbn KINKI_KOUBE = new C_ZaimucdKbn("12");

    public static final C_ZaimucdKbn KINKI_NARA = new C_ZaimucdKbn("13");

    public static final C_ZaimucdKbn KINKI_WAKAYAMA = new C_ZaimucdKbn("14");

    public static final C_ZaimucdKbn KINKI_OOTU = new C_ZaimucdKbn("15");

    public static final C_ZaimucdKbn HOKKAIDO_HON = new C_ZaimucdKbn("20");

    public static final C_ZaimucdKbn HOKKAIDO_HAKODATE = new C_ZaimucdKbn("21");

    public static final C_ZaimucdKbn HOKKAIDO_OTARU = new C_ZaimucdKbn("22");

    public static final C_ZaimucdKbn HOKKAIDO_ASAHIKAWA = new C_ZaimucdKbn("23");

    public static final C_ZaimucdKbn HOKKAIDO_OBIHIRO = new C_ZaimucdKbn("24");

    public static final C_ZaimucdKbn HOKKAIDO_KUSIRO = new C_ZaimucdKbn("25");

    public static final C_ZaimucdKbn HOKKAIDO_KITAMI = new C_ZaimucdKbn("26");

    public static final C_ZaimucdKbn TOUHOKU_HON = new C_ZaimucdKbn("30");

    public static final C_ZaimucdKbn TOUHOKU_MORIOKA = new C_ZaimucdKbn("31");

    public static final C_ZaimucdKbn TOUHOKU_HUKUSIMA = new C_ZaimucdKbn("32");

    public static final C_ZaimucdKbn TOUHOKU_AKITA = new C_ZaimucdKbn("33");

    public static final C_ZaimucdKbn TOUHOKU_AOMORI = new C_ZaimucdKbn("34");

    public static final C_ZaimucdKbn TOUHOKU_YAMAGATA = new C_ZaimucdKbn("35");

    public static final C_ZaimucdKbn TOUKAI_HON = new C_ZaimucdKbn("40");

    public static final C_ZaimucdKbn TOUKAI_SIZUOKA = new C_ZaimucdKbn("41");

    public static final C_ZaimucdKbn TOUKAI_TU = new C_ZaimucdKbn("42");

    public static final C_ZaimucdKbn TOUKAI_GIFU = new C_ZaimucdKbn("43");

    public static final C_ZaimucdKbn HOKURIKU_HON = new C_ZaimucdKbn("50");

    public static final C_ZaimucdKbn HOKURIKU_HUKUI = new C_ZaimucdKbn("51");

    public static final C_ZaimucdKbn HOKURIKU_TOYAMA = new C_ZaimucdKbn("52");

    public static final C_ZaimucdKbn TYUGOKU_HON = new C_ZaimucdKbn("60");

    public static final C_ZaimucdKbn TYUGOKU_YAMAGUTI = new C_ZaimucdKbn("61");

    public static final C_ZaimucdKbn TYUGOKU_OKAYAMA = new C_ZaimucdKbn("62");

    public static final C_ZaimucdKbn TYUGOKU_TOTTORI = new C_ZaimucdKbn("63");

    public static final C_ZaimucdKbn TYUGOKU_MATUE = new C_ZaimucdKbn("64");

    public static final C_ZaimucdKbn SIKOKU_HON = new C_ZaimucdKbn("70");

    public static final C_ZaimucdKbn SIKOKU_MATUYAMA = new C_ZaimucdKbn("71");

    public static final C_ZaimucdKbn SIKOKU_TOKUSIMA = new C_ZaimucdKbn("72");

    public static final C_ZaimucdKbn SIKOKU_KOUTI = new C_ZaimucdKbn("73");

    public static final C_ZaimucdKbn HUKUOKA_HON = new C_ZaimucdKbn("80");

    public static final C_ZaimucdKbn HUKUOKA_SAGA = new C_ZaimucdKbn("81");

    public static final C_ZaimucdKbn HUKUOKA_NAGASAKI = new C_ZaimucdKbn("82");

    public static final C_ZaimucdKbn KYUSYU_HON = new C_ZaimucdKbn("90");

    public static final C_ZaimucdKbn KYUSYU_OOITA = new C_ZaimucdKbn("91");

    public static final C_ZaimucdKbn KYUSYU_KAGOSIMA = new C_ZaimucdKbn("92");

    public static final C_ZaimucdKbn KYUSYU_MIYAZAKI = new C_ZaimucdKbn("93");

    public static final C_ZaimucdKbn OKINAWA_HON = new C_ZaimucdKbn("99");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KANTOU_HON, "KANTOU_HON", false);
        addPattern(PATTERN_DEFAULT, KANTOU_YOKOHAMA, "KANTOU_YOKOHAMA", false);
        addPattern(PATTERN_DEFAULT, KANTOU_CHIBA, "KANTOU_CHIBA", false);
        addPattern(PATTERN_DEFAULT, KANTOU_KOFU, "KANTOU_KOFU", false);
        addPattern(PATTERN_DEFAULT, KANTOU_TOKYO, "KANTOU_TOKYO", false);
        addPattern(PATTERN_DEFAULT, KANTOU_MITO, "KANTOU_MITO", false);
        addPattern(PATTERN_DEFAULT, KANTOU_UTUNOMIYA, "KANTOU_UTUNOMIYA", false);
        addPattern(PATTERN_DEFAULT, KANTOU_MAEBASI, "KANTOU_MAEBASI", false);
        addPattern(PATTERN_DEFAULT, KANTOU_NAGANO, "KANTOU_NAGANO", false);
        addPattern(PATTERN_DEFAULT, KANTOU_NIIGATA, "KANTOU_NIIGATA", false);
        addPattern(PATTERN_DEFAULT, KINKI_HON, "KINKI_HON", false);
        addPattern(PATTERN_DEFAULT, KINKI_KYOTO, "KINKI_KYOTO", false);
        addPattern(PATTERN_DEFAULT, KINKI_KOUBE, "KINKI_KOUBE", false);
        addPattern(PATTERN_DEFAULT, KINKI_NARA, "KINKI_NARA", false);
        addPattern(PATTERN_DEFAULT, KINKI_WAKAYAMA, "KINKI_WAKAYAMA", false);
        addPattern(PATTERN_DEFAULT, KINKI_OOTU, "KINKI_OOTU", false);
        addPattern(PATTERN_DEFAULT, HOKKAIDO_HON, "HOKKAIDO_HON", false);
        addPattern(PATTERN_DEFAULT, HOKKAIDO_HAKODATE, "HOKKAIDO_HAKODATE", false);
        addPattern(PATTERN_DEFAULT, HOKKAIDO_OTARU, "HOKKAIDO_OTARU", false);
        addPattern(PATTERN_DEFAULT, HOKKAIDO_ASAHIKAWA, "HOKKAIDO_ASAHIKAWA", false);
        addPattern(PATTERN_DEFAULT, HOKKAIDO_OBIHIRO, "HOKKAIDO_OBIHIRO", false);
        addPattern(PATTERN_DEFAULT, HOKKAIDO_KUSIRO, "HOKKAIDO_KUSIRO", false);
        addPattern(PATTERN_DEFAULT, HOKKAIDO_KITAMI, "HOKKAIDO_KITAMI", false);
        addPattern(PATTERN_DEFAULT, TOUHOKU_HON, "TOUHOKU_HON", false);
        addPattern(PATTERN_DEFAULT, TOUHOKU_MORIOKA, "TOUHOKU_MORIOKA", false);
        addPattern(PATTERN_DEFAULT, TOUHOKU_HUKUSIMA, "TOUHOKU_HUKUSIMA", false);
        addPattern(PATTERN_DEFAULT, TOUHOKU_AKITA, "TOUHOKU_AKITA", false);
        addPattern(PATTERN_DEFAULT, TOUHOKU_AOMORI, "TOUHOKU_AOMORI", false);
        addPattern(PATTERN_DEFAULT, TOUHOKU_YAMAGATA, "TOUHOKU_YAMAGATA", false);
        addPattern(PATTERN_DEFAULT, TOUKAI_HON, "TOUKAI_HON", false);
        addPattern(PATTERN_DEFAULT, TOUKAI_SIZUOKA, "TOUKAI_SIZUOKA", false);
        addPattern(PATTERN_DEFAULT, TOUKAI_TU, "TOUKAI_TU", false);
        addPattern(PATTERN_DEFAULT, TOUKAI_GIFU, "TOUKAI_GIFU", false);
        addPattern(PATTERN_DEFAULT, HOKURIKU_HON, "HOKURIKU_HON", false);
        addPattern(PATTERN_DEFAULT, HOKURIKU_HUKUI, "HOKURIKU_HUKUI", false);
        addPattern(PATTERN_DEFAULT, HOKURIKU_TOYAMA, "HOKURIKU_TOYAMA", false);
        addPattern(PATTERN_DEFAULT, TYUGOKU_HON, "TYUGOKU_HON", false);
        addPattern(PATTERN_DEFAULT, TYUGOKU_YAMAGUTI, "TYUGOKU_YAMAGUTI", false);
        addPattern(PATTERN_DEFAULT, TYUGOKU_OKAYAMA, "TYUGOKU_OKAYAMA", false);
        addPattern(PATTERN_DEFAULT, TYUGOKU_TOTTORI, "TYUGOKU_TOTTORI", false);
        addPattern(PATTERN_DEFAULT, TYUGOKU_MATUE, "TYUGOKU_MATUE", false);
        addPattern(PATTERN_DEFAULT, SIKOKU_HON, "SIKOKU_HON", false);
        addPattern(PATTERN_DEFAULT, SIKOKU_MATUYAMA, "SIKOKU_MATUYAMA", false);
        addPattern(PATTERN_DEFAULT, SIKOKU_TOKUSIMA, "SIKOKU_TOKUSIMA", false);
        addPattern(PATTERN_DEFAULT, SIKOKU_KOUTI, "SIKOKU_KOUTI", false);
        addPattern(PATTERN_DEFAULT, HUKUOKA_HON, "HUKUOKA_HON", false);
        addPattern(PATTERN_DEFAULT, HUKUOKA_SAGA, "HUKUOKA_SAGA", false);
        addPattern(PATTERN_DEFAULT, HUKUOKA_NAGASAKI, "HUKUOKA_NAGASAKI", false);
        addPattern(PATTERN_DEFAULT, KYUSYU_HON, "KYUSYU_HON", false);
        addPattern(PATTERN_DEFAULT, KYUSYU_OOITA, "KYUSYU_OOITA", false);
        addPattern(PATTERN_DEFAULT, KYUSYU_KAGOSIMA, "KYUSYU_KAGOSIMA", false);
        addPattern(PATTERN_DEFAULT, KYUSYU_MIYAZAKI, "KYUSYU_MIYAZAKI", false);
        addPattern(PATTERN_DEFAULT, OKINAWA_HON, "OKINAWA_HON", false);


        lock(C_ZaimucdKbn.class);
    }

    private C_ZaimucdKbn(String value) {
        super(value);
    }

    public static C_ZaimucdKbn valueOf(String value) {
        return valueOf(C_ZaimucdKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ZaimucdKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ZaimucdKbn.class, patternId, value);
    }
}
