package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_DsSyoriNaiyouKbn;
import yuyu.def.db.entity.MT_SousaRirekiSyousai;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_DsSyoriNaiyouKbn;

/**
 * 操作履歴詳細テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQMT_SousaRirekiSyousai extends AbstractExDBTable<MT_SousaRirekiSyousai> {

    public GenQMT_SousaRirekiSyousai() {
        this("MT_SousaRirekiSyousai");
    }

    public GenQMT_SousaRirekiSyousai(String pAlias) {
        super("MT_SousaRirekiSyousai", MT_SousaRirekiSyousai.class, pAlias);
    }

    public String MT_SousaRirekiSyousai() {
        return getAliasExpression();
    }

    public final ExDBFieldString<MT_SousaRirekiSyousai, String> ttdksikibetuid = new ExDBFieldString<>("ttdksikibetuid", this);

    public final ExDBFieldNumber<MT_SousaRirekiSyousai, Integer> sousarirekirenno = new ExDBFieldNumber<>("sousarirekirenno", this);

    public final ExDBFieldString<MT_SousaRirekiSyousai, BizDate> syoriendymd = new ExDBFieldString<>("syoriendymd", this, BizDateType.class);

    public final ExDBFieldString<MT_SousaRirekiSyousai, String> syoriendtime = new ExDBFieldString<>("syoriendtime", this);

    public final ExDBFieldString<MT_SousaRirekiSyousai, C_DsSyoriNaiyouKbn> syorinaiyoukbn = new ExDBFieldString<>("syorinaiyoukbn", this, UserType_C_DsSyoriNaiyouKbn.class);

    public final ExDBFieldString<MT_SousaRirekiSyousai, String> syorisyousai = new ExDBFieldString<>("syorisyousai", this);

    public final ExDBFieldString<MT_SousaRirekiSyousai, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<MT_SousaRirekiSyousai, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<MT_SousaRirekiSyousai, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
