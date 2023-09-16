
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 完了通知出力区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KanryotuutioutKbn</td><td colspan="3">完了通知出力区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PDF}</td><td>&quot;1&quot;</td><td>PDF</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIBU}</td><td>&quot;2&quot;</td><td>外部印刷</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_NOBLNK NOBLNK}<br />(ブランクなし)</td><td align="center">○</td><td>{@link #GAIBU}</td><td>&quot;2&quot;</td><td>外部印刷</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PDF}</td><td>&quot;1&quot;</td><td>PDF</td></tr>
 * </table>
 */
public class C_KanryotuutioutKbn extends Classification<C_KanryotuutioutKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KanryotuutioutKbn BLNK = new C_KanryotuutioutKbn("0");

    public static final C_KanryotuutioutKbn PDF = new C_KanryotuutioutKbn("1");

    public static final C_KanryotuutioutKbn GAIBU = new C_KanryotuutioutKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOBLNK = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, PDF, "PDF", false);
        addPattern(PATTERN_DEFAULT, GAIBU, "GAIBU", false);


        addPattern(PATTERN_NOBLNK, GAIBU, "GAIBU", true);
        addPattern(PATTERN_NOBLNK, PDF, "PDF", false);


        lock(C_KanryotuutioutKbn.class);
    }

    private C_KanryotuutioutKbn(String value) {
        super(value);
    }

    public static C_KanryotuutioutKbn valueOf(String value) {
        return valueOf(C_KanryotuutioutKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KanryotuutioutKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KanryotuutioutKbn.class, patternId, value);
    }
}
