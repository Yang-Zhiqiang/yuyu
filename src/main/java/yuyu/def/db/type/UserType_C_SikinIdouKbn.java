package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SikinIdouKbn;

/**
 * {@link C_SikinIdouKbn 資金移動区分} の Hibernate ユーザー定義型です。<br />
 * 資金移動区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SikinIdouKbn extends AbstractUserType<C_SikinIdouKbn> {

    @Override
    protected Class<C_SikinIdouKbn> returnType() {
        return C_SikinIdouKbn.class;
    }

    @Override
    protected C_SikinIdouKbn valueOf(String pValue) {
        return C_SikinIdouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SikinIdouKbn pValue) {
        return pValue.getValue();
    }
}
