package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HrkmiraiinsatuKbn;

/**
 * {@link C_HrkmiraiinsatuKbn 振込依頼書印刷対象区分} の Hibernate ユーザー定義型です。<br />
 * 振込依頼書印刷対象区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HrkmiraiinsatuKbn extends AbstractUserType<C_HrkmiraiinsatuKbn> {

    @Override
    protected Class<C_HrkmiraiinsatuKbn> returnType() {
        return C_HrkmiraiinsatuKbn.class;
    }

    @Override
    protected C_HrkmiraiinsatuKbn valueOf(String pValue) {
        return C_HrkmiraiinsatuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HrkmiraiinsatuKbn pValue) {
        return pValue.getValue();
    }
}
