package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_LegalHolidayKbn;

/**
 * {@link C_LegalHolidayKbn 法定休日区分} の Hibernate ユーザー定義型です。<br />
 * 法定休日区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_LegalHolidayKbn extends AbstractUserType<C_LegalHolidayKbn> {

    @Override
    protected Class<C_LegalHolidayKbn> returnType() {
        return C_LegalHolidayKbn.class;
    }

    @Override
    protected C_LegalHolidayKbn valueOf(String pValue) {
        return C_LegalHolidayKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_LegalHolidayKbn pValue) {
        return pValue.getValue();
    }
}
