
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 受取人区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_UktKbn</td><td colspan="3">受取人区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="14">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYK}</td><td>&quot;1&quot;</td><td>契約者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN}</td><td>&quot;2&quot;</td><td>被保険者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #STDRNIN}</td><td>&quot;3&quot;</td><td>被保険者代理人と同じ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKUSUU}</td><td>&quot;4&quot;</td><td>複数人指定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUZOKUNIN}</td><td>&quot;5&quot;</td><td>相続人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUTEIMEIGI}</td><td>&quot;6&quot;</td><td>特定名義</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBUK}</td><td>&quot;7&quot;</td><td>死亡受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NASI}</td><td>&quot;8&quot;</td><td>指定なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKHGU}</td><td>&quot;9&quot;</td><td>年金受取人の配偶者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUROKUKAZOKU1}</td><td>&quot;10&quot;</td><td>登録家族（１人目）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUROKUKAZOKU2}</td><td>&quot;11&quot;</td><td>登録家族（２人目）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;90&quot;</td><td>その他</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BLNK_BOS}</td><td>&quot;99&quot;</td><td>ブランク（募集用）</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_SIBOU SIBOU}<br />(死亡)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYK}</td><td>&quot;1&quot;</td><td>契約者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #STDRNIN}</td><td>&quot;3&quot;</td><td>被保険者代理人と同じ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;90&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SKSIBOUUKT SKSIBOUUKT}<br />(新契約死亡受取人)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYK}</td><td>&quot;1&quot;</td><td>契約者と同じ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUTEIMEIGI}</td><td>&quot;6&quot;</td><td>特定名義</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_MOS MOS}<br />(申出受付)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #STDRNIN}</td><td>&quot;3&quot;</td><td>被保険者代理人と同じ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;90&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_KHSBUK KHSBUK}<br />(保全死亡受取人)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYK}</td><td>&quot;1&quot;</td><td>契約者と同じ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN}</td><td>&quot;2&quot;</td><td>被保険者と同じ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUZOKUNIN}</td><td>&quot;5&quot;</td><td>相続人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUTEIMEIGI}</td><td>&quot;6&quot;</td><td>特定名義</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_NKUKT NKUKT}<br />(年金受取人)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYK}</td><td>&quot;1&quot;</td><td>契約者と同じ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN}</td><td>&quot;2&quot;</td><td>被保険者と同じ</td></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_SKSTDR SKSTDR}<br />(新契約指定代理)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUROKUKAZOKU1}</td><td>&quot;10&quot;</td><td>登録家族１人目と同じ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUROKUKAZOKU2}</td><td>&quot;11&quot;</td><td>登録家族２人目と同じ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYK}</td><td>&quot;1&quot;</td><td>契約者と同じ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBUK}</td><td>&quot;7&quot;</td><td>死亡受取人と同じ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUTEIMEIGI}</td><td>&quot;6&quot;</td><td>特定名義</td></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_KHSTDR KHSTDR}<br />(保全指定代理)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUROKUKAZOKU1}</td><td>&quot;10&quot;</td><td>登録家族（１人目）と同じ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUROKUKAZOKU2}</td><td>&quot;11&quot;</td><td>登録家族（２人目）と同じ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYK}</td><td>&quot;1&quot;</td><td>契約者と同じ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUTEIMEIGI}</td><td>&quot;6&quot;</td><td>特定名義</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBUK}</td><td>&quot;7&quot;</td><td>死亡受取人と同じ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NASI}</td><td>&quot;8&quot;</td><td>指定なし</td></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_KHSTDRMGHK KHSTDRMGHK}<br />(保全指定代理名義変更)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUROKUKAZOKU1}</td><td>&quot;10&quot;</td><td>登録家族（１人目）と同じ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUROKUKAZOKU2}</td><td>&quot;11&quot;</td><td>登録家族（２人目）と同じ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYK}</td><td>&quot;1&quot;</td><td>契約者と同じ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUTEIMEIGI}</td><td>&quot;6&quot;</td><td>特定名義</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBUK}</td><td>&quot;7&quot;</td><td>死亡受取人と同じ</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_NKSTDRMGHK NKSTDRMGHK}<br />(年金指定代理名義変更)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUTEIMEIGI}</td><td>&quot;6&quot;</td><td>特定名義</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKHGU}</td><td>&quot;9&quot;</td><td>年金受取人の配偶者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;90&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_KNKUKT KNKUKT}<br />(継続年金受取人)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NASI}</td><td>&quot;8&quot;</td><td>指定なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN}</td><td>&quot;2&quot;</td><td>被保険者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUTEIMEIGI}</td><td>&quot;6&quot;</td><td>特定名義</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_KNKUKT_SEL1 KNKUKT_SEL1}<br />(継続年金受取人選択用１)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUTEIMEIGI}</td><td>&quot;6&quot;</td><td>特定名義</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_KNKUKT_SEL2 KNKUKT_SEL2}<br />(継続年金受取人選択用２)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN}</td><td>&quot;2&quot;</td><td>被保険者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUTEIMEIGI}</td><td>&quot;6&quot;</td><td>特定名義</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_KHKYKDR KHKYKDR}<br />(保全契約者代理人)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUROKUKAZOKU1}</td><td>&quot;10&quot;</td><td>登録家族（１人目）と同じ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUROKUKAZOKU2}</td><td>&quot;11&quot;</td><td>登録家族（２人目）と同じ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUTEIMEIGI}</td><td>&quot;6&quot;</td><td>特定名義</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SKKYKDR SKKYKDR}<br />(新契約契約者代理人)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUROKUKAZOKU1}</td><td>&quot;10&quot;</td><td>登録家族１人目と同じ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUROKUKAZOKU2}</td><td>&quot;11&quot;</td><td>登録家族２人目と同じ</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_SKHHKDR SKHHKDR}<br />(新契約被保険者代理人)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUROKUKAZOKU1}</td><td>&quot;10&quot;</td><td>登録家族１人目と同じ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUROKUKAZOKU2}</td><td>&quot;11&quot;</td><td>登録家族２人目と同じ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYK}</td><td>&quot;1&quot;</td><td>契約者と同じ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUTEIMEIGI}</td><td>&quot;6&quot;</td><td>特定名義</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_TEIKISHRUKT TEIKISHRUKT}<br />(定期支払金受取人)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYK}</td><td>&quot;1&quot;</td><td>契約者と同じ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUTEIMEIGI}</td><td>&quot;6&quot;</td><td>特定名義</td></tr>
 * </table>
 */
