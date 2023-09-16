package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_YokinKbn;

/**
 * {@link C_YokinKbn 預金種目区分} の Hibernate ユーザー定義型です。<br />
 * 預金種目区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_YokinKbn extends AbstractUserType<C_YokinKbn> {

    @Override
    protected Class<C_YokinKbn> returnType() {
        return C_YokinKbn.class;
    }

    @Override
    protected C_YokinKbn valueOf(String pValue) {
        return C_YokinKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_YokinKbn pValue) {
        return pValue.getValue();
    }
}
