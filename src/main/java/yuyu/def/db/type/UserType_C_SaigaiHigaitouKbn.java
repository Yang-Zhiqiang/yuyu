package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SaigaiHigaitouKbn;

/**
 * {@link C_SaigaiHigaitouKbn 災害非該当区分} の Hibernate ユーザー定義型です。<br />
 * 災害非該当区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SaigaiHigaitouKbn extends AbstractUserType<C_SaigaiHigaitouKbn> {

    @Override
    protected Class<C_SaigaiHigaitouKbn> returnType() {
        return C_SaigaiHigaitouKbn.class;
    }

    @Override
    protected C_SaigaiHigaitouKbn valueOf(String pValue) {
        return C_SaigaiHigaitouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SaigaiHigaitouKbn pValue) {
        return pValue.getValue();
    }
}
