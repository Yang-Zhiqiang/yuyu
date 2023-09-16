package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ZfiIdoujiyuuKbn;

/**
 * {@link C_ZfiIdoujiyuuKbn （資産運用）異動事由区分} の Hibernate ユーザー定義型です。<br />
 * （資産運用）異動事由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ZfiIdoujiyuuKbn extends AbstractUserType<C_ZfiIdoujiyuuKbn> {

    @Override
    protected Class<C_ZfiIdoujiyuuKbn> returnType() {
        return C_ZfiIdoujiyuuKbn.class;
    }

    @Override
    protected C_ZfiIdoujiyuuKbn valueOf(String pValue) {
        return C_ZfiIdoujiyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ZfiIdoujiyuuKbn pValue) {
        return pValue.getValue();
    }
}
