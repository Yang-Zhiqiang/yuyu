
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 新契約機能モードＩＤ区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SkkinouModeIdKbn</td><td colspan="3">新契約機能モードＩＤ区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="47">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #DEFAULT}</td><td>&quot;default&quot;</td><td>デフォルト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOUSIKOMISYO_1JI}</td><td>&quot;mousikomisyo_1ji&quot;</td><td>申込書入力（新規（１次））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOUSIKOMISYO_2JI}</td><td>&quot;mousikomisyo_2ji&quot;</td><td>申込書入力（新規（２次））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOUSIKOMISYO_3JI}</td><td>&quot;mousikomisyo_3ji&quot;</td><td>申込書入力（新規（３次））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOUSIKOMISYO_UPD}</td><td>&quot;mousikomisyo_upd&quot;</td><td>申込書入力（変更訂正）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOUSIKOMISYO_SYOUKAI}</td><td>&quot;mousikomisyo_syoukai&quot;</td><td>申込書入力（変更訂正照会）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOUSIKOMISYO_INS_UPD}</td><td>&quot;mousikomisyo_ins_upd&quot;</td><td>申込書入力（入力訂正）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUZA_1JI}</td><td>&quot;kouza_1ji&quot;</td><td>口座情報入力（新規（１次））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUZA_2JI}</td><td>&quot;kouza_2ji&quot;</td><td>口座情報入力（新規（２次））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUZA_SYUUSEI}</td><td>&quot;kouza_syuusei&quot;</td><td>口座情報入力（新規（修正））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUZA_UPD}</td><td>&quot;kouza_upd&quot;</td><td>口座情報入力（訂正）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUZA_DEL}</td><td>&quot;kouza_del&quot;</td><td>口座情報入力（削除）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDITCARD_1JI}</td><td>&quot;creditcard_1ji&quot;</td><td>クレジットカード情報入力（新規（１次））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDITCARD_2JI}</td><td>&quot;creditcard_2ji&quot;</td><td>クレジットカード情報入力（新規（２次））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDITCARD_SYUUSEI}</td><td>&quot;creditcard_syuusei&quot;</td><td>クレジットカード情報入力（新規（修正））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDITCARD_UPD}</td><td>&quot;creditcard_upd&quot;</td><td>クレジットカード情報入力（訂正）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDITCARD_AUTHORI}</td><td>&quot;creditcard_authori&quot;</td><td>クレジットカード情報入力（オーソリ訂正）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDITCARD_DEL}</td><td>&quot;creditcard_del&quot;</td><td>クレジットカード情報入力（削除）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIZENAUTHORI_NEW}</td><td>&quot;jizenauthori_new&quot;</td><td>事前オーソリ情報入力(新規)</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIZENAUTHORI_DEL}</td><td>&quot;jizenauthori_del&quot;</td><td>事前オーソリ情報入力(削除)</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOKUTISYO_1JI}</td><td>&quot;kokutisyo_1ji&quot;</td><td>告知書入力（新規（１次））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOKUTISYO_2JI}</td><td>&quot;kokutisyo_2ji&quot;</td><td>告知書入力（新規（２次））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOKUTISYO_3JI}</td><td>&quot;kokutisyo_3ji&quot;</td><td>告知書入力（新規（３次））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOKUTISYO_UPD}</td><td>&quot;kokutisyo_upd&quot;</td><td>告知書入力（訂正）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOKUTISYO_DEL}</td><td>&quot;kokutisyo_del&quot;</td><td>告知書入力（削除）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOUJYOU_NEW_SYOSIN}</td><td>&quot;houjyou_new_syosin&quot;</td><td>報状入力（新規（初診））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOUJYOU_NEW_SAISIN}</td><td>&quot;houjyou_new_saisin&quot;</td><td>報状入力（新規（再診））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOUJYOU_UPD_SYOSIN}</td><td>&quot;houjyou_upd_syosin&quot;</td><td>報状入力（訂正（初診））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOUJYOU_UPD_SAISIN}</td><td>&quot;houjyou_upd_saisin&quot;</td><td>報状入力（訂正（再診））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOUJYOU_DEL_SYOSIN}</td><td>&quot;houjyou_del_syosin&quot;</td><td>報状入力（削除（初診））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOUJYOU_DEL_SAISIN}</td><td>&quot;houjyou_del_saisin&quot;</td><td>報状入力（削除（再診））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOSTENKEN_1JI}</td><td>&quot;mostenken_1ji&quot;</td><td>申込点検（１次）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOSTENKEN_2JI}</td><td>&quot;mostenken_2ji&quot;</td><td>申込点検（２次）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOSTENKEN_3JI}</td><td>&quot;mostenken_3ji&quot;</td><td>申込点検（３次）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOSTENKEN_HUBI}</td><td>&quot;mostenken_hubi&quot;</td><td>申込点検（点検後不備）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANKYOUSATEI_1JI}</td><td>&quot;kankyousatei_1ji&quot;</td><td>環境査定（１次）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANKYOUSATEI_2JIA}</td><td>&quot;kankyousatei_2jia&quot;</td><td>環境査定（２次Ａ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANKYOUSATEI_2JIB}</td><td>&quot;kankyousatei_2jib&quot;</td><td>環境査定（２次Ｂ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOSTORIKESI}</td><td>&quot;mostorikesi&quot;</td><td>申込取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IMUSATEI_KANI_UW}</td><td>&quot;imusatei_kani_uw&quot;</td><td>医務査定（簡易（ＵＷ））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IMUSATEI_KANI_MD}</td><td>&quot;imusatei_kani_md&quot;</td><td>医務査定（簡易（ＭＤ））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBITOUROKU}</td><td>&quot;hubitouroku&quot;</td><td>不備登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBIHASSIN}</td><td>&quot;hubihassin&quot;</td><td>不備内容確認・発信</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBIKAISYOU}</td><td>&quot;hubikaisyou&quot;</td><td>不備解消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBIKAITOUMATI}</td><td>&quot;hubikaitoumati&quot;</td><td>不備回答待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENKINKIBOU}</td><td>&quot;henkinkibou&quot;</td><td>返金希望</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENKINNYUURYOKU}</td><td>&quot;henkinnyuuryoku&quot;</td><td>返金入力</td></tr>
 * </table>
 */
