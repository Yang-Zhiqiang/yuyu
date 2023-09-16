package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_PmnjtkKbn;

/**
 * {@link C_PmnjtkKbn 保険料免除特約区分} の Hibernate ユーザー定義型です。<br />
 * 保険料免除特約区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_PmnjtkKbn extends AbstractUserType<C_PmnjtkKbn> {

    @Override
    protected Class<C_PmnjtkKbn> returnType() {
        return C_PmnjtkKbn.class;
    }

    @Override
    protected C_PmnjtkKbn valueOf(String pValue) {
        return C_PmnjtkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_PmnjtkKbn pValue) {
        return pValue.getValue();
    }
}
