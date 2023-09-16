
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 工程終了フラグ クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KouteiSyuuryouFlg</td><td colspan="3">工程終了フラグ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #KEIZOKUTYUU}</td><td>&quot;0&quot;</td><td>継続中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUURYOU}</td><td>&quot;1&quot;</td><td>終了</td></tr>
 * </table>
 */
public class C_KouteiSyuuryouFlg extends Classification<C_KouteiSyuuryouFlg> {

    private static final long serialVersionUID = 1L;


    public static final C_KouteiSyuuryouFlg KEIZOKUTYUU = new C_KouteiSyuuryouFlg("0");

    public static final C_KouteiSyuuryouFlg SYUURYOU = new C_KouteiSyuuryouFlg("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, KEIZOKUTYUU, "KEIZOKUTYUU", true);
        addPattern(PATTERN_DEFAULT, SYUURYOU, "SYUURYOU", false);


        lock(C_KouteiSyuuryouFlg.class);
    }

    private C_KouteiSyuuryouFlg(String value) {
        super(value);
    }

    public static C_KouteiSyuuryouFlg valueOf(String value) {
        return valueOf(C_KouteiSyuuryouFlg.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KouteiSyuuryouFlg.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KouteiSyuuryouFlg.class, patternId, value);
    }
}
