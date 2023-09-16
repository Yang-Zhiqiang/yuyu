
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 番号種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NosyuruiKbn</td><td colspan="3">番号種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="27">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #KOKYAKUNO}</td><td>&quot;1&quot;</td><td>顧客番号</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MRJHNO}</td><td>&quot;2&quot;</td><td>MR情報番号</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIKYUNO}</td><td>&quot;3&quot;</td><td>請求番号</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEISYOUNINKEY}</td><td>&quot;4&quot;</td><td>査定承認識別キー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHRSIKIBETUKEY}</td><td>&quot;5&quot;</td><td>支払識別キー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYOUSASIKIBETUKEY}</td><td>&quot;6&quot;</td><td>調査識別キー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TTDKRRKSIKIBETUKEY}</td><td>&quot;7&quot;</td><td>手続履歴識別キー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHRKENSYOUSIKIBETUKEY}</td><td>&quot;8&quot;</td><td>支払後検証識別キー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYUKINTRRENNO}</td><td>&quot;9&quot;</td><td>入金TR連番</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENKOUSIKIBETUKEY}</td><td>&quot;10&quot;</td><td>変更識別キー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_TOUJITUTRKSKEY}</td><td>&quot;11&quot;</td><td>（年金）当日取消キー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_HENKOUSIKIBETUKEY}</td><td>&quot;12&quot;</td><td>（年金）変更識別キー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NK_SHRSIKIBETUKEY}</td><td>&quot;13&quot;</td><td>（年金）支払識別キー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HANDKARIKANJONO}</td><td>&quot;14&quot;</td><td>ハンド仮勘定番号</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOUKYUUNO}</td><td>&quot;15&quot;</td><td>要求通番</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DS_KOKYAKUNO}</td><td>&quot;16&quot;</td><td>ＤＳ顧客番号</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DS_HENKOUSIKIBETUKEY}</td><td>&quot;17&quot;</td><td>ＤＳ変更識別キー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AKS_RENDOUIMAGENO}</td><td>&quot;18&quot;</td><td>ＡＫＳ連動イメージ番号</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DS_SOUSINNORENNO}</td><td>&quot;19&quot;</td><td>ＤＳ送信番号連番</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUUTIRIREKIRENNO}</td><td>&quot;20&quot;</td><td>通知履歴連番</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOZENHENKOUUKTKRENNO}</td><td>&quot;21&quot;</td><td>保全変更受付連番</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DS_SOUSINNORENNO_REALTIMEMAIL}</td><td>&quot;22&quot;</td><td>ＤＳ送信番号連番（リアルタイムメール）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DS_TETUZUKISIKIBETUID}</td><td>&quot;23&quot;</td><td>ＤＳ手続識別ＩＤ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIKYUUINFOFRENNO}</td><td>&quot;24&quot;</td><td>請求情報ファイル連番</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BUNKATUSIFRENNO}</td><td>&quot;25&quot;</td><td>分割支払計算ファイル連番</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIRISYORIRENNO}</td><td>&quot;26&quot;</td><td>経理用処理連番</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #REPORTKEY}</td><td>&quot;90&quot;</td><td>帳票キー</td></tr>
 * </table>
 */
