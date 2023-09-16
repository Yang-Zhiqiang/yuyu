package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_KykDairiten;


/**
 * 契約代理店テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KykDairiten} の JavaDoc を参照してください。<br />
 * @see     GenIT_KykDairiten<br />
 * @see     PKIT_KykDairiten<br />
 * @see     QIT_KykDairiten<br />
 * @see     GenQIT_KykDairiten<br />
 */
@Entity
public class IT_KykDairiten extends GenIT_KykDairiten {

    private static final long serialVersionUID = 1L;

    public IT_KykDairiten() {
    }

    public IT_KykDairiten(String pKbnkey,String pSyono,Integer pDrtenrenno) {
        super(pKbnkey,pSyono,pDrtenrenno);
    }

    public IT_KykDairiten(String pSyono,Integer pDrtenrenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pDrtenrenno);
    }


    private IT_KykKihon iT_KykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_KykDairiten.KBNKEY  , referencedColumnName=IT_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_KykDairiten.SYONO  , referencedColumnName=IT_KykKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_KykKihon getKykKihon() {
        return iT_KykKihon;
    }

    public void setKykKihon(IT_KykKihon pIT_KykKihon) {
        this.iT_KykKihon = pIT_KykKihon;
    }

}

