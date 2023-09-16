package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SuuriRendouHrkhouKbn;

/**
 * {@link C_SuuriRendouHrkhouKbn 数理連動用払込方法区分} の Hibernate ユーザー定義型です。<br />
 * 数理連動用払込方法区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SuuriRendouHrkhouKbn extends AbstractUserType<C_SuuriRendouHrkhouKbn> {

    @Override
    protected Class<C_SuuriRendouHrkhouKbn> returnType() {
        return C_SuuriRendouHrkhouKbn.class;
    }

    @Override
    protected C_SuuriRendouHrkhouKbn valueOf(String pValue) {
        return C_SuuriRendouHrkhouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SuuriRendouHrkhouKbn pValue) {
        return pValue.getValue();
    }
}
