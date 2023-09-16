package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Stydataumu;

/**
 * {@link C_Stydataumu 進捗データ有無区分} の Hibernate ユーザー定義型です。<br />
 * 進捗データ有無区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Stydataumu extends AbstractUserType<C_Stydataumu> {

    @Override
    protected Class<C_Stydataumu> returnType() {
        return C_Stydataumu.class;
    }

    @Override
    protected C_Stydataumu valueOf(String pValue) {
        return C_Stydataumu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Stydataumu pValue) {
        return pValue.getValue();
    }
}