public class C_NosyuruiKbn extends Classification<C_NosyuruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NosyuruiKbn KOKYAKUNO = new C_NosyuruiKbn("1");

    public static final C_NosyuruiKbn MRJHNO = new C_NosyuruiKbn("2");

    public static final C_NosyuruiKbn SEIKYUNO = new C_NosyuruiKbn("3");

    public static final C_NosyuruiKbn SATEISYOUNINKEY = new C_NosyuruiKbn("4");

    public static final C_NosyuruiKbn SHRSIKIBETUKEY = new C_NosyuruiKbn("5");

    public static final C_NosyuruiKbn TYOUSASIKIBETUKEY = new C_NosyuruiKbn("6");

    public static final C_NosyuruiKbn TTDKRRKSIKIBETUKEY = new C_NosyuruiKbn("7");

    public static final C_NosyuruiKbn SHRKENSYOUSIKIBETUKEY = new C_NosyuruiKbn("8");

    public static final C_NosyuruiKbn NYUKINTRRENNO = new C_NosyuruiKbn("9");

    public static final C_NosyuruiKbn HENKOUSIKIBETUKEY = new C_NosyuruiKbn("10");

    public static final C_NosyuruiKbn NK_TOUJITUTRKSKEY = new C_NosyuruiKbn("11");

    public static final C_NosyuruiKbn NK_HENKOUSIKIBETUKEY = new C_NosyuruiKbn("12");

    public static final C_NosyuruiKbn NK_SHRSIKIBETUKEY = new C_NosyuruiKbn("13");

    public static final C_NosyuruiKbn HANDKARIKANJONO = new C_NosyuruiKbn("14");

    public static final C_NosyuruiKbn YOUKYUUNO = new C_NosyuruiKbn("15");

    public static final C_NosyuruiKbn DS_KOKYAKUNO = new C_NosyuruiKbn("16");

    public static final C_NosyuruiKbn DS_HENKOUSIKIBETUKEY = new C_NosyuruiKbn("17");

    public static final C_NosyuruiKbn AKS_RENDOUIMAGENO = new C_NosyuruiKbn("18");

    public static final C_NosyuruiKbn DS_SOUSINNORENNO = new C_NosyuruiKbn("19");

    public static final C_NosyuruiKbn TUUTIRIREKIRENNO = new C_NosyuruiKbn("20");

    public static final C_NosyuruiKbn HOZENHENKOUUKTKRENNO = new C_NosyuruiKbn("21");

    public static final C_NosyuruiKbn DS_SOUSINNORENNO_REALTIMEMAIL = new C_NosyuruiKbn("22");

    public static final C_NosyuruiKbn DS_TETUZUKISIKIBETUID = new C_NosyuruiKbn("23");

    public static final C_NosyuruiKbn SEIKYUUINFOFRENNO = new C_NosyuruiKbn("24");

    public static final C_NosyuruiKbn BUNKATUSIFRENNO = new C_NosyuruiKbn("25");

    public static final C_NosyuruiKbn KEIRISYORIRENNO = new C_NosyuruiKbn("26");

    public static final C_NosyuruiKbn REPORTKEY = new C_NosyuruiKbn("90");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, KOKYAKUNO, "KOKYAKUNO", true);
        addPattern(PATTERN_DEFAULT, MRJHNO, "MRJHNO", false);
        addPattern(PATTERN_DEFAULT, SEIKYUNO, "SEIKYUNO", false);
        addPattern(PATTERN_DEFAULT, SATEISYOUNINKEY, "SATEISYOUNINKEY", false);
        addPattern(PATTERN_DEFAULT, SHRSIKIBETUKEY, "SHRSIKIBETUKEY", false);
        addPattern(PATTERN_DEFAULT, TYOUSASIKIBETUKEY, "TYOUSASIKIBETUKEY", false);
        addPattern(PATTERN_DEFAULT, TTDKRRKSIKIBETUKEY, "TTDKRRKSIKIBETUKEY", false);
        addPattern(PATTERN_DEFAULT, SHRKENSYOUSIKIBETUKEY, "SHRKENSYOUSIKIBETUKEY", false);
        addPattern(PATTERN_DEFAULT, NYUKINTRRENNO, "NYUKINTRRENNO", false);
        addPattern(PATTERN_DEFAULT, HENKOUSIKIBETUKEY, "HENKOUSIKIBETUKEY", false);
        addPattern(PATTERN_DEFAULT, NK_TOUJITUTRKSKEY, "NK_TOUJITUTRKSKEY", false);
        addPattern(PATTERN_DEFAULT, NK_HENKOUSIKIBETUKEY, "NK_HENKOUSIKIBETUKEY", false);
        addPattern(PATTERN_DEFAULT, NK_SHRSIKIBETUKEY, "NK_SHRSIKIBETUKEY", false);
        addPattern(PATTERN_DEFAULT, HANDKARIKANJONO, "HANDKARIKANJONO", false);
        addPattern(PATTERN_DEFAULT, YOUKYUUNO, "YOUKYUUNO", false);
        addPattern(PATTERN_DEFAULT, DS_KOKYAKUNO, "DS_KOKYAKUNO", false);
        addPattern(PATTERN_DEFAULT, DS_HENKOUSIKIBETUKEY, "DS_HENKOUSIKIBETUKEY", false);
        addPattern(PATTERN_DEFAULT, AKS_RENDOUIMAGENO, "AKS_RENDOUIMAGENO", false);
        addPattern(PATTERN_DEFAULT, DS_SOUSINNORENNO, "DS_SOUSINNORENNO", false);
        addPattern(PATTERN_DEFAULT, TUUTIRIREKIRENNO, "TUUTIRIREKIRENNO", false);
        addPattern(PATTERN_DEFAULT, HOZENHENKOUUKTKRENNO, "HOZENHENKOUUKTKRENNO", false);
        addPattern(PATTERN_DEFAULT, DS_SOUSINNORENNO_REALTIMEMAIL, "DS_SOUSINNORENNO_REALTIMEMAIL", false);
        addPattern(PATTERN_DEFAULT, DS_TETUZUKISIKIBETUID, "DS_TETUZUKISIKIBETUID", false);
        addPattern(PATTERN_DEFAULT, SEIKYUUINFOFRENNO, "SEIKYUUINFOFRENNO", false);
        addPattern(PATTERN_DEFAULT, BUNKATUSIFRENNO, "BUNKATUSIFRENNO", false);
        addPattern(PATTERN_DEFAULT, KEIRISYORIRENNO, "KEIRISYORIRENNO", false);
        addPattern(PATTERN_DEFAULT, REPORTKEY, "REPORTKEY", false);


        lock(C_NosyuruiKbn.class);
    }

    private C_NosyuruiKbn(String value) {
        super(value);
    }

    public static C_NosyuruiKbn valueOf(String value) {
        return valueOf(C_NosyuruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NosyuruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NosyuruiKbn.class, patternId, value);
    }
}
