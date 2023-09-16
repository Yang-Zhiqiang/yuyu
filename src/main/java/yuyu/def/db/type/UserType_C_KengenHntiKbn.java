package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KengenHntiKbn;

/**
 * {@link C_KengenHntiKbn 権限判定区分} の Hibernate ユーザー定義型です。<br />
 * 権限判定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KengenHntiKbn extends AbstractUserType<C_KengenHntiKbn> {

    @Override
    protected Class<C_KengenHntiKbn> returnType() {
        return C_KengenHntiKbn.class;
    }

    @Override
    protected C_KengenHntiKbn valueOf(String pValue) {
        return C_KengenHntiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KengenHntiKbn pValue) {
        return pValue.getValue();
    }
}
