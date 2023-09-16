package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_PplessrendoukouhurikousouKbn;

/**
 * {@link C_PplessrendoukouhurikousouKbn ペーパーレス連動時口振申込書後送区分} の Hibernate ユーザー定義型です。<br />
 * ペーパーレス連動時口振申込書後送区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_PplessrendoukouhurikousouKbn extends AbstractUserType<C_PplessrendoukouhurikousouKbn> {

    @Override
    protected Class<C_PplessrendoukouhurikousouKbn> returnType() {
        return C_PplessrendoukouhurikousouKbn.class;
    }

    @Override
    protected C_PplessrendoukouhurikousouKbn valueOf(String pValue) {
        return C_PplessrendoukouhurikousouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_PplessrendoukouhurikousouKbn pValue) {
        return pValue.getValue();
    }
}
