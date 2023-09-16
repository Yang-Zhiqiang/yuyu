package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_KoujyoSymNaiyouD;

/**
 * 控除証明内容Ｄテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KoujyoSymNaiyouD} の JavaDoc を参照してください。<br />
 * @see     GenIT_KoujyoSymNaiyouD<br />
 * @see     PKIT_KoujyoSymNaiyouD<br />
 * @see     QIT_KoujyoSymNaiyouD<br />
 * @see     GenQIT_KoujyoSymNaiyouD<br />
 */
@Entity
public class IT_KoujyoSymNaiyouD extends GenIT_KoujyoSymNaiyouD {

    private static final long serialVersionUID = 1L;

    public IT_KoujyoSymNaiyouD() {
    }

    public IT_KoujyoSymNaiyouD(String pKbnkey,String pSyono,String pSyouhncd,Integer pRenno3keta) {
        super(pKbnkey,pSyono,pSyouhncd,pRenno3keta);
    }

    public IT_KoujyoSymNaiyouD(String pSyono,String pSyouhncd,Integer pRenno3keta) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pSyouhncd,pRenno3keta);
    }


    private IT_KykKihon iT_KykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_KoujyoSymNaiyouD.KBNKEY  , referencedColumnName=IT_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_KoujyoSymNaiyouD.SYONO  , referencedColumnName=IT_KykKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_KykKihon getKykKihon() {
        return iT_KykKihon;
    }

    public void setKykKihon(IT_KykKihon pIT_KykKihon) {
        this.iT_KykKihon = pIT_KykKihon;
    }

}

