package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TekikakutkykKbn;

/**
 * {@link C_TekikakutkykKbn 適格特約} の Hibernate ユーザー定義型です。<br />
 * 適格特約 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TekikakutkykKbn extends AbstractUserType<C_TekikakutkykKbn> {

    @Override
    protected Class<C_TekikakutkykKbn> returnType() {
        return C_TekikakutkykKbn.class;
    }

    @Override
    protected C_TekikakutkykKbn valueOf(String pValue) {
        return C_TekikakutkykKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TekikakutkykKbn pValue) {
        return pValue.getValue();
    }
}
