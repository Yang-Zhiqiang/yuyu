package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HuridensksKbn;

/**
 * {@link C_HuridensksKbn 振替伝票作成区分} の Hibernate ユーザー定義型です。<br />
 * 振替伝票作成区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HuridensksKbn extends AbstractUserType<C_HuridensksKbn> {

    @Override
    protected Class<C_HuridensksKbn> returnType() {
        return C_HuridensksKbn.class;
    }

    @Override
    protected C_HuridensksKbn valueOf(String pValue) {
        return C_HuridensksKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HuridensksKbn pValue) {
        return pValue.getValue();
    }
}
