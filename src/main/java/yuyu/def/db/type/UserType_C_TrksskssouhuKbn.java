package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TrksskssouhuKbn;

/**
 * {@link C_TrksskssouhuKbn 取消請求書送付区分} の Hibernate ユーザー定義型です。<br />
 * 取消請求書送付区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TrksskssouhuKbn extends AbstractUserType<C_TrksskssouhuKbn> {

    @Override
    protected Class<C_TrksskssouhuKbn> returnType() {
        return C_TrksskssouhuKbn.class;
    }

    @Override
    protected C_TrksskssouhuKbn valueOf(String pValue) {
        return C_TrksskssouhuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TrksskssouhuKbn pValue) {
        return pValue.getValue();
    }
}
