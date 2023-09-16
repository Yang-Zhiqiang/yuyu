package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.mapping.GenIT_UketoriKouza;

/**
 * 受取口座テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_UketoriKouza} の JavaDoc を参照してください。<br />
 * @see     GenIT_UketoriKouza<br />
 * @see     PKIT_UketoriKouza<br />
 * @see     QIT_UketoriKouza<br />
 * @see     GenQIT_UketoriKouza<br />
 */
@Entity
public class IT_UketoriKouza extends GenIT_UketoriKouza {

    private static final long serialVersionUID = 1L;

    public IT_UketoriKouza() {
    }

    public IT_UketoriKouza(String pKbnkey,String pSyono,C_UktsyuKbn pUktsyukbn,Integer pUktsyurenno) {
        super(pKbnkey,pSyono,pUktsyukbn,pUktsyurenno);
    }

    public IT_UketoriKouza(String pSyono,C_UktsyuKbn pUktsyukbn,Integer pUktsyurenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pUktsyukbn,pUktsyurenno);
    }


    private IT_KykUkt iT_KykUkt ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_UketoriKouza.KBNKEY  , referencedColumnName=IT_KykUkt.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_UketoriKouza.SYONO  , referencedColumnName=IT_KykUkt.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_UketoriKouza.UKTSYUKBN  , referencedColumnName=IT_KykUkt.UKTSYUKBN, insertable=false, updatable=false),
        @JoinColumn(name=IT_UketoriKouza.UKTSYURENNO  , referencedColumnName=IT_KykUkt.UKTSYURENNO, insertable=false, updatable=false)
    })
    public IT_KykUkt getKykUkt() {
        return iT_KykUkt;
    }

    public void setKykUkt(IT_KykUkt pIT_KykUkt) {
        this.iT_KykUkt = pIT_KykUkt;
    }

}

