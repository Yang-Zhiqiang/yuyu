package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ShrSkJyoukyouGtymd;

/**
 * {@link C_ShrSkJyoukyouGtymd 支払請求状況該当日} の Hibernate ユーザー定義型です。<br />
 * 支払請求状況該当日 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ShrSkJyoukyouGtymd extends AbstractUserType<C_ShrSkJyoukyouGtymd> {

    @Override
    protected Class<C_ShrSkJyoukyouGtymd> returnType() {
        return C_ShrSkJyoukyouGtymd.class;
    }

    @Override
    protected C_ShrSkJyoukyouGtymd valueOf(String pValue) {
        return C_ShrSkJyoukyouGtymd.valueOf(pValue);
    }

    @Override
    protected String toString(C_ShrSkJyoukyouGtymd pValue) {
        return pValue.getValue();
    }
}
