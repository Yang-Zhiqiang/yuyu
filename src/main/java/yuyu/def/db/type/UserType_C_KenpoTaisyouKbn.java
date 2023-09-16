package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KenpoTaisyouKbn;

/**
 * {@link C_KenpoTaisyouKbn 健保対象区分} の Hibernate ユーザー定義型です。<br />
 * 健保対象区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KenpoTaisyouKbn extends AbstractUserType<C_KenpoTaisyouKbn> {

    @Override
    protected Class<C_KenpoTaisyouKbn> returnType() {
        return C_KenpoTaisyouKbn.class;
    }

    @Override
    protected C_KenpoTaisyouKbn valueOf(String pValue) {
        return C_KenpoTaisyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KenpoTaisyouKbn pValue) {
        return pValue.getValue();
    }
}
