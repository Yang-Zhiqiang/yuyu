package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SetudanKasyoKbn;

/**
 * {@link C_SetudanKasyoKbn 切断箇所区分} の Hibernate ユーザー定義型です。<br />
 * 切断箇所区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SetudanKasyoKbn extends AbstractUserType<C_SetudanKasyoKbn> {

    @Override
    protected Class<C_SetudanKasyoKbn> returnType() {
        return C_SetudanKasyoKbn.class;
    }

    @Override
    protected C_SetudanKasyoKbn valueOf(String pValue) {
        return C_SetudanKasyoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SetudanKasyoKbn pValue) {
        return pValue.getValue();
    }
}
