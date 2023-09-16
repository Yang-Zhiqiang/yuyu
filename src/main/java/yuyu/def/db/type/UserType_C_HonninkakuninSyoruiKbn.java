package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HonninkakuninSyoruiKbn;

/**
 * {@link C_HonninkakuninSyoruiKbn 本人確認書類区分} の Hibernate ユーザー定義型です。<br />
 * 本人確認書類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HonninkakuninSyoruiKbn extends AbstractUserType<C_HonninkakuninSyoruiKbn> {

    @Override
    protected Class<C_HonninkakuninSyoruiKbn> returnType() {
        return C_HonninkakuninSyoruiKbn.class;
    }

    @Override
    protected C_HonninkakuninSyoruiKbn valueOf(String pValue) {
        return C_HonninkakuninSyoruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HonninkakuninSyoruiKbn pValue) {
        return pValue.getValue();
    }
}
