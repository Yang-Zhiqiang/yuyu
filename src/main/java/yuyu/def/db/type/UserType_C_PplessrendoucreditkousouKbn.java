package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_PplessrendoucreditkousouKbn;

/**
 * {@link C_PplessrendoucreditkousouKbn ペーパーレス連動時クレカ申込書後送区分} の Hibernate ユーザー定義型です。<br />
 * ペーパーレス連動時クレカ申込書後送区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_PplessrendoucreditkousouKbn extends AbstractUserType<C_PplessrendoucreditkousouKbn> {

    @Override
    protected Class<C_PplessrendoucreditkousouKbn> returnType() {
        return C_PplessrendoucreditkousouKbn.class;
    }

    @Override
    protected C_PplessrendoucreditkousouKbn valueOf(String pValue) {
        return C_PplessrendoucreditkousouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_PplessrendoucreditkousouKbn pValue) {
        return pValue.getValue();
    }
}
