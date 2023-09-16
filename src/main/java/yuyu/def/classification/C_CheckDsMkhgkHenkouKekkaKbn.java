
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＤＳ目標額変更共通チェック結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_CheckDsMkhgkHenkouKekkaKbn</td><td colspan="3">ＤＳ目標額変更共通チェック結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="13">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLANK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KADOUZIKANGAI}</td><td>&quot;01&quot;</td><td>稼動時間外</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TARGETTKYK}</td><td>&quot;02&quot;</td><td>ターゲット特約チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKISHIHARAITKYK}</td><td>&quot;03&quot;</td><td>定期支払特約チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIYAKUYMDMAE}</td><td>&quot;04&quot;</td><td>契約日前チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DSDATAMAINTENANCE}</td><td>&quot;05&quot;</td><td>ＤＳデータメンテナンス中チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MKHGKHNKKANOUKIKANGAI}</td><td>&quot;06&quot;</td><td>目標額変更可能期間外チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOZENYUUKOUJYOUTAI}</td><td>&quot;07&quot;</td><td>保全有効状態チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TETUDUKITYUUI}</td><td>&quot;08&quot;</td><td>手続注意チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MKHGKWARIGENZAIHENKOUNASHI}</td><td>&quot;09&quot;</td><td>目標額割合入力チェックエラー（現在目標額から変更なし）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MKHGKWARITETUDUKITYUUHENKOUNASHI}</td><td>&quot;10&quot;</td><td>目標額割合入力チェックエラー（変更手続中目標額から変更なし）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MKHGKWARISEIGOUSEI}</td><td>&quot;11&quot;</td><td>目標額割合整合性チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MFHUSEIGOU}</td><td>&quot;12&quot;</td><td>ＭＦ不整合チェックエラー</td></tr>
 * </table>
 */
public class C_CheckDsMkhgkHenkouKekkaKbn extends Classification<C_CheckDsMkhgkHenkouKekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_CheckDsMkhgkHenkouKekkaKbn BLANK = new C_CheckDsMkhgkHenkouKekkaKbn("0");

    public static final C_CheckDsMkhgkHenkouKekkaKbn KADOUZIKANGAI = new C_CheckDsMkhgkHenkouKekkaKbn("01");

    public static final C_CheckDsMkhgkHenkouKekkaKbn TARGETTKYK = new C_CheckDsMkhgkHenkouKekkaKbn("02");

    public static final C_CheckDsMkhgkHenkouKekkaKbn TEIKISHIHARAITKYK = new C_CheckDsMkhgkHenkouKekkaKbn("03");

    public static final C_CheckDsMkhgkHenkouKekkaKbn KEIYAKUYMDMAE = new C_CheckDsMkhgkHenkouKekkaKbn("04");

    public static final C_CheckDsMkhgkHenkouKekkaKbn DSDATAMAINTENANCE = new C_CheckDsMkhgkHenkouKekkaKbn("05");

    public static final C_CheckDsMkhgkHenkouKekkaKbn MKHGKHNKKANOUKIKANGAI = new C_CheckDsMkhgkHenkouKekkaKbn("06");

    public static final C_CheckDsMkhgkHenkouKekkaKbn HOZENYUUKOUJYOUTAI = new C_CheckDsMkhgkHenkouKekkaKbn("07");

    public static final C_CheckDsMkhgkHenkouKekkaKbn TETUDUKITYUUI = new C_CheckDsMkhgkHenkouKekkaKbn("08");

    public static final C_CheckDsMkhgkHenkouKekkaKbn MKHGKWARIGENZAIHENKOUNASHI = new C_CheckDsMkhgkHenkouKekkaKbn("09");

    public static final C_CheckDsMkhgkHenkouKekkaKbn MKHGKWARITETUDUKITYUUHENKOUNASHI = new C_CheckDsMkhgkHenkouKekkaKbn("10");

    public static final C_CheckDsMkhgkHenkouKekkaKbn MKHGKWARISEIGOUSEI = new C_CheckDsMkhgkHenkouKekkaKbn("11");

    public static final C_CheckDsMkhgkHenkouKekkaKbn MFHUSEIGOU = new C_CheckDsMkhgkHenkouKekkaKbn("12");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLANK, "BLANK", true);
        addPattern(PATTERN_DEFAULT, KADOUZIKANGAI, "KADOUZIKANGAI", false);
        addPattern(PATTERN_DEFAULT, TARGETTKYK, "TARGETTKYK", false);
        addPattern(PATTERN_DEFAULT, TEIKISHIHARAITKYK, "TEIKISHIHARAITKYK", false);
        addPattern(PATTERN_DEFAULT, KEIYAKUYMDMAE, "KEIYAKUYMDMAE", false);
        addPattern(PATTERN_DEFAULT, DSDATAMAINTENANCE, "DSDATAMAINTENANCE", false);
        addPattern(PATTERN_DEFAULT, MKHGKHNKKANOUKIKANGAI, "MKHGKHNKKANOUKIKANGAI", false);
        addPattern(PATTERN_DEFAULT, HOZENYUUKOUJYOUTAI, "HOZENYUUKOUJYOUTAI", false);
        addPattern(PATTERN_DEFAULT, TETUDUKITYUUI, "TETUDUKITYUUI", false);
        addPattern(PATTERN_DEFAULT, MKHGKWARIGENZAIHENKOUNASHI, "MKHGKWARIGENZAIHENKOUNASHI", false);
        addPattern(PATTERN_DEFAULT, MKHGKWARITETUDUKITYUUHENKOUNASHI, "MKHGKWARITETUDUKITYUUHENKOUNASHI", false);
        addPattern(PATTERN_DEFAULT, MKHGKWARISEIGOUSEI, "MKHGKWARISEIGOUSEI", false);
        addPattern(PATTERN_DEFAULT, MFHUSEIGOU, "MFHUSEIGOU", false);


        lock(C_CheckDsMkhgkHenkouKekkaKbn.class);
    }

    private C_CheckDsMkhgkHenkouKekkaKbn(String value) {
        super(value);
    }

    public static C_CheckDsMkhgkHenkouKekkaKbn valueOf(String value) {
        return valueOf(C_CheckDsMkhgkHenkouKekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_CheckDsMkhgkHenkouKekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_CheckDsMkhgkHenkouKekkaKbn.class, patternId, value);
    }
}
