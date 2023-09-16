package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DsHosyouHyoujiPtnKbn;

/**
 * {@link C_DsHosyouHyoujiPtnKbn ＤＳ保障内容表示パターン区分} の Hibernate ユーザー定義型です。<br />
 * ＤＳ保障内容表示パターン区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DsHosyouHyoujiPtnKbn extends AbstractUserType<C_DsHosyouHyoujiPtnKbn> {

    @Override
    protected Class<C_DsHosyouHyoujiPtnKbn> returnType() {
        return C_DsHosyouHyoujiPtnKbn.class;
    }

    @Override
    protected C_DsHosyouHyoujiPtnKbn valueOf(String pValue) {
        return C_DsHosyouHyoujiPtnKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DsHosyouHyoujiPtnKbn pValue) {
        return pValue.getValue();
    }
}
