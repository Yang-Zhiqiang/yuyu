package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HokenbossysriyouKbn;

/**
 * {@link C_HokenbossysriyouKbn 保険募集システム利用区分} の Hibernate ユーザー定義型です。<br />
 * 保険募集システム利用区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HokenbossysriyouKbn extends AbstractUserType<C_HokenbossysriyouKbn> {

    @Override
    protected Class<C_HokenbossysriyouKbn> returnType() {
        return C_HokenbossysriyouKbn.class;
    }

    @Override
    protected C_HokenbossysriyouKbn valueOf(String pValue) {
        return C_HokenbossysriyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HokenbossysriyouKbn pValue) {
        return pValue.getValue();
    }
}
