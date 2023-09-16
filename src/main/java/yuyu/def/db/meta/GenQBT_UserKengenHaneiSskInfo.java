package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HnsyaSosikiKengenKbn;
import yuyu.def.db.entity.BT_UserKengenHaneiSskInfo;
import yuyu.def.db.type.UserType_C_HnsyaSosikiKengenKbn;

/**
 * ユーザー権限自動反映組織情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_UserKengenHaneiSskInfo extends AbstractExDBTable<BT_UserKengenHaneiSskInfo> {

    public GenQBT_UserKengenHaneiSskInfo() {
        this("BT_UserKengenHaneiSskInfo");
    }

    public GenQBT_UserKengenHaneiSskInfo(String pAlias) {
        super("BT_UserKengenHaneiSskInfo", BT_UserKengenHaneiSskInfo.class, pAlias);
    }

    public String BT_UserKengenHaneiSskInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_UserKengenHaneiSskInfo, String> sosikicdkami3 = new ExDBFieldString<>("sosikicdkami3", this);

    public final ExDBFieldString<BT_UserKengenHaneiSskInfo, C_HnsyaSosikiKengenKbn> hnsyasosikikengenkbn = new ExDBFieldString<>("hnsyasosikikengenkbn", this, UserType_C_HnsyaSosikiKengenKbn.class);
}
