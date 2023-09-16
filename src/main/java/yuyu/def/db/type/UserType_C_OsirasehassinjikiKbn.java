package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_OsirasehassinjikiKbn;

/**
 * {@link C_OsirasehassinjikiKbn お知らせ発信時期区分} の Hibernate ユーザー定義型です。<br />
 * お知らせ発信時期区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_OsirasehassinjikiKbn extends AbstractUserType<C_OsirasehassinjikiKbn> {

    @Override
    protected Class<C_OsirasehassinjikiKbn> returnType() {
        return C_OsirasehassinjikiKbn.class;
    }

    @Override
    protected C_OsirasehassinjikiKbn valueOf(String pValue) {
        return C_OsirasehassinjikiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_OsirasehassinjikiKbn pValue) {
        return pValue.getValue();
    }
}
