package yuyu.app.hozen.khozen.khkeiyakusyoukai;

import jp.co.slcs.swak.util.message.MessageUtil;

/**
 * 契約内容照会 の定数定義クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class KhKeiyakuSyoukaiConstants extends GenKhKeiyakuSyoukaiConstants {
    public static final String KEIYAKUDAIRITEN_TABLE = "契約代理店テーブル";

    public static final String SYOUKENBANGOUSITEI    = "●証券番号指定";

    public static final String DISP_MESSAGE1    = "（未収保険料を含まない）";

    public static final String DISP_MESSAGE2    = "払込期月が到来していないため、＊と表示しております。";

    public static final String YEN_HENKANK_NAME = MessageUtil.getMessage(DDID_HENKANKINFO_YENHENKANK.getErrorResourceKey());
}
