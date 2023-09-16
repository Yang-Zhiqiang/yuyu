package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_ChkJhNenreiNensyuuTuusanS;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 年齢年収制限通算限度Ｓ事方書チェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkJhNenreiNensyuuTuusanS extends AbstractExDBTable<BM_ChkJhNenreiNensyuuTuusanS> {

    public GenQBM_ChkJhNenreiNensyuuTuusanS() {
        this("BM_ChkJhNenreiNensyuuTuusanS");
    }

    public GenQBM_ChkJhNenreiNensyuuTuusanS(String pAlias) {
        super("BM_ChkJhNenreiNensyuuTuusanS", BM_ChkJhNenreiNensyuuTuusanS.class, pAlias);
    }

    public String BM_ChkJhNenreiNensyuuTuusanS() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkJhNenreiNensyuuTuusanS, BizNumber> hhknfromnen = new ExDBFieldString<>("hhknfromnen", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkJhNenreiNensyuuTuusanS, BizNumber> hhkntonen = new ExDBFieldString<>("hhkntonen", this, BizNumberType.class);

    public final ExDBFieldNumber<BM_ChkJhNenreiNensyuuTuusanS, Integer> hhknfromnensyuu = new ExDBFieldNumber<>("hhknfromnensyuu", this);

    public final ExDBFieldNumber<BM_ChkJhNenreiNensyuuTuusanS, Integer> hhkntonensyuu = new ExDBFieldNumber<>("hhkntonensyuu", this);

    public final ExDBFieldBizCurrency<BM_ChkJhNenreiNensyuuTuusanS> gnds1 = new ExDBFieldBizCurrency<>("gnds1", this);

    public final ExDBFieldBizCurrency<BM_ChkJhNenreiNensyuuTuusanS> gnds2 = new ExDBFieldBizCurrency<>("gnds2", this);

    public final ExDBFieldBizCurrency<BM_ChkJhNenreiNensyuuTuusanS> itijibrgnds1 = new ExDBFieldBizCurrency<>("itijibrgnds1", this);

    public final ExDBFieldBizCurrency<BM_ChkJhNenreiNensyuuTuusanS> itijibrgnds2 = new ExDBFieldBizCurrency<>("itijibrgnds2", this);
}
