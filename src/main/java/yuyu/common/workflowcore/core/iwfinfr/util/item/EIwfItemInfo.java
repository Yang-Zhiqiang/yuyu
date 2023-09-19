package yuyu.common.workflowcore.core.iwfinfr.util.item;


/**
 * 項目定義情報<br />
 * ※ワークフローで扱う項目を定義したクラス<br />
 * ※チェック処理、ログ生成時の項目名 などを共通化する目的で作成したクラス<br />
 */
public enum EIwfItemInfo {

    S_GYOUMUKEY       ("業務キー"          , 50 ),
    S_FLOWID          ("フローＩＤ"        , 19 ),
    S_TOKENID         ("トークンＩＤ"      , 19 ),
    S_ACCOUNTID       ("アカウントＩＤ"    , 30 ),
    S_ACCOUNTNAME     ("アカウント名"      , 50 ),
    S_TEISIKBN        ("停止区分"          , 1  ),
    S_GROUPID         ("グループＩＤ"      , 30 ),
    S_KENGENID        ("権限ＩＤ"          , 30 ),
    S_REQUESTID       ("リクエストＩＤ"    , 10 ),
    S_DAIBUNRUIID     ("大分類ＩＤ"        , 30 ),
    S_VERSION         ("バージョン"        , 16 );

    private final String sItemName_;

    private final int iMaxByteLength_;


    private EIwfItemInfo(String name, int length) {
        this.sItemName_ = name;
        this.iMaxByteLength_ = length;
    }


    public String getItemName() {
        return sItemName_;
    }

    public int getMaxByteLength() {
        return iMaxByteLength_;
    }

}
