package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MosnoSaibanKbn;

/**
 * {@link C_MosnoSaibanKbn 申込番号採番区分} の Hibernate ユーザー定義型です。<br />
 * 申込番号採番区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MosnoSaibanKbn extends AbstractUserType<C_MosnoSaibanKbn> {

    @Override
    protected Class<C_MosnoSaibanKbn> returnType() {
        return C_MosnoSaibanKbn.class;
    }

    @Override
    protected C_MosnoSaibanKbn valueOf(String pValue) {
        return C_MosnoSaibanKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MosnoSaibanKbn pValue) {
        return pValue.getValue();
    }
}
