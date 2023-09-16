package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.HT_KmTsRireki;

/**
 * 項目訂正履歴テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_KmTsRireki extends AbstractExDBTable<HT_KmTsRireki> {

    public GenQHT_KmTsRireki() {
        this("HT_KmTsRireki");
    }

    public GenQHT_KmTsRireki(String pAlias) {
        super("HT_KmTsRireki", HT_KmTsRireki.class, pAlias);
    }

    public String HT_KmTsRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_KmTsRireki, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_KmTsRireki, String> syoriTime = new ExDBFieldString<>("syoriTime", this);

    public final ExDBFieldNumber<HT_KmTsRireki, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldString<HT_KmTsRireki, String> kinouId = new ExDBFieldString<>("kinouId", this);

    public final ExDBFieldString<HT_KmTsRireki, String> kinouModeId = new ExDBFieldString<>("kinouModeId", this);

    public final ExDBFieldString<HT_KmTsRireki, String> tskmnm = new ExDBFieldString<>("tskmnm", this);

    public final ExDBFieldString<HT_KmTsRireki, String> tsmaenaiyou = new ExDBFieldString<>("tsmaenaiyou", this);

    public final ExDBFieldString<HT_KmTsRireki, String> tsgonaiyou = new ExDBFieldString<>("tsgonaiyou", this);

    public final ExDBFieldString<HT_KmTsRireki, String> tantid = new ExDBFieldString<>("tantid", this);

    public final ExDBFieldString<HT_KmTsRireki, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_KmTsRireki, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
