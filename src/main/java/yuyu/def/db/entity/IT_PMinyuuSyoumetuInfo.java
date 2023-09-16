package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_PMinyuuSyoumetuInfo;


/**
 * Ｐ未入消滅情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_PMinyuuSyoumetuInfo} の JavaDoc を参照してください。<br />
 * @see     GenIT_PMinyuuSyoumetuInfo<br />
 * @see     PKIT_PMinyuuSyoumetuInfo<br />
 * @see     QIT_PMinyuuSyoumetuInfo<br />
 * @see     GenQIT_PMinyuuSyoumetuInfo<br />
 */
@Entity
public class IT_PMinyuuSyoumetuInfo extends GenIT_PMinyuuSyoumetuInfo {

    private static final long serialVersionUID = 1L;

    public IT_PMinyuuSyoumetuInfo() {
    }

    public IT_PMinyuuSyoumetuInfo(String pKbnkey,String pSyono) {
        super(pKbnkey,pSyono);
    }

    public IT_PMinyuuSyoumetuInfo(String pSyono) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono);
    }


    private IT_KykKihon iT_KykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_PMinyuuSyoumetuInfo.KBNKEY  , referencedColumnName=IT_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_PMinyuuSyoumetuInfo.SYONO  , referencedColumnName=IT_KykKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_KykKihon getKykKihon() {
        return iT_KykKihon;
    }

    public void setKykKihon(IT_KykKihon pIT_KykKihon) {
        this.iT_KykKihon = pIT_KykKihon;
    }

}

