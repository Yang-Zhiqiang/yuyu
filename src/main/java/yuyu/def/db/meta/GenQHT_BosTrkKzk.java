package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.db.entity.HT_BosTrkKzk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_KjkhukaKbn;
import yuyu.def.db.type.UserType_C_Seibetu;
import yuyu.def.db.type.UserType_C_Tdk;
import yuyu.def.db.type.UserType_C_TrkKzkKbn;
import yuyu.def.db.type.UserType_C_TsindousiteiKbn;

/**
 * 募集登録家族テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_BosTrkKzk extends AbstractExDBTable<HT_BosTrkKzk> {

    public GenQHT_BosTrkKzk() {
        this("HT_BosTrkKzk");
    }

    public GenQHT_BosTrkKzk(String pAlias) {
        super("HT_BosTrkKzk", HT_BosTrkKzk.class, pAlias);
    }

    public String HT_BosTrkKzk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_BosTrkKzk, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_BosTrkKzk, C_TrkKzkKbn> trkkzkkbn = new ExDBFieldString<>("trkkzkkbn", this, UserType_C_TrkKzkKbn.class);

    public final ExDBFieldString<HT_BosTrkKzk, String> trkkzknmkn = new ExDBFieldString<>("trkkzknmkn", this);

    public final ExDBFieldString<HT_BosTrkKzk, String> trkkzknmkj = new ExDBFieldString<>("trkkzknmkj", this);

    public final ExDBFieldString<HT_BosTrkKzk, C_KjkhukaKbn> trkkzknmkjkhukakbn = new ExDBFieldString<>("trkkzknmkjkhukakbn", this, UserType_C_KjkhukaKbn.class);

    public final ExDBFieldString<HT_BosTrkKzk, BizDate> trkkzkseiymd = new ExDBFieldString<>("trkkzkseiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_BosTrkKzk, C_Seibetu> trkkzksei = new ExDBFieldString<>("trkkzksei", this, UserType_C_Seibetu.class);

    public final ExDBFieldString<HT_BosTrkKzk, C_Tdk> trkkzktdk = new ExDBFieldString<>("trkkzktdk", this, UserType_C_Tdk.class);

    public final ExDBFieldString<HT_BosTrkKzk, C_TsindousiteiKbn> trkkzktsindousiteikbn = new ExDBFieldString<>("trkkzktsindousiteikbn", this, UserType_C_TsindousiteiKbn.class);

    public final ExDBFieldString<HT_BosTrkKzk, String> trkkzkyno = new ExDBFieldString<>("trkkzkyno", this);

    public final ExDBFieldString<HT_BosTrkKzk, String> trkkzkadr1kj = new ExDBFieldString<>("trkkzkadr1kj", this);

    public final ExDBFieldString<HT_BosTrkKzk, String> trkkzkadr2kj = new ExDBFieldString<>("trkkzkadr2kj", this);

    public final ExDBFieldString<HT_BosTrkKzk, String> trkkzkadr3kj = new ExDBFieldString<>("trkkzkadr3kj", this);

    public final ExDBFieldString<HT_BosTrkKzk, String> trkkzktelno = new ExDBFieldString<>("trkkzktelno", this);

    public final ExDBFieldString<HT_BosTrkKzk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_BosTrkKzk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
