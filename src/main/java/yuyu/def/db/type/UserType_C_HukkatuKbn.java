package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HukkatuKbn;

/**
 * {@link C_HukkatuKbn 復活区分} の Hibernate ユーザー定義型です。<br />
 * 復活区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HukkatuKbn extends AbstractUserType<C_HukkatuKbn> {

    @Override
    protected Class<C_HukkatuKbn> returnType() {
        return C_HukkatuKbn.class;
    }

    @Override
    protected C_HukkatuKbn valueOf(String pValue) {
        return C_HukkatuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HukkatuKbn pValue) {
        return pValue.getValue();
    }
}
