package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.db.entity.HT_MosTrkKzk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_KjkhukaKbn;
import yuyu.def.db.type.UserType_C_Seibetu;
import yuyu.def.db.type.UserType_C_Tdk;
import yuyu.def.db.type.UserType_C_TrkKzkKbn;
import yuyu.def.db.type.UserType_C_TsindousiteiKbn;

/**
 * 申込登録家族テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_MosTrkKzk extends AbstractExDBTable<HT_MosTrkKzk> {

    public GenQHT_MosTrkKzk() {
        this("HT_MosTrkKzk");
    }

    public GenQHT_MosTrkKzk(String pAlias) {
        super("HT_MosTrkKzk", HT_MosTrkKzk.class, pAlias);
    }

    public String HT_MosTrkKzk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_MosTrkKzk, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_MosTrkKzk, C_TrkKzkKbn> trkkzkkbn = new ExDBFieldString<>("trkkzkkbn", this, UserType_C_TrkKzkKbn.class);

    public final ExDBFieldString<HT_MosTrkKzk, String> trkkzknmkn = new ExDBFieldString<>("trkkzknmkn", this);

    public final ExDBFieldString<HT_MosTrkKzk, String> trkkzknmkj = new ExDBFieldString<>("trkkzknmkj", this);

    public final ExDBFieldString<HT_MosTrkKzk, C_KjkhukaKbn> trkkzknmkjkhukakbn = new ExDBFieldString<>("trkkzknmkjkhukakbn", this, UserType_C_KjkhukaKbn.class);

    public final ExDBFieldString<HT_MosTrkKzk, BizDate> trkkzkseiymd = new ExDBFieldString<>("trkkzkseiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_MosTrkKzk, C_Seibetu> trkkzksei = new ExDBFieldString<>("trkkzksei", this, UserType_C_Seibetu.class);

    public final ExDBFieldString<HT_MosTrkKzk, C_Tdk> trkkzktdk = new ExDBFieldString<>("trkkzktdk", this, UserType_C_Tdk.class);

    public final ExDBFieldString<HT_MosTrkKzk, C_TsindousiteiKbn> trkkzktsindousiteikbn = new ExDBFieldString<>("trkkzktsindousiteikbn", this, UserType_C_TsindousiteiKbn.class);

    public final ExDBFieldString<HT_MosTrkKzk, String> trkkzkyno = new ExDBFieldString<>("trkkzkyno", this);

    public final ExDBFieldString<HT_MosTrkKzk, String> trkkzkadr1kj = new ExDBFieldString<>("trkkzkadr1kj", this);

    public final ExDBFieldString<HT_MosTrkKzk, String> trkkzkadr2kj = new ExDBFieldString<>("trkkzkadr2kj", this);

    public final ExDBFieldString<HT_MosTrkKzk, String> trkkzkadr3kj = new ExDBFieldString<>("trkkzkadr3kj", this);

    public final ExDBFieldString<HT_MosTrkKzk, String> trkkzktelno = new ExDBFieldString<>("trkkzktelno", this);

    public final ExDBFieldString<HT_MosTrkKzk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_MosTrkKzk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
