
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 保険設計操作区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HknsekkeisousaKbn</td><td colspan="3">保険設計操作区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="13">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #P_CALC}</td><td>&quot;1&quot;</td><td>保険料計算</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOSYO_KAKUTEI}</td><td>&quot;2&quot;</td><td>保障内容確定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEK_PRINT}</td><td>&quot;3&quot;</td><td>設計書印刷</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOS_PRINT}</td><td>&quot;4&quot;</td><td>申込書印刷</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEKMOS_PRINT}</td><td>&quot;5&quot;</td><td>設計書・申込書印刷</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RYUUYOU}</td><td>&quot;6&quot;</td><td>流用設計</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOS_SAKUSEI}</td><td>&quot;7&quot;</td><td>申込書作成</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEK_HYOUJI}</td><td>&quot;8&quot;</td><td>設計書情報表示</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOKINFORIYOU}</td><td>&quot;9&quot;</td><td>顧客情報利用</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CONFSEKSAKUSEI}</td><td>&quot;10&quot;</td><td>確認後設計書作成</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #REPRINT}</td><td>&quot;11&quot;</td><td>帳票再印刷</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GWKOKINFORENKEISEK}</td><td>&quot;12&quot;</td><td>ＧＷ顧客情報連携設計</td></tr>
 * </table>
 */
public class C_HknsekkeisousaKbn extends Classification<C_HknsekkeisousaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HknsekkeisousaKbn BLNK = new C_HknsekkeisousaKbn("0");

    public static final C_HknsekkeisousaKbn P_CALC = new C_HknsekkeisousaKbn("1");

    public static final C_HknsekkeisousaKbn HOSYO_KAKUTEI = new C_HknsekkeisousaKbn("2");

    public static final C_HknsekkeisousaKbn SEK_PRINT = new C_HknsekkeisousaKbn("3");

    public static final C_HknsekkeisousaKbn MOS_PRINT = new C_HknsekkeisousaKbn("4");

    public static final C_HknsekkeisousaKbn SEKMOS_PRINT = new C_HknsekkeisousaKbn("5");

    public static final C_HknsekkeisousaKbn RYUUYOU = new C_HknsekkeisousaKbn("6");

    public static final C_HknsekkeisousaKbn MOS_SAKUSEI = new C_HknsekkeisousaKbn("7");

    public static final C_HknsekkeisousaKbn SEK_HYOUJI = new C_HknsekkeisousaKbn("8");

    public static final C_HknsekkeisousaKbn KOKINFORIYOU = new C_HknsekkeisousaKbn("9");

    public static final C_HknsekkeisousaKbn CONFSEKSAKUSEI = new C_HknsekkeisousaKbn("10");

    public static final C_HknsekkeisousaKbn REPRINT = new C_HknsekkeisousaKbn("11");

    public static final C_HknsekkeisousaKbn GWKOKINFORENKEISEK = new C_HknsekkeisousaKbn("12");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, P_CALC, "P_CALC", false);
        addPattern(PATTERN_DEFAULT, HOSYO_KAKUTEI, "HOSYO_KAKUTEI", false);
        addPattern(PATTERN_DEFAULT, SEK_PRINT, "SEK_PRINT", false);
        addPattern(PATTERN_DEFAULT, MOS_PRINT, "MOS_PRINT", false);
        addPattern(PATTERN_DEFAULT, SEKMOS_PRINT, "SEKMOS_PRINT", false);
        addPattern(PATTERN_DEFAULT, RYUUYOU, "RYUUYOU", false);
        addPattern(PATTERN_DEFAULT, MOS_SAKUSEI, "MOS_SAKUSEI", false);
        addPattern(PATTERN_DEFAULT, SEK_HYOUJI, "SEK_HYOUJI", false);
        addPattern(PATTERN_DEFAULT, KOKINFORIYOU, "KOKINFORIYOU", false);
        addPattern(PATTERN_DEFAULT, CONFSEKSAKUSEI, "CONFSEKSAKUSEI", false);
        addPattern(PATTERN_DEFAULT, REPRINT, "REPRINT", false);
        addPattern(PATTERN_DEFAULT, GWKOKINFORENKEISEK, "GWKOKINFORENKEISEK", false);


        lock(C_HknsekkeisousaKbn.class);
    }

    private C_HknsekkeisousaKbn(String value) {
        super(value);
    }

    public static C_HknsekkeisousaKbn valueOf(String value) {
        return valueOf(C_HknsekkeisousaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HknsekkeisousaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HknsekkeisousaKbn.class, patternId, value);
    }
}
