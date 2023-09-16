
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＤＳ処理内容区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DsSyoriNaiyouKbn</td><td colspan="3">ＤＳ処理内容区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="10">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOKITOUROKU}</td><td>&quot;001&quot;</td><td>初期登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYONOINPUT}</td><td>&quot;002&quot;</td><td>証券番号入力</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUTEIANSYONOINPUT}</td><td>&quot;003&quot;</td><td>特定取引用暗証番号入力</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKUINFOSYUTOKU}</td><td>&quot;004&quot;</td><td>解約情報取得</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKUSAISYUUKAKUNIN}</td><td>&quot;005&quot;</td><td>解約最終確認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUURYOUSYORI}</td><td>&quot;006&quot;</td><td>終了処理</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TETUZUKIKEKKA}</td><td>&quot;007&quot;</td><td>手続結果</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IVRRENKEIINFO}</td><td>&quot;008&quot;</td><td>ＩＶＲ連携情報</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TESTCALL}</td><td>&quot;999&quot;</td><td>テストコール</td></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_DENWAKAIYAKU DENWAKAIYAKU}<br />(電話解約受付)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOKITOUROKU}</td><td>&quot;001&quot;</td><td>初期登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYONOINPUT}</td><td>&quot;002&quot;</td><td>証券番号入力</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUTEIANSYONOINPUT}</td><td>&quot;003&quot;</td><td>特定取引用暗証番号入力</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKUINFOSYUTOKU}</td><td>&quot;004&quot;</td><td>解約情報取得</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKUSAISYUUKAKUNIN}</td><td>&quot;005&quot;</td><td>解約最終確認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUURYOUSYORI}</td><td>&quot;006&quot;</td><td>終了処理</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TETUZUKIKEKKA}</td><td>&quot;007&quot;</td><td>手続結果</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IVRRENKEIINFO}</td><td>&quot;008&quot;</td><td>ＩＶＲ連携情報</td></tr>
 * </table>
 */
public class C_DsSyoriNaiyouKbn extends Classification<C_DsSyoriNaiyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DsSyoriNaiyouKbn BLNK = new C_DsSyoriNaiyouKbn("0");

    public static final C_DsSyoriNaiyouKbn SYOKITOUROKU = new C_DsSyoriNaiyouKbn("001");

    public static final C_DsSyoriNaiyouKbn SYONOINPUT = new C_DsSyoriNaiyouKbn("002");

    public static final C_DsSyoriNaiyouKbn TOKUTEIANSYONOINPUT = new C_DsSyoriNaiyouKbn("003");

    public static final C_DsSyoriNaiyouKbn KAIYAKUINFOSYUTOKU = new C_DsSyoriNaiyouKbn("004");

    public static final C_DsSyoriNaiyouKbn KAIYAKUSAISYUUKAKUNIN = new C_DsSyoriNaiyouKbn("005");

    public static final C_DsSyoriNaiyouKbn SYUURYOUSYORI = new C_DsSyoriNaiyouKbn("006");

    public static final C_DsSyoriNaiyouKbn TETUZUKIKEKKA = new C_DsSyoriNaiyouKbn("007");

    public static final C_DsSyoriNaiyouKbn IVRRENKEIINFO = new C_DsSyoriNaiyouKbn("008");

    public static final C_DsSyoriNaiyouKbn TESTCALL = new C_DsSyoriNaiyouKbn("999");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_DENWAKAIYAKU = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYOKITOUROKU, "SYOKITOUROKU", false);
        addPattern(PATTERN_DEFAULT, SYONOINPUT, "SYONOINPUT", false);
        addPattern(PATTERN_DEFAULT, TOKUTEIANSYONOINPUT, "TOKUTEIANSYONOINPUT", false);
        addPattern(PATTERN_DEFAULT, KAIYAKUINFOSYUTOKU, "KAIYAKUINFOSYUTOKU", false);
        addPattern(PATTERN_DEFAULT, KAIYAKUSAISYUUKAKUNIN, "KAIYAKUSAISYUUKAKUNIN", false);
        addPattern(PATTERN_DEFAULT, SYUURYOUSYORI, "SYUURYOUSYORI", false);
        addPattern(PATTERN_DEFAULT, TETUZUKIKEKKA, "TETUZUKIKEKKA", false);
        addPattern(PATTERN_DEFAULT, IVRRENKEIINFO, "IVRRENKEIINFO", false);
        addPattern(PATTERN_DEFAULT, TESTCALL, "TESTCALL", false);


        addPattern(PATTERN_DENWAKAIYAKU, BLNK, "BLNK", true);
        addPattern(PATTERN_DENWAKAIYAKU, SYOKITOUROKU, "SYOKITOUROKU", false);
        addPattern(PATTERN_DENWAKAIYAKU, SYONOINPUT, "SYONOINPUT", false);
        addPattern(PATTERN_DENWAKAIYAKU, TOKUTEIANSYONOINPUT, "TOKUTEIANSYONOINPUT", false);
        addPattern(PATTERN_DENWAKAIYAKU, KAIYAKUINFOSYUTOKU, "KAIYAKUINFOSYUTOKU", false);
        addPattern(PATTERN_DENWAKAIYAKU, KAIYAKUSAISYUUKAKUNIN, "KAIYAKUSAISYUUKAKUNIN", false);
        addPattern(PATTERN_DENWAKAIYAKU, SYUURYOUSYORI, "SYUURYOUSYORI", false);
        addPattern(PATTERN_DENWAKAIYAKU, TETUZUKIKEKKA, "TETUZUKIKEKKA", false);
        addPattern(PATTERN_DENWAKAIYAKU, IVRRENKEIINFO, "IVRRENKEIINFO", false);


        lock(C_DsSyoriNaiyouKbn.class);
    }

    private C_DsSyoriNaiyouKbn(String value) {
        super(value);
    }

    public static C_DsSyoriNaiyouKbn valueOf(String value) {
        return valueOf(C_DsSyoriNaiyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DsSyoriNaiyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DsSyoriNaiyouKbn.class, patternId, value);
    }
}
