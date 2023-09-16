package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SpKeisanKahiKbn;

/**
 * {@link C_SpKeisanKahiKbn ＳＰ計算可否区分} の Hibernate ユーザー定義型です。<br />
 * ＳＰ計算可否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SpKeisanKahiKbn extends AbstractUserType<C_SpKeisanKahiKbn> {

    @Override
    protected Class<C_SpKeisanKahiKbn> returnType() {
        return C_SpKeisanKahiKbn.class;
    }

    @Override
    protected C_SpKeisanKahiKbn valueOf(String pValue) {
        return C_SpKeisanKahiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SpKeisanKahiKbn pValue) {
        return pValue.getValue();
    }
}
