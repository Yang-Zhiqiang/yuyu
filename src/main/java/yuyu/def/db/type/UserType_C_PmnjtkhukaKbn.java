package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_PmnjtkhukaKbn;

/**
 * {@link C_PmnjtkhukaKbn 保険料免除特約付加区分} の Hibernate ユーザー定義型です。<br />
 * 保険料免除特約付加区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_PmnjtkhukaKbn extends AbstractUserType<C_PmnjtkhukaKbn> {

    @Override
    protected Class<C_PmnjtkhukaKbn> returnType() {
        return C_PmnjtkhukaKbn.class;
    }

    @Override
    protected C_PmnjtkhukaKbn valueOf(String pValue) {
        return C_PmnjtkhukaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_PmnjtkhukaKbn pValue) {
        return pValue.getValue();
    }
}
