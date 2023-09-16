package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_DrtenRnrkhouKbn;
import yuyu.def.classification.C_NykntratkiKbn;
import yuyu.def.classification.C_TrksskssouhuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.HM_SkDairitenKobetuJyouhou;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_DrtenRnrkhouKbn;
import yuyu.def.db.type.UserType_C_NykntratkiKbn;
import yuyu.def.db.type.UserType_C_TrksskssouhuKbn;
import yuyu.def.db.type.UserType_C_YouhiKbn;
import yuyu.def.db.type.UserType_C_YouhiblnkKbn;

/**
 * 代理店個別情報マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHM_SkDairitenKobetuJyouhou extends AbstractExDBTable<HM_SkDairitenKobetuJyouhou> {

    public GenQHM_SkDairitenKobetuJyouhou() {
        this("HM_SkDairitenKobetuJyouhou");
    }

    public GenQHM_SkDairitenKobetuJyouhou(String pAlias) {
        super("HM_SkDairitenKobetuJyouhou", HM_SkDairitenKobetuJyouhou.class, pAlias);
    }

    public String HM_SkDairitenKobetuJyouhou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HM_SkDairitenKobetuJyouhou, String> oyadrtencd = new ExDBFieldString<>("oyadrtencd", this);

    public final ExDBFieldString<HM_SkDairitenKobetuJyouhou, C_DrtenRnrkhouKbn> drtenRnrkhouKbn = new ExDBFieldString<>("drtenRnrkhouKbn", this, UserType_C_DrtenRnrkhouKbn.class);

    public final ExDBFieldString<HM_SkDairitenKobetuJyouhou, String> utdskknnm1kj = new ExDBFieldString<>("utdskknnm1kj", this);

    public final ExDBFieldString<HM_SkDairitenKobetuJyouhou, String> utdskknnm2kj = new ExDBFieldString<>("utdskknnm2kj", this);

    public final ExDBFieldString<HM_SkDairitenKobetuJyouhou, C_NykntratkiKbn> nykntratkikbn = new ExDBFieldString<>("nykntratkikbn", this, UserType_C_NykntratkiKbn.class);

    public final ExDBFieldString<HM_SkDairitenKobetuJyouhou, C_TrksskssouhuKbn> trksskssouhukbn = new ExDBFieldString<>("trksskssouhukbn", this, UserType_C_TrksskssouhuKbn.class);

    public final ExDBFieldString<HM_SkDairitenKobetuJyouhou, String> tkhjnkinyuucd = new ExDBFieldString<>("tkhjnkinyuucd", this);

    public final ExDBFieldString<HM_SkDairitenKobetuJyouhou, String> drtentrkno = new ExDBFieldString<>("drtentrkno", this);

    public final ExDBFieldString<HM_SkDairitenKobetuJyouhou, C_YouhiKbn> cifcdcheckyouhi = new ExDBFieldString<>("cifcdcheckyouhi", this, UserType_C_YouhiKbn.class);

    public final ExDBFieldString<HM_SkDairitenKobetuJyouhou, String> cifcdsiteiketasuu = new ExDBFieldString<>("cifcdsiteiketasuu", this);

    public final ExDBFieldString<HM_SkDairitenKobetuJyouhou, C_YouhiblnkKbn> cifcdmaezeroumeyouhi = new ExDBFieldString<>("cifcdmaezeroumeyouhi", this, UserType_C_YouhiblnkKbn.class);

    public final ExDBFieldString<HM_SkDairitenKobetuJyouhou, BizDate> kosymd = new ExDBFieldString<>("kosymd", this, BizDateType.class);

    public final ExDBFieldString<HM_SkDairitenKobetuJyouhou, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HM_SkDairitenKobetuJyouhou, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
