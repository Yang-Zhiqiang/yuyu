package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_FatcakakkekkaKbn;

/**
 * {@link C_FatcakakkekkaKbn FATCA確認結果区分} の Hibernate ユーザー定義型です。<br />
 * FATCA確認結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_FatcakakkekkaKbn extends AbstractUserType<C_FatcakakkekkaKbn> {

    @Override
    protected Class<C_FatcakakkekkaKbn> returnType() {
        return C_FatcakakkekkaKbn.class;
    }

    @Override
    protected C_FatcakakkekkaKbn valueOf(String pValue) {
        return C_FatcakakkekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_FatcakakkekkaKbn pValue) {
        return pValue.getValue();
    }
}
