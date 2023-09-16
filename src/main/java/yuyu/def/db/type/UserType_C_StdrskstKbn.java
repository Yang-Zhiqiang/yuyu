package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_StdrskstKbn;

/**
 * {@link C_StdrskstKbn 指定代理請求人指定区分} の Hibernate ユーザー定義型です。<br />
 * 指定代理請求人指定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_StdrskstKbn extends AbstractUserType<C_StdrskstKbn> {

    @Override
    protected Class<C_StdrskstKbn> returnType() {
        return C_StdrskstKbn.class;
    }

    @Override
    protected C_StdrskstKbn valueOf(String pValue) {
        return C_StdrskstKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_StdrskstKbn pValue) {
        return pValue.getValue();
    }
}
