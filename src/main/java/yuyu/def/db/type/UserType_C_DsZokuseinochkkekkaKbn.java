package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DsZokuseinochkkekkaKbn;

/**
 * {@link C_DsZokuseinochkkekkaKbn ＤＳ属性番号チェック結果区分} の Hibernate ユーザー定義型です。<br />
 * ＤＳ属性番号チェック結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DsZokuseinochkkekkaKbn extends AbstractUserType<C_DsZokuseinochkkekkaKbn> {

    @Override
    protected Class<C_DsZokuseinochkkekkaKbn> returnType() {
        return C_DsZokuseinochkkekkaKbn.class;
    }

    @Override
    protected C_DsZokuseinochkkekkaKbn valueOf(String pValue) {
        return C_DsZokuseinochkkekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DsZokuseinochkkekkaKbn pValue) {
        return pValue.getValue();
    }
}
