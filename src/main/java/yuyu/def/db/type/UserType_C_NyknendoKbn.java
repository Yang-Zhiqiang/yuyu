package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NyknendoKbn;

/**
 * {@link C_NyknendoKbn 入金年度区分} の Hibernate ユーザー定義型です。<br />
 * 入金年度区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NyknendoKbn extends AbstractUserType<C_NyknendoKbn> {

    @Override
    protected Class<C_NyknendoKbn> returnType() {
        return C_NyknendoKbn.class;
    }

    @Override
    protected C_NyknendoKbn valueOf(String pValue) {
        return C_NyknendoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NyknendoKbn pValue) {
        return pValue.getValue();
    }
}
