package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SpecialUserKbn;

/**
 * {@link C_SpecialUserKbn 特別ユーザー区分} の Hibernate ユーザー定義型です。<br />
 * 特別ユーザー区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SpecialUserKbn extends AbstractUserType<C_SpecialUserKbn> {

    @Override
    protected Class<C_SpecialUserKbn> returnType() {
        return C_SpecialUserKbn.class;
    }

    @Override
    protected C_SpecialUserKbn valueOf(String pValue) {
        return C_SpecialUserKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SpecialUserKbn pValue) {
        return pValue.getValue();
    }
}
