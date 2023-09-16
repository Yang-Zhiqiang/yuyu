
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＬＩＮＣ確認状況区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_LinckknnjkKbn</td><td colspan="3">ＬＩＮＣ確認状況区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #KAKUNINHUYOU}</td><td>&quot;0&quot;</td><td>確認不要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAKUNINMATI}</td><td>&quot;1&quot;</td><td>確認待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAKUNINKANRYOU}</td><td>&quot;2&quot;</td><td>確認完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAKUNINKANRYOUJIDOUKAIJO}</td><td>&quot;3&quot;</td><td>確認完了（自動解除）</td></tr>
 * </table>
 */
public class C_LinckknnjkKbn extends Classification<C_LinckknnjkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_LinckknnjkKbn KAKUNINHUYOU = new C_LinckknnjkKbn("0");

    public static final C_LinckknnjkKbn KAKUNINMATI = new C_LinckknnjkKbn("1");

    public static final C_LinckknnjkKbn KAKUNINKANRYOU = new C_LinckknnjkKbn("2");

    public static final C_LinckknnjkKbn KAKUNINKANRYOUJIDOUKAIJO = new C_LinckknnjkKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, KAKUNINHUYOU, "KAKUNINHUYOU", true);
        addPattern(PATTERN_DEFAULT, KAKUNINMATI, "KAKUNINMATI", false);
        addPattern(PATTERN_DEFAULT, KAKUNINKANRYOU, "KAKUNINKANRYOU", false);
        addPattern(PATTERN_DEFAULT, KAKUNINKANRYOUJIDOUKAIJO, "KAKUNINKANRYOUJIDOUKAIJO", false);


        lock(C_LinckknnjkKbn.class);
    }

    private C_LinckknnjkKbn(String value) {
        super(value);
    }

    public static C_LinckknnjkKbn valueOf(String value) {
        return valueOf(C_LinckknnjkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_LinckknnjkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_LinckknnjkKbn.class, patternId, value);
    }
}
