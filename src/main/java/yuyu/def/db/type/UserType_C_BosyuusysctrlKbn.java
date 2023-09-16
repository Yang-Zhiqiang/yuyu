package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BosyuusysctrlKbn;

/**
 * {@link C_BosyuusysctrlKbn 募集システム制御区分} の Hibernate ユーザー定義型です。<br />
 * 募集システム制御区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BosyuusysctrlKbn extends AbstractUserType<C_BosyuusysctrlKbn> {

    @Override
    protected Class<C_BosyuusysctrlKbn> returnType() {
        return C_BosyuusysctrlKbn.class;
    }

    @Override
    protected C_BosyuusysctrlKbn valueOf(String pValue) {
        return C_BosyuusysctrlKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BosyuusysctrlKbn pValue) {
        return pValue.getValue();
    }
}
