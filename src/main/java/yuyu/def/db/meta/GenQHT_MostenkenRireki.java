package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_SateiketsyorinmKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.db.entity.HT_MostenkenRireki;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_SateiketsyorinmKbn;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;

/**
 * 申込点検履歴テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_MostenkenRireki extends AbstractExDBTable<HT_MostenkenRireki> {

    public GenQHT_MostenkenRireki() {
        this("HT_MostenkenRireki");
    }

    public GenQHT_MostenkenRireki(String pAlias) {
        super("HT_MostenkenRireki", HT_MostenkenRireki.class, pAlias);
    }

    public String HT_MostenkenRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_MostenkenRireki, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldNumber<HT_MostenkenRireki, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<HT_MostenkenRireki, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<HT_MostenkenRireki, C_SateiketsyorinmKbn> sateiketsyorinmkbn = new ExDBFieldString<>("sateiketsyorinmkbn", this, UserType_C_SateiketsyorinmKbn.class);

    public final ExDBFieldString<HT_MostenkenRireki, C_SyorikekkaKbn> mostenkenkekkakbn = new ExDBFieldString<>("mostenkenkekkakbn", this, UserType_C_SyorikekkaKbn.class);

    public final ExDBFieldString<HT_MostenkenRireki, String> tnsketsyacd = new ExDBFieldString<>("tnsketsyacd", this);

    public final ExDBFieldString<HT_MostenkenRireki, String> ketsyacd = new ExDBFieldString<>("ketsyacd", this);

    public final ExDBFieldString<HT_MostenkenRireki, String> palketsyacd = new ExDBFieldString<>("palketsyacd", this);

    public final ExDBFieldString<HT_MostenkenRireki, String> mostenkencomment = new ExDBFieldString<>("mostenkencomment", this);

    public final ExDBFieldString<HT_MostenkenRireki, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_MostenkenRireki, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
