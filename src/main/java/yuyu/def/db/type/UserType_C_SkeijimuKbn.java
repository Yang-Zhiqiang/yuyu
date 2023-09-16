package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SkeijimuKbn;

/**
 * {@link C_SkeijimuKbn 新契約事務区分} の Hibernate ユーザー定義型です。<br />
 * 新契約事務区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SkeijimuKbn extends AbstractUserType<C_SkeijimuKbn> {

    @Override
    protected Class<C_SkeijimuKbn> returnType() {
        return C_SkeijimuKbn.class;
    }

    @Override
    protected C_SkeijimuKbn valueOf(String pValue) {
        return C_SkeijimuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SkeijimuKbn pValue) {
        return pValue.getValue();
    }
}
