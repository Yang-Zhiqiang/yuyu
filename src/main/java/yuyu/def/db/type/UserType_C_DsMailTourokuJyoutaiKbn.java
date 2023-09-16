package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DsMailTourokuJyoutaiKbn;

/**
 * {@link C_DsMailTourokuJyoutaiKbn ＤＳメール登録状態区分} の Hibernate ユーザー定義型です。<br />
 * ＤＳメール登録状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DsMailTourokuJyoutaiKbn extends AbstractUserType<C_DsMailTourokuJyoutaiKbn> {

    @Override
    protected Class<C_DsMailTourokuJyoutaiKbn> returnType() {
        return C_DsMailTourokuJyoutaiKbn.class;
    }

    @Override
    protected C_DsMailTourokuJyoutaiKbn valueOf(String pValue) {
        return C_DsMailTourokuJyoutaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DsMailTourokuJyoutaiKbn pValue) {
        return pValue.getValue();
    }
}
