package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TykdtkanoutksyuKbn;

/**
 * {@link C_TykdtkanoutksyuKbn 着脱可能特約種類区分} の Hibernate ユーザー定義型です。<br />
 * 着脱可能特約種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TykdtkanoutksyuKbn extends AbstractUserType<C_TykdtkanoutksyuKbn> {

    @Override
    protected Class<C_TykdtkanoutksyuKbn> returnType() {
        return C_TykdtkanoutksyuKbn.class;
    }

    @Override
    protected C_TykdtkanoutksyuKbn valueOf(String pValue) {
        return C_TykdtkanoutksyuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TykdtkanoutksyuKbn pValue) {
        return pValue.getValue();
    }
}
