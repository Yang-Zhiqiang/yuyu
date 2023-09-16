package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TanmatuSiyouKbn;

/**
 * {@link C_TanmatuSiyouKbn 端末使用区分} の Hibernate ユーザー定義型です。<br />
 * 端末使用区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TanmatuSiyouKbn extends AbstractUserType<C_TanmatuSiyouKbn> {

    @Override
    protected Class<C_TanmatuSiyouKbn> returnType() {
        return C_TanmatuSiyouKbn.class;
    }

    @Override
    protected C_TanmatuSiyouKbn valueOf(String pValue) {
        return C_TanmatuSiyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TanmatuSiyouKbn pValue) {
        return pValue.getValue();
    }
}
