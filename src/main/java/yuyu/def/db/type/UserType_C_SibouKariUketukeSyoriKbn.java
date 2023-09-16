package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SibouKariUketukeSyoriKbn;

/**
 * {@link C_SibouKariUketukeSyoriKbn 死亡仮受付処理区分} の Hibernate ユーザー定義型です。<br />
 * 死亡仮受付処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SibouKariUketukeSyoriKbn extends AbstractUserType<C_SibouKariUketukeSyoriKbn> {

    @Override
    protected Class<C_SibouKariUketukeSyoriKbn> returnType() {
        return C_SibouKariUketukeSyoriKbn.class;
    }

    @Override
    protected C_SibouKariUketukeSyoriKbn valueOf(String pValue) {
        return C_SibouKariUketukeSyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SibouKariUketukeSyoriKbn pValue) {
        return pValue.getValue();
    }
}
