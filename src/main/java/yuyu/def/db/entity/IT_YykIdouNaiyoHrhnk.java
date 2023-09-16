package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_YykIdouNaiyoHrhnk;


/**
 * 予約異動受付内容（払方変更）テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_YykIdouNaiyoHrhnk} の JavaDoc を参照してください。<br />
 * @see     GenIT_YykIdouNaiyoHrhnk<br />
 * @see     PKIT_YykIdouNaiyoHrhnk<br />
 * @see     QIT_YykIdouNaiyoHrhnk<br />
 * @see     GenQIT_YykIdouNaiyoHrhnk<br />
 */
@Entity
public class IT_YykIdouNaiyoHrhnk extends GenIT_YykIdouNaiyoHrhnk {

    private static final long serialVersionUID = 1L;

    public IT_YykIdouNaiyoHrhnk() {
    }

    public IT_YykIdouNaiyoHrhnk(String pKbnkey,String pSyono,String pHenkousikibetukey) {
        super(pKbnkey,pSyono,pHenkousikibetukey);
    }

    public IT_YykIdouNaiyoHrhnk(String pSyono,String pHenkousikibetukey) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pHenkousikibetukey);
    }


    private IT_KykKihon iT_KykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_YykIdouNaiyoHrhnk.KBNKEY  , referencedColumnName=IT_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_YykIdouNaiyoHrhnk.SYONO  , referencedColumnName=IT_KykKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_KykKihon getKykKihon() {
        return iT_KykKihon;
    }

    public void setKykKihon(IT_KykKihon pIT_KykKihon) {
        this.iT_KykKihon = pIT_KykKihon;
    }

}