public class C_SkkinouModeIdKbn extends Classification<C_SkkinouModeIdKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SkkinouModeIdKbn DEFAULT = new C_SkkinouModeIdKbn("default");

    public static final C_SkkinouModeIdKbn MOUSIKOMISYO_1JI = new C_SkkinouModeIdKbn("mousikomisyo_1ji");

    public static final C_SkkinouModeIdKbn MOUSIKOMISYO_2JI = new C_SkkinouModeIdKbn("mousikomisyo_2ji");

    public static final C_SkkinouModeIdKbn MOUSIKOMISYO_3JI = new C_SkkinouModeIdKbn("mousikomisyo_3ji");

    public static final C_SkkinouModeIdKbn MOUSIKOMISYO_UPD = new C_SkkinouModeIdKbn("mousikomisyo_upd");

    public static final C_SkkinouModeIdKbn MOUSIKOMISYO_SYOUKAI = new C_SkkinouModeIdKbn("mousikomisyo_syoukai");

    public static final C_SkkinouModeIdKbn MOUSIKOMISYO_INS_UPD = new C_SkkinouModeIdKbn("mousikomisyo_ins_upd");

    public static final C_SkkinouModeIdKbn KOUZA_1JI = new C_SkkinouModeIdKbn("kouza_1ji");

    public static final C_SkkinouModeIdKbn KOUZA_2JI = new C_SkkinouModeIdKbn("kouza_2ji");

    public static final C_SkkinouModeIdKbn KOUZA_SYUUSEI = new C_SkkinouModeIdKbn("kouza_syuusei");

    public static final C_SkkinouModeIdKbn KOUZA_UPD = new C_SkkinouModeIdKbn("kouza_upd");

    public static final C_SkkinouModeIdKbn KOUZA_DEL = new C_SkkinouModeIdKbn("kouza_del");

    public static final C_SkkinouModeIdKbn CREDITCARD_1JI = new C_SkkinouModeIdKbn("creditcard_1ji");

    public static final C_SkkinouModeIdKbn CREDITCARD_2JI = new C_SkkinouModeIdKbn("creditcard_2ji");

    public static final C_SkkinouModeIdKbn CREDITCARD_SYUUSEI = new C_SkkinouModeIdKbn("creditcard_syuusei");

    public static final C_SkkinouModeIdKbn CREDITCARD_UPD = new C_SkkinouModeIdKbn("creditcard_upd");

    public static final C_SkkinouModeIdKbn CREDITCARD_AUTHORI = new C_SkkinouModeIdKbn("creditcard_authori");

    public static final C_SkkinouModeIdKbn CREDITCARD_DEL = new C_SkkinouModeIdKbn("creditcard_del");

    public static final C_SkkinouModeIdKbn JIZENAUTHORI_NEW = new C_SkkinouModeIdKbn("jizenauthori_new");

    public static final C_SkkinouModeIdKbn JIZENAUTHORI_DEL = new C_SkkinouModeIdKbn("jizenauthori_del");

    public static final C_SkkinouModeIdKbn KOKUTISYO_1JI = new C_SkkinouModeIdKbn("kokutisyo_1ji");

    public static final C_SkkinouModeIdKbn KOKUTISYO_2JI = new C_SkkinouModeIdKbn("kokutisyo_2ji");

    public static final C_SkkinouModeIdKbn KOKUTISYO_3JI = new C_SkkinouModeIdKbn("kokutisyo_3ji");

    public static final C_SkkinouModeIdKbn KOKUTISYO_UPD = new C_SkkinouModeIdKbn("kokutisyo_upd");

    public static final C_SkkinouModeIdKbn KOKUTISYO_DEL = new C_SkkinouModeIdKbn("kokutisyo_del");

    public static final C_SkkinouModeIdKbn HOUJYOU_NEW_SYOSIN = new C_SkkinouModeIdKbn("houjyou_new_syosin");

    public static final C_SkkinouModeIdKbn HOUJYOU_NEW_SAISIN = new C_SkkinouModeIdKbn("houjyou_new_saisin");

    public static final C_SkkinouModeIdKbn HOUJYOU_UPD_SYOSIN = new C_SkkinouModeIdKbn("houjyou_upd_syosin");

    public static final C_SkkinouModeIdKbn HOUJYOU_UPD_SAISIN = new C_SkkinouModeIdKbn("houjyou_upd_saisin");

    public static final C_SkkinouModeIdKbn HOUJYOU_DEL_SYOSIN = new C_SkkinouModeIdKbn("houjyou_del_syosin");

    public static final C_SkkinouModeIdKbn HOUJYOU_DEL_SAISIN = new C_SkkinouModeIdKbn("houjyou_del_saisin");

    public static final C_SkkinouModeIdKbn MOSTENKEN_1JI = new C_SkkinouModeIdKbn("mostenken_1ji");

    public static final C_SkkinouModeIdKbn MOSTENKEN_2JI = new C_SkkinouModeIdKbn("mostenken_2ji");

    public static final C_SkkinouModeIdKbn MOSTENKEN_3JI = new C_SkkinouModeIdKbn("mostenken_3ji");

    public static final C_SkkinouModeIdKbn MOSTENKEN_HUBI = new C_SkkinouModeIdKbn("mostenken_hubi");

    public static final C_SkkinouModeIdKbn KANKYOUSATEI_1JI = new C_SkkinouModeIdKbn("kankyousatei_1ji");

    public static final C_SkkinouModeIdKbn KANKYOUSATEI_2JIA = new C_SkkinouModeIdKbn("kankyousatei_2jia");

    public static final C_SkkinouModeIdKbn KANKYOUSATEI_2JIB = new C_SkkinouModeIdKbn("kankyousatei_2jib");

    public static final C_SkkinouModeIdKbn MOSTORIKESI = new C_SkkinouModeIdKbn("mostorikesi");

    public static final C_SkkinouModeIdKbn IMUSATEI_KANI_UW = new C_SkkinouModeIdKbn("imusatei_kani_uw");

    public static final C_SkkinouModeIdKbn IMUSATEI_KANI_MD = new C_SkkinouModeIdKbn("imusatei_kani_md");

    public static final C_SkkinouModeIdKbn HUBITOUROKU = new C_SkkinouModeIdKbn("hubitouroku");

    public static final C_SkkinouModeIdKbn HUBIHASSIN = new C_SkkinouModeIdKbn("hubihassin");

    public static final C_SkkinouModeIdKbn HUBIKAISYOU = new C_SkkinouModeIdKbn("hubikaisyou");

    public static final C_SkkinouModeIdKbn HUBIKAITOUMATI = new C_SkkinouModeIdKbn("hubikaitoumati");

    public static final C_SkkinouModeIdKbn HENKINKIBOU = new C_SkkinouModeIdKbn("henkinkibou");

    public static final C_SkkinouModeIdKbn HENKINNYUURYOKU = new C_SkkinouModeIdKbn("henkinnyuuryoku");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, DEFAULT, "DEFAULT", true);
        addPattern(PATTERN_DEFAULT, MOUSIKOMISYO_1JI, "MOUSIKOMISYO_1JI", false);
        addPattern(PATTERN_DEFAULT, MOUSIKOMISYO_2JI, "MOUSIKOMISYO_2JI", false);
        addPattern(PATTERN_DEFAULT, MOUSIKOMISYO_3JI, "MOUSIKOMISYO_3JI", false);
        addPattern(PATTERN_DEFAULT, MOUSIKOMISYO_UPD, "MOUSIKOMISYO_UPD", false);
        addPattern(PATTERN_DEFAULT, MOUSIKOMISYO_SYOUKAI, "MOUSIKOMISYO_SYOUKAI", false);
        addPattern(PATTERN_DEFAULT, MOUSIKOMISYO_INS_UPD, "MOUSIKOMISYO_INS_UPD", false);
        addPattern(PATTERN_DEFAULT, KOUZA_1JI, "KOUZA_1JI", false);
        addPattern(PATTERN_DEFAULT, KOUZA_2JI, "KOUZA_2JI", false);
        addPattern(PATTERN_DEFAULT, KOUZA_SYUUSEI, "KOUZA_SYUUSEI", false);
        addPattern(PATTERN_DEFAULT, KOUZA_UPD, "KOUZA_UPD", false);
        addPattern(PATTERN_DEFAULT, KOUZA_DEL, "KOUZA_DEL", false);
        addPattern(PATTERN_DEFAULT, CREDITCARD_1JI, "CREDITCARD_1JI", false);
        addPattern(PATTERN_DEFAULT, CREDITCARD_2JI, "CREDITCARD_2JI", false);
        addPattern(PATTERN_DEFAULT, CREDITCARD_SYUUSEI, "CREDITCARD_SYUUSEI", false);
        addPattern(PATTERN_DEFAULT, CREDITCARD_UPD, "CREDITCARD_UPD", false);
        addPattern(PATTERN_DEFAULT, CREDITCARD_AUTHORI, "CREDITCARD_AUTHORI", false);
        addPattern(PATTERN_DEFAULT, CREDITCARD_DEL, "CREDITCARD_DEL", false);
        addPattern(PATTERN_DEFAULT, JIZENAUTHORI_NEW, "JIZENAUTHORI_NEW", false);
        addPattern(PATTERN_DEFAULT, JIZENAUTHORI_DEL, "JIZENAUTHORI_DEL", false);
        addPattern(PATTERN_DEFAULT, KOKUTISYO_1JI, "KOKUTISYO_1JI", false);
        addPattern(PATTERN_DEFAULT, KOKUTISYO_2JI, "KOKUTISYO_2JI", false);
        addPattern(PATTERN_DEFAULT, KOKUTISYO_3JI, "KOKUTISYO_3JI", false);
        addPattern(PATTERN_DEFAULT, KOKUTISYO_UPD, "KOKUTISYO_UPD", false);
        addPattern(PATTERN_DEFAULT, KOKUTISYO_DEL, "KOKUTISYO_DEL", false);
        addPattern(PATTERN_DEFAULT, HOUJYOU_NEW_SYOSIN, "HOUJYOU_NEW_SYOSIN", false);
        addPattern(PATTERN_DEFAULT, HOUJYOU_NEW_SAISIN, "HOUJYOU_NEW_SAISIN", false);
        addPattern(PATTERN_DEFAULT, HOUJYOU_UPD_SYOSIN, "HOUJYOU_UPD_SYOSIN", false);
        addPattern(PATTERN_DEFAULT, HOUJYOU_UPD_SAISIN, "HOUJYOU_UPD_SAISIN", false);
        addPattern(PATTERN_DEFAULT, HOUJYOU_DEL_SYOSIN, "HOUJYOU_DEL_SYOSIN", false);
        addPattern(PATTERN_DEFAULT, HOUJYOU_DEL_SAISIN, "HOUJYOU_DEL_SAISIN", false);
        addPattern(PATTERN_DEFAULT, MOSTENKEN_1JI, "MOSTENKEN_1JI", false);
        addPattern(PATTERN_DEFAULT, MOSTENKEN_2JI, "MOSTENKEN_2JI", false);
        addPattern(PATTERN_DEFAULT, MOSTENKEN_3JI, "MOSTENKEN_3JI", false);
        addPattern(PATTERN_DEFAULT, MOSTENKEN_HUBI, "MOSTENKEN_HUBI", false);
        addPattern(PATTERN_DEFAULT, KANKYOUSATEI_1JI, "KANKYOUSATEI_1JI", false);
        addPattern(PATTERN_DEFAULT, KANKYOUSATEI_2JIA, "KANKYOUSATEI_2JIA", false);
        addPattern(PATTERN_DEFAULT, KANKYOUSATEI_2JIB, "KANKYOUSATEI_2JIB", false);
        addPattern(PATTERN_DEFAULT, MOSTORIKESI, "MOSTORIKESI", false);
        addPattern(PATTERN_DEFAULT, IMUSATEI_KANI_UW, "IMUSATEI_KANI_UW", false);
        addPattern(PATTERN_DEFAULT, IMUSATEI_KANI_MD, "IMUSATEI_KANI_MD", false);
        addPattern(PATTERN_DEFAULT, HUBITOUROKU, "HUBITOUROKU", false);
        addPattern(PATTERN_DEFAULT, HUBIHASSIN, "HUBIHASSIN", false);
        addPattern(PATTERN_DEFAULT, HUBIKAISYOU, "HUBIKAISYOU", false);
        addPattern(PATTERN_DEFAULT, HUBIKAITOUMATI, "HUBIKAITOUMATI", false);
        addPattern(PATTERN_DEFAULT, HENKINKIBOU, "HENKINKIBOU", false);
        addPattern(PATTERN_DEFAULT, HENKINNYUURYOKU, "HENKINNYUURYOKU", false);


        lock(C_SkkinouModeIdKbn.class);
    }

    private C_SkkinouModeIdKbn(String value) {
        super(value);
    }

    public static C_SkkinouModeIdKbn valueOf(String value) {
        return valueOf(C_SkkinouModeIdKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SkkinouModeIdKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SkkinouModeIdKbn.class, patternId, value);
    }
}
