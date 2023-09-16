package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HubiJyoukyouKbn;

/**
 * {@link C_HubiJyoukyouKbn 不備状況区分} の Hibernate ユーザー定義型です。<br />
 * 不備状況区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HubiJyoukyouKbn extends AbstractUserType<C_HubiJyoukyouKbn> {

    @Override
    protected Class<C_HubiJyoukyouKbn> returnType() {
        return C_HubiJyoukyouKbn.class;
    }

    @Override
    protected C_HubiJyoukyouKbn valueOf(String pValue) {
        return C_HubiJyoukyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HubiJyoukyouKbn pValue) {
        return pValue.getValue();
    }
}
