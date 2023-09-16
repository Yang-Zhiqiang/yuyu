package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_KouzahuriMinyuTuuti;


/**
 * 口座振替未入通知テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KouzahuriMinyuTuuti} の JavaDoc を参照してください。<br />
 * @see     GenIT_KouzahuriMinyuTuuti<br />
 * @see     PKIT_KouzahuriMinyuTuuti<br />
 * @see     QIT_KouzahuriMinyuTuuti<br />
 * @see     GenQIT_KouzahuriMinyuTuuti<br />
 */
@Entity
public class IT_KouzahuriMinyuTuuti extends GenIT_KouzahuriMinyuTuuti {

    private static final long serialVersionUID = 1L;

    public IT_KouzahuriMinyuTuuti() {
    }

    public IT_KouzahuriMinyuTuuti(String pKbnkey,String pSyono,BizDate pTyouhyouymd) {
        super(pKbnkey,pSyono,pTyouhyouymd);
    }

    public IT_KouzahuriMinyuTuuti(String pSyono,BizDate pTyouhyouymd) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTyouhyouymd);
    }


}

