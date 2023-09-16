package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DrtenkadoujkKbn;

/**
 * {@link C_DrtenkadoujkKbn 代理店稼働状況区分} の Hibernate ユーザー定義型です。<br />
 * 代理店稼働状況区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DrtenkadoujkKbn extends AbstractUserType<C_DrtenkadoujkKbn> {

    @Override
    protected Class<C_DrtenkadoujkKbn> returnType() {
        return C_DrtenkadoujkKbn.class;
    }

    @Override
    protected C_DrtenkadoujkKbn valueOf(String pValue) {
        return C_DrtenkadoujkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DrtenkadoujkKbn pValue) {
        return pValue.getValue();
    }
}
