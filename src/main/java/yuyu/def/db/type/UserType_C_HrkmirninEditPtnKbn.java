package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HrkmirninEditPtnKbn;

/**
 * {@link C_HrkmirninEditPtnKbn 振込依頼人編集パターン区分} の Hibernate ユーザー定義型です。<br />
 * 振込依頼人編集パターン区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HrkmirninEditPtnKbn extends AbstractUserType<C_HrkmirninEditPtnKbn> {

    @Override
    protected Class<C_HrkmirninEditPtnKbn> returnType() {
        return C_HrkmirninEditPtnKbn.class;
    }

    @Override
    protected C_HrkmirninEditPtnKbn valueOf(String pValue) {
        return C_HrkmirninEditPtnKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HrkmirninEditPtnKbn pValue) {
        return pValue.getValue();
    }
}
