
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * クレジットカード売上請求ＮＧ事由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_CreditUriageNgJiyuuKbn</td><td colspan="3">クレジットカード売上請求ＮＧ事由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GENDOGAKUTYOUKA}</td><td>&quot;1&quot;</td><td>限度額超過</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #URIAGESYORIMIKANRYOU}</td><td>&quot;2&quot;</td><td>売上処理未完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUKOUKIGENERROR}</td><td>&quot;5&quot;</td><td>有効期限エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KINKYUUTEISI}</td><td>&quot;8&quot;</td><td>緊急停止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CARDGAISYAERROR}</td><td>&quot;9&quot;</td><td>カード会社判定エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIJYOU}</td><td>&quot;99&quot;</td><td>正常終了</td></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DISP DISP}<br />(表示用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GENDOGAKUTYOUKA}</td><td>&quot;1&quot;</td><td>限度額超過</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #URIAGESYORIMIKANRYOU}</td><td>&quot;2&quot;</td><td>売上処理未完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUKOUKIGENERROR}</td><td>&quot;5&quot;</td><td>有効期限エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KINKYUUTEISI}</td><td>&quot;8&quot;</td><td>緊急停止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CARDGAISYAERROR}</td><td>&quot;9&quot;</td><td>カード会社判定エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIJYOU}</td><td>&quot;99&quot;</td><td>ブランク</td></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_SKDISP SKDISP}<br />(新契約表示用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GENDOGAKUTYOUKA}</td><td>&quot;1&quot;</td><td>クレジットカード利用限度額をオーバー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #URIAGESYORIMIKANRYOU}</td><td>&quot;2&quot;</td><td>売上処理が完了していない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUKOUKIGENERROR}</td><td>&quot;5&quot;</td><td>クレジットカードの有効期限エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KINKYUUTEISI}</td><td>&quot;8&quot;</td><td>緊急停止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CARDGAISYAERROR}</td><td>&quot;9&quot;</td><td>収納代行センターにて送信先カード判定エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIJYOU}</td><td>&quot;99&quot;</td><td>ブランク</td></tr>
 * </table>
 */
public class C_CreditUriageNgJiyuuKbn extends Classification<C_CreditUriageNgJiyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_CreditUriageNgJiyuuKbn BLNK = new C_CreditUriageNgJiyuuKbn("0");

    public static final C_CreditUriageNgJiyuuKbn GENDOGAKUTYOUKA = new C_CreditUriageNgJiyuuKbn("1");

    public static final C_CreditUriageNgJiyuuKbn URIAGESYORIMIKANRYOU = new C_CreditUriageNgJiyuuKbn("2");

    public static final C_CreditUriageNgJiyuuKbn YUUKOUKIGENERROR = new C_CreditUriageNgJiyuuKbn("5");

    public static final C_CreditUriageNgJiyuuKbn KINKYUUTEISI = new C_CreditUriageNgJiyuuKbn("8");

    public static final C_CreditUriageNgJiyuuKbn CARDGAISYAERROR = new C_CreditUriageNgJiyuuKbn("9");

    public static final C_CreditUriageNgJiyuuKbn SEIJYOU = new C_CreditUriageNgJiyuuKbn("99");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_DISP = "2";

    public static final String PATTERN_SKDISP = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, GENDOGAKUTYOUKA, "GENDOGAKUTYOUKA", false);
        addPattern(PATTERN_DEFAULT, URIAGESYORIMIKANRYOU, "URIAGESYORIMIKANRYOU", false);
        addPattern(PATTERN_DEFAULT, YUUKOUKIGENERROR, "YUUKOUKIGENERROR", false);
        addPattern(PATTERN_DEFAULT, KINKYUUTEISI, "KINKYUUTEISI", false);
        addPattern(PATTERN_DEFAULT, CARDGAISYAERROR, "CARDGAISYAERROR", false);
        addPattern(PATTERN_DEFAULT, SEIJYOU, "SEIJYOU", false);


        addPattern(PATTERN_DISP, BLNK, "BLNK", true);
        addPattern(PATTERN_DISP, GENDOGAKUTYOUKA, "GENDOGAKUTYOUKA", false);
        addPattern(PATTERN_DISP, URIAGESYORIMIKANRYOU, "URIAGESYORIMIKANRYOU", false);
        addPattern(PATTERN_DISP, YUUKOUKIGENERROR, "YUUKOUKIGENERROR", false);
        addPattern(PATTERN_DISP, KINKYUUTEISI, "KINKYUUTEISI", false);
        addPattern(PATTERN_DISP, CARDGAISYAERROR, "CARDGAISYAERROR", false);
        addPattern(PATTERN_DISP, SEIJYOU, "SEIJYOU", false);


        addPattern(PATTERN_SKDISP, BLNK, "BLNK", true);
        addPattern(PATTERN_SKDISP, GENDOGAKUTYOUKA, "GENDOGAKUTYOUKA", false);
        addPattern(PATTERN_SKDISP, URIAGESYORIMIKANRYOU, "URIAGESYORIMIKANRYOU", false);
        addPattern(PATTERN_SKDISP, YUUKOUKIGENERROR, "YUUKOUKIGENERROR", false);
        addPattern(PATTERN_SKDISP, KINKYUUTEISI, "KINKYUUTEISI", false);
        addPattern(PATTERN_SKDISP, CARDGAISYAERROR, "CARDGAISYAERROR", false);
        addPattern(PATTERN_SKDISP, SEIJYOU, "SEIJYOU", false);


        lock(C_CreditUriageNgJiyuuKbn.class);
    }

    private C_CreditUriageNgJiyuuKbn(String value) {
        super(value);
    }

    public static C_CreditUriageNgJiyuuKbn valueOf(String value) {
        return valueOf(C_CreditUriageNgJiyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_CreditUriageNgJiyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_CreditUriageNgJiyuuKbn.class, patternId, value);
    }
}
