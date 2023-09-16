package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MostenkenyhKbn;

/**
 * {@link C_MostenkenyhKbn 申込点検要否区分} の Hibernate ユーザー定義型です。<br />
 * 申込点検要否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MostenkenyhKbn extends AbstractUserType<C_MostenkenyhKbn> {

    @Override
    protected Class<C_MostenkenyhKbn> returnType() {
        return C_MostenkenyhKbn.class;
    }

    @Override
    protected C_MostenkenyhKbn valueOf(String pValue) {
        return C_MostenkenyhKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MostenkenyhKbn pValue) {
        return pValue.getValue();
    }
}
