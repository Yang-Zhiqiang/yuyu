package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SounenfKykJyoutaiKbn;

/**
 * {@link C_SounenfKykJyoutaiKbn 総年Ｆ契約状態区分} の Hibernate ユーザー定義型です。<br />
 * 総年Ｆ契約状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SounenfKykJyoutaiKbn extends AbstractUserType<C_SounenfKykJyoutaiKbn> {

    @Override
    protected Class<C_SounenfKykJyoutaiKbn> returnType() {
        return C_SounenfKykJyoutaiKbn.class;
    }

    @Override
    protected C_SounenfKykJyoutaiKbn valueOf(String pValue) {
        return C_SounenfKykJyoutaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SounenfKykJyoutaiKbn pValue) {
        return pValue.getValue();
    }
}
