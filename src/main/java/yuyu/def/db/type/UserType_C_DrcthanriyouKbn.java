package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DrcthanriyouKbn;

/**
 * {@link C_DrcthanriyouKbn ダイレクト販売利用区分} の Hibernate ユーザー定義型です。<br />
 * ダイレクト販売利用区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DrcthanriyouKbn extends AbstractUserType<C_DrcthanriyouKbn> {

    @Override
    protected Class<C_DrcthanriyouKbn> returnType() {
        return C_DrcthanriyouKbn.class;
    }

    @Override
    protected C_DrcthanriyouKbn valueOf(String pValue) {
        return C_DrcthanriyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DrcthanriyouKbn pValue) {
        return pValue.getValue();
    }
}
