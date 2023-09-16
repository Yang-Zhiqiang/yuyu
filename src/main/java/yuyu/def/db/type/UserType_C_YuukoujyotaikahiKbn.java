package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_YuukoujyotaikahiKbn;

/**
 * {@link C_YuukoujyotaikahiKbn 有効状態処理可否区分} の Hibernate ユーザー定義型です。<br />
 * 有効状態処理可否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_YuukoujyotaikahiKbn extends AbstractUserType<C_YuukoujyotaikahiKbn> {

    @Override
    protected Class<C_YuukoujyotaikahiKbn> returnType() {
        return C_YuukoujyotaikahiKbn.class;
    }

    @Override
    protected C_YuukoujyotaikahiKbn valueOf(String pValue) {
        return C_YuukoujyotaikahiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_YuukoujyotaikahiKbn pValue) {
        return pValue.getValue();
    }
}
