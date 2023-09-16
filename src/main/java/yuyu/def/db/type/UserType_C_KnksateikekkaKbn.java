package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KnksateikekkaKbn;

/**
 * {@link C_KnksateikekkaKbn 環境査定結果区分} の Hibernate ユーザー定義型です。<br />
 * 環境査定結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KnksateikekkaKbn extends AbstractUserType<C_KnksateikekkaKbn> {

    @Override
    protected Class<C_KnksateikekkaKbn> returnType() {
        return C_KnksateikekkaKbn.class;
    }

    @Override
    protected C_KnksateikekkaKbn valueOf(String pValue) {
        return C_KnksateikekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KnksateikekkaKbn pValue) {
        return pValue.getValue();
    }
}
