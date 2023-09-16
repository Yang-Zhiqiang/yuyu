package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HasseiRiyuuKbn;

/**
 * {@link C_HasseiRiyuuKbn 発生理由区分} の Hibernate ユーザー定義型です。<br />
 * 発生理由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HasseiRiyuuKbn extends AbstractUserType<C_HasseiRiyuuKbn> {

    @Override
    protected Class<C_HasseiRiyuuKbn> returnType() {
        return C_HasseiRiyuuKbn.class;
    }

    @Override
    protected C_HasseiRiyuuKbn valueOf(String pValue) {
        return C_HasseiRiyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HasseiRiyuuKbn pValue) {
        return pValue.getValue();
    }
}
