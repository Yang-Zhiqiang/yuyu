
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 契約内容反映エラー区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KyknaiyouhaneiErrKbn</td><td colspan="3">契約内容反映エラー区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SYORIOK}</td><td>&quot;0&quot;</td><td>処理ＯＫ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYORIERROR}</td><td>&quot;1&quot;</td><td>処理エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUMEI_JIDOUTRKSYOU}</td><td>&quot;2&quot;</td><td>不明（自動取消要）</td></tr>
 * </table>
 */
public class C_KyknaiyouhaneiErrKbn extends Classification<C_KyknaiyouhaneiErrKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KyknaiyouhaneiErrKbn SYORIOK = new C_KyknaiyouhaneiErrKbn("0");

    public static final C_KyknaiyouhaneiErrKbn SYORIERROR = new C_KyknaiyouhaneiErrKbn("1");

    public static final C_KyknaiyouhaneiErrKbn HUMEI_JIDOUTRKSYOU = new C_KyknaiyouhaneiErrKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SYORIOK, "SYORIOK", true);
        addPattern(PATTERN_DEFAULT, SYORIERROR, "SYORIERROR", false);
        addPattern(PATTERN_DEFAULT, HUMEI_JIDOUTRKSYOU, "HUMEI_JIDOUTRKSYOU", false);


        lock(C_KyknaiyouhaneiErrKbn.class);
    }

    private C_KyknaiyouhaneiErrKbn(String value) {
        super(value);
    }

    public static C_KyknaiyouhaneiErrKbn valueOf(String value) {
        return valueOf(C_KyknaiyouhaneiErrKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KyknaiyouhaneiErrKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KyknaiyouhaneiErrKbn.class, patternId, value);
    }
}
