package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NenreiCalcKbn;

/**
 * {@link C_NenreiCalcKbn 年齢計算区分} の Hibernate ユーザー定義型です。<br />
 * 年齢計算区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NenreiCalcKbn extends AbstractUserType<C_NenreiCalcKbn> {

    @Override
    protected Class<C_NenreiCalcKbn> returnType() {
        return C_NenreiCalcKbn.class;
    }

    @Override
    protected C_NenreiCalcKbn valueOf(String pValue) {
        return C_NenreiCalcKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NenreiCalcKbn pValue) {
        return pValue.getValue();
    }
}
