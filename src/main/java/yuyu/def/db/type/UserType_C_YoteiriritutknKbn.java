package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_YoteiriritutknKbn;

/**
 * {@link C_YoteiriritutknKbn 予定利率特認区分} の Hibernate ユーザー定義型です。<br />
 * 予定利率特認区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_YoteiriritutknKbn extends AbstractUserType<C_YoteiriritutknKbn> {

    @Override
    protected Class<C_YoteiriritutknKbn> returnType() {
        return C_YoteiriritutknKbn.class;
    }

    @Override
    protected C_YoteiriritutknKbn valueOf(String pValue) {
        return C_YoteiriritutknKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_YoteiriritutknKbn pValue) {
        return pValue.getValue();
    }
}
