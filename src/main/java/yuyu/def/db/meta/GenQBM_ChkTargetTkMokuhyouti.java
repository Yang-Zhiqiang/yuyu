package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.db.entity.BM_ChkTargetTkMokuhyouti;
import yuyu.def.db.type.UserType_C_Channelcd;

/**
 * ターゲット特約目標値チェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkTargetTkMokuhyouti extends AbstractExDBTable<BM_ChkTargetTkMokuhyouti> {

    public GenQBM_ChkTargetTkMokuhyouti() {
        this("BM_ChkTargetTkMokuhyouti");
    }

    public GenQBM_ChkTargetTkMokuhyouti(String pAlias) {
        super("BM_ChkTargetTkMokuhyouti", BM_ChkTargetTkMokuhyouti.class, pAlias);
    }

    public String BM_ChkTargetTkMokuhyouti() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkTargetTkMokuhyouti, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<BM_ChkTargetTkMokuhyouti, Integer> syusyouhnsdnofrom = new ExDBFieldNumber<>("syusyouhnsdnofrom", this);

    public final ExDBFieldNumber<BM_ChkTargetTkMokuhyouti, Integer> syusyouhnsdnoto = new ExDBFieldNumber<>("syusyouhnsdnoto", this);

    public final ExDBFieldString<BM_ChkTargetTkMokuhyouti, C_Channelcd> channelcd = new ExDBFieldString<>("channelcd", this, UserType_C_Channelcd.class);

    public final ExDBFieldNumber<BM_ChkTargetTkMokuhyouti, Integer> targettkmokuhyouti = new ExDBFieldNumber<>("targettkmokuhyouti", this);
}
