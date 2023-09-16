package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIW_CifcdIktHnkWk;

/**
 * ＣＩＦコード一括変更ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIW_CifcdIktHnkWk} の JavaDoc を参照してください。<br />
 * @see     GenIW_CifcdIktHnkWk<br />
 * @see     PKIW_CifcdIktHnkWk<br />
 * @see     QIW_CifcdIktHnkWk<br />
 * @see     GenQIW_CifcdIktHnkWk<br />
 */
@Entity
public class IW_CifcdIktHnkWk extends GenIW_CifcdIktHnkWk {

    private static final long serialVersionUID = 1L;

    public IW_CifcdIktHnkWk() {
    }

    public IW_CifcdIktHnkWk(String pKbnkey,String pSyono) {
        super(pKbnkey,pSyono);
    }

    public IW_CifcdIktHnkWk(String pSyono) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono);
    }


}

