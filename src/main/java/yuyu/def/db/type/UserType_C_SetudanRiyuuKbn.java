package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SetudanRiyuuKbn;

/**
 * {@link C_SetudanRiyuuKbn 切断理由区分} の Hibernate ユーザー定義型です。<br />
 * 切断理由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SetudanRiyuuKbn extends AbstractUserType<C_SetudanRiyuuKbn> {

    @Override
    protected Class<C_SetudanRiyuuKbn> returnType() {
        return C_SetudanRiyuuKbn.class;
    }

    @Override
    protected C_SetudanRiyuuKbn valueOf(String pValue) {
        return C_SetudanRiyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SetudanRiyuuKbn pValue) {
        return pValue.getValue();
    }
}
