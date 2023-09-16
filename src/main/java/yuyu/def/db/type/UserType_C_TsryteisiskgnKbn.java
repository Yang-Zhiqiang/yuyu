package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TsryteisiskgnKbn;

/**
 * {@link C_TsryteisiskgnKbn 手数料停止削減区分} の Hibernate ユーザー定義型です。<br />
 * 手数料停止削減区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TsryteisiskgnKbn extends AbstractUserType<C_TsryteisiskgnKbn> {

    @Override
    protected Class<C_TsryteisiskgnKbn> returnType() {
        return C_TsryteisiskgnKbn.class;
    }

    @Override
    protected C_TsryteisiskgnKbn valueOf(String pValue) {
        return C_TsryteisiskgnKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TsryteisiskgnKbn pValue) {
        return pValue.getValue();
    }
}
