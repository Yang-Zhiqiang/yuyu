package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TsryrnytaiKbn;

/**
 * {@link C_TsryrnytaiKbn 手数料戻入対象区分} の Hibernate ユーザー定義型です。<br />
 * 手数料戻入対象区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TsryrnytaiKbn extends AbstractUserType<C_TsryrnytaiKbn> {

    @Override
    protected Class<C_TsryrnytaiKbn> returnType() {
        return C_TsryrnytaiKbn.class;
    }

    @Override
    protected C_TsryrnytaiKbn valueOf(String pValue) {
        return C_TsryrnytaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TsryrnytaiKbn pValue) {
        return pValue.getValue();
    }
}
