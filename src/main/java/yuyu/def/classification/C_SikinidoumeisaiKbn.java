
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 資金移動明細区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SikinidoumeisaiKbn</td><td colspan="3">資金移動明細区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;000&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DSKAIYAKU}</td><td>&quot;010&quot;</td><td>ＤＳ解約分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYUUKINTORIKESI}</td><td>&quot;020&quot;</td><td>入金取消分</td></tr>
 * </table>
 */
public class C_SikinidoumeisaiKbn extends Classification<C_SikinidoumeisaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SikinidoumeisaiKbn BLNK = new C_SikinidoumeisaiKbn("000");

    public static final C_SikinidoumeisaiKbn DSKAIYAKU = new C_SikinidoumeisaiKbn("010");

    public static final C_SikinidoumeisaiKbn NYUUKINTORIKESI = new C_SikinidoumeisaiKbn("020");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, DSKAIYAKU, "DSKAIYAKU", false);
        addPattern(PATTERN_DEFAULT, NYUUKINTORIKESI, "NYUUKINTORIKESI", false);


        lock(C_SikinidoumeisaiKbn.class);
    }

    private C_SikinidoumeisaiKbn(String value) {
        super(value);
    }

    public static C_SikinidoumeisaiKbn valueOf(String value) {
        return valueOf(C_SikinidoumeisaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SikinidoumeisaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SikinidoumeisaiKbn.class, patternId, value);
    }
}
