package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_GkdtKoktuutiUktKbn;

/**
 * {@link C_GkdtKoktuutiUktKbn 外貨建顧客通知受取人区分} の Hibernate ユーザー定義型です。<br />
 * 外貨建顧客通知受取人区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_GkdtKoktuutiUktKbn extends AbstractUserType<C_GkdtKoktuutiUktKbn> {

    @Override
    protected Class<C_GkdtKoktuutiUktKbn> returnType() {
        return C_GkdtKoktuutiUktKbn.class;
    }

    @Override
    protected C_GkdtKoktuutiUktKbn valueOf(String pValue) {
        return C_GkdtKoktuutiUktKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_GkdtKoktuutiUktKbn pValue) {
        return pValue.getValue();
    }
}
