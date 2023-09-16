package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SysnJyoujiKaigoGaitouKbn;

/**
 * {@link C_SysnJyoujiKaigoGaitouKbn 終身常時介護該当区分} の Hibernate ユーザー定義型です。<br />
 * 終身常時介護該当区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SysnJyoujiKaigoGaitouKbn extends AbstractUserType<C_SysnJyoujiKaigoGaitouKbn> {

    @Override
    protected Class<C_SysnJyoujiKaigoGaitouKbn> returnType() {
        return C_SysnJyoujiKaigoGaitouKbn.class;
    }

    @Override
    protected C_SysnJyoujiKaigoGaitouKbn valueOf(String pValue) {
        return C_SysnJyoujiKaigoGaitouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SysnJyoujiKaigoGaitouKbn pValue) {
        return pValue.getValue();
    }
}
