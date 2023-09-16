package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyoukenUktMidasiKbn;

/**
 * {@link C_SyoukenUktMidasiKbn 証券受取人見出し区分} の Hibernate ユーザー定義型です。<br />
 * 証券受取人見出し区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyoukenUktMidasiKbn extends AbstractUserType<C_SyoukenUktMidasiKbn> {

    @Override
    protected Class<C_SyoukenUktMidasiKbn> returnType() {
        return C_SyoukenUktMidasiKbn.class;
    }

    @Override
    protected C_SyoukenUktMidasiKbn valueOf(String pValue) {
        return C_SyoukenUktMidasiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyoukenUktMidasiKbn pValue) {
        return pValue.getValue();
    }
}
