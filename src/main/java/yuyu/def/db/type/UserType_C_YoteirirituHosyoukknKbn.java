package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_YoteirirituHosyoukknKbn;

/**
 * {@link C_YoteirirituHosyoukknKbn 予定利率保証期間区分} の Hibernate ユーザー定義型です。<br />
 * 予定利率保証期間区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_YoteirirituHosyoukknKbn extends AbstractUserType<C_YoteirirituHosyoukknKbn> {

    @Override
    protected Class<C_YoteirirituHosyoukknKbn> returnType() {
        return C_YoteirirituHosyoukknKbn.class;
    }

    @Override
    protected C_YoteirirituHosyoukknKbn valueOf(String pValue) {
        return C_YoteirirituHosyoukknKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_YoteirirituHosyoukknKbn pValue) {
        return pValue.getValue();
    }
}
