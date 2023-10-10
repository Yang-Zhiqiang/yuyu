package yuyu.app.base.system.kadoutimetouroku;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import yuyu.def.classification.C_KadouTimeYoubiKbn;

/**
 * 稼働時間登録 の定数定義クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class KadouTimeTourokuConstants extends GenKadouTimeTourokuConstants {

    static final String BLANK = "\'\'";

    static final Item[] FROM_ITEMS = {
        DDID_KADOUTIMEINFOINPUT_KADOUTIMEFROM1,
        DDID_KADOUTIMEINFOINPUT_KADOUTIMEFROM2,
        DDID_KADOUTIMEINFOINPUT_KADOUTIMEFROM3,
        DDID_KADOUTIMEINFOINPUT_KADOUTIMEFROM4,
        DDID_KADOUTIMEINFOINPUT_KADOUTIMEFROM5
    };

    static final Item[] TO_ITEMS = {
        DDID_KADOUTIMEINFOINPUT_KADOUTIMETO1,
        DDID_KADOUTIMEINFOINPUT_KADOUTIMETO2,
        DDID_KADOUTIMEINFOINPUT_KADOUTIMETO3,
        DDID_KADOUTIMEINFOINPUT_KADOUTIMETO4,
        DDID_KADOUTIMEINFOINPUT_KADOUTIMETO5
    };

    static final C_KadouTimeYoubiKbn[] YOUBIKBNS = {
        C_KadouTimeYoubiKbn.HYOUJYUN,
        C_KadouTimeYoubiKbn.GETUYOU,
        C_KadouTimeYoubiKbn.KAYOU,
        C_KadouTimeYoubiKbn.SUIYOU,
        C_KadouTimeYoubiKbn.MOKUYOU,
        C_KadouTimeYoubiKbn.KINYOU,
        C_KadouTimeYoubiKbn.DOYOU,
        C_KadouTimeYoubiKbn.NITIYOU
    };

}
