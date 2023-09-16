package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.db.entity.IT_BAK_TrkKzk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_KjkhukaKbn;
import yuyu.def.db.type.UserType_C_Seibetu;
import yuyu.def.db.type.UserType_C_Tdk;
import yuyu.def.db.type.UserType_C_TrkKzkKbn;
import yuyu.def.db.type.UserType_C_TsindousiteiKbn;

/**
 * 登録家族バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_TrkKzk extends AbstractExDBTable<IT_BAK_TrkKzk> {

    public GenQIT_BAK_TrkKzk() {
        this("IT_BAK_TrkKzk");
    }

    public GenQIT_BAK_TrkKzk(String pAlias) {
        super("IT_BAK_TrkKzk", IT_BAK_TrkKzk.class, pAlias);
    }

    public String IT_BAK_TrkKzk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_TrkKzk, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_TrkKzk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_TrkKzk, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_TrkKzk, C_TrkKzkKbn> trkkzkkbn = new ExDBFieldString<>("trkkzkkbn", this, UserType_C_TrkKzkKbn.class);

    public final ExDBFieldString<IT_BAK_TrkKzk, BizDate> trkkzksetteiymd = new ExDBFieldString<>("trkkzksetteiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_TrkKzk, String> trkkzknmkn = new ExDBFieldString<>("trkkzknmkn", this);

    public final ExDBFieldString<IT_BAK_TrkKzk, String> trkkzknmkj = new ExDBFieldString<>("trkkzknmkj", this);

    public final ExDBFieldString<IT_BAK_TrkKzk, C_KjkhukaKbn> trkkzknmkjkhukakbn = new ExDBFieldString<>("trkkzknmkjkhukakbn", this, UserType_C_KjkhukaKbn.class);

    public final ExDBFieldString<IT_BAK_TrkKzk, BizDate> trkkzkseiymd = new ExDBFieldString<>("trkkzkseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_TrkKzk, C_Seibetu> trkkzksei = new ExDBFieldString<>("trkkzksei", this, UserType_C_Seibetu.class);

    public final ExDBFieldString<IT_BAK_TrkKzk, C_Tdk> trkkzktdk = new ExDBFieldString<>("trkkzktdk", this, UserType_C_Tdk.class);

    public final ExDBFieldString<IT_BAK_TrkKzk, String> trkkzkyno = new ExDBFieldString<>("trkkzkyno", this);

    public final ExDBFieldString<IT_BAK_TrkKzk, String> trkkzkadr1kj = new ExDBFieldString<>("trkkzkadr1kj", this);

    public final ExDBFieldString<IT_BAK_TrkKzk, String> trkkzkadr2kj = new ExDBFieldString<>("trkkzkadr2kj", this);

    public final ExDBFieldString<IT_BAK_TrkKzk, String> trkkzkadr3kj = new ExDBFieldString<>("trkkzkadr3kj", this);

    public final ExDBFieldString<IT_BAK_TrkKzk, String> trkkzktelno = new ExDBFieldString<>("trkkzktelno", this);

    public final ExDBFieldString<IT_BAK_TrkKzk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_TrkKzk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_TrkKzk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IT_BAK_TrkKzk, C_TsindousiteiKbn> trkkzktsindousiteikbn = new ExDBFieldString<>("trkkzktsindousiteikbn", this, UserType_C_TsindousiteiKbn.class);
}
