package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SegbunruiKbn;

/**
 * {@link C_SegbunruiKbn セグメント分類区分} の Hibernate ユーザー定義型です。<br />
 * セグメント分類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SegbunruiKbn extends AbstractUserType<C_SegbunruiKbn> {

    @Override
    protected Class<C_SegbunruiKbn> returnType() {
        return C_SegbunruiKbn.class;
    }

    @Override
    protected C_SegbunruiKbn valueOf(String pValue) {
        return C_SegbunruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SegbunruiKbn pValue) {
        return pValue.getValue();
    }
}
