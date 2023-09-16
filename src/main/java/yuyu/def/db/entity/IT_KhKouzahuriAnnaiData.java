package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.db.mapping.GenIT_KhKouzahuriAnnaiData;

/**
 * 口座振替案内データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhKouzahuriAnnaiData} の JavaDoc を参照してください。<br />
 * @see     GenIT_KhKouzahuriAnnaiData<br />
 * @see     PKIT_KhKouzahuriAnnaiData<br />
 * @see     QIT_KhKouzahuriAnnaiData<br />
 * @see     GenQIT_KhKouzahuriAnnaiData<br />
 */
@Entity
public class IT_KhKouzahuriAnnaiData extends GenIT_KhKouzahuriAnnaiData {

    private static final long serialVersionUID = 1L;

    public IT_KhKouzahuriAnnaiData() {
    }

    public IT_KhKouzahuriAnnaiData(String pKbnkey,C_AnsyuusysKbn pAnsyuusyskbn,BizDate pSyoriYmd,String pSyono,C_NyknaiyouKbn pNyknaiyoukbn,BizDateYM pJyuutouym) {
        super(pKbnkey,pAnsyuusyskbn,pSyoriYmd,pSyono,pNyknaiyoukbn,pJyuutouym);
    }

    public IT_KhKouzahuriAnnaiData(C_AnsyuusysKbn pAnsyuusyskbn,BizDate pSyoriYmd,String pSyono,C_NyknaiyouKbn pNyknaiyoukbn,BizDateYM pJyuutouym) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pAnsyuusyskbn,pSyoriYmd,pSyono,pNyknaiyoukbn,pJyuutouym);
    }


}

