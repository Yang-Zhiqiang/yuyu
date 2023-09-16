package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.db.mapping.GenHT_SkKouzahuriAnnaiData;


/**
 * 新契約口座振替案内データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_SkKouzahuriAnnaiData} の JavaDoc を参照してください。<br />
 * @see     GenHT_SkKouzahuriAnnaiData<br />
 * @see     PKHT_SkKouzahuriAnnaiData<br />
 * @see     QHT_SkKouzahuriAnnaiData<br />
 * @see     GenQHT_SkKouzahuriAnnaiData<br />
 */
@Entity
public class HT_SkKouzahuriAnnaiData extends GenHT_SkKouzahuriAnnaiData {

    private static final long serialVersionUID = 1L;

    public HT_SkKouzahuriAnnaiData() {
    }

    public HT_SkKouzahuriAnnaiData(C_AnsyuusysKbn pAnsyuusyskbn,BizDate pSyoriYmd,String pMosno,C_NyknaiyouKbn pNyknaiyoukbn,BizDateYM pJyuutouym) {
        super(pAnsyuusyskbn,pSyoriYmd,pMosno,pNyknaiyoukbn,pJyuutouym);
    }



}

