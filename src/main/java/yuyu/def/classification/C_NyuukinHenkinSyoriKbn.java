
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 入金返金処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NyuukinHenkinSyoriKbn</td><td colspan="3">入金返金処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYUUKIN}</td><td>&quot;01&quot;</td><td>入金入力</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HURIKOMINYUUKIN}</td><td>&quot;02&quot;</td><td>振込入金処理</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIRITU}</td><td>&quot;03&quot;</td><td>成立処理</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENKIN}</td><td>&quot;11&quot;</td><td>返金入力</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENKINKIBOU}</td><td>&quot;12&quot;</td><td>返金希望</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TFBHENKINTORIKESI}</td><td>&quot;13&quot;</td><td>当日ＦＢ返金取消</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SELECT SELECT}<br />(選択用)</td><td align="center">○</td><td>{@link #NYUUKIN}</td><td>&quot;01&quot;</td><td>入金入力</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENKIN}</td><td>&quot;11&quot;</td><td>返金入力</td></tr>
 * </table>
 */
public class C_NyuukinHenkinSyoriKbn extends Classification<C_NyuukinHenkinSyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NyuukinHenkinSyoriKbn BLNK = new C_NyuukinHenkinSyoriKbn("00");

    public static final C_NyuukinHenkinSyoriKbn NYUUKIN = new C_NyuukinHenkinSyoriKbn("01");

    public static final C_NyuukinHenkinSyoriKbn HURIKOMINYUUKIN = new C_NyuukinHenkinSyoriKbn("02");

    public static final C_NyuukinHenkinSyoriKbn SEIRITU = new C_NyuukinHenkinSyoriKbn("03");

    public static final C_NyuukinHenkinSyoriKbn HENKIN = new C_NyuukinHenkinSyoriKbn("11");

    public static final C_NyuukinHenkinSyoriKbn HENKINKIBOU = new C_NyuukinHenkinSyoriKbn("12");

    public static final C_NyuukinHenkinSyoriKbn TFBHENKINTORIKESI = new C_NyuukinHenkinSyoriKbn("13");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NYUUKIN, "NYUUKIN", false);
        addPattern(PATTERN_DEFAULT, HURIKOMINYUUKIN, "HURIKOMINYUUKIN", false);
        addPattern(PATTERN_DEFAULT, SEIRITU, "SEIRITU", false);
        addPattern(PATTERN_DEFAULT, HENKIN, "HENKIN", false);
        addPattern(PATTERN_DEFAULT, HENKINKIBOU, "HENKINKIBOU", false);
        addPattern(PATTERN_DEFAULT, TFBHENKINTORIKESI, "TFBHENKINTORIKESI", false);


        addPattern(PATTERN_SELECT, NYUUKIN, "NYUUKIN", true);
        addPattern(PATTERN_SELECT, HENKIN, "HENKIN", false);


        lock(C_NyuukinHenkinSyoriKbn.class);
    }

    private C_NyuukinHenkinSyoriKbn(String value) {
        super(value);
    }

    public static C_NyuukinHenkinSyoriKbn valueOf(String value) {
        return valueOf(C_NyuukinHenkinSyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NyuukinHenkinSyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NyuukinHenkinSyoriKbn.class, patternId, value);
    }
}
