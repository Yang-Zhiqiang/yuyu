package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.mapping.GenIT_BAK_UketoriKouza;

/**
 * 受取口座バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_UketoriKouza} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_UketoriKouza<br />
 * @see     PKIT_BAK_UketoriKouza<br />
 * @see     QIT_BAK_UketoriKouza<br />
 * @see     GenQIT_BAK_UketoriKouza<br />
 */
@Entity
public class IT_BAK_UketoriKouza extends GenIT_BAK_UketoriKouza {

    private static final long serialVersionUID = 1L;

    public IT_BAK_UketoriKouza() {
    }

    public IT_BAK_UketoriKouza(String pKbnkey,String pSyono,String pTrkssikibetukey,C_UktsyuKbn pUktsyukbn,Integer pUktsyurenno) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pUktsyukbn,pUktsyurenno);
    }

    public IT_BAK_UketoriKouza(String pSyono,String pTrkssikibetukey,C_UktsyuKbn pUktsyukbn,Integer pUktsyurenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pUktsyukbn,pUktsyurenno);
    }


    private IT_BAK_KykUkt iT_BAKKykUkt ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_UketoriKouza.KBNKEY  , referencedColumnName=IT_BAK_KykUkt.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_UketoriKouza.SYONO  , referencedColumnName=IT_BAK_KykUkt.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_UketoriKouza.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_KykUkt.TRKSSIKIBETUKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_UketoriKouza.UKTSYUKBN  , referencedColumnName=IT_BAK_KykUkt.UKTSYUKBN, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_UketoriKouza.UKTSYURENNO  , referencedColumnName=IT_BAK_KykUkt.UKTSYURENNO, insertable=false, updatable=false)
    })
    public IT_BAK_KykUkt getBAKKykUkt() {
        return iT_BAKKykUkt;
    }

    public void setBAKKykUkt(IT_BAK_KykUkt pIT_BAK_KykUkt) {
        this.iT_BAKKykUkt = pIT_BAK_KykUkt;
    }

}

