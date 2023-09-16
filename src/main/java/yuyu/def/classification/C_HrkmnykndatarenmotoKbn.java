
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 振込入金データ連携元区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HrkmnykndatarenmotoKbn</td><td colspan="3">振込入金データ連携元区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NYKNMEISAI}</td><td>&quot;0&quot;</td><td>入出金明細</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATUTORIKOMI}</td><td>&quot;1&quot;</td><td>明細一括取込</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ONLINE}</td><td>&quot;2&quot;</td><td>外貨資金管理オンライン</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DISP DISP}<br />(表示用)</td><td align="center">&nbsp;</td><td>{@link #NYKNMEISAI}</td><td>&quot;0&quot;</td><td>自動入金連動分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATUTORIKOMI}</td><td>&quot;1&quot;</td><td>明細一括取込分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ONLINE}</td><td>&quot;2&quot;</td><td>外貨資金管理オンライン入力分</td></tr>
 * </table>
 */
public class C_HrkmnykndatarenmotoKbn extends Classification<C_HrkmnykndatarenmotoKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HrkmnykndatarenmotoKbn NYKNMEISAI = new C_HrkmnykndatarenmotoKbn("0");

    public static final C_HrkmnykndatarenmotoKbn IKKATUTORIKOMI = new C_HrkmnykndatarenmotoKbn("1");

    public static final C_HrkmnykndatarenmotoKbn ONLINE = new C_HrkmnykndatarenmotoKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_DISP = "2";


    static {

        addPattern(PATTERN_DEFAULT, NYKNMEISAI, "NYKNMEISAI", true);
        addPattern(PATTERN_DEFAULT, IKKATUTORIKOMI, "IKKATUTORIKOMI", false);
        addPattern(PATTERN_DEFAULT, ONLINE, "ONLINE", false);


        addPattern(PATTERN_DISP, NYKNMEISAI, "NYKNMEISAI", false);
        addPattern(PATTERN_DISP, IKKATUTORIKOMI, "IKKATUTORIKOMI", false);
        addPattern(PATTERN_DISP, ONLINE, "ONLINE", false);


        lock(C_HrkmnykndatarenmotoKbn.class);
    }

    private C_HrkmnykndatarenmotoKbn(String value) {
        super(value);
    }

    public static C_HrkmnykndatarenmotoKbn valueOf(String value) {
        return valueOf(C_HrkmnykndatarenmotoKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HrkmnykndatarenmotoKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HrkmnykndatarenmotoKbn.class, patternId, value);
    }
}
