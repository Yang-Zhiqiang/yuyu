package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_KouzahuriStartAnnai;


/**
 * 口座振替開始案内テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KouzahuriStartAnnai} の JavaDoc を参照してください。<br />
 * @see     GenIT_KouzahuriStartAnnai<br />
 * @see     PKIT_KouzahuriStartAnnai<br />
 * @see     QIT_KouzahuriStartAnnai<br />
 * @see     GenQIT_KouzahuriStartAnnai<br />
 */
@Entity
public class IT_KouzahuriStartAnnai extends GenIT_KouzahuriStartAnnai {

    private static final long serialVersionUID = 1L;

    public IT_KouzahuriStartAnnai() {
    }

    public IT_KouzahuriStartAnnai(String pKbnkey,String pSyono) {
        super(pKbnkey,pSyono);
    }

    public IT_KouzahuriStartAnnai(String pSyono) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono);
    }


}