public class C_UktKbn extends Classification<C_UktKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_UktKbn BLNK = new C_UktKbn("0");

    public static final C_UktKbn KYK = new C_UktKbn("1");

    public static final C_UktKbn HHKN = new C_UktKbn("2");

    public static final C_UktKbn STDRNIN = new C_UktKbn("3");

    public static final C_UktKbn HUKUSUU = new C_UktKbn("4");

    public static final C_UktKbn SOUZOKUNIN = new C_UktKbn("5");

    public static final C_UktKbn TOKUTEIMEIGI = new C_UktKbn("6");

    public static final C_UktKbn SBUK = new C_UktKbn("7");

    public static final C_UktKbn NASI = new C_UktKbn("8");

    public static final C_UktKbn NKHGU = new C_UktKbn("9");

    public static final C_UktKbn TOUROKUKAZOKU1 = new C_UktKbn("10");

    public static final C_UktKbn TOUROKUKAZOKU2 = new C_UktKbn("11");

    public static final C_UktKbn SONOTA = new C_UktKbn("90");

    public static final C_UktKbn BLNK_BOS = new C_UktKbn("99");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SIBOU = "2";

    public static final String PATTERN_SKSIBOUUKT = "3";

    public static final String PATTERN_MOS = "4";

    public static final String PATTERN_KHSBUK = "5";

    public static final String PATTERN_NKUKT = "6";

    public static final String PATTERN_SKSTDR = "7";

    public static final String PATTERN_KHSTDR = "8";

    public static final String PATTERN_KHSTDRMGHK = "9";

    public static final String PATTERN_NKSTDRMGHK = "10";

    public static final String PATTERN_KNKUKT = "11";

    public static final String PATTERN_KNKUKT_SEL1 = "12";

    public static final String PATTERN_KNKUKT_SEL2 = "13";

    public static final String PATTERN_KHKYKDR = "14";

    public static final String PATTERN_SKKYKDR = "15";

    public static final String PATTERN_SKHHKDR = "16";

    public static final String PATTERN_TEIKISHRUKT = "17";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KYK, "KYK", false);
        addPattern(PATTERN_DEFAULT, HHKN, "HHKN", false);
        addPattern(PATTERN_DEFAULT, STDRNIN, "STDRNIN", false);
        addPattern(PATTERN_DEFAULT, HUKUSUU, "HUKUSUU", false);
        addPattern(PATTERN_DEFAULT, SOUZOKUNIN, "SOUZOKUNIN", false);
        addPattern(PATTERN_DEFAULT, TOKUTEIMEIGI, "TOKUTEIMEIGI", false);
        addPattern(PATTERN_DEFAULT, SBUK, "SBUK", false);
        addPattern(PATTERN_DEFAULT, NASI, "NASI", false);
        addPattern(PATTERN_DEFAULT, NKHGU, "NKHGU", false);
        addPattern(PATTERN_DEFAULT, TOUROKUKAZOKU1, "TOUROKUKAZOKU1", false);
        addPattern(PATTERN_DEFAULT, TOUROKUKAZOKU2, "TOUROKUKAZOKU2", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);
        addPattern(PATTERN_DEFAULT, BLNK_BOS, "BLNK_BOS", false);


        addPattern(PATTERN_SIBOU, BLNK, "BLNK", true);
        addPattern(PATTERN_SIBOU, KYK, "KYK", false);
        addPattern(PATTERN_SIBOU, STDRNIN, "STDRNIN", false);
        addPattern(PATTERN_SIBOU, SONOTA, "SONOTA", false);


        addPattern(PATTERN_SKSIBOUUKT, BLNK, "BLNK", true);
        addPattern(PATTERN_SKSIBOUUKT, KYK, "KYK", false);
        addPattern(PATTERN_SKSIBOUUKT, TOKUTEIMEIGI, "TOKUTEIMEIGI", false);


        addPattern(PATTERN_MOS, BLNK, "BLNK", true);
        addPattern(PATTERN_MOS, STDRNIN, "STDRNIN", false);
        addPattern(PATTERN_MOS, SONOTA, "SONOTA", false);


        addPattern(PATTERN_KHSBUK, BLNK, "BLNK", true);
        addPattern(PATTERN_KHSBUK, KYK, "KYK", false);
        addPattern(PATTERN_KHSBUK, HHKN, "HHKN", false);
        addPattern(PATTERN_KHSBUK, SOUZOKUNIN, "SOUZOKUNIN", false);
        addPattern(PATTERN_KHSBUK, TOKUTEIMEIGI, "TOKUTEIMEIGI", false);


        addPattern(PATTERN_NKUKT, BLNK, "BLNK", true);
        addPattern(PATTERN_NKUKT, KYK, "KYK", false);
        addPattern(PATTERN_NKUKT, HHKN, "HHKN", false);


        addPattern(PATTERN_SKSTDR, BLNK, "BLNK", true);
        addPattern(PATTERN_SKSTDR, TOUROKUKAZOKU1, "TOUROKUKAZOKU1", false);
        addPattern(PATTERN_SKSTDR, TOUROKUKAZOKU2, "TOUROKUKAZOKU2", false);
        addPattern(PATTERN_SKSTDR, KYK, "KYK", false);
        addPattern(PATTERN_SKSTDR, SBUK, "SBUK", false);
        addPattern(PATTERN_SKSTDR, TOKUTEIMEIGI, "TOKUTEIMEIGI", false);


        addPattern(PATTERN_KHSTDR, BLNK, "BLNK", true);
        addPattern(PATTERN_KHSTDR, TOUROKUKAZOKU1, "TOUROKUKAZOKU1", false);
        addPattern(PATTERN_KHSTDR, TOUROKUKAZOKU2, "TOUROKUKAZOKU2", false);
        addPattern(PATTERN_KHSTDR, KYK, "KYK", false);
        addPattern(PATTERN_KHSTDR, TOKUTEIMEIGI, "TOKUTEIMEIGI", false);
        addPattern(PATTERN_KHSTDR, SBUK, "SBUK", false);
        addPattern(PATTERN_KHSTDR, NASI, "NASI", false);


        addPattern(PATTERN_KHSTDRMGHK, BLNK, "BLNK", true);
        addPattern(PATTERN_KHSTDRMGHK, TOUROKUKAZOKU1, "TOUROKUKAZOKU1", false);
        addPattern(PATTERN_KHSTDRMGHK, TOUROKUKAZOKU2, "TOUROKUKAZOKU2", false);
        addPattern(PATTERN_KHSTDRMGHK, KYK, "KYK", false);
        addPattern(PATTERN_KHSTDRMGHK, TOKUTEIMEIGI, "TOKUTEIMEIGI", false);
        addPattern(PATTERN_KHSTDRMGHK, SBUK, "SBUK", false);


        addPattern(PATTERN_NKSTDRMGHK, BLNK, "BLNK", true);
        addPattern(PATTERN_NKSTDRMGHK, TOKUTEIMEIGI, "TOKUTEIMEIGI", false);
        addPattern(PATTERN_NKSTDRMGHK, NKHGU, "NKHGU", false);
        addPattern(PATTERN_NKSTDRMGHK, SONOTA, "SONOTA", false);


        addPattern(PATTERN_KNKUKT, BLNK, "BLNK", true);
        addPattern(PATTERN_KNKUKT, NASI, "NASI", false);
        addPattern(PATTERN_KNKUKT, HHKN, "HHKN", false);
        addPattern(PATTERN_KNKUKT, TOKUTEIMEIGI, "TOKUTEIMEIGI", false);


        addPattern(PATTERN_KNKUKT_SEL1, BLNK, "BLNK", true);
        addPattern(PATTERN_KNKUKT_SEL1, TOKUTEIMEIGI, "TOKUTEIMEIGI", false);


        addPattern(PATTERN_KNKUKT_SEL2, BLNK, "BLNK", true);
        addPattern(PATTERN_KNKUKT_SEL2, HHKN, "HHKN", false);
        addPattern(PATTERN_KNKUKT_SEL2, TOKUTEIMEIGI, "TOKUTEIMEIGI", false);


        addPattern(PATTERN_KHKYKDR, BLNK, "BLNK", true);
        addPattern(PATTERN_KHKYKDR, TOUROKUKAZOKU1, "TOUROKUKAZOKU1", false);
        addPattern(PATTERN_KHKYKDR, TOUROKUKAZOKU2, "TOUROKUKAZOKU2", false);
        addPattern(PATTERN_KHKYKDR, TOKUTEIMEIGI, "TOKUTEIMEIGI", false);


        addPattern(PATTERN_SKKYKDR, BLNK, "BLNK", true);
        addPattern(PATTERN_SKKYKDR, TOUROKUKAZOKU1, "TOUROKUKAZOKU1", false);
        addPattern(PATTERN_SKKYKDR, TOUROKUKAZOKU2, "TOUROKUKAZOKU2", false);


        addPattern(PATTERN_SKHHKDR, BLNK, "BLNK", true);
        addPattern(PATTERN_SKHHKDR, TOUROKUKAZOKU1, "TOUROKUKAZOKU1", false);
        addPattern(PATTERN_SKHHKDR, TOUROKUKAZOKU2, "TOUROKUKAZOKU2", false);
        addPattern(PATTERN_SKHHKDR, KYK, "KYK", false);
        addPattern(PATTERN_SKHHKDR, TOKUTEIMEIGI, "TOKUTEIMEIGI", false);


        addPattern(PATTERN_TEIKISHRUKT, BLNK, "BLNK", true);
        addPattern(PATTERN_TEIKISHRUKT, KYK, "KYK", false);
        addPattern(PATTERN_TEIKISHRUKT, TOKUTEIMEIGI, "TOKUTEIMEIGI", false);


        lock(C_UktKbn.class);
    }

    private C_UktKbn(String value) {
        super(value);
    }

    public static C_UktKbn valueOf(String value) {
        return valueOf(C_UktKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_UktKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_UktKbn.class, patternId, value);
    }
}
