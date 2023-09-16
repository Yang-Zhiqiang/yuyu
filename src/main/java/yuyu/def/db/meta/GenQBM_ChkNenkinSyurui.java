package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.db.entity.BM_ChkNenkinSyurui;
import yuyu.def.db.type.UserType_C_Sknenkinsyu;

/**
 * 年金種類チェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkNenkinSyurui extends AbstractExDBTable<BM_ChkNenkinSyurui> {

    public GenQBM_ChkNenkinSyurui() {
        this("BM_ChkNenkinSyurui");
    }

    public GenQBM_ChkNenkinSyurui(String pAlias) {
        super("BM_ChkNenkinSyurui", BM_ChkNenkinSyurui.class, pAlias);
    }

    public String BM_ChkNenkinSyurui() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkNenkinSyurui, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<BM_ChkNenkinSyurui, Integer> syusyouhnsdnofrom = new ExDBFieldNumber<>("syusyouhnsdnofrom", this);

    public final ExDBFieldNumber<BM_ChkNenkinSyurui, Integer> syusyouhnsdnoto = new ExDBFieldNumber<>("syusyouhnsdnoto", this);

    public final ExDBFieldString<BM_ChkNenkinSyurui, C_Sknenkinsyu> sknenkinsyu = new ExDBFieldString<>("sknenkinsyu", this, UserType_C_Sknenkinsyu.class);
}
