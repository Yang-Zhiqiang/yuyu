package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.db.mapping.GenHT_SkUriageData;


/**
 * 新契約売上データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_SkUriageData} の JavaDoc を参照してください。<br />
 * @see     GenHT_SkUriageData<br />
 * @see     PKHT_SkUriageData<br />
 * @see     QHT_SkUriageData<br />
 * @see     GenQHT_SkUriageData<br />
 */
@Entity
public class HT_SkUriageData extends GenHT_SkUriageData {

    private static final long serialVersionUID = 1L;

    public HT_SkUriageData() {
    }

    public HT_SkUriageData(C_AnsyuusysKbn pAnsyuusyskbn,BizDate pSyoriYmd,String pMosno,Integer pAuthorikaisuu) {
        super(pAnsyuusyskbn,pSyoriYmd,pMosno,pAuthorikaisuu);
    }



}

