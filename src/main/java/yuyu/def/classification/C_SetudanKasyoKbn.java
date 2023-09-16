
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 切断箇所区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SetudanKasyoKbn</td><td colspan="3">切断箇所区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="16">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HASSINNOCHECK}</td><td>&quot;010&quot;</td><td>発信番号チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZIKANGAICHECK}</td><td>&quot;020&quot;</td><td>時間外チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TTDKIDSYUTOKU}</td><td>&quot;030&quot;</td><td>手続識別ＩＤ取得</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OPENING}</td><td>&quot;040&quot;</td><td>オープニング</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYONOINPUT}</td><td>&quot;050&quot;</td><td>証券番号入力</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYONOSYOUGOU}</td><td>&quot;060&quot;</td><td>証券番号照合</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUTEIANSYONOINPUT}</td><td>&quot;070&quot;</td><td>特定取引用暗証番号入力</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUTEIANSYONOSYOUKAI}</td><td>&quot;080&quot;</td><td>特定取引用暗証番号照会</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOMIAGEDATASYUTOKU}</td><td>&quot;090&quot;</td><td>読上げデータ取得</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKUINFOYOMIAGE}</td><td>&quot;100&quot;</td><td>解約情報読上げ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAISYUUKAKUNIN}</td><td>&quot;110&quot;</td><td>最終確認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKUSYORIHANTEISOUSYUTU}</td><td>&quot;120&quot;</td><td>解約処理判定送出</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKUSYORIKANRYOU}</td><td>&quot;130&quot;</td><td>解約処理完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKUSYORITYUUSI}</td><td>&quot;140&quot;</td><td>解約処理中止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IVRSYSTEMERROR}</td><td>&quot;990&quot;</td><td>ＩＶＲシステムエラー</td></tr>
 * </table>
 */
public class C_SetudanKasyoKbn extends Classification<C_SetudanKasyoKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SetudanKasyoKbn BLNK = new C_SetudanKasyoKbn("0");

    public static final C_SetudanKasyoKbn HASSINNOCHECK = new C_SetudanKasyoKbn("010");

    public static final C_SetudanKasyoKbn ZIKANGAICHECK = new C_SetudanKasyoKbn("020");

    public static final C_SetudanKasyoKbn TTDKIDSYUTOKU = new C_SetudanKasyoKbn("030");

    public static final C_SetudanKasyoKbn OPENING = new C_SetudanKasyoKbn("040");

    public static final C_SetudanKasyoKbn SYONOINPUT = new C_SetudanKasyoKbn("050");

    public static final C_SetudanKasyoKbn SYONOSYOUGOU = new C_SetudanKasyoKbn("060");

    public static final C_SetudanKasyoKbn TOKUTEIANSYONOINPUT = new C_SetudanKasyoKbn("070");

    public static final C_SetudanKasyoKbn TOKUTEIANSYONOSYOUKAI = new C_SetudanKasyoKbn("080");

    public static final C_SetudanKasyoKbn YOMIAGEDATASYUTOKU = new C_SetudanKasyoKbn("090");

    public static final C_SetudanKasyoKbn KAIYAKUINFOYOMIAGE = new C_SetudanKasyoKbn("100");

    public static final C_SetudanKasyoKbn SAISYUUKAKUNIN = new C_SetudanKasyoKbn("110");

    public static final C_SetudanKasyoKbn KAIYAKUSYORIHANTEISOUSYUTU = new C_SetudanKasyoKbn("120");

    public static final C_SetudanKasyoKbn KAIYAKUSYORIKANRYOU = new C_SetudanKasyoKbn("130");

    public static final C_SetudanKasyoKbn KAIYAKUSYORITYUUSI = new C_SetudanKasyoKbn("140");

    public static final C_SetudanKasyoKbn IVRSYSTEMERROR = new C_SetudanKasyoKbn("990");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HASSINNOCHECK, "HASSINNOCHECK", false);
        addPattern(PATTERN_DEFAULT, ZIKANGAICHECK, "ZIKANGAICHECK", false);
        addPattern(PATTERN_DEFAULT, TTDKIDSYUTOKU, "TTDKIDSYUTOKU", false);
        addPattern(PATTERN_DEFAULT, OPENING, "OPENING", false);
        addPattern(PATTERN_DEFAULT, SYONOINPUT, "SYONOINPUT", false);
        addPattern(PATTERN_DEFAULT, SYONOSYOUGOU, "SYONOSYOUGOU", false);
        addPattern(PATTERN_DEFAULT, TOKUTEIANSYONOINPUT, "TOKUTEIANSYONOINPUT", false);
        addPattern(PATTERN_DEFAULT, TOKUTEIANSYONOSYOUKAI, "TOKUTEIANSYONOSYOUKAI", false);
        addPattern(PATTERN_DEFAULT, YOMIAGEDATASYUTOKU, "YOMIAGEDATASYUTOKU", false);
        addPattern(PATTERN_DEFAULT, KAIYAKUINFOYOMIAGE, "KAIYAKUINFOYOMIAGE", false);
        addPattern(PATTERN_DEFAULT, SAISYUUKAKUNIN, "SAISYUUKAKUNIN", false);
        addPattern(PATTERN_DEFAULT, KAIYAKUSYORIHANTEISOUSYUTU, "KAIYAKUSYORIHANTEISOUSYUTU", false);
        addPattern(PATTERN_DEFAULT, KAIYAKUSYORIKANRYOU, "KAIYAKUSYORIKANRYOU", false);
        addPattern(PATTERN_DEFAULT, KAIYAKUSYORITYUUSI, "KAIYAKUSYORITYUUSI", false);
        addPattern(PATTERN_DEFAULT, IVRSYSTEMERROR, "IVRSYSTEMERROR", false);


        lock(C_SetudanKasyoKbn.class);
    }

    private C_SetudanKasyoKbn(String value) {
        super(value);
    }

    public static C_SetudanKasyoKbn valueOf(String value) {
        return valueOf(C_SetudanKasyoKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SetudanKasyoKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SetudanKasyoKbn.class, patternId, value);
    }
}
