package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_Kariukekin;


/**
 * 仮受金テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_Kariukekin} の JavaDoc を参照してください。<br />
 * @see     GenIT_Kariukekin<br />
 * @see     PKIT_Kariukekin<br />
 * @see     QIT_Kariukekin<br />
 * @see     GenQIT_Kariukekin<br />
 */
@Entity
public class IT_Kariukekin extends GenIT_Kariukekin {

    private static final long serialVersionUID = 1L;

    public IT_Kariukekin() {
    }

    public IT_Kariukekin(String pKbnkey,String pSyono,Integer pKrkno) {
        super(pKbnkey,pSyono,pKrkno);
    }

    public IT_Kariukekin(String pSyono,Integer pKrkno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pKrkno);
    }


    private IT_KykKihon iT_KykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_Kariukekin.KBNKEY  , referencedColumnName=IT_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_Kariukekin.SYONO  , referencedColumnName=IT_KykKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_KykKihon getKykKihon() {
        return iT_KykKihon;
    }

    public void setKykKihon(IT_KykKihon pIT_KykKihon) {
        this.iT_KykKihon = pIT_KykKihon;
    }

}

