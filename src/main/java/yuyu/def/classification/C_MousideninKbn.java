
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 申出人区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MousideninKbn</td><td colspan="3">申出人区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="16">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UKTHONNIN}</td><td>&quot;1&quot;</td><td>受取人本人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UKTDAIHYOU}</td><td>&quot;2&quot;</td><td>受取人代表者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #STDRNIN}</td><td>&quot;3&quot;</td><td>指定代理人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKENSYA}</td><td>&quot;4&quot;</td><td>親権者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUKENNIN}</td><td>&quot;5&quot;</td><td>後見人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUZOKUNIN}</td><td>&quot;6&quot;</td><td>相続人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOUJIN}</td><td>&quot;7&quot;</td><td>法人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKNHONNIN}</td><td>&quot;8&quot;</td><td>被保険者本人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKHONNIN}</td><td>&quot;9&quot;</td><td>契約者本人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUZOKUNIN_DHARI}</td><td>&quot;10&quot;</td><td>相続人(代表選任届出力あり)</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUZOKUNIN_DHNONE}</td><td>&quot;11&quot;</td><td>相続人(代表選任届出力なし)</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TRKKZK1}</td><td>&quot;12&quot;</td><td>登録家族（１人目）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TRKKZK2}</td><td>&quot;13&quot;</td><td>登録家族（２人目）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKDAIRININ}</td><td>&quot;14&quot;</td><td>契約者代理人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_HKKYH HKKYH}<br />(保険金給付金申出受付時)</td><td align="center">&nbsp;</td><td>{@link #UKTHONNIN}</td><td>&quot;1&quot;</td><td>受取人本人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UKTDAIHYOU}</td><td>&quot;2&quot;</td><td>受取人代表者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKDAIRININ}</td><td>&quot;14&quot;</td><td>契約者代理人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKENSYA}</td><td>&quot;4&quot;</td><td>親権者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUKENNIN}</td><td>&quot;5&quot;</td><td>後見人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUZOKUNIN}</td><td>&quot;6&quot;</td><td>相続人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_TTD TTD}<br />(手続案内照会時)</td><td align="center">&nbsp;</td><td>{@link #HHKNHONNIN}</td><td>&quot;8&quot;</td><td>被保険者本人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #STDRNIN}</td><td>&quot;3&quot;</td><td>指定代理人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_KYHKN KYHKN}<br />(給付金申出受付時)</td><td align="center">&nbsp;</td><td>{@link #UKTHONNIN}</td><td>&quot;1&quot;</td><td>受取人本人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #STDRNIN}</td><td>&quot;3&quot;</td><td>指定代理人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKENSYA}</td><td>&quot;4&quot;</td><td>親権者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUKENNIN}</td><td>&quot;5&quot;</td><td>後見人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUZOKUNIN_DHARI}</td><td>&quot;10&quot;</td><td>相続人（代表選任届出力あり）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUZOKUNIN_DHNONE}</td><td>&quot;11&quot;</td><td>相続人（代表選任届出力なし）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOUJIN}</td><td>&quot;7&quot;</td><td>法人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_PM PM}<br />(Ｐ免)</td><td align="center">&nbsp;</td><td>{@link #KYKHONNIN}</td><td>&quot;9&quot;</td><td>契約者本人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #STDRNIN}</td><td>&quot;3&quot;</td><td>指定代理人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKENSYA}</td><td>&quot;4&quot;</td><td>親権者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUKENNIN}</td><td>&quot;5&quot;</td><td>後見人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUZOKUNIN}</td><td>&quot;6&quot;</td><td>相続人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOUJIN}</td><td>&quot;7&quot;</td><td>法人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_KZKTRKKYKDRTKYKHNK KZKTRKKYKDRTKYKHNK}<br />(家族登録契約者代理特約変更)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKHONNIN}</td><td>&quot;9&quot;</td><td>契約者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKNHONNIN}</td><td>&quot;8&quot;</td><td>被保険者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TRKKZK1}</td><td>&quot;12&quot;</td><td>登録家族（１人目）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TRKKZK2}</td><td>&quot;13&quot;</td><td>登録家族（２人目）</td></tr>
 * </table>
 */
