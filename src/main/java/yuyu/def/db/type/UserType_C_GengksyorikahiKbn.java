package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_GengksyorikahiKbn;

/**
 * {@link C_GengksyorikahiKbn 減額処理可否区分} の Hibernate ユーザー定義型です。<br />
 * 減額処理可否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_GengksyorikahiKbn extends AbstractUserType<C_GengksyorikahiKbn> {

    @Override
    protected Class<C_GengksyorikahiKbn> returnType() {
        return C_GengksyorikahiKbn.class;
    }

    @Override
    protected C_GengksyorikahiKbn valueOf(String pValue) {
        return C_GengksyorikahiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_GengksyorikahiKbn pValue) {
        return pValue.getValue();
    }
}
