package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SuuriHrkhouKbn;

/**
 * {@link C_SuuriHrkhouKbn 数理払込方法区分} の Hibernate ユーザー定義型です。<br />
 * 数理払込方法区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SuuriHrkhouKbn extends AbstractUserType<C_SuuriHrkhouKbn> {

    @Override
    protected Class<C_SuuriHrkhouKbn> returnType() {
        return C_SuuriHrkhouKbn.class;
    }

    @Override
    protected C_SuuriHrkhouKbn valueOf(String pValue) {
        return C_SuuriHrkhouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SuuriHrkhouKbn pValue) {
        return pValue.getValue();
    }
}
