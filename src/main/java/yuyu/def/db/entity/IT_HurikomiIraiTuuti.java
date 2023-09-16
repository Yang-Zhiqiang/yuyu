package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_HurikomiIraiTuuti;


/**
 * 振込依頼通知テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_HurikomiIraiTuuti} の JavaDoc を参照してください。<br />
 * @see     GenIT_HurikomiIraiTuuti<br />
 * @see     PKIT_HurikomiIraiTuuti<br />
 * @see     QIT_HurikomiIraiTuuti<br />
 * @see     GenQIT_HurikomiIraiTuuti<br />
 */
@Entity
public class IT_HurikomiIraiTuuti extends GenIT_HurikomiIraiTuuti {

    private static final long serialVersionUID = 1L;

    public IT_HurikomiIraiTuuti() {
    }

    public IT_HurikomiIraiTuuti(String pKbnkey,String pSyono,BizDate pTyouhyouymd) {
        super(pKbnkey,pSyono,pTyouhyouymd);
    }

    public IT_HurikomiIraiTuuti(String pSyono,BizDate pTyouhyouymd) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTyouhyouymd);
    }


}

