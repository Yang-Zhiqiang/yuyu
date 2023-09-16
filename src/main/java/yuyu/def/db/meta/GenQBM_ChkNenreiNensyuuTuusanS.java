package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_ChkNenreiNensyuuTuusanS;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 年齢年収制限通算限度Ｓチェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkNenreiNensyuuTuusanS extends AbstractExDBTable<BM_ChkNenreiNensyuuTuusanS> {

    public GenQBM_ChkNenreiNensyuuTuusanS() {
        this("BM_ChkNenreiNensyuuTuusanS");
    }

    public GenQBM_ChkNenreiNensyuuTuusanS(String pAlias) {
        super("BM_ChkNenreiNensyuuTuusanS", BM_ChkNenreiNensyuuTuusanS.class, pAlias);
    }

    public String BM_ChkNenreiNensyuuTuusanS() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkNenreiNensyuuTuusanS, BizNumber> hhknfromnen = new ExDBFieldString<>("hhknfromnen", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkNenreiNensyuuTuusanS, BizNumber> hhkntonen = new ExDBFieldString<>("hhkntonen", this, BizNumberType.class);

    public final ExDBFieldNumber<BM_ChkNenreiNensyuuTuusanS, Integer> hhknfromnensyuu = new ExDBFieldNumber<>("hhknfromnensyuu", this);

    public final ExDBFieldNumber<BM_ChkNenreiNensyuuTuusanS, Integer> hhkntonensyuu = new ExDBFieldNumber<>("hhkntonensyuu", this);

    public final ExDBFieldBizCurrency<BM_ChkNenreiNensyuuTuusanS> gnds1 = new ExDBFieldBizCurrency<>("gnds1", this);

    public final ExDBFieldBizCurrency<BM_ChkNenreiNensyuuTuusanS> gnds2 = new ExDBFieldBizCurrency<>("gnds2", this);

    public final ExDBFieldBizCurrency<BM_ChkNenreiNensyuuTuusanS> itijibrgnds1 = new ExDBFieldBizCurrency<>("itijibrgnds1", this);

    public final ExDBFieldBizCurrency<BM_ChkNenreiNensyuuTuusanS> itijibrgnds2 = new ExDBFieldBizCurrency<>("itijibrgnds2", this);
}
