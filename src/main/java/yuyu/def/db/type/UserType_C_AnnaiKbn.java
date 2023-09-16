package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_AnnaiKbn;

/**
 * {@link C_AnnaiKbn 案内区分} の Hibernate ユーザー定義型です。<br />
 * 案内区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_AnnaiKbn extends AbstractUserType<C_AnnaiKbn> {

    @Override
    protected Class<C_AnnaiKbn> returnType() {
        return C_AnnaiKbn.class;
    }

    @Override
    protected C_AnnaiKbn valueOf(String pValue) {
        return C_AnnaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_AnnaiKbn pValue) {
        return pValue.getValue();
    }
}
