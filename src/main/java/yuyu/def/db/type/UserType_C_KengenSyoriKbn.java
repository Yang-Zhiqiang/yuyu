package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KengenSyoriKbn;

/**
 * {@link C_KengenSyoriKbn 権限用処理区分} の Hibernate ユーザー定義型です。<br />
 * 権限用処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KengenSyoriKbn extends AbstractUserType<C_KengenSyoriKbn> {

    @Override
    protected Class<C_KengenSyoriKbn> returnType() {
        return C_KengenSyoriKbn.class;
    }

    @Override
    protected C_KengenSyoriKbn valueOf(String pValue) {
        return C_KengenSyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KengenSyoriKbn pValue) {
        return pValue.getValue();
    }
}
