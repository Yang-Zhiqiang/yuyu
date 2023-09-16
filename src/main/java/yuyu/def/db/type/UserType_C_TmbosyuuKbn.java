package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TmbosyuuKbn;

/**
 * {@link C_TmbosyuuKbn 対面募集区分} の Hibernate ユーザー定義型です。<br />
 * 対面募集区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TmbosyuuKbn extends AbstractUserType<C_TmbosyuuKbn> {

    @Override
    protected Class<C_TmbosyuuKbn> returnType() {
        return C_TmbosyuuKbn.class;
    }

    @Override
    protected C_TmbosyuuKbn valueOf(String pValue) {
        return C_TmbosyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TmbosyuuKbn pValue) {
        return pValue.getValue();
    }
}
