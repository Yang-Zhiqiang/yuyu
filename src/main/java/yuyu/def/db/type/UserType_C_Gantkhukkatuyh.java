package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Gantkhukkatuyh;

/**
 * {@link C_Gantkhukkatuyh がん特約復活要否} の Hibernate ユーザー定義型です。<br />
 * がん特約復活要否 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Gantkhukkatuyh extends AbstractUserType<C_Gantkhukkatuyh> {

    @Override
    protected Class<C_Gantkhukkatuyh> returnType() {
        return C_Gantkhukkatuyh.class;
    }

    @Override
    protected C_Gantkhukkatuyh valueOf(String pValue) {
        return C_Gantkhukkatuyh.valueOf(pValue);
    }

    @Override
    protected String toString(C_Gantkhukkatuyh pValue) {
        return pValue.getValue();
    }
}
