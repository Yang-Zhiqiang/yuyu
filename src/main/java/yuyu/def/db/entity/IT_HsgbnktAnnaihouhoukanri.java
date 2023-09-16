package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_HsgbnktAnnaihouhoukanri;

/**
 * 被災害分割案内方法管理テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_HsgbnktAnnaihouhoukanri} の JavaDoc を参照してください。<br />
 * @see     GenIT_HsgbnktAnnaihouhoukanri<br />
 * @see     PKIT_HsgbnktAnnaihouhoukanri<br />
 * @see     QIT_HsgbnktAnnaihouhoukanri<br />
 * @see     GenQIT_HsgbnktAnnaihouhoukanri<br />
 */
@Entity
public class IT_HsgbnktAnnaihouhoukanri extends GenIT_HsgbnktAnnaihouhoukanri {

    private static final long serialVersionUID = 1L;

    public IT_HsgbnktAnnaihouhoukanri() {
    }

    public IT_HsgbnktAnnaihouhoukanri(String pKbnkey, String pSyono, BizDate pHsgymd) {
        super(pKbnkey, pSyono, pHsgymd);
    }

    public IT_HsgbnktAnnaihouhoukanri(String pSyono, BizDate pHsgymd) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono), pSyono, pHsgymd);
    }

}
