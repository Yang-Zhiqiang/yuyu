package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SinkihnkKbn;

/**
 * {@link C_SinkihnkKbn 新規変更区分} の Hibernate ユーザー定義型です。<br />
 * 新規変更区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SinkihnkKbn extends AbstractUserType<C_SinkihnkKbn> {

    @Override
    protected Class<C_SinkihnkKbn> returnType() {
        return C_SinkihnkKbn.class;
    }

    @Override
    protected C_SinkihnkKbn valueOf(String pValue) {
        return C_SinkihnkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SinkihnkKbn pValue) {
        return pValue.getValue();
    }
}
