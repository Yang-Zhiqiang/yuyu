package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_AzukariRiritu;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 預り利率マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_AzukariRiritu extends AbstractExDBTable<BM_AzukariRiritu> {

    public GenQBM_AzukariRiritu() {
        this("BM_AzukariRiritu");
    }

    public GenQBM_AzukariRiritu(String pAlias) {
        super("BM_AzukariRiritu", BM_AzukariRiritu.class, pAlias);
    }

    public String BM_AzukariRiritu() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_AzukariRiritu, C_Tuukasyu> tuukasyu = new ExDBFieldString<>("tuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<BM_AzukariRiritu, BizDate> tkyfromymd = new ExDBFieldString<>("tkyfromymd", this, BizDateType.class);

    public final ExDBFieldString<BM_AzukariRiritu, BizDate> tkytoymd = new ExDBFieldString<>("tkytoymd", this, BizDateType.class);

    public final ExDBFieldString<BM_AzukariRiritu, BizNumber> azukaririritu = new ExDBFieldString<>("azukaririritu", this, BizNumberType.class);
}
