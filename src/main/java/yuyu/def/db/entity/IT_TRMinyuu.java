package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_TRMinyuu;

/**
 * 未入ＴＲテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_TRMinyuu} の JavaDoc を参照してください。<br />
 * @see     GenIT_TRMinyuu<br />
 * @see     PKIT_TRMinyuu<br />
 * @see     QIT_TRMinyuu<br />
 * @see     GenQIT_TRMinyuu<br />
 */
@Entity
public class IT_TRMinyuu extends GenIT_TRMinyuu {

    private static final long serialVersionUID = 1L;

    public IT_TRMinyuu() {
    }

    public IT_TRMinyuu(String pKbnkey,String pSyono,BizDate pSyoriYmd,String pMinyuutrrenno) {
        super(pKbnkey,pSyono,pSyoriYmd,pMinyuutrrenno);
    }

    public IT_TRMinyuu(String pSyono,BizDate pSyoriYmd,String pMinyuutrrenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pSyoriYmd,pMinyuutrrenno);
    }


}

