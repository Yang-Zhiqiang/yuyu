package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KzhuritourokuhouKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_SinkeizkKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.HT_KouzaJyouhou;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_KzhuritourokuhouKbn;
import yuyu.def.db.type.UserType_C_KzkykdouKbn;
import yuyu.def.db.type.UserType_C_SinkeizkKbn;
import yuyu.def.db.type.UserType_C_Syuudaikocd;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.def.db.type.UserType_C_YouhiblnkKbn;

/**
 * 口座情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_KouzaJyouhou extends AbstractExDBTable<HT_KouzaJyouhou> {

    public GenQHT_KouzaJyouhou() {
        this("HT_KouzaJyouhou");
    }

    public GenQHT_KouzaJyouhou(String pAlias) {
        super("HT_KouzaJyouhou", HT_KouzaJyouhou.class, pAlias);
    }

    public String HT_KouzaJyouhou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_KouzaJyouhou, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_KouzaJyouhou, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<HT_KouzaJyouhou, C_KzkykdouKbn> kzkykdoukbn = new ExDBFieldString<>("kzkykdoukbn", this, UserType_C_KzkykdouKbn.class);

    public final ExDBFieldString<HT_KouzaJyouhou, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<HT_KouzaJyouhou, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<HT_KouzaJyouhou, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<HT_KouzaJyouhou, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<HT_KouzaJyouhou, C_SinkeizkKbn> sinkeizkkbn = new ExDBFieldString<>("sinkeizkkbn", this, UserType_C_SinkeizkKbn.class);

    public final ExDBFieldString<HT_KouzaJyouhou, String> hbcmnt = new ExDBFieldString<>("hbcmnt", this);

    public final ExDBFieldString<HT_KouzaJyouhou, C_Syuudaikocd> syuudaikocd = new ExDBFieldString<>("syuudaikocd", this, UserType_C_Syuudaikocd.class);

    public final ExDBFieldString<HT_KouzaJyouhou, C_YouhiblnkKbn> kouzakakuniniraikbn = new ExDBFieldString<>("kouzakakuniniraikbn", this, UserType_C_YouhiblnkKbn.class);

    public final ExDBFieldString<HT_KouzaJyouhou, BizDate> kouzakakuniniraiymd = new ExDBFieldString<>("kouzakakuniniraiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_KouzaJyouhou, BizDate> kouzajyouhounyuuryokuymd = new ExDBFieldString<>("kouzajyouhounyuuryokuymd", this, BizDateType.class);

    public final ExDBFieldString<HT_KouzaJyouhou, C_KzhuritourokuhouKbn> kzhuritourokuhoukbn = new ExDBFieldString<>("kzhuritourokuhoukbn", this, UserType_C_KzhuritourokuhouKbn.class);

    public final ExDBFieldString<HT_KouzaJyouhou, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_KouzaJyouhou, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
