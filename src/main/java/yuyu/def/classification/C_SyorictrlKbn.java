
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 処理制御区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyorictrlKbn</td><td colspan="3">処理制御区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="29">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NRK}</td><td>&quot;1&quot;</td><td>入力</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #REF}</td><td>&quot;2&quot;</td><td>照会</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #REFONLY}</td><td>&quot;3&quot;</td><td>照会のみ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAINRK}</td><td>&quot;4&quot;</td><td>再入力</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYORI}</td><td>&quot;5&quot;</td><td>処理</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OK}</td><td>&quot;6&quot;</td><td>ＯＫ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CANCEL}</td><td>&quot;7&quot;</td><td>キャンセル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOKIGAMEN}</td><td>&quot;8&quot;</td><td>初期画面</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BACK}</td><td>&quot;9&quot;</td><td>戻る</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKNAIYOU}</td><td>&quot;10&quot;</td><td>契約内容</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TETUDUKI}</td><td>&quot;11&quot;</td><td>手続履歴</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SRCH}</td><td>&quot;12&quot;</td><td>検索</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTAHENKOU}</td><td>&quot;13&quot;</td><td>その他変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SRCH_BACK}</td><td>&quot;14&quot;</td><td>検索結果へ戻る</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYHY}</td><td>&quot;15&quot;</td><td>帳票出力</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAKUTEI}</td><td>&quot;16&quot;</td><td>確定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SETTEI}</td><td>&quot;17&quot;</td><td>設定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKESI}</td><td>&quot;18&quot;</td><td>取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAKUNIN}</td><td>&quot;19&quot;</td><td>確認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LINK_INPUTKEY}</td><td>&quot;81&quot;</td><td>リンク（キー入力）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LINK_NRK}</td><td>&quot;82&quot;</td><td>リンク（内容入力）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LINK_REF}</td><td>&quot;83&quot;</td><td>リンク（照会）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LINK_SRCH}</td><td>&quot;84&quot;</td><td>リンク（検索結果）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LINK_KYKHENKOU}</td><td>&quot;85&quot;</td><td>リンク（契約者変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PAGELINK}</td><td>&quot;86&quot;</td><td>ページリンク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKI}</td><td>&quot;31&quot;</td><td>新規</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENKOU}</td><td>&quot;32&quot;</td><td>変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAKUJYO}</td><td>&quot;33&quot;</td><td>削除</td></tr>
 * </table>
 */
