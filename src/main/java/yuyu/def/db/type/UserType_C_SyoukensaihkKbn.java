package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyoukensaihkKbn;

/**
 * {@link C_SyoukensaihkKbn 証券再発行区分} の Hibernate ユーザー定義型です。<br />
 * 証券再発行区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyoukensaihkKbn extends AbstractUserType<C_SyoukensaihkKbn> {

    @Override
    protected Class<C_SyoukensaihkKbn> returnType() {
        return C_SyoukensaihkKbn.class;
    }

    @Override
    protected C_SyoukensaihkKbn valueOf(String pValue) {
        return C_SyoukensaihkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyoukensaihkKbn pValue) {
        return pValue.getValue();
    }
}
