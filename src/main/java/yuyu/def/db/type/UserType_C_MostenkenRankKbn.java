package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MostenkenRankKbn;

/**
 * {@link C_MostenkenRankKbn 申込点検ランク区分} の Hibernate ユーザー定義型です。<br />
 * 申込点検ランク区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MostenkenRankKbn extends AbstractUserType<C_MostenkenRankKbn> {

    @Override
    protected Class<C_MostenkenRankKbn> returnType() {
        return C_MostenkenRankKbn.class;
    }

    @Override
    protected C_MostenkenRankKbn valueOf(String pValue) {
        return C_MostenkenRankKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MostenkenRankKbn pValue) {
        return pValue.getValue();
    }
}
