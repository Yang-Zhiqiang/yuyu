package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NenkinJimuTesuuryouKbn;

/**
 * {@link C_NenkinJimuTesuuryouKbn 年金事務手数料区分} の Hibernate ユーザー定義型です。<br />
 * 年金事務手数料区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NenkinJimuTesuuryouKbn extends AbstractUserType<C_NenkinJimuTesuuryouKbn> {

    @Override
    protected Class<C_NenkinJimuTesuuryouKbn> returnType() {
        return C_NenkinJimuTesuuryouKbn.class;
    }

    @Override
    protected C_NenkinJimuTesuuryouKbn valueOf(String pValue) {
        return C_NenkinJimuTesuuryouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NenkinJimuTesuuryouKbn pValue) {
        return pValue.getValue();
    }
}
