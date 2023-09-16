package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HuridenpageKbn;

/**
 * {@link C_HuridenpageKbn 振替伝票ページ区分} の Hibernate ユーザー定義型です。<br />
 * 振替伝票ページ区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HuridenpageKbn extends AbstractUserType<C_HuridenpageKbn> {

    @Override
    protected Class<C_HuridenpageKbn> returnType() {
        return C_HuridenpageKbn.class;
    }

    @Override
    protected C_HuridenpageKbn valueOf(String pValue) {
        return C_HuridenpageKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HuridenpageKbn pValue) {
        return pValue.getValue();
    }
}
