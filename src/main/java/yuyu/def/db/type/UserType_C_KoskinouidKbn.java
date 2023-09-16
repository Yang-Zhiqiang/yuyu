package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KoskinouidKbn;

/**
 * {@link C_KoskinouidKbn 更新機能ＩＤ区分} の Hibernate ユーザー定義型です。<br />
 * 更新機能ＩＤ区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KoskinouidKbn extends AbstractUserType<C_KoskinouidKbn> {

    @Override
    protected Class<C_KoskinouidKbn> returnType() {
        return C_KoskinouidKbn.class;
    }

    @Override
    protected C_KoskinouidKbn valueOf(String pValue) {
        return C_KoskinouidKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KoskinouidKbn pValue) {
        return pValue.getValue();
    }
}
