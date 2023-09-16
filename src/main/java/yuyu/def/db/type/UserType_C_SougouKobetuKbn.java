package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SougouKobetuKbn;

/**
 * {@link C_SougouKobetuKbn 総合個別区分} の Hibernate ユーザー定義型です。<br />
 * 総合個別区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SougouKobetuKbn extends AbstractUserType<C_SougouKobetuKbn> {

    @Override
    protected Class<C_SougouKobetuKbn> returnType() {
        return C_SougouKobetuKbn.class;
    }

    @Override
    protected C_SougouKobetuKbn valueOf(String pValue) {
        return C_SougouKobetuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SougouKobetuKbn pValue) {
        return pValue.getValue();
    }
}
