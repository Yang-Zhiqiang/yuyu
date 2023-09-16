package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.db.entity.IT_ItekiToukeiInfo;
import yuyu.def.db.type.UserType_C_Ketkekkacd;

/**
 * 医的統計用情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_ItekiToukeiInfo extends AbstractExDBTable<IT_ItekiToukeiInfo> {

    public GenQIT_ItekiToukeiInfo() {
        this("IT_ItekiToukeiInfo");
    }

    public GenQIT_ItekiToukeiInfo(String pAlias) {
        super("IT_ItekiToukeiInfo", IT_ItekiToukeiInfo.class, pAlias);
    }

    public String IT_ItekiToukeiInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_ItekiToukeiInfo, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_ItekiToukeiInfo, C_Ketkekkacd> ketkekkacd = new ExDBFieldString<>("ketkekkacd", this, UserType_C_Ketkekkacd.class);

    public final ExDBFieldString<IT_ItekiToukeiInfo, String> palketsyacd = new ExDBFieldString<>("palketsyacd", this);
}
