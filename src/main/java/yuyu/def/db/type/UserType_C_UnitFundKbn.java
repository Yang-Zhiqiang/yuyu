package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_UnitFundKbn;

/**
 * {@link C_UnitFundKbn ユニットファンド区分} の Hibernate ユーザー定義型です。<br />
 * ユニットファンド区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_UnitFundKbn extends AbstractUserType<C_UnitFundKbn> {

    @Override
    protected Class<C_UnitFundKbn> returnType() {
        return C_UnitFundKbn.class;
    }

    @Override
    protected C_UnitFundKbn valueOf(String pValue) {
        return C_UnitFundKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_UnitFundKbn pValue) {
        return pValue.getValue();
    }
}
