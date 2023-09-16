package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NyknaiyouKbn;

/**
 * {@link C_NyknaiyouKbn 入金内容区分} の Hibernate ユーザー定義型です。<br />
 * 入金内容区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NyknaiyouKbn extends AbstractUserType<C_NyknaiyouKbn> {

    @Override
    protected Class<C_NyknaiyouKbn> returnType() {
        return C_NyknaiyouKbn.class;
    }

    @Override
    protected C_NyknaiyouKbn valueOf(String pValue) {
        return C_NyknaiyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NyknaiyouKbn pValue) {
        return pValue.getValue();
    }
}
