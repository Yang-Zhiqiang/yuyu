package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MosKbn;

/**
 * {@link C_MosKbn 申込区分} の Hibernate ユーザー定義型です。<br />
 * 申込区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MosKbn extends AbstractUserType<C_MosKbn> {

    @Override
    protected Class<C_MosKbn> returnType() {
        return C_MosKbn.class;
    }

    @Override
    protected C_MosKbn valueOf(String pValue) {
        return C_MosKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MosKbn pValue) {
        return pValue.getValue();
    }
}
