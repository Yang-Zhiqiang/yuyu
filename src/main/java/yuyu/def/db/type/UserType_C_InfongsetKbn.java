package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_InfongsetKbn;

/**
 * {@link C_InfongsetKbn 情報系日額設定区分} の Hibernate ユーザー定義型です。<br />
 * 情報系日額設定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_InfongsetKbn extends AbstractUserType<C_InfongsetKbn> {

    @Override
    protected Class<C_InfongsetKbn> returnType() {
        return C_InfongsetKbn.class;
    }

    @Override
    protected C_InfongsetKbn valueOf(String pValue) {
        return C_InfongsetKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_InfongsetKbn pValue) {
        return pValue.getValue();
    }
}
