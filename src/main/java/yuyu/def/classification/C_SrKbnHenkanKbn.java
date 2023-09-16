
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 数理区分変換区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SrKbnHenkanKbn</td><td colspan="3">数理区分変換区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="26">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>デフォルト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BOSYU_KEITAI}</td><td>&quot;1&quot;</td><td>募集形態区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIRITENGYOUSYU}</td><td>&quot;2&quot;</td><td>募集代理店業種区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEDAI}</td><td>&quot;3&quot;</td><td>世代区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHITEI_DAIRININ}</td><td>&quot;4&quot;</td><td>指定代理人区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIYAKU_HIHOKEN_DOU}</td><td>&quot;5&quot;</td><td>契約者被保険者同一表示</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KETTEI_KEKKA}</td><td>&quot;6&quot;</td><td>決定結果区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIYAKU_KAKUNI_SYU}</td><td>&quot;7&quot;</td><td>契約確認種類区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHIIN}</td><td>&quot;8&quot;</td><td>死因区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOKEIYAKU}</td><td>&quot;9&quot;</td><td>主契約種類コード</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUURISYURUI}</td><td>&quot;10&quot;</td><td>数理種類コード</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHIHARAI_HASSEI_JIYUU}</td><td>&quot;11&quot;</td><td>年金支払発生理由区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHIHARAI_KAISUU}</td><td>&quot;12&quot;</td><td>支払回数区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKIN_D_UKETORI}</td><td>&quot;13&quot;</td><td>年金当Ｄ受取方法区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOS_HONNIN_KAKUNIN}</td><td>&quot;14&quot;</td><td>申込時本人確認区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUURI_HAITOU}</td><td>&quot;15&quot;</td><td>数理用配当区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUURI_KEIYAKUDATE_TUUKA}</td><td>&quot;16&quot;</td><td>数理用契約建通貨区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUURI_NYUUSYUKKIN_TUUKA}</td><td>&quot;17&quot;</td><td>数理用入出金通貨区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUURI_SISUU}</td><td>&quot;18&quot;</td><td>数理用指数区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKINGATA}</td><td>&quot;19&quot;</td><td>年金型区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUURI_SIBOUHYOU}</td><td>&quot;20&quot;</td><td>死亡表区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUURI_SIBOUHYOU2}</td><td>&quot;21&quot;</td><td>死亡表区分２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRK_KAISUU}</td><td>&quot;22&quot;</td><td>払込回数区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRK_KEIRO}</td><td>&quot;23&quot;</td><td>払込経路区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYK_JYOUTAI}</td><td>&quot;24&quot;</td><td>契約状態</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUUKA_SYU}</td><td>&quot;25&quot;</td><td>通貨種類区分</td></tr>
 * </table>
 */
