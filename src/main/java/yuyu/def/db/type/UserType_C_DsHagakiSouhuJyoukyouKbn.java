package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DsHagakiSouhuJyoukyouKbn;

/**
 * {@link C_DsHagakiSouhuJyoukyouKbn ＤＳハガキ送付状況区分} の Hibernate ユーザー定義型です。<br />
 * ＤＳハガキ送付状況区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DsHagakiSouhuJyoukyouKbn extends AbstractUserType<C_DsHagakiSouhuJyoukyouKbn> {

    @Override
    protected Class<C_DsHagakiSouhuJyoukyouKbn> returnType() {
        return C_DsHagakiSouhuJyoukyouKbn.class;
    }

    @Override
    protected C_DsHagakiSouhuJyoukyouKbn valueOf(String pValue) {
        return C_DsHagakiSouhuJyoukyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DsHagakiSouhuJyoukyouKbn pValue) {
        return pValue.getValue();
    }
}
