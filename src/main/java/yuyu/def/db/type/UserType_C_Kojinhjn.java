package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Kojinhjn;

/**
 * {@link C_Kojinhjn 個人法人区分} の Hibernate ユーザー定義型です。<br />
 * 個人法人区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Kojinhjn extends AbstractUserType<C_Kojinhjn> {

    @Override
    protected Class<C_Kojinhjn> returnType() {
        return C_Kojinhjn.class;
    }

    @Override
    protected C_Kojinhjn valueOf(String pValue) {
        return C_Kojinhjn.valueOf(pValue);
    }

    @Override
    protected String toString(C_Kojinhjn pValue) {
        return pValue.getValue();
    }
}
