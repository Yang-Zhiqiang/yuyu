
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 年金消滅コード クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NkSyoumetuCd</td><td colspan="3">年金消滅コード</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUURYOU}</td><td>&quot;10&quot;</td><td>年金終了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LASTNKSHR}</td><td>&quot;11&quot;</td><td>最終年金支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKSEISAN}</td><td>&quot;20&quot;</td><td>年金開始前精算</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITJKIN}</td><td>&quot;30&quot;</td><td>一時金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOU}</td><td>&quot;40&quot;</td><td>死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIKOU}</td><td>&quot;90&quot;</td><td>時効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKTORIKESI}</td><td>&quot;99&quot;</td><td>年金連動取消し</td></tr>
 * </table>
 */
public class C_NkSyoumetuCd extends Classification<C_NkSyoumetuCd> {

    private static final long serialVersionUID = 1L;


    public static final C_NkSyoumetuCd BLNK = new C_NkSyoumetuCd("00");

    public static final C_NkSyoumetuCd SYUURYOU = new C_NkSyoumetuCd("10");

    public static final C_NkSyoumetuCd LASTNKSHR = new C_NkSyoumetuCd("11");

    public static final C_NkSyoumetuCd NKSEISAN = new C_NkSyoumetuCd("20");

    public static final C_NkSyoumetuCd ITJKIN = new C_NkSyoumetuCd("30");

    public static final C_NkSyoumetuCd SIBOU = new C_NkSyoumetuCd("40");

    public static final C_NkSyoumetuCd JIKOU = new C_NkSyoumetuCd("90");

    public static final C_NkSyoumetuCd NKTORIKESI = new C_NkSyoumetuCd("99");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYUURYOU, "SYUURYOU", false);
        addPattern(PATTERN_DEFAULT, LASTNKSHR, "LASTNKSHR", false);
        addPattern(PATTERN_DEFAULT, NKSEISAN, "NKSEISAN", false);
        addPattern(PATTERN_DEFAULT, ITJKIN, "ITJKIN", false);
        addPattern(PATTERN_DEFAULT, SIBOU, "SIBOU", false);
        addPattern(PATTERN_DEFAULT, JIKOU, "JIKOU", false);
        addPattern(PATTERN_DEFAULT, NKTORIKESI, "NKTORIKESI", false);


        lock(C_NkSyoumetuCd.class);
    }

    private C_NkSyoumetuCd(String value) {
        super(value);
    }

    public static C_NkSyoumetuCd valueOf(String value) {
        return valueOf(C_NkSyoumetuCd.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NkSyoumetuCd.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NkSyoumetuCd.class, patternId, value);
    }
}
