package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ZeimuNaiyouHnsyuCtrlKbn;

/**
 * {@link C_ZeimuNaiyouHnsyuCtrlKbn 税務内容編集制御区分} の Hibernate ユーザー定義型です。<br />
 * 税務内容編集制御区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ZeimuNaiyouHnsyuCtrlKbn extends AbstractUserType<C_ZeimuNaiyouHnsyuCtrlKbn> {

    @Override
    protected Class<C_ZeimuNaiyouHnsyuCtrlKbn> returnType() {
        return C_ZeimuNaiyouHnsyuCtrlKbn.class;
    }

    @Override
    protected C_ZeimuNaiyouHnsyuCtrlKbn valueOf(String pValue) {
        return C_ZeimuNaiyouHnsyuCtrlKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ZeimuNaiyouHnsyuCtrlKbn pValue) {
        return pValue.getValue();
    }
}
