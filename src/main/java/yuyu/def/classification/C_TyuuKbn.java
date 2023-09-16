
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 中区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TyuuKbn</td><td colspan="3">中区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYSN}</td><td>&quot;1110&quot;</td><td>終身</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SITEITUKASYSN}</td><td>&quot;1610&quot;</td><td>指定通貨建終身</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDATESYSN_HNK}</td><td>&quot;1620&quot;</td><td>円建終身（変更後）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SITEITUKANNKN}</td><td>&quot;5610&quot;</td><td>指定通貨建個人年金（一時払い）（指数連動型）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOTEIRRT_SITEITUKANNKN}</td><td>&quot;5620&quot;</td><td>予定利率変動型指定通貨建個人年金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ENKATEIGAKUNNKN}</td><td>&quot;5701&quot;</td><td>円貨定額年金</td></tr>
 * </table>
 */
public class C_TyuuKbn extends Classification<C_TyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TyuuKbn BLNK = new C_TyuuKbn("0");

    public static final C_TyuuKbn SYSN = new C_TyuuKbn("1110");

    public static final C_TyuuKbn SITEITUKASYSN = new C_TyuuKbn("1610");

    public static final C_TyuuKbn YENDATESYSN_HNK = new C_TyuuKbn("1620");

    public static final C_TyuuKbn SITEITUKANNKN = new C_TyuuKbn("5610");

    public static final C_TyuuKbn YOTEIRRT_SITEITUKANNKN = new C_TyuuKbn("5620");

    public static final C_TyuuKbn ENKATEIGAKUNNKN = new C_TyuuKbn("5701");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYSN, "SYSN", false);
        addPattern(PATTERN_DEFAULT, SITEITUKASYSN, "SITEITUKASYSN", false);
        addPattern(PATTERN_DEFAULT, YENDATESYSN_HNK, "YENDATESYSN_HNK", false);
        addPattern(PATTERN_DEFAULT, SITEITUKANNKN, "SITEITUKANNKN", false);
        addPattern(PATTERN_DEFAULT, YOTEIRRT_SITEITUKANNKN, "YOTEIRRT_SITEITUKANNKN", false);
        addPattern(PATTERN_DEFAULT, ENKATEIGAKUNNKN, "ENKATEIGAKUNNKN", false);


        lock(C_TyuuKbn.class);
    }

    private C_TyuuKbn(String value) {
        super(value);
    }

    public static C_TyuuKbn valueOf(String value) {
        return valueOf(C_TyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TyuuKbn.class, patternId, value);
    }
}
