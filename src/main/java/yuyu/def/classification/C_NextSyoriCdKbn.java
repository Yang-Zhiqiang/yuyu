
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 遷移先処理コード区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NextSyoriCdKbn</td><td colspan="3">遷移先処理コード区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="14">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZIKANGAIERROR}</td><td>&quot;010&quot;</td><td>時間外エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYONOINPUT}</td><td>&quot;020&quot;</td><td>証券番号入力</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUTEIINPUT}</td><td>&quot;030&quot;</td><td>特定取引用暗証番号入力</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYONONINSYOUERROR}</td><td>&quot;040&quot;</td><td>証券番号認証エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYONOTYOUKAERROR}</td><td>&quot;050&quot;</td><td>証券番号認証エラー（規定回数超過）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKUINFOSYUTOKU}</td><td>&quot;060&quot;</td><td>解約情報取得</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUTEIANSYONONINSYOUERROR}</td><td>&quot;070&quot;</td><td>特定取引用暗証番号認証エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUTEIANSYONOTYOUKAERROR}</td><td>&quot;080&quot;</td><td>特定取引用暗証番号認証エラー（規定回超過）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKUSAISYUUKAKUNIIN}</td><td>&quot;090&quot;</td><td>解約最終確認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKUKANRYOU}</td><td>&quot;100&quot;</td><td>解約完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKUTYUUSI}</td><td>&quot;110&quot;</td><td>解約中止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYORITYUUDANGUIDANCE}</td><td>&quot;990&quot;</td><td>処理中断ガイダンス</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TESTCALL}</td><td>&quot;991&quot;</td><td>テストコール</td></tr>
 * </table>
 */
public class C_NextSyoriCdKbn extends Classification<C_NextSyoriCdKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NextSyoriCdKbn BLNK = new C_NextSyoriCdKbn("0");

    public static final C_NextSyoriCdKbn ZIKANGAIERROR = new C_NextSyoriCdKbn("010");

    public static final C_NextSyoriCdKbn SYONOINPUT = new C_NextSyoriCdKbn("020");

    public static final C_NextSyoriCdKbn TOKUTEIINPUT = new C_NextSyoriCdKbn("030");

    public static final C_NextSyoriCdKbn SYONONINSYOUERROR = new C_NextSyoriCdKbn("040");

    public static final C_NextSyoriCdKbn SYONOTYOUKAERROR = new C_NextSyoriCdKbn("050");

    public static final C_NextSyoriCdKbn KAIYAKUINFOSYUTOKU = new C_NextSyoriCdKbn("060");

    public static final C_NextSyoriCdKbn TOKUTEIANSYONONINSYOUERROR = new C_NextSyoriCdKbn("070");

    public static final C_NextSyoriCdKbn TOKUTEIANSYONOTYOUKAERROR = new C_NextSyoriCdKbn("080");

    public static final C_NextSyoriCdKbn KAIYAKUSAISYUUKAKUNIIN = new C_NextSyoriCdKbn("090");

    public static final C_NextSyoriCdKbn KAIYAKUKANRYOU = new C_NextSyoriCdKbn("100");

    public static final C_NextSyoriCdKbn KAIYAKUTYUUSI = new C_NextSyoriCdKbn("110");

    public static final C_NextSyoriCdKbn SYORITYUUDANGUIDANCE = new C_NextSyoriCdKbn("990");

    public static final C_NextSyoriCdKbn TESTCALL = new C_NextSyoriCdKbn("991");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ZIKANGAIERROR, "ZIKANGAIERROR", false);
        addPattern(PATTERN_DEFAULT, SYONOINPUT, "SYONOINPUT", false);
        addPattern(PATTERN_DEFAULT, TOKUTEIINPUT, "TOKUTEIINPUT", false);
        addPattern(PATTERN_DEFAULT, SYONONINSYOUERROR, "SYONONINSYOUERROR", false);
        addPattern(PATTERN_DEFAULT, SYONOTYOUKAERROR, "SYONOTYOUKAERROR", false);
        addPattern(PATTERN_DEFAULT, KAIYAKUINFOSYUTOKU, "KAIYAKUINFOSYUTOKU", false);
        addPattern(PATTERN_DEFAULT, TOKUTEIANSYONONINSYOUERROR, "TOKUTEIANSYONONINSYOUERROR", false);
        addPattern(PATTERN_DEFAULT, TOKUTEIANSYONOTYOUKAERROR, "TOKUTEIANSYONOTYOUKAERROR", false);
        addPattern(PATTERN_DEFAULT, KAIYAKUSAISYUUKAKUNIIN, "KAIYAKUSAISYUUKAKUNIIN", false);
        addPattern(PATTERN_DEFAULT, KAIYAKUKANRYOU, "KAIYAKUKANRYOU", false);
        addPattern(PATTERN_DEFAULT, KAIYAKUTYUUSI, "KAIYAKUTYUUSI", false);
        addPattern(PATTERN_DEFAULT, SYORITYUUDANGUIDANCE, "SYORITYUUDANGUIDANCE", false);
        addPattern(PATTERN_DEFAULT, TESTCALL, "TESTCALL", false);


        lock(C_NextSyoriCdKbn.class);
    }

    private C_NextSyoriCdKbn(String value) {
        super(value);
    }

    public static C_NextSyoriCdKbn valueOf(String value) {
        return valueOf(C_NextSyoriCdKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NextSyoriCdKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NextSyoriCdKbn.class, patternId, value);
    }
}
