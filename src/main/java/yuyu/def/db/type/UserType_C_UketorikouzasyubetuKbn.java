package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_UketorikouzasyubetuKbn;

/**
 * {@link C_UketorikouzasyubetuKbn 受取口座種別区分} の Hibernate ユーザー定義型です。<br />
 * 受取口座種別区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_UketorikouzasyubetuKbn extends AbstractUserType<C_UketorikouzasyubetuKbn> {

    @Override
    protected Class<C_UketorikouzasyubetuKbn> returnType() {
        return C_UketorikouzasyubetuKbn.class;
    }

    @Override
    protected C_UketorikouzasyubetuKbn valueOf(String pValue) {
        return C_UketorikouzasyubetuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_UketorikouzasyubetuKbn pValue) {
        return pValue.getValue();
    }
}
