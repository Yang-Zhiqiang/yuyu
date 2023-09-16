package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DelhukaKbn;

/**
 * {@link C_DelhukaKbn 削除不可区分} の Hibernate ユーザー定義型です。<br />
 * 削除不可区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DelhukaKbn extends AbstractUserType<C_DelhukaKbn> {

    @Override
    protected Class<C_DelhukaKbn> returnType() {
        return C_DelhukaKbn.class;
    }

    @Override
    protected C_DelhukaKbn valueOf(String pValue) {
        return C_DelhukaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DelhukaKbn pValue) {
        return pValue.getValue();
    }
}
