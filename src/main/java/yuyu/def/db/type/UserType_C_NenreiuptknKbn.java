package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NenreiuptknKbn;

/**
 * {@link C_NenreiuptknKbn 年齢アップ特認区分} の Hibernate ユーザー定義型です。<br />
 * 年齢アップ特認区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NenreiuptknKbn extends AbstractUserType<C_NenreiuptknKbn> {

    @Override
    protected Class<C_NenreiuptknKbn> returnType() {
        return C_NenreiuptknKbn.class;
    }

    @Override
    protected C_NenreiuptknKbn valueOf(String pValue) {
        return C_NenreiuptknKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NenreiuptknKbn pValue) {
        return pValue.getValue();
    }
}
