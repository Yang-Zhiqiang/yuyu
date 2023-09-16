package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KaiyksyorikahiKbn;

/**
 * {@link C_KaiyksyorikahiKbn 解約処理可否区分} の Hibernate ユーザー定義型です。<br />
 * 解約処理可否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KaiyksyorikahiKbn extends AbstractUserType<C_KaiyksyorikahiKbn> {

    @Override
    protected Class<C_KaiyksyorikahiKbn> returnType() {
        return C_KaiyksyorikahiKbn.class;
    }

    @Override
    protected C_KaiyksyorikahiKbn valueOf(String pValue) {
        return C_KaiyksyorikahiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KaiyksyorikahiKbn pValue) {
        return pValue.getValue();
    }
}
