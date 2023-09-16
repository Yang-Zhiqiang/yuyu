package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HnkSyuruiKbn;
import yuyu.def.db.entity.MT_DsHenkouRireki;
import yuyu.def.db.type.UserType_C_HnkSyuruiKbn;

/**
 * ＤＳ変更履歴テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQMT_DsHenkouRireki extends AbstractExDBTable<MT_DsHenkouRireki> {

    public GenQMT_DsHenkouRireki() {
        this("MT_DsHenkouRireki");
    }

    public GenQMT_DsHenkouRireki(String pAlias) {
        super("MT_DsHenkouRireki", MT_DsHenkouRireki.class, pAlias);
    }

    public String MT_DsHenkouRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<MT_DsHenkouRireki, String> dskokno = new ExDBFieldString<>("dskokno", this);

    public final ExDBFieldString<MT_DsHenkouRireki, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldNumber<MT_DsHenkouRireki, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<MT_DsHenkouRireki, String> tablenm = new ExDBFieldString<>("tablenm", this);

    public final ExDBFieldString<MT_DsHenkouRireki, String> tableid = new ExDBFieldString<>("tableid", this);

    public final ExDBFieldString<MT_DsHenkouRireki, C_HnkSyuruiKbn> hnksyuruikbn = new ExDBFieldString<>("hnksyuruikbn", this, UserType_C_HnkSyuruiKbn.class);

    public final ExDBFieldString<MT_DsHenkouRireki, String> hanbetukoumokunm = new ExDBFieldString<>("hanbetukoumokunm", this);

    public final ExDBFieldString<MT_DsHenkouRireki, String> henkoukoumokuid = new ExDBFieldString<>("henkoukoumokuid", this);

    public final ExDBFieldString<MT_DsHenkouRireki, String> henkoukoumokunm = new ExDBFieldString<>("henkoukoumokunm", this);

    public final ExDBFieldString<MT_DsHenkouRireki, String> bfrnaiyouoriginal = new ExDBFieldString<>("bfrnaiyouoriginal", this);

    public final ExDBFieldString<MT_DsHenkouRireki, String> bfrnaiyou = new ExDBFieldString<>("bfrnaiyou", this);

    public final ExDBFieldString<MT_DsHenkouRireki, String> newnaiyouoriginal = new ExDBFieldString<>("newnaiyouoriginal", this);

    public final ExDBFieldString<MT_DsHenkouRireki, String> newnaiyou = new ExDBFieldString<>("newnaiyou", this);

    public final ExDBFieldString<MT_DsHenkouRireki, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<MT_DsHenkouRireki, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<MT_DsHenkouRireki, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);
}
