package yuyu.app.sinkeiyaku.sksyoukai.skmossyoukai;

import jp.co.slcs.swak.date.BizDate;

/**
 * 申込状況照会 の定数定義クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class SkMosSyoukaiConstants extends GenSkMosSyoukaiConstants {

    public static final String KEYSITEI                  = "●キー指定";

    public static final String KHKINOUMODE_DEFAULT       = "default";

    public static final String ZENNKAKUSPACE             = "　";

    public static final String TYUUIMONGON1              = "※保険料入金前のため暫定（申込日）";

    public static final String TYUUIMONGON1_2            = "※保険料入金前のため暫定（申込日前日）";

    public static final String TYUUIMONGON2              = "※保険料入金前のため暫定";

    public static final String SRTUSMKEYAKU              = "1";

    public static final int SEISUUONE                    = 1;

    public static final int SEISUUFUSUUONE               = -1;

    public static final BizDate HIDUKEINIT               = BizDate.valueOf("00000000");

    public static final int DATA_LIMIT_COUNT = 1000;

    public static final String PERCENT                   = "％";

    public static final String BAI                       = "倍";

    public static final String MARK                      = "－";

    public static final String INPUTKEY                  = "キー入力画面";

    public static final String INQUIRYLOADINGHNKGTMTTRRT = "　契約時から１０年経過後）";

    public static final String KBKAKKOSTART = "（";

    public static enum E_SyoriKeiyu {
        SYORI_SYOUKAI,

        SYORI_KENSAKU,
    }
}