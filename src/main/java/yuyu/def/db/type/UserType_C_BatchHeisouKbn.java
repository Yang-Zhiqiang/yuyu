package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BatchHeisouKbn;

/**
 * {@link C_BatchHeisouKbn バッチ並走区分} の Hibernate ユーザー定義型です。<br />
 * バッチ並走区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BatchHeisouKbn extends AbstractUserType<C_BatchHeisouKbn> {

    @Override
    protected Class<C_BatchHeisouKbn> returnType() {
        return C_BatchHeisouKbn.class;
    }

    @Override
    protected C_BatchHeisouKbn valueOf(String pValue) {
        return C_BatchHeisouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BatchHeisouKbn pValue) {
        return pValue.getValue();
    }
}
