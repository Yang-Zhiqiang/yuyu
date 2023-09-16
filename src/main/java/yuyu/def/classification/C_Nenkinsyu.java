
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 年金種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Nenkinsyu</td><td colspan="3">年金種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAKUTEINENKIN}</td><td>&quot;1&quot;</td><td>確定年金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SGKHSYSYSNNENKIN}</td><td>&quot;2&quot;</td><td>年金総額保証付終身年金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAKUTEIDAI1NENKINBAIGK}</td><td>&quot;3&quot;</td><td>確定年金（第１回年金倍額型）</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_KHSYOUKAI KHSYOUKAI}<br />(契約保全照会画面用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAKUTEINENKIN}</td><td>&quot;1&quot;</td><td>確定年金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SGKHSYSYSNNENKIN}</td><td>&quot;2&quot;</td><td>終身年金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAKUTEIDAI1NENKINBAIGK}</td><td>&quot;3&quot;</td><td>確定年金（第１回年金倍額型）</td></tr>
 * </table>
 */
public class C_Nenkinsyu extends Classification<C_Nenkinsyu> {

    private static final long serialVersionUID = 1L;


    public static final C_Nenkinsyu BLNK = new C_Nenkinsyu("0");

    public static final C_Nenkinsyu KAKUTEINENKIN = new C_Nenkinsyu("1");

    public static final C_Nenkinsyu SGKHSYSYSNNENKIN = new C_Nenkinsyu("2");

    public static final C_Nenkinsyu KAKUTEIDAI1NENKINBAIGK = new C_Nenkinsyu("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_KHSYOUKAI = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KAKUTEINENKIN, "KAKUTEINENKIN", false);
        addPattern(PATTERN_DEFAULT, SGKHSYSYSNNENKIN, "SGKHSYSYSNNENKIN", false);
        addPattern(PATTERN_DEFAULT, KAKUTEIDAI1NENKINBAIGK, "KAKUTEIDAI1NENKINBAIGK", false);


        addPattern(PATTERN_KHSYOUKAI, BLNK, "BLNK", true);
        addPattern(PATTERN_KHSYOUKAI, KAKUTEINENKIN, "KAKUTEINENKIN", false);
        addPattern(PATTERN_KHSYOUKAI, SGKHSYSYSNNENKIN, "SGKHSYSYSNNENKIN", false);
        addPattern(PATTERN_KHSYOUKAI, KAKUTEIDAI1NENKINBAIGK, "KAKUTEIDAI1NENKINBAIGK", false);


        lock(C_Nenkinsyu.class);
    }

    private C_Nenkinsyu(String value) {
        super(value);
    }

    public static C_Nenkinsyu valueOf(String value) {
        return valueOf(C_Nenkinsyu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Nenkinsyu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Nenkinsyu.class, patternId, value);
    }
}
