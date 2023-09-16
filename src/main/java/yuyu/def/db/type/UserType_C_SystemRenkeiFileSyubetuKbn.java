package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SystemRenkeiFileSyubetuKbn;

/**
 * {@link C_SystemRenkeiFileSyubetuKbn システム間連携用ファイル種別区分} の Hibernate ユーザー定義型です。<br />
 * システム間連携用ファイル種別区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SystemRenkeiFileSyubetuKbn extends AbstractUserType<C_SystemRenkeiFileSyubetuKbn> {

    @Override
    protected Class<C_SystemRenkeiFileSyubetuKbn> returnType() {
        return C_SystemRenkeiFileSyubetuKbn.class;
    }

    @Override
    protected C_SystemRenkeiFileSyubetuKbn valueOf(String pValue) {
        return C_SystemRenkeiFileSyubetuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SystemRenkeiFileSyubetuKbn pValue) {
        return pValue.getValue();
    }
}
