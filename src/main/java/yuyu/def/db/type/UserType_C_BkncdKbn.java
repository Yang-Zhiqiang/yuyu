package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BkncdKbn;

/**
 * {@link C_BkncdKbn 備金コード区分} の Hibernate ユーザー定義型です。<br />
 * 備金コード区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BkncdKbn extends AbstractUserType<C_BkncdKbn> {

    @Override
    protected Class<C_BkncdKbn> returnType() {
        return C_BkncdKbn.class;
    }

    @Override
    protected C_BkncdKbn valueOf(String pValue) {
        return C_BkncdKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BkncdKbn pValue) {
        return pValue.getValue();
    }
}
