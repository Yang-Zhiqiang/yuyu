package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_TRCreditKurikosiMinyuu;

/**
 * クレカ繰越未入ＴＲテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_TRCreditKurikosiMinyuu} の JavaDoc を参照してください。<br />
 * @see     GenIT_TRCreditKurikosiMinyuu<br />
 * @see     PKIT_TRCreditKurikosiMinyuu<br />
 * @see     QIT_TRCreditKurikosiMinyuu<br />
 * @see     GenQIT_TRCreditKurikosiMinyuu<br />
 */
@Entity
public class IT_TRCreditKurikosiMinyuu extends GenIT_TRCreditKurikosiMinyuu {

    private static final long serialVersionUID = 1L;

    public IT_TRCreditKurikosiMinyuu() {
    }

    public IT_TRCreditKurikosiMinyuu(String pKbnkey,String pSyono,BizDate pSyoriYmd,String pMinyuutrrenno) {
        super(pKbnkey,pSyono,pSyoriYmd,pMinyuutrrenno);
    }

    public IT_TRCreditKurikosiMinyuu(String pSyono,BizDate pSyoriYmd,String pMinyuutrrenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pSyoriYmd,pMinyuutrrenno);
    }


}

