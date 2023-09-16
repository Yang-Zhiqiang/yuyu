package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MsymkeipksnKbn;

/**
 * {@link C_MsymkeipksnKbn 未収未経過計算区分} の Hibernate ユーザー定義型です。<br />
 * 未収未経過計算区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MsymkeipksnKbn extends AbstractUserType<C_MsymkeipksnKbn> {

    @Override
    protected Class<C_MsymkeipksnKbn> returnType() {
        return C_MsymkeipksnKbn.class;
    }

    @Override
    protected C_MsymkeipksnKbn valueOf(String pValue) {
        return C_MsymkeipksnKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MsymkeipksnKbn pValue) {
        return pValue.getValue();
    }
}
