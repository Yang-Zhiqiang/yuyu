package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TourokustatusKbn;

/**
 * {@link C_TourokustatusKbn 登録ステータス区分} の Hibernate ユーザー定義型です。<br />
 * 登録ステータス区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TourokustatusKbn extends AbstractUserType<C_TourokustatusKbn> {

    @Override
    protected Class<C_TourokustatusKbn> returnType() {
        return C_TourokustatusKbn.class;
    }

    @Override
    protected C_TourokustatusKbn valueOf(String pValue) {
        return C_TourokustatusKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TourokustatusKbn pValue) {
        return pValue.getValue();
    }
}
