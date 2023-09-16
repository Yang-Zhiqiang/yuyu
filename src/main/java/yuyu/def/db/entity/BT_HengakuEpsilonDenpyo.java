package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_DenpyouKbn;
import yuyu.def.classification.C_HengakuSyuruiKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TkbtKanjyouUnitFundKbn;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.mapping.GenBT_HengakuEpsilonDenpyo;


/**
 * 変額イプシロン伝票テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_HengakuEpsilonDenpyo} の JavaDoc を参照してください。<br />
 * @see     GenBT_HengakuEpsilonDenpyo<br />
 * @see     PKBT_HengakuEpsilonDenpyo<br />
 * @see     QBT_HengakuEpsilonDenpyo<br />
 * @see     GenQBT_HengakuEpsilonDenpyo<br />
 */
@Entity
public class BT_HengakuEpsilonDenpyo extends GenBT_HengakuEpsilonDenpyo {

    private static final long serialVersionUID = 1L;

    public BT_HengakuEpsilonDenpyo() {
    }

    public BT_HengakuEpsilonDenpyo(C_HengakuSyuruiKbn pHengakusyuruikbn,C_UnitFundKbn pUnitfundkbn,C_TkbtKanjyouUnitFundKbn pTkbtkanjyouunitfundkbn,String pKacd,BizDate pDenymd,C_DenpyouKbn pDenpyoukbn,C_TaisyakuKbn pTaisyakukbn,String pKamokucd,BizDate pSyoriYmd) {
        super(pHengakusyuruikbn,pUnitfundkbn,pTkbtkanjyouunitfundkbn,pKacd,pDenymd,pDenpyoukbn,pTaisyakukbn,pKamokucd,pSyoriYmd);
    }



}

