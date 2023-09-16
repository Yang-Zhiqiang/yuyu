package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Kanryouflg;

/**
 * {@link C_Kanryouflg 完了フラグ} の Hibernate ユーザー定義型です。<br />
 * 完了フラグ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Kanryouflg extends AbstractUserType<C_Kanryouflg> {

    @Override
    protected Class<C_Kanryouflg> returnType() {
        return C_Kanryouflg.class;
    }

    @Override
    protected C_Kanryouflg valueOf(String pValue) {
        return C_Kanryouflg.valueOf(pValue);
    }

    @Override
    protected String toString(C_Kanryouflg pValue) {
        return pValue.getValue();
    }
}
