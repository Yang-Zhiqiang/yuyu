package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MosUketukeKbn;

/**
 * {@link C_MosUketukeKbn 申込受付区分} の Hibernate ユーザー定義型です。<br />
 * 申込受付区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MosUketukeKbn extends AbstractUserType<C_MosUketukeKbn> {

    @Override
    protected Class<C_MosUketukeKbn> returnType() {
        return C_MosUketukeKbn.class;
    }

    @Override
    protected C_MosUketukeKbn valueOf(String pValue) {
        return C_MosUketukeKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MosUketukeKbn pValue) {
        return pValue.getValue();
    }
}
