package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HozonHousiki;

/**
 * {@link C_HozonHousiki 保存方式} の Hibernate ユーザー定義型です。<br />
 * 保存方式 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HozonHousiki extends AbstractUserType<C_HozonHousiki> {

    @Override
    protected Class<C_HozonHousiki> returnType() {
        return C_HozonHousiki.class;
    }

    @Override
    protected C_HozonHousiki valueOf(String pValue) {
        return C_HozonHousiki.valueOf(pValue);
    }

    @Override
    protected String toString(C_HozonHousiki pValue) {
        return pValue.getValue();
    }
}
