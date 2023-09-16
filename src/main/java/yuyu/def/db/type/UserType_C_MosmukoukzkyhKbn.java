package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MosmukoukzkyhKbn;

/**
 * {@link C_MosmukoukzkyhKbn 申出無効継続要否区分} の Hibernate ユーザー定義型です。<br />
 * 申出無効継続要否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MosmukoukzkyhKbn extends AbstractUserType<C_MosmukoukzkyhKbn> {

    @Override
    protected Class<C_MosmukoukzkyhKbn> returnType() {
        return C_MosmukoukzkyhKbn.class;
    }

    @Override
    protected C_MosmukoukzkyhKbn valueOf(String pValue) {
        return C_MosmukoukzkyhKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MosmukoukzkyhKbn pValue) {
        return pValue.getValue();
    }
}
