package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KzhuritourokuhouKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.HT_BosKouzaJyouhou;
import yuyu.def.db.type.UserType_C_KzhuritourokuhouKbn;
import yuyu.def.db.type.UserType_C_KzkykdouKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.def.db.type.UserType_C_YouhiblnkKbn;

/**
 * 募集口座情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_BosKouzaJyouhou extends AbstractExDBTable<HT_BosKouzaJyouhou> {

    public GenQHT_BosKouzaJyouhou() {
        this("HT_BosKouzaJyouhou");
    }

    public GenQHT_BosKouzaJyouhou(String pAlias) {
        super("HT_BosKouzaJyouhou", HT_BosKouzaJyouhou.class, pAlias);
    }

    public String HT_BosKouzaJyouhou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_BosKouzaJyouhou, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_BosKouzaJyouhou, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<HT_BosKouzaJyouhou, C_KzkykdouKbn> kzkykdoukbn = new ExDBFieldString<>("kzkykdoukbn", this, UserType_C_KzkykdouKbn.class);

    public final ExDBFieldString<HT_BosKouzaJyouhou, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<HT_BosKouzaJyouhou, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<HT_BosKouzaJyouhou, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<HT_BosKouzaJyouhou, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<HT_BosKouzaJyouhou, C_YouhiblnkKbn> kouzakakuniniraikbn = new ExDBFieldString<>("kouzakakuniniraikbn", this, UserType_C_YouhiblnkKbn.class);

    public final ExDBFieldString<HT_BosKouzaJyouhou, C_KzhuritourokuhouKbn> kzhuritourokuhoukbn = new ExDBFieldString<>("kzhuritourokuhoukbn", this, UserType_C_KzhuritourokuhouKbn.class);

    public final ExDBFieldString<HT_BosKouzaJyouhou, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_BosKouzaJyouhou, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
