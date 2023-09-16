package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HitmbosyuuKbn;

/**
 * {@link C_HitmbosyuuKbn 非対面募集区分} の Hibernate ユーザー定義型です。<br />
 * 非対面募集区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HitmbosyuuKbn extends AbstractUserType<C_HitmbosyuuKbn> {

    @Override
    protected Class<C_HitmbosyuuKbn> returnType() {
        return C_HitmbosyuuKbn.class;
    }

    @Override
    protected C_HitmbosyuuKbn valueOf(String pValue) {
        return C_HitmbosyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HitmbosyuuKbn pValue) {
        return pValue.getValue();
    }
}
