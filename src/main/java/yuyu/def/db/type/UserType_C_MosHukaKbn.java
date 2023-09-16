package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MosHukaKbn;

/**
 * {@link C_MosHukaKbn 申込不可区分} の Hibernate ユーザー定義型です。<br />
 * 申込不可区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MosHukaKbn extends AbstractUserType<C_MosHukaKbn> {

    @Override
    protected Class<C_MosHukaKbn> returnType() {
        return C_MosHukaKbn.class;
    }

    @Override
    protected C_MosHukaKbn valueOf(String pValue) {
        return C_MosHukaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MosHukaKbn pValue) {
        return pValue.getValue();
    }
}
