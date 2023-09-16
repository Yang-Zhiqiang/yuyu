package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SateikanKbn;

/**
 * {@link C_SateikanKbn 査定完了区分} の Hibernate ユーザー定義型です。<br />
 * 査定完了区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SateikanKbn extends AbstractUserType<C_SateikanKbn> {

    @Override
    protected Class<C_SateikanKbn> returnType() {
        return C_SateikanKbn.class;
    }

    @Override
    protected C_SateikanKbn valueOf(String pValue) {
        return C_SateikanKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SateikanKbn pValue) {
        return pValue.getValue();
    }
}
