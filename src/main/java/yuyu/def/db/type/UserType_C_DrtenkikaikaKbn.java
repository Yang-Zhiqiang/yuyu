package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DrtenkikaikaKbn;

/**
 * {@link C_DrtenkikaikaKbn 代理店機械化区分} の Hibernate ユーザー定義型です。<br />
 * 代理店機械化区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DrtenkikaikaKbn extends AbstractUserType<C_DrtenkikaikaKbn> {

    @Override
    protected Class<C_DrtenkikaikaKbn> returnType() {
        return C_DrtenkikaikaKbn.class;
    }

    @Override
    protected C_DrtenkikaikaKbn valueOf(String pValue) {
        return C_DrtenkikaikaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DrtenkikaikaKbn pValue) {
        return pValue.getValue();
    }
}
