package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DsMailSousinJyoutaiKbn;

/**
 * {@link C_DsMailSousinJyoutaiKbn ＤＳメール送信状態区分} の Hibernate ユーザー定義型です。<br />
 * ＤＳメール送信状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DsMailSousinJyoutaiKbn extends AbstractUserType<C_DsMailSousinJyoutaiKbn> {

    @Override
    protected Class<C_DsMailSousinJyoutaiKbn> returnType() {
        return C_DsMailSousinJyoutaiKbn.class;
    }

    @Override
    protected C_DsMailSousinJyoutaiKbn valueOf(String pValue) {
        return C_DsMailSousinJyoutaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DsMailSousinJyoutaiKbn pValue) {
        return pValue.getValue();
    }
}
