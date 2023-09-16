package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MdhncifcdknrKbn;

/**
 * {@link C_MdhncifcdknrKbn 窓販ＣＩＦコード管理区分} の Hibernate ユーザー定義型です。<br />
 * 窓販ＣＩＦコード管理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MdhncifcdknrKbn extends AbstractUserType<C_MdhncifcdknrKbn> {

    @Override
    protected Class<C_MdhncifcdknrKbn> returnType() {
        return C_MdhncifcdknrKbn.class;
    }

    @Override
    protected C_MdhncifcdknrKbn valueOf(String pValue) {
        return C_MdhncifcdknrKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MdhncifcdknrKbn pValue) {
        return pValue.getValue();
    }
}
