package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_CreditInfoTourokuGamenSyoriKbn;

/**
 * {@link C_CreditInfoTourokuGamenSyoriKbn クレジットカード情報登録画面処理区分} の Hibernate ユーザー定義型です。<br />
 * クレジットカード情報登録画面処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_CreditInfoTourokuGamenSyoriKbn extends AbstractUserType<C_CreditInfoTourokuGamenSyoriKbn> {

    @Override
    protected Class<C_CreditInfoTourokuGamenSyoriKbn> returnType() {
        return C_CreditInfoTourokuGamenSyoriKbn.class;
    }

    @Override
    protected C_CreditInfoTourokuGamenSyoriKbn valueOf(String pValue) {
        return C_CreditInfoTourokuGamenSyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_CreditInfoTourokuGamenSyoriKbn pValue) {
        return pValue.getValue();
    }
}
