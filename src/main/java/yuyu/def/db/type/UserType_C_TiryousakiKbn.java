package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TiryousakiKbn;

/**
 * {@link C_TiryousakiKbn 治療先区分} の Hibernate ユーザー定義型です。<br />
 * 治療先区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TiryousakiKbn extends AbstractUserType<C_TiryousakiKbn> {

    @Override
    protected Class<C_TiryousakiKbn> returnType() {
        return C_TiryousakiKbn.class;
    }

    @Override
    protected C_TiryousakiKbn valueOf(String pValue) {
        return C_TiryousakiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TiryousakiKbn pValue) {
        return pValue.getValue();
    }
}
