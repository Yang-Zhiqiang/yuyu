
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * メッセージ種別 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MsgSyubetu</td><td colspan="3">メッセージ種別</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #INFOMATION}</td><td>&quot;I&quot;</td><td>インフォメーション</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WARNING}</td><td>&quot;W&quot;</td><td>ワーニング</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ERROR}</td><td>&quot;E&quot;</td><td>エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #VALIDATION}</td><td>&quot;V&quot;</td><td>バリデーション</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TERROR}</td><td>&quot;T&quot;</td><td>特認エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TKANOU}</td><td>&quot;K&quot;</td><td>特認可能</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #QUESTION}</td><td>&quot;Q&quot;</td><td>クエスチョン</td></tr>
 * </table>
 */
public class C_MsgSyubetu extends Classification<C_MsgSyubetu> {

    private static final long serialVersionUID = 1L;


    public static final C_MsgSyubetu INFOMATION = new C_MsgSyubetu("I");

    public static final C_MsgSyubetu WARNING = new C_MsgSyubetu("W");

    public static final C_MsgSyubetu ERROR = new C_MsgSyubetu("E");

    public static final C_MsgSyubetu VALIDATION = new C_MsgSyubetu("V");

    public static final C_MsgSyubetu TERROR = new C_MsgSyubetu("T");

    public static final C_MsgSyubetu TKANOU = new C_MsgSyubetu("K");

    public static final C_MsgSyubetu QUESTION = new C_MsgSyubetu("Q");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, INFOMATION, "INFOMATION", true);
        addPattern(PATTERN_DEFAULT, WARNING, "WARNING", false);
        addPattern(PATTERN_DEFAULT, ERROR, "ERROR", false);
        addPattern(PATTERN_DEFAULT, VALIDATION, "VALIDATION", false);
        addPattern(PATTERN_DEFAULT, TERROR, "TERROR", false);
        addPattern(PATTERN_DEFAULT, TKANOU, "TKANOU", false);
        addPattern(PATTERN_DEFAULT, QUESTION, "QUESTION", false);


        lock(C_MsgSyubetu.class);
    }

    private C_MsgSyubetu(String value) {
        super(value);
    }

    public static C_MsgSyubetu valueOf(String value) {
        return valueOf(C_MsgSyubetu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MsgSyubetu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MsgSyubetu.class, patternId, value);
    }
}
