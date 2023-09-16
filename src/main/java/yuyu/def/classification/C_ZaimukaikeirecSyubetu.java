
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 財務会計レコード種別 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ZaimukaikeirecSyubetu</td><td colspan="3">財務会計レコード種別</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RUIKEIZZENGETUMATU}</td><td>&quot;1&quot;</td><td>前々月末累計</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GOUKEIZENGETU}</td><td>&quot;2&quot;</td><td>前月合計</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RUIKEIZENGETUMATU}</td><td>&quot;3&quot;</td><td>前月末累計</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GOUKEITOUGETU}</td><td>&quot;4&quot;</td><td>当月合計</td></tr>
 * </table>
 */
public class C_ZaimukaikeirecSyubetu extends Classification<C_ZaimukaikeirecSyubetu> {

    private static final long serialVersionUID = 1L;


    public static final C_ZaimukaikeirecSyubetu BLNK = new C_ZaimukaikeirecSyubetu("0");

    public static final C_ZaimukaikeirecSyubetu RUIKEIZZENGETUMATU = new C_ZaimukaikeirecSyubetu("1");

    public static final C_ZaimukaikeirecSyubetu GOUKEIZENGETU = new C_ZaimukaikeirecSyubetu("2");

    public static final C_ZaimukaikeirecSyubetu RUIKEIZENGETUMATU = new C_ZaimukaikeirecSyubetu("3");

    public static final C_ZaimukaikeirecSyubetu GOUKEITOUGETU = new C_ZaimukaikeirecSyubetu("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, RUIKEIZZENGETUMATU, "RUIKEIZZENGETUMATU", false);
        addPattern(PATTERN_DEFAULT, GOUKEIZENGETU, "GOUKEIZENGETU", false);
        addPattern(PATTERN_DEFAULT, RUIKEIZENGETUMATU, "RUIKEIZENGETUMATU", false);
        addPattern(PATTERN_DEFAULT, GOUKEITOUGETU, "GOUKEITOUGETU", false);


        lock(C_ZaimukaikeirecSyubetu.class);
    }

    private C_ZaimukaikeirecSyubetu(String value) {
        super(value);
    }

    public static C_ZaimukaikeirecSyubetu valueOf(String value) {
        return valueOf(C_ZaimukaikeirecSyubetu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ZaimukaikeirecSyubetu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ZaimukaikeirecSyubetu.class, patternId, value);
    }
}
