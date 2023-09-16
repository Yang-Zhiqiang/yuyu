package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MosUktkErrKbn;

/**
 * {@link C_MosUktkErrKbn 申込受付エラー区分} の Hibernate ユーザー定義型です。<br />
 * 申込受付エラー区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MosUktkErrKbn extends AbstractUserType<C_MosUktkErrKbn> {

    @Override
    protected Class<C_MosUktkErrKbn> returnType() {
        return C_MosUktkErrKbn.class;
    }

    @Override
    protected C_MosUktkErrKbn valueOf(String pValue) {
        return C_MosUktkErrKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MosUktkErrKbn pValue) {
        return pValue.getValue();
    }
}
