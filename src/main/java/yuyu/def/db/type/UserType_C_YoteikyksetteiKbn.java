package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_YoteikyksetteiKbn;

/**
 * {@link C_YoteikyksetteiKbn 予定契約日設定方法区分} の Hibernate ユーザー定義型です。<br />
 * 予定契約日設定方法区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_YoteikyksetteiKbn extends AbstractUserType<C_YoteikyksetteiKbn> {

    @Override
    protected Class<C_YoteikyksetteiKbn> returnType() {
        return C_YoteikyksetteiKbn.class;
    }

    @Override
    protected C_YoteikyksetteiKbn valueOf(String pValue) {
        return C_YoteikyksetteiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_YoteikyksetteiKbn pValue) {
        return pValue.getValue();
    }
}