public class C_MousideninKbn extends Classification<C_MousideninKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MousideninKbn BLNK = new C_MousideninKbn("0");

    public static final C_MousideninKbn UKTHONNIN = new C_MousideninKbn("1");

    public static final C_MousideninKbn UKTDAIHYOU = new C_MousideninKbn("2");

    public static final C_MousideninKbn STDRNIN = new C_MousideninKbn("3");

    public static final C_MousideninKbn SINKENSYA = new C_MousideninKbn("4");

    public static final C_MousideninKbn KOUKENNIN = new C_MousideninKbn("5");

    public static final C_MousideninKbn SOUZOKUNIN = new C_MousideninKbn("6");

    public static final C_MousideninKbn HOUJIN = new C_MousideninKbn("7");

    public static final C_MousideninKbn HHKNHONNIN = new C_MousideninKbn("8");

    public static final C_MousideninKbn KYKHONNIN = new C_MousideninKbn("9");

    public static final C_MousideninKbn SOUZOKUNIN_DHARI = new C_MousideninKbn("10");

    public static final C_MousideninKbn SOUZOKUNIN_DHNONE = new C_MousideninKbn("11");

    public static final C_MousideninKbn TRKKZK1 = new C_MousideninKbn("12");

    public static final C_MousideninKbn TRKKZK2 = new C_MousideninKbn("13");

    public static final C_MousideninKbn KYKDAIRININ = new C_MousideninKbn("14");

    public static final C_MousideninKbn SONOTA = new C_MousideninKbn("99");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_HKKYH = "2";

    public static final String PATTERN_TTD = "3";

    public static final String PATTERN_KYHKN = "4";

    public static final String PATTERN_PM = "5";

    public static final String PATTERN_KZKTRKKYKDRTKYKHNK = "6";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, UKTHONNIN, "UKTHONNIN", false);
        addPattern(PATTERN_DEFAULT, UKTDAIHYOU, "UKTDAIHYOU", false);
        addPattern(PATTERN_DEFAULT, STDRNIN, "STDRNIN", false);
        addPattern(PATTERN_DEFAULT, SINKENSYA, "SINKENSYA", false);
        addPattern(PATTERN_DEFAULT, KOUKENNIN, "KOUKENNIN", false);
        addPattern(PATTERN_DEFAULT, SOUZOKUNIN, "SOUZOKUNIN", false);
        addPattern(PATTERN_DEFAULT, HOUJIN, "HOUJIN", false);
        addPattern(PATTERN_DEFAULT, HHKNHONNIN, "HHKNHONNIN", false);
        addPattern(PATTERN_DEFAULT, KYKHONNIN, "KYKHONNIN", false);
        addPattern(PATTERN_DEFAULT, SOUZOKUNIN_DHARI, "SOUZOKUNIN_DHARI", false);
        addPattern(PATTERN_DEFAULT, SOUZOKUNIN_DHNONE, "SOUZOKUNIN_DHNONE", false);
        addPattern(PATTERN_DEFAULT, TRKKZK1, "TRKKZK1", false);
        addPattern(PATTERN_DEFAULT, TRKKZK2, "TRKKZK2", false);
        addPattern(PATTERN_DEFAULT, KYKDAIRININ, "KYKDAIRININ", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        addPattern(PATTERN_HKKYH, UKTHONNIN, "UKTHONNIN", false);
        addPattern(PATTERN_HKKYH, UKTDAIHYOU, "UKTDAIHYOU", false);
        addPattern(PATTERN_HKKYH, KYKDAIRININ, "KYKDAIRININ", false);
        addPattern(PATTERN_HKKYH, SINKENSYA, "SINKENSYA", false);
        addPattern(PATTERN_HKKYH, KOUKENNIN, "KOUKENNIN", false);
        addPattern(PATTERN_HKKYH, SOUZOKUNIN, "SOUZOKUNIN", false);
        addPattern(PATTERN_HKKYH, SONOTA, "SONOTA", false);


        addPattern(PATTERN_TTD, HHKNHONNIN, "HHKNHONNIN", false);
        addPattern(PATTERN_TTD, STDRNIN, "STDRNIN", false);
        addPattern(PATTERN_TTD, SONOTA, "SONOTA", false);


        addPattern(PATTERN_KYHKN, UKTHONNIN, "UKTHONNIN", false);
        addPattern(PATTERN_KYHKN, STDRNIN, "STDRNIN", false);
        addPattern(PATTERN_KYHKN, SINKENSYA, "SINKENSYA", false);
        addPattern(PATTERN_KYHKN, KOUKENNIN, "KOUKENNIN", false);
        addPattern(PATTERN_KYHKN, SOUZOKUNIN_DHARI, "SOUZOKUNIN_DHARI", false);
        addPattern(PATTERN_KYHKN, SOUZOKUNIN_DHNONE, "SOUZOKUNIN_DHNONE", false);
        addPattern(PATTERN_KYHKN, HOUJIN, "HOUJIN", false);
        addPattern(PATTERN_KYHKN, SONOTA, "SONOTA", false);


        addPattern(PATTERN_PM, KYKHONNIN, "KYKHONNIN", false);
        addPattern(PATTERN_PM, STDRNIN, "STDRNIN", false);
        addPattern(PATTERN_PM, SINKENSYA, "SINKENSYA", false);
        addPattern(PATTERN_PM, KOUKENNIN, "KOUKENNIN", false);
        addPattern(PATTERN_PM, SOUZOKUNIN, "SOUZOKUNIN", false);
        addPattern(PATTERN_PM, HOUJIN, "HOUJIN", false);
        addPattern(PATTERN_PM, SONOTA, "SONOTA", false);


        addPattern(PATTERN_KZKTRKKYKDRTKYKHNK, BLNK, "BLNK", false);
        addPattern(PATTERN_KZKTRKKYKDRTKYKHNK, KYKHONNIN, "KYKHONNIN", false);
        addPattern(PATTERN_KZKTRKKYKDRTKYKHNK, HHKNHONNIN, "HHKNHONNIN", false);
        addPattern(PATTERN_KZKTRKKYKDRTKYKHNK, TRKKZK1, "TRKKZK1", false);
        addPattern(PATTERN_KZKTRKKYKDRTKYKHNK, TRKKZK2, "TRKKZK2", false);


        lock(C_MousideninKbn.class);
    }

    private C_MousideninKbn(String value) {
        super(value);
    }

    public static C_MousideninKbn valueOf(String value) {
        return valueOf(C_MousideninKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MousideninKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MousideninKbn.class, patternId, value);
    }
}
