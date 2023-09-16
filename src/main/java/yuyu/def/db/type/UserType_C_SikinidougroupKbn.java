package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SikinidougroupKbn;

/**
 * {@link C_SikinidougroupKbn 資金移動グループ区分} の Hibernate ユーザー定義型です。<br />
 * 資金移動グループ区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SikinidougroupKbn extends AbstractUserType<C_SikinidougroupKbn> {

    @Override
    protected Class<C_SikinidougroupKbn> returnType() {
        return C_SikinidougroupKbn.class;
    }

    @Override
    protected C_SikinidougroupKbn valueOf(String pValue) {
        return C_SikinidougroupKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SikinidougroupKbn pValue) {
        return pValue.getValue();
    }
}