public class C_SrKbnHenkanKbn extends Classification<C_SrKbnHenkanKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SrKbnHenkanKbn BLNK = new C_SrKbnHenkanKbn("0");

    public static final C_SrKbnHenkanKbn BOSYU_KEITAI = new C_SrKbnHenkanKbn("1");

    public static final C_SrKbnHenkanKbn DAIRITENGYOUSYU = new C_SrKbnHenkanKbn("2");

    public static final C_SrKbnHenkanKbn SEDAI = new C_SrKbnHenkanKbn("3");

    public static final C_SrKbnHenkanKbn SHITEI_DAIRININ = new C_SrKbnHenkanKbn("4");

    public static final C_SrKbnHenkanKbn KEIYAKU_HIHOKEN_DOU = new C_SrKbnHenkanKbn("5");

    public static final C_SrKbnHenkanKbn KETTEI_KEKKA = new C_SrKbnHenkanKbn("6");

    public static final C_SrKbnHenkanKbn KEIYAKU_KAKUNI_SYU = new C_SrKbnHenkanKbn("7");

    public static final C_SrKbnHenkanKbn SHIIN = new C_SrKbnHenkanKbn("8");

    public static final C_SrKbnHenkanKbn SYOKEIYAKU = new C_SrKbnHenkanKbn("9");

    public static final C_SrKbnHenkanKbn SUURISYURUI = new C_SrKbnHenkanKbn("10");

    public static final C_SrKbnHenkanKbn SHIHARAI_HASSEI_JIYUU = new C_SrKbnHenkanKbn("11");

    public static final C_SrKbnHenkanKbn SHIHARAI_KAISUU = new C_SrKbnHenkanKbn("12");

    public static final C_SrKbnHenkanKbn NENKIN_D_UKETORI = new C_SrKbnHenkanKbn("13");

    public static final C_SrKbnHenkanKbn MOS_HONNIN_KAKUNIN = new C_SrKbnHenkanKbn("14");

    public static final C_SrKbnHenkanKbn SUURI_HAITOU = new C_SrKbnHenkanKbn("15");

    public static final C_SrKbnHenkanKbn SUURI_KEIYAKUDATE_TUUKA = new C_SrKbnHenkanKbn("16");

    public static final C_SrKbnHenkanKbn SUURI_NYUUSYUKKIN_TUUKA = new C_SrKbnHenkanKbn("17");

    public static final C_SrKbnHenkanKbn SUURI_SISUU = new C_SrKbnHenkanKbn("18");

    public static final C_SrKbnHenkanKbn NENKINGATA = new C_SrKbnHenkanKbn("19");

    public static final C_SrKbnHenkanKbn SUURI_SIBOUHYOU = new C_SrKbnHenkanKbn("20");

    public static final C_SrKbnHenkanKbn SUURI_SIBOUHYOU2 = new C_SrKbnHenkanKbn("21");

    public static final C_SrKbnHenkanKbn HRK_KAISUU = new C_SrKbnHenkanKbn("22");

    public static final C_SrKbnHenkanKbn HRK_KEIRO = new C_SrKbnHenkanKbn("23");

    public static final C_SrKbnHenkanKbn KYK_JYOUTAI = new C_SrKbnHenkanKbn("24");

    public static final C_SrKbnHenkanKbn TUUKA_SYU = new C_SrKbnHenkanKbn("25");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, BOSYU_KEITAI, "BOSYU_KEITAI", false);
        addPattern(PATTERN_DEFAULT, DAIRITENGYOUSYU, "DAIRITENGYOUSYU", false);
        addPattern(PATTERN_DEFAULT, SEDAI, "SEDAI", false);
        addPattern(PATTERN_DEFAULT, SHITEI_DAIRININ, "SHITEI_DAIRININ", false);
        addPattern(PATTERN_DEFAULT, KEIYAKU_HIHOKEN_DOU, "KEIYAKU_HIHOKEN_DOU", false);
        addPattern(PATTERN_DEFAULT, KETTEI_KEKKA, "KETTEI_KEKKA", false);
        addPattern(PATTERN_DEFAULT, KEIYAKU_KAKUNI_SYU, "KEIYAKU_KAKUNI_SYU", false);
        addPattern(PATTERN_DEFAULT, SHIIN, "SHIIN", false);
        addPattern(PATTERN_DEFAULT, SYOKEIYAKU, "SYOKEIYAKU", false);
        addPattern(PATTERN_DEFAULT, SUURISYURUI, "SUURISYURUI", false);
        addPattern(PATTERN_DEFAULT, SHIHARAI_HASSEI_JIYUU, "SHIHARAI_HASSEI_JIYUU", false);
        addPattern(PATTERN_DEFAULT, SHIHARAI_KAISUU, "SHIHARAI_KAISUU", false);
        addPattern(PATTERN_DEFAULT, NENKIN_D_UKETORI, "NENKIN_D_UKETORI", false);
        addPattern(PATTERN_DEFAULT, MOS_HONNIN_KAKUNIN, "MOS_HONNIN_KAKUNIN", false);
        addPattern(PATTERN_DEFAULT, SUURI_HAITOU, "SUURI_HAITOU", false);
        addPattern(PATTERN_DEFAULT, SUURI_KEIYAKUDATE_TUUKA, "SUURI_KEIYAKUDATE_TUUKA", false);
        addPattern(PATTERN_DEFAULT, SUURI_NYUUSYUKKIN_TUUKA, "SUURI_NYUUSYUKKIN_TUUKA", false);
        addPattern(PATTERN_DEFAULT, SUURI_SISUU, "SUURI_SISUU", false);
        addPattern(PATTERN_DEFAULT, NENKINGATA, "NENKINGATA", false);
        addPattern(PATTERN_DEFAULT, SUURI_SIBOUHYOU, "SUURI_SIBOUHYOU", false);
        addPattern(PATTERN_DEFAULT, SUURI_SIBOUHYOU2, "SUURI_SIBOUHYOU2", false);
        addPattern(PATTERN_DEFAULT, HRK_KAISUU, "HRK_KAISUU", false);
        addPattern(PATTERN_DEFAULT, HRK_KEIRO, "HRK_KEIRO", false);
        addPattern(PATTERN_DEFAULT, KYK_JYOUTAI, "KYK_JYOUTAI", false);
        addPattern(PATTERN_DEFAULT, TUUKA_SYU, "TUUKA_SYU", false);


        lock(C_SrKbnHenkanKbn.class);
    }

    private C_SrKbnHenkanKbn(String value) {
        super(value);
    }

    public static C_SrKbnHenkanKbn valueOf(String value) {
        return valueOf(C_SrKbnHenkanKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SrKbnHenkanKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SrKbnHenkanKbn.class, patternId, value);
    }
}