public class C_SyorictrlKbn extends Classification<C_SyorictrlKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SyorictrlKbn BLNK = new C_SyorictrlKbn("0");

    public static final C_SyorictrlKbn NRK = new C_SyorictrlKbn("1");

    public static final C_SyorictrlKbn REF = new C_SyorictrlKbn("2");

    public static final C_SyorictrlKbn REFONLY = new C_SyorictrlKbn("3");

    public static final C_SyorictrlKbn SAINRK = new C_SyorictrlKbn("4");

    public static final C_SyorictrlKbn SYORI = new C_SyorictrlKbn("5");

    public static final C_SyorictrlKbn OK = new C_SyorictrlKbn("6");

    public static final C_SyorictrlKbn CANCEL = new C_SyorictrlKbn("7");

    public static final C_SyorictrlKbn SYOKIGAMEN = new C_SyorictrlKbn("8");

    public static final C_SyorictrlKbn BACK = new C_SyorictrlKbn("9");

    public static final C_SyorictrlKbn KYKNAIYOU = new C_SyorictrlKbn("10");

    public static final C_SyorictrlKbn TETUDUKI = new C_SyorictrlKbn("11");

    public static final C_SyorictrlKbn SRCH = new C_SyorictrlKbn("12");

    public static final C_SyorictrlKbn SONOTAHENKOU = new C_SyorictrlKbn("13");

    public static final C_SyorictrlKbn SRCH_BACK = new C_SyorictrlKbn("14");

    public static final C_SyorictrlKbn TYHY = new C_SyorictrlKbn("15");

    public static final C_SyorictrlKbn KAKUTEI = new C_SyorictrlKbn("16");

    public static final C_SyorictrlKbn SETTEI = new C_SyorictrlKbn("17");

    public static final C_SyorictrlKbn TORIKESI = new C_SyorictrlKbn("18");

    public static final C_SyorictrlKbn KAKUNIN = new C_SyorictrlKbn("19");

    public static final C_SyorictrlKbn LINK_INPUTKEY = new C_SyorictrlKbn("81");

    public static final C_SyorictrlKbn LINK_NRK = new C_SyorictrlKbn("82");

    public static final C_SyorictrlKbn LINK_REF = new C_SyorictrlKbn("83");

    public static final C_SyorictrlKbn LINK_SRCH = new C_SyorictrlKbn("84");

    public static final C_SyorictrlKbn LINK_KYKHENKOU = new C_SyorictrlKbn("85");

    public static final C_SyorictrlKbn PAGELINK = new C_SyorictrlKbn("86");

    public static final C_SyorictrlKbn SINKI = new C_SyorictrlKbn("31");

    public static final C_SyorictrlKbn HENKOU = new C_SyorictrlKbn("32");

    public static final C_SyorictrlKbn SAKUJYO = new C_SyorictrlKbn("33");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NRK, "NRK", false);
        addPattern(PATTERN_DEFAULT, REF, "REF", false);
        addPattern(PATTERN_DEFAULT, REFONLY, "REFONLY", false);
        addPattern(PATTERN_DEFAULT, SAINRK, "SAINRK", false);
        addPattern(PATTERN_DEFAULT, SYORI, "SYORI", false);
        addPattern(PATTERN_DEFAULT, OK, "OK", false);
        addPattern(PATTERN_DEFAULT, CANCEL, "CANCEL", false);
        addPattern(PATTERN_DEFAULT, SYOKIGAMEN, "SYOKIGAMEN", false);
        addPattern(PATTERN_DEFAULT, BACK, "BACK", false);
        addPattern(PATTERN_DEFAULT, KYKNAIYOU, "KYKNAIYOU", false);
        addPattern(PATTERN_DEFAULT, TETUDUKI, "TETUDUKI", false);
        addPattern(PATTERN_DEFAULT, SRCH, "SRCH", false);
        addPattern(PATTERN_DEFAULT, SONOTAHENKOU, "SONOTAHENKOU", false);
        addPattern(PATTERN_DEFAULT, SRCH_BACK, "SRCH_BACK", false);
        addPattern(PATTERN_DEFAULT, TYHY, "TYHY", false);
        addPattern(PATTERN_DEFAULT, KAKUTEI, "KAKUTEI", false);
        addPattern(PATTERN_DEFAULT, SETTEI, "SETTEI", false);
        addPattern(PATTERN_DEFAULT, TORIKESI, "TORIKESI", false);
        addPattern(PATTERN_DEFAULT, KAKUNIN, "KAKUNIN", false);
        addPattern(PATTERN_DEFAULT, LINK_INPUTKEY, "LINK_INPUTKEY", false);
        addPattern(PATTERN_DEFAULT, LINK_NRK, "LINK_NRK", false);
        addPattern(PATTERN_DEFAULT, LINK_REF, "LINK_REF", false);
        addPattern(PATTERN_DEFAULT, LINK_SRCH, "LINK_SRCH", false);
        addPattern(PATTERN_DEFAULT, LINK_KYKHENKOU, "LINK_KYKHENKOU", false);
        addPattern(PATTERN_DEFAULT, PAGELINK, "PAGELINK", false);
        addPattern(PATTERN_DEFAULT, SINKI, "SINKI", false);
        addPattern(PATTERN_DEFAULT, HENKOU, "HENKOU", false);
        addPattern(PATTERN_DEFAULT, SAKUJYO, "SAKUJYO", false);


        lock(C_SyorictrlKbn.class);
    }

    private C_SyorictrlKbn(String value) {
        super(value);
    }

    public static C_SyorictrlKbn valueOf(String value) {
        return valueOf(C_SyorictrlKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyorictrlKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyorictrlKbn.class, patternId, value);
    }
}
