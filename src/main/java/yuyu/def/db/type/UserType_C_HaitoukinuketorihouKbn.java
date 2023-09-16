package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;

/**
 * {@link C_HaitoukinuketorihouKbn 配当金受取方法区分} の Hibernate ユーザー定義型です。<br />
 * 配当金受取方法区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HaitoukinuketorihouKbn extends AbstractUserType<C_HaitoukinuketorihouKbn> {

    @Override
    protected Class<C_HaitoukinuketorihouKbn> returnType() {
        return C_HaitoukinuketorihouKbn.class;
    }

    @Override
    protected C_HaitoukinuketorihouKbn valueOf(String pValue) {
        return C_HaitoukinuketorihouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HaitoukinuketorihouKbn pValue) {
        return pValue.getValue();
    }
}
