package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_DrtensyKbn;
import yuyu.def.classification.C_YuuseiKbn;
import yuyu.def.db.entity.HT_MosDairitenVrf;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_DrtensyKbn;
import yuyu.def.db.type.UserType_C_YuuseiKbn;

/**
 * 申込代理店ベリファイテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_MosDairitenVrf extends AbstractExDBTable<HT_MosDairitenVrf> {

    public GenQHT_MosDairitenVrf() {
        this("HT_MosDairitenVrf");
    }

    public GenQHT_MosDairitenVrf(String pAlias) {
        super("HT_MosDairitenVrf", HT_MosDairitenVrf.class, pAlias);
    }

    public String HT_MosDairitenVrf() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_MosDairitenVrf, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldNumber<HT_MosDairitenVrf, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<HT_MosDairitenVrf, String> bsyujoyadrtencd = new ExDBFieldString<>("bsyujoyadrtencd", this);

    public final ExDBFieldString<HT_MosDairitenVrf, C_DrtensyKbn> drtensykbn = new ExDBFieldString<>("drtensykbn", this, UserType_C_DrtensyKbn.class);

    public final ExDBFieldString<HT_MosDairitenVrf, String> kinyuucd = new ExDBFieldString<>("kinyuucd", this);

    public final ExDBFieldString<HT_MosDairitenVrf, String> kinyuusitencd = new ExDBFieldString<>("kinyuusitencd", this);

    public final ExDBFieldString<HT_MosDairitenVrf, String> tratkiagcd = new ExDBFieldString<>("tratkiagcd", this);

    public final ExDBFieldString<HT_MosDairitenVrf, String> oyadrtencd = new ExDBFieldString<>("oyadrtencd", this);

    public final ExDBFieldString<HT_MosDairitenVrf, String> jimusyocd = new ExDBFieldString<>("jimusyocd", this);

    public final ExDBFieldString<HT_MosDairitenVrf, String> bosyuutrkno = new ExDBFieldString<>("bosyuutrkno", this);

    public final ExDBFieldString<HT_MosDairitenVrf, String> cifcd = new ExDBFieldString<>("cifcd", this);

    public final ExDBFieldString<HT_MosDairitenVrf, String> drtencd = new ExDBFieldString<>("drtencd", this);

    public final ExDBFieldString<HT_MosDairitenVrf, String> bosyuucd = new ExDBFieldString<>("bosyuucd", this);

    public final ExDBFieldString<HT_MosDairitenVrf, String> inputbosyuucd = new ExDBFieldString<>("inputbosyuucd", this);

    public final ExDBFieldString<HT_MosDairitenVrf, String> daibosyuucd = new ExDBFieldString<>("daibosyuucd", this);

    public final ExDBFieldString<HT_MosDairitenVrf, String> tratkikouinncd = new ExDBFieldString<>("tratkikouinncd", this);

    public final ExDBFieldString<HT_MosDairitenVrf, C_YuuseiKbn> yuuseikbn = new ExDBFieldString<>("yuuseikbn", this, UserType_C_YuuseiKbn.class);

    public final ExDBFieldString<HT_MosDairitenVrf, String> kyokusyocd = new ExDBFieldString<>("kyokusyocd", this);

    public final ExDBFieldString<HT_MosDairitenVrf, String> yuuseisyainno = new ExDBFieldString<>("yuuseisyainno", this);

    public final ExDBFieldString<HT_MosDairitenVrf, String> drtenkanrisosikicd = new ExDBFieldString<>("drtenkanrisosikicd", this);

    public final ExDBFieldString<HT_MosDairitenVrf, String> gyousekikeijyousakisosikicd = new ExDBFieldString<>("gyousekikeijyousakisosikicd", this);

    public final ExDBFieldString<HT_MosDairitenVrf, BizNumber> bunwari = new ExDBFieldString<>("bunwari", this, BizNumberType.class);

    public final ExDBFieldString<HT_MosDairitenVrf, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_MosDairitenVrf, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
