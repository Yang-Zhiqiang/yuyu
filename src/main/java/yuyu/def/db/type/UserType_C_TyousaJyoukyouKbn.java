package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TyousaJyoukyouKbn;

/**
 * {@link C_TyousaJyoukyouKbn 調査状況区分} の Hibernate ユーザー定義型です。<br />
 * 調査状況区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TyousaJyoukyouKbn extends AbstractUserType<C_TyousaJyoukyouKbn> {

    @Override
    protected Class<C_TyousaJyoukyouKbn> returnType() {
        return C_TyousaJyoukyouKbn.class;
    }

    @Override
    protected C_TyousaJyoukyouKbn valueOf(String pValue) {
        return C_TyousaJyoukyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TyousaJyoukyouKbn pValue) {
        return pValue.getValue();
    }
}
