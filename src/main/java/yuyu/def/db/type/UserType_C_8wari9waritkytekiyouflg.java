package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_8wari9waritkytekiyouflg;

/**
 * {@link C_8wari9waritkytekiyouflg ８割９割保証特約適用フラグ} の Hibernate ユーザー定義型です。<br />
 * ８割９割保証特約適用フラグ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_8wari9waritkytekiyouflg extends AbstractUserType<C_8wari9waritkytekiyouflg> {

    @Override
    protected Class<C_8wari9waritkytekiyouflg> returnType() {
        return C_8wari9waritkytekiyouflg.class;
    }

    @Override
    protected C_8wari9waritkytekiyouflg valueOf(String pValue) {
        return C_8wari9waritkytekiyouflg.valueOf(pValue);
    }

    @Override
    protected String toString(C_8wari9waritkytekiyouflg pValue) {
        return pValue.getValue();
    }
}
