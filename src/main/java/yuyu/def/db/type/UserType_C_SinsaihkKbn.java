package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SinsaihkKbn;

/**
 * {@link C_SinsaihkKbn 新規再発行区分} の Hibernate ユーザー定義型です。<br />
 * 新規再発行区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SinsaihkKbn extends AbstractUserType<C_SinsaihkKbn> {

    @Override
    protected Class<C_SinsaihkKbn> returnType() {
        return C_SinsaihkKbn.class;
    }

    @Override
    protected C_SinsaihkKbn valueOf(String pValue) {
        return C_SinsaihkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SinsaihkKbn pValue) {
        return pValue.getValue();
    }
}
