
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 収納代行社コード クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Syuudaikocd</td><td colspan="3">収納代行社コード</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIS}</td><td>&quot;10&quot;</td><td>ＳＩＳ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENSINKYOU}</td><td>&quot;20&quot;</td><td>全信協</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CSS}</td><td>&quot;30&quot;</td><td>ＣＳＳ</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIS}</td><td>&quot;10&quot;</td><td>ＳＩＳ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CSS}</td><td>&quot;30&quot;</td><td>ＣＳＳ</td></tr>
 * </table>
 */
public class C_Syuudaikocd extends Classification<C_Syuudaikocd> {

    private static final long serialVersionUID = 1L;


    public static final C_Syuudaikocd BLNK = new C_Syuudaikocd("00");

    public static final C_Syuudaikocd SIS = new C_Syuudaikocd("10");

    public static final C_Syuudaikocd ZENSINKYOU = new C_Syuudaikocd("20");

    public static final C_Syuudaikocd CSS = new C_Syuudaikocd("30");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SIS, "SIS", false);
        addPattern(PATTERN_DEFAULT, ZENSINKYOU, "ZENSINKYOU", false);
        addPattern(PATTERN_DEFAULT, CSS, "CSS", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, SIS, "SIS", false);
        addPattern(PATTERN_SELECT, CSS, "CSS", false);


        lock(C_Syuudaikocd.class);
    }

    private C_Syuudaikocd(String value) {
        super(value);
    }

    public static C_Syuudaikocd valueOf(String value) {
        return valueOf(C_Syuudaikocd.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Syuudaikocd.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Syuudaikocd.class, patternId, value);
    }
}
