package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KyhkshrbikinKbn;

/**
 * {@link C_KyhkshrbikinKbn 給付金支払備金区分} の Hibernate ユーザー定義型です。<br />
 * 給付金支払備金区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KyhkshrbikinKbn extends AbstractUserType<C_KyhkshrbikinKbn> {

    @Override
    protected Class<C_KyhkshrbikinKbn> returnType() {
        return C_KyhkshrbikinKbn.class;
    }

    @Override
    protected C_KyhkshrbikinKbn valueOf(String pValue) {
        return C_KyhkshrbikinKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KyhkshrbikinKbn pValue) {
        return pValue.getValue();
    }
}
