package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_DairitenMinyuKykMeisai;

/**
 * 代理店未入契約明細テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_DairitenMinyuKykMeisai} の JavaDoc を参照してください。<br />
 * @see     GenIT_DairitenMinyuKykMeisai<br />
 * @see     PKIT_DairitenMinyuKykMeisai<br />
 * @see     QIT_DairitenMinyuKykMeisai<br />
 * @see     GenQIT_DairitenMinyuKykMeisai<br />
 */
@Entity
public class IT_DairitenMinyuKykMeisai extends GenIT_DairitenMinyuKykMeisai {

    private static final long serialVersionUID = 1L;

    public IT_DairitenMinyuKykMeisai() {
    }

    public IT_DairitenMinyuKykMeisai(String pKbnkey,BizDate pSyoriYmd,String pSyono,Integer pDrtenrenno) {
        super(pKbnkey,pSyoriYmd,pSyono,pDrtenrenno);
    }

    public IT_DairitenMinyuKykMeisai(BizDate pSyoriYmd,String pSyono,Integer pDrtenrenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyoriYmd,pSyono,pDrtenrenno);
    }


}

