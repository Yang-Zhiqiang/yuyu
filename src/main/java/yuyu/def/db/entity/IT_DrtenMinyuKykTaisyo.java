package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_DrtenMinyuKykTaisyo;

/**
 * 代理店未入契約明細対象テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_DrtenMinyuKykTaisyo} の JavaDoc を参照してください。<br />
 * @see     GenIT_DrtenMinyuKykTaisyo<br />
 * @see     PKIT_DrtenMinyuKykTaisyo<br />
 * @see     QIT_DrtenMinyuKykTaisyo<br />
 * @see     GenQIT_DrtenMinyuKykTaisyo<br />
 */
@Entity
public class IT_DrtenMinyuKykTaisyo extends GenIT_DrtenMinyuKykTaisyo {

    private static final long serialVersionUID = 1L;

    public IT_DrtenMinyuKykTaisyo() {
    }

    public IT_DrtenMinyuKykTaisyo(String pKbnkey,String pSyono,BizDate pSyoriYmd,String pMinyuutrrenno) {
        super(pKbnkey,pSyono,pSyoriYmd,pMinyuutrrenno);
    }

    public IT_DrtenMinyuKykTaisyo(String pSyono,BizDate pSyoriYmd,String pMinyuutrrenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pSyoriYmd,pMinyuutrrenno);
    }


}

