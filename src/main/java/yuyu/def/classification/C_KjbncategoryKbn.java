
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 掲示板カテゴリ区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KjbncategoryKbn</td><td colspan="3">掲示板カテゴリ区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="10">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BOSSIRYOU}</td><td>&quot;10&quot;</td><td>募集資料　　</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOHNMANUAL}</td><td>&quot;20&quot;</td><td>商品マニュアル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEMINARSIRYOU}</td><td>&quot;30&quot;</td><td>セミナー資料・教材</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JMTUUTI}</td><td>&quot;40&quot;</td><td>事務通知・マニュアル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JMTYHY}</td><td>&quot;50&quot;</td><td>事務帳票</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYHYMIHON}</td><td>&quot;60&quot;</td><td>お客さまあて帳票見本</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYSMANUAL}</td><td>&quot;70&quot;</td><td>システム操作マニュアル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #COMPLIANCE}</td><td>&quot;90&quot;</td><td>コンプライアンス</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUUTIMANUAL}</td><td>&quot;91&quot;</td><td>通知・マニュアル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYOUHYOU}</td><td>&quot;92&quot;</td><td>帳票</td></tr>
 * </table>
 */
public class C_KjbncategoryKbn extends Classification<C_KjbncategoryKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KjbncategoryKbn BOSSIRYOU = new C_KjbncategoryKbn("10");

    public static final C_KjbncategoryKbn SYOHNMANUAL = new C_KjbncategoryKbn("20");

    public static final C_KjbncategoryKbn SEMINARSIRYOU = new C_KjbncategoryKbn("30");

    public static final C_KjbncategoryKbn JMTUUTI = new C_KjbncategoryKbn("40");

    public static final C_KjbncategoryKbn JMTYHY = new C_KjbncategoryKbn("50");

    public static final C_KjbncategoryKbn TYHYMIHON = new C_KjbncategoryKbn("60");

    public static final C_KjbncategoryKbn SYSMANUAL = new C_KjbncategoryKbn("70");

    public static final C_KjbncategoryKbn COMPLIANCE = new C_KjbncategoryKbn("90");

    public static final C_KjbncategoryKbn TUUTIMANUAL = new C_KjbncategoryKbn("91");

    public static final C_KjbncategoryKbn TYOUHYOU = new C_KjbncategoryKbn("92");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BOSSIRYOU, "BOSSIRYOU", true);
        addPattern(PATTERN_DEFAULT, SYOHNMANUAL, "SYOHNMANUAL", false);
        addPattern(PATTERN_DEFAULT, SEMINARSIRYOU, "SEMINARSIRYOU", false);
        addPattern(PATTERN_DEFAULT, JMTUUTI, "JMTUUTI", false);
        addPattern(PATTERN_DEFAULT, JMTYHY, "JMTYHY", false);
        addPattern(PATTERN_DEFAULT, TYHYMIHON, "TYHYMIHON", false);
        addPattern(PATTERN_DEFAULT, SYSMANUAL, "SYSMANUAL", false);
        addPattern(PATTERN_DEFAULT, COMPLIANCE, "COMPLIANCE", false);
        addPattern(PATTERN_DEFAULT, TUUTIMANUAL, "TUUTIMANUAL", false);
        addPattern(PATTERN_DEFAULT, TYOUHYOU, "TYOUHYOU", false);


        lock(C_KjbncategoryKbn.class);
    }

    private C_KjbncategoryKbn(String value) {
        super(value);
    }

    public static C_KjbncategoryKbn valueOf(String value) {
        return valueOf(C_KjbncategoryKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KjbncategoryKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KjbncategoryKbn.class, patternId, value);
    }
}
