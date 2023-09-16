package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HusyoudakuTuutiSouhusakiKbn;

/**
 * {@link C_HusyoudakuTuutiSouhusakiKbn 不承諾通知送付先区分} の Hibernate ユーザー定義型です。<br />
 * 不承諾通知送付先区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HusyoudakuTuutiSouhusakiKbn extends AbstractUserType<C_HusyoudakuTuutiSouhusakiKbn> {

    @Override
    protected Class<C_HusyoudakuTuutiSouhusakiKbn> returnType() {
        return C_HusyoudakuTuutiSouhusakiKbn.class;
    }

    @Override
    protected C_HusyoudakuTuutiSouhusakiKbn valueOf(String pValue) {
        return C_HusyoudakuTuutiSouhusakiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HusyoudakuTuutiSouhusakiKbn pValue) {
        return pValue.getValue();
    }
}
