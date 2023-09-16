package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;

/**
 * {@link C_SystemRenkeiHenkanHoukouKbn システム間連携用変換方向区分} の Hibernate ユーザー定義型です。<br />
 * システム間連携用変換方向区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SystemRenkeiHenkanHoukouKbn extends AbstractUserType<C_SystemRenkeiHenkanHoukouKbn> {

    @Override
    protected Class<C_SystemRenkeiHenkanHoukouKbn> returnType() {
        return C_SystemRenkeiHenkanHoukouKbn.class;
    }

    @Override
    protected C_SystemRenkeiHenkanHoukouKbn valueOf(String pValue) {
        return C_SystemRenkeiHenkanHoukouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SystemRenkeiHenkanHoukouKbn pValue) {
        return pValue.getValue();
    }
}
