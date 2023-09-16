package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KouzaInfoInputHoryuuKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_UketorikouzasyubetuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.HT_UketoriKouzaJyouhouVrf;
import yuyu.def.db.type.UserType_C_KouzaInfoInputHoryuuKbn;
import yuyu.def.db.type.UserType_C_KouzasyuruiKbn;
import yuyu.def.db.type.UserType_C_KzkykdouKbn;
import yuyu.def.db.type.UserType_C_UketorikouzasyubetuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 受取口座情報ベリファイテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_UketoriKouzaJyouhouVrf extends AbstractExDBTable<HT_UketoriKouzaJyouhouVrf> {

    public GenQHT_UketoriKouzaJyouhouVrf() {
        this("HT_UketoriKouzaJyouhouVrf");
    }

    public GenQHT_UketoriKouzaJyouhouVrf(String pAlias) {
        super("HT_UketoriKouzaJyouhouVrf", HT_UketoriKouzaJyouhouVrf.class, pAlias);
    }

    public String HT_UketoriKouzaJyouhouVrf() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_UketoriKouzaJyouhouVrf, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_UketoriKouzaJyouhouVrf, C_UketorikouzasyubetuKbn> uktkzsyubetukbn = new ExDBFieldString<>("uktkzsyubetukbn", this, UserType_C_UketorikouzasyubetuKbn.class);

    public final ExDBFieldString<HT_UketoriKouzaJyouhouVrf, C_KouzaInfoInputHoryuuKbn> kouzainfoinputhoryuukbn = new ExDBFieldString<>("kouzainfoinputhoryuukbn", this, UserType_C_KouzaInfoInputHoryuuKbn.class);

    public final ExDBFieldString<HT_UketoriKouzaJyouhouVrf, C_KouzasyuruiKbn> kzsyuruikbn = new ExDBFieldString<>("kzsyuruikbn", this, UserType_C_KouzasyuruiKbn.class);

    public final ExDBFieldString<HT_UketoriKouzaJyouhouVrf, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<HT_UketoriKouzaJyouhouVrf, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<HT_UketoriKouzaJyouhouVrf, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<HT_UketoriKouzaJyouhouVrf, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<HT_UketoriKouzaJyouhouVrf, C_KzkykdouKbn> kzkykdoukbn = new ExDBFieldString<>("kzkykdoukbn", this, UserType_C_KzkykdouKbn.class);

    public final ExDBFieldString<HT_UketoriKouzaJyouhouVrf, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<HT_UketoriKouzaJyouhouVrf, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_UketoriKouzaJyouhouVrf, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
