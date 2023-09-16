package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BnktAnnaiHouhouKbn;

/**
 * {@link C_BnktAnnaiHouhouKbn 分割案内方法区分} の Hibernate ユーザー定義型です。<br />
 * 分割案内方法区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BnktAnnaiHouhouKbn extends AbstractUserType<C_BnktAnnaiHouhouKbn> {

    @Override
    protected Class<C_BnktAnnaiHouhouKbn> returnType() {
        return C_BnktAnnaiHouhouKbn.class;
    }

    @Override
    protected C_BnktAnnaiHouhouKbn valueOf(String pValue) {
        return C_BnktAnnaiHouhouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BnktAnnaiHouhouKbn pValue) {
        return pValue.getValue();
    }
}
