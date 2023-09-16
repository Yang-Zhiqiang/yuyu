package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Lincsousinflg;

/**
 * {@link C_Lincsousinflg ＬＩＮＣ送信済フラグ} の Hibernate ユーザー定義型です。<br />
 * ＬＩＮＣ送信済フラグ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Lincsousinflg extends AbstractUserType<C_Lincsousinflg> {

    @Override
    protected Class<C_Lincsousinflg> returnType() {
        return C_Lincsousinflg.class;
    }

    @Override
    protected C_Lincsousinflg valueOf(String pValue) {
        return C_Lincsousinflg.valueOf(pValue);
    }

    @Override
    protected String toString(C_Lincsousinflg pValue) {
        return pValue.getValue();
    }
}
