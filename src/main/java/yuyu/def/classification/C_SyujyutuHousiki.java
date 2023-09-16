
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 手術方式 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyujyutuHousiki</td><td colspan="3">手術方式</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="14">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAITOU}</td><td>&quot;1&quot;</td><td>1：開頭術</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SENTOU}</td><td>&quot;2&quot;</td><td>2：穿頭術</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIKYOU}</td><td>&quot;3&quot;</td><td>3：開胸術</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYOUKUKYOU}</td><td>&quot;4&quot;</td><td>4：胸腔鏡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIFUKU}</td><td>&quot;5&quot;</td><td>5：開腹術</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FUKUKUKYOU}</td><td>&quot;6&quot;</td><td>6：腹腔鏡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FBSC}</td><td>&quot;7&quot;</td><td>7：ﾌｧｲﾊﾞｰｽｺｰﾌﾟ又はｶﾃｰﾃﾙ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIHI}</td><td>&quot;8&quot;</td><td>8：経皮的</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEINYOUDOU}</td><td>&quot;9&quot;</td><td>9：経尿道的</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEITITU}</td><td>&quot;10&quot;</td><td>10：経膣的</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LASER}</td><td>&quot;11&quot;</td><td>11：レーザー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;12&quot;</td><td>12：その他</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KISAINASI}</td><td>&quot;13&quot;</td><td>13：記載無し</td></tr>
 * </table>
 */
public class C_SyujyutuHousiki extends Classification<C_SyujyutuHousiki> {

    private static final long serialVersionUID = 1L;


    public static final C_SyujyutuHousiki BLNK = new C_SyujyutuHousiki("0");

    public static final C_SyujyutuHousiki KAITOU = new C_SyujyutuHousiki("1");

    public static final C_SyujyutuHousiki SENTOU = new C_SyujyutuHousiki("2");

    public static final C_SyujyutuHousiki KAIKYOU = new C_SyujyutuHousiki("3");

    public static final C_SyujyutuHousiki KYOUKUKYOU = new C_SyujyutuHousiki("4");

    public static final C_SyujyutuHousiki KAIFUKU = new C_SyujyutuHousiki("5");

    public static final C_SyujyutuHousiki FUKUKUKYOU = new C_SyujyutuHousiki("6");

    public static final C_SyujyutuHousiki FBSC = new C_SyujyutuHousiki("7");

    public static final C_SyujyutuHousiki KEIHI = new C_SyujyutuHousiki("8");

    public static final C_SyujyutuHousiki KEINYOUDOU = new C_SyujyutuHousiki("9");

    public static final C_SyujyutuHousiki KEITITU = new C_SyujyutuHousiki("10");

    public static final C_SyujyutuHousiki LASER = new C_SyujyutuHousiki("11");

    public static final C_SyujyutuHousiki SONOTA = new C_SyujyutuHousiki("12");

    public static final C_SyujyutuHousiki KISAINASI = new C_SyujyutuHousiki("13");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KAITOU, "KAITOU", false);
        addPattern(PATTERN_DEFAULT, SENTOU, "SENTOU", false);
        addPattern(PATTERN_DEFAULT, KAIKYOU, "KAIKYOU", false);
        addPattern(PATTERN_DEFAULT, KYOUKUKYOU, "KYOUKUKYOU", false);
        addPattern(PATTERN_DEFAULT, KAIFUKU, "KAIFUKU", false);
        addPattern(PATTERN_DEFAULT, FUKUKUKYOU, "FUKUKUKYOU", false);
        addPattern(PATTERN_DEFAULT, FBSC, "FBSC", false);
        addPattern(PATTERN_DEFAULT, KEIHI, "KEIHI", false);
        addPattern(PATTERN_DEFAULT, KEINYOUDOU, "KEINYOUDOU", false);
        addPattern(PATTERN_DEFAULT, KEITITU, "KEITITU", false);
        addPattern(PATTERN_DEFAULT, LASER, "LASER", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);
        addPattern(PATTERN_DEFAULT, KISAINASI, "KISAINASI", false);


        lock(C_SyujyutuHousiki.class);
    }

    private C_SyujyutuHousiki(String value) {
        super(value);
    }

    public static C_SyujyutuHousiki valueOf(String value) {
        return valueOf(C_SyujyutuHousiki.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyujyutuHousiki.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyujyutuHousiki.class, patternId, value);
    }
}
