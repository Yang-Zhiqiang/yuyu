package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SuuriSoukouKbn;

/**
 * {@link C_SuuriSoukouKbn 数理走行区分} の Hibernate ユーザー定義型です。<br />
 * 数理走行区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SuuriSoukouKbn extends AbstractUserType<C_SuuriSoukouKbn> {

    @Override
    protected Class<C_SuuriSoukouKbn> returnType() {
        return C_SuuriSoukouKbn.class;
    }

    @Override
    protected C_SuuriSoukouKbn valueOf(String pValue) {
        return C_SuuriSoukouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SuuriSoukouKbn pValue) {
        return pValue.getValue();
    }
}
