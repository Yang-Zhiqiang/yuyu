package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Htnpkkn;

/**
 * {@link C_Htnpkkn 不担保期間} の Hibernate ユーザー定義型です。<br />
 * 不担保期間 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Htnpkkn extends AbstractUserType<C_Htnpkkn> {

    @Override
    protected Class<C_Htnpkkn> returnType() {
        return C_Htnpkkn.class;
    }

    @Override
    protected C_Htnpkkn valueOf(String pValue) {
        return C_Htnpkkn.valueOf(pValue);
    }

    @Override
    protected String toString(C_Htnpkkn pValue) {
        return pValue.getValue();
    }
}
