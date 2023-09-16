package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MskKbn;

/**
 * {@link C_MskKbn マスキング区分} の Hibernate ユーザー定義型です。<br />
 * マスキング区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MskKbn extends AbstractUserType<C_MskKbn> {

    @Override
    protected Class<C_MskKbn> returnType() {
        return C_MskKbn.class;
    }

    @Override
    protected C_MskKbn valueOf(String pValue) {
        return C_MskKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MskKbn pValue) {
        return pValue.getValue();
    }
}
