package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_YmdHenkanPtnKbn;

/**
 * {@link C_YmdHenkanPtnKbn 日付変換パターン区分} の Hibernate ユーザー定義型です。<br />
 * 日付変換パターン区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_YmdHenkanPtnKbn extends AbstractUserType<C_YmdHenkanPtnKbn> {

    @Override
    protected Class<C_YmdHenkanPtnKbn> returnType() {
        return C_YmdHenkanPtnKbn.class;
    }

    @Override
    protected C_YmdHenkanPtnKbn valueOf(String pValue) {
        return C_YmdHenkanPtnKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_YmdHenkanPtnKbn pValue) {
        return pValue.getValue();
    }
}
