package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_KijituTouraiAnnai;


/**
 * 期日到来案内テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KijituTouraiAnnai} の JavaDoc を参照してください。<br />
 * @see     GenIT_KijituTouraiAnnai<br />
 * @see     PKIT_KijituTouraiAnnai<br />
 * @see     QIT_KijituTouraiAnnai<br />
 * @see     GenQIT_KijituTouraiAnnai<br />
 */
@Entity
public class IT_KijituTouraiAnnai extends GenIT_KijituTouraiAnnai {

    private static final long serialVersionUID = 1L;

    public IT_KijituTouraiAnnai() {
    }

    public IT_KijituTouraiAnnai(String pKbnkey,String pSyono,BizDate pTyouhyouymd) {
        super(pKbnkey,pSyono,pTyouhyouymd);
    }

    public IT_KijituTouraiAnnai(String pSyono,BizDate pTyouhyouymd) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTyouhyouymd);
    }


}

