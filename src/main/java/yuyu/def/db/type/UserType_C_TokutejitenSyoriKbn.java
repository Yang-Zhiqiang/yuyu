package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TokutejitenSyoriKbn;

/**
 * {@link C_TokutejitenSyoriKbn 特定時点判定処理区分} の Hibernate ユーザー定義型です。<br />
 * 特定時点判定処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TokutejitenSyoriKbn extends AbstractUserType<C_TokutejitenSyoriKbn> {

    @Override
    protected Class<C_TokutejitenSyoriKbn> returnType() {
        return C_TokutejitenSyoriKbn.class;
    }

    @Override
    protected C_TokutejitenSyoriKbn valueOf(String pValue) {
        return C_TokutejitenSyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TokutejitenSyoriKbn pValue) {
        return pValue.getValue();
    }
}
