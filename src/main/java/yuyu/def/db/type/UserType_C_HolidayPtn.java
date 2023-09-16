package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HolidayPtn;

/**
 * {@link C_HolidayPtn 休日パターン} の Hibernate ユーザー定義型です。<br />
 * 休日パターン 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HolidayPtn extends AbstractUserType<C_HolidayPtn> {

    @Override
    protected Class<C_HolidayPtn> returnType() {
        return C_HolidayPtn.class;
    }

    @Override
    protected C_HolidayPtn valueOf(String pValue) {
        return C_HolidayPtn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HolidayPtn pValue) {
        return pValue.getValue();
    }
}
