package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TekiyouKbn;

/**
 * {@link C_TekiyouKbn 摘要区分} の Hibernate ユーザー定義型です。<br />
 * 摘要区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TekiyouKbn extends AbstractUserType<C_TekiyouKbn> {

    @Override
    protected Class<C_TekiyouKbn> returnType() {
        return C_TekiyouKbn.class;
    }

    @Override
    protected C_TekiyouKbn valueOf(String pValue) {
        return C_TekiyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TekiyouKbn pValue) {
        return pValue.getValue();
    }
}
