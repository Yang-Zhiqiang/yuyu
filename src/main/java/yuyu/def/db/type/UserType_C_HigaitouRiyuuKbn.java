package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HigaitouRiyuuKbn;

/**
 * {@link C_HigaitouRiyuuKbn 非該当理由区分} の Hibernate ユーザー定義型です。<br />
 * 非該当理由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HigaitouRiyuuKbn extends AbstractUserType<C_HigaitouRiyuuKbn> {

    @Override
    protected Class<C_HigaitouRiyuuKbn> returnType() {
        return C_HigaitouRiyuuKbn.class;
    }

    @Override
    protected C_HigaitouRiyuuKbn valueOf(String pValue) {
        return C_HigaitouRiyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HigaitouRiyuuKbn pValue) {
        return pValue.getValue();
    }
}
