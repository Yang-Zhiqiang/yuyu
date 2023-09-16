package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ShrtysySksTeisiFlg;

/**
 * {@link C_ShrtysySksTeisiFlg 支払調書作成停止フラグ} の Hibernate ユーザー定義型です。<br />
 * 支払調書作成停止フラグ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ShrtysySksTeisiFlg extends AbstractUserType<C_ShrtysySksTeisiFlg> {

    @Override
    protected Class<C_ShrtysySksTeisiFlg> returnType() {
        return C_ShrtysySksTeisiFlg.class;
    }

    @Override
    protected C_ShrtysySksTeisiFlg valueOf(String pValue) {
        return C_ShrtysySksTeisiFlg.valueOf(pValue);
    }

    @Override
    protected String toString(C_ShrtysySksTeisiFlg pValue) {
        return pValue.getValue();
    }
}
