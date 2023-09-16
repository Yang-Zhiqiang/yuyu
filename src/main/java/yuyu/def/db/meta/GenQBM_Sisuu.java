package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.db.entity.BM_Sisuu;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Sisuukbn;

/**
 * 指数マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_Sisuu extends AbstractExDBTable<BM_Sisuu> {

    public GenQBM_Sisuu() {
        this("BM_Sisuu");
    }

    public GenQBM_Sisuu(String pAlias) {
        super("BM_Sisuu", BM_Sisuu.class, pAlias);
    }

    public String BM_Sisuu() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_Sisuu, C_Sisuukbn> sisuukbn = new ExDBFieldString<>("sisuukbn", this, UserType_C_Sisuukbn.class);

    public final ExDBFieldString<BM_Sisuu, BizDate> sisuukouhyouymd = new ExDBFieldString<>("sisuukouhyouymd", this, BizDateType.class);

    public final ExDBFieldString<BM_Sisuu, BizNumber> sisuu = new ExDBFieldString<>("sisuu", this, BizNumberType.class);

    public final ExDBFieldString<BM_Sisuu, BizDate> sisuucalckijyunymd = new ExDBFieldString<>("sisuucalckijyunymd", this, BizDateType.class);
}
