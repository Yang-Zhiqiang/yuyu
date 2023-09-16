package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HenkinriyuuKbn;

/**
 * {@link C_HenkinriyuuKbn 返金理由区分} の Hibernate ユーザー定義型です。<br />
 * 返金理由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HenkinriyuuKbn extends AbstractUserType<C_HenkinriyuuKbn> {

    @Override
    protected Class<C_HenkinriyuuKbn> returnType() {
        return C_HenkinriyuuKbn.class;
    }

    @Override
    protected C_HenkinriyuuKbn valueOf(String pValue) {
        return C_HenkinriyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HenkinriyuuKbn pValue) {
        return pValue.getValue();
    }
}
