package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_TRKzhuriKurikosiMinyuu;


/**
 * 口座振替繰越未入ＴＲテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_TRKzhuriKurikosiMinyuu} の JavaDoc を参照してください。<br />
 * @see     GenIT_TRKzhuriKurikosiMinyuu<br />
 * @see     PKIT_TRKzhuriKurikosiMinyuu<br />
 * @see     QIT_TRKzhuriKurikosiMinyuu<br />
 * @see     GenQIT_TRKzhuriKurikosiMinyuu<br />
 */
@Entity
public class IT_TRKzhuriKurikosiMinyuu extends GenIT_TRKzhuriKurikosiMinyuu {

    private static final long serialVersionUID = 1L;

    public IT_TRKzhuriKurikosiMinyuu() {
    }

    public IT_TRKzhuriKurikosiMinyuu(String pKbnkey,String pSyono,BizDate pSyoriYmd,String pMinyuutrrenno) {
        super(pKbnkey,pSyono,pSyoriYmd,pMinyuutrrenno);
    }

    public IT_TRKzhuriKurikosiMinyuu(String pSyono,BizDate pSyoriYmd,String pMinyuutrrenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pSyoriYmd,pMinyuutrrenno);
    }


}

