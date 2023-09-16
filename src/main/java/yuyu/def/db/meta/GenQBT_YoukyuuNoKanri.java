package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_JdTrksPalTrksZanKbn;
import yuyu.def.classification.C_KyknaiyouhaneiErrKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_TorikesiKekkaKbn;
import yuyu.def.db.entity.BT_YoukyuuNoKanri;
import yuyu.def.db.type.UserType_C_Huho2kyknoKbn;
import yuyu.def.db.type.UserType_C_JdTrksPalTrksZanKbn;
import yuyu.def.db.type.UserType_C_KyknaiyouhaneiErrKbn;
import yuyu.def.db.type.UserType_C_MQSyorikekkaKbn;
import yuyu.def.db.type.UserType_C_TorikesiKekkaKbn;

/**
 * 要求通番管理テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_YoukyuuNoKanri extends AbstractExDBTable<BT_YoukyuuNoKanri> {

    public GenQBT_YoukyuuNoKanri() {
        this("BT_YoukyuuNoKanri");
    }

    public GenQBT_YoukyuuNoKanri(String pAlias) {
        super("BT_YoukyuuNoKanri", BT_YoukyuuNoKanri.class, pAlias);
    }

    public String BT_YoukyuuNoKanri() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_YoukyuuNoKanri, String> youkyuuno = new ExDBFieldString<>("youkyuuno", this);

    public final ExDBFieldString<BT_YoukyuuNoKanri, C_Huho2kyknoKbn> huho2kyknokbn = new ExDBFieldString<>("huho2kyknokbn", this, UserType_C_Huho2kyknoKbn.class);

    public final ExDBFieldString<BT_YoukyuuNoKanri, String> huho2kykno = new ExDBFieldString<>("huho2kykno", this);

    public final ExDBFieldString<BT_YoukyuuNoKanri, C_MQSyorikekkaKbn> mqkousinmqsyorikekkakbn = new ExDBFieldString<>("mqkousinmqsyorikekkakbn", this, UserType_C_MQSyorikekkaKbn.class);

    public final ExDBFieldString<BT_YoukyuuNoKanri, String> mqkousinacserrcd = new ExDBFieldString<>("mqkousinacserrcd", this);

    public final ExDBFieldString<BT_YoukyuuNoKanri, C_MQSyorikekkaKbn> mqtrksiraimqsyorikekkakbn = new ExDBFieldString<>("mqtrksiraimqsyorikekkakbn", this, UserType_C_MQSyorikekkaKbn.class);

    public final ExDBFieldString<BT_YoukyuuNoKanri, String> mqtrksiraiacserrcd = new ExDBFieldString<>("mqtrksiraiacserrcd", this);

    public final ExDBFieldString<BT_YoukyuuNoKanri, C_KyknaiyouhaneiErrKbn> kyknaiyouhaneierrkbn = new ExDBFieldString<>("kyknaiyouhaneierrkbn", this, UserType_C_KyknaiyouhaneiErrKbn.class);

    public final ExDBFieldString<BT_YoukyuuNoKanri, C_TorikesiKekkaKbn> trkskekkakbn = new ExDBFieldString<>("trkskekkakbn", this, UserType_C_TorikesiKekkaKbn.class);

    public final ExDBFieldString<BT_YoukyuuNoKanri, C_JdTrksPalTrksZanKbn> jdtrkspaltrkszankbn = new ExDBFieldString<>("jdtrkspaltrkszankbn", this, UserType_C_JdTrksPalTrksZanKbn.class);

    public final ExDBFieldString<BT_YoukyuuNoKanri, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<BT_YoukyuuNoKanri, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BT_YoukyuuNoKanri, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
