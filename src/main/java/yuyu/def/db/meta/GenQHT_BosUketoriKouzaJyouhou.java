package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KouzaInfoInputHoryuuKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_UketorikouzasyubetuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.HT_BosUketoriKouzaJyouhou;
import yuyu.def.db.type.UserType_C_KouzaInfoInputHoryuuKbn;
import yuyu.def.db.type.UserType_C_KouzasyuruiKbn;
import yuyu.def.db.type.UserType_C_KzkykdouKbn;
import yuyu.def.db.type.UserType_C_UketorikouzasyubetuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 募集受取口座情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_BosUketoriKouzaJyouhou extends AbstractExDBTable<HT_BosUketoriKouzaJyouhou> {

    public GenQHT_BosUketoriKouzaJyouhou() {
        this("HT_BosUketoriKouzaJyouhou");
    }

    public GenQHT_BosUketoriKouzaJyouhou(String pAlias) {
        super("HT_BosUketoriKouzaJyouhou", HT_BosUketoriKouzaJyouhou.class, pAlias);
    }

    public String HT_BosUketoriKouzaJyouhou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_BosUketoriKouzaJyouhou, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_BosUketoriKouzaJyouhou, C_UketorikouzasyubetuKbn> uktkzsyubetukbn = new ExDBFieldString<>("uktkzsyubetukbn", this, UserType_C_UketorikouzasyubetuKbn.class);

    public final ExDBFieldString<HT_BosUketoriKouzaJyouhou, C_KouzaInfoInputHoryuuKbn> kouzainfoinputhoryuukbn = new ExDBFieldString<>("kouzainfoinputhoryuukbn", this, UserType_C_KouzaInfoInputHoryuuKbn.class);

    public final ExDBFieldString<HT_BosUketoriKouzaJyouhou, C_KouzasyuruiKbn> kzsyuruikbn = new ExDBFieldString<>("kzsyuruikbn", this, UserType_C_KouzasyuruiKbn.class);

    public final ExDBFieldString<HT_BosUketoriKouzaJyouhou, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<HT_BosUketoriKouzaJyouhou, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<HT_BosUketoriKouzaJyouhou, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<HT_BosUketoriKouzaJyouhou, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<HT_BosUketoriKouzaJyouhou, C_KzkykdouKbn> kzkykdoukbn = new ExDBFieldString<>("kzkykdoukbn", this, UserType_C_KzkykdouKbn.class);

    public final ExDBFieldString<HT_BosUketoriKouzaJyouhou, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<HT_BosUketoriKouzaJyouhou, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_BosUketoriKouzaJyouhou, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
