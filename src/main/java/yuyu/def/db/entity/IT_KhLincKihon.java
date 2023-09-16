package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_KhLincKihon;


/**
 * 契約保全ＬＩＮＣ基本テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhLincKihon} の JavaDoc を参照してください。<br />
 * @see     GenIT_KhLincKihon<br />
 * @see     PKIT_KhLincKihon<br />
 * @see     QIT_KhLincKihon<br />
 * @see     GenQIT_KhLincKihon<br />
 */
@Entity
public class IT_KhLincKihon extends GenIT_KhLincKihon {

    private static final long serialVersionUID = 1L;

    public IT_KhLincKihon() {
    }

    public IT_KhLincKihon(String pKbnkey,String pSyono) {
        super(pKbnkey,pSyono);
    }

    public IT_KhLincKihon(String pSyono) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono);
    }


    private IT_KykKihon iT_KykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_KhLincKihon.KBNKEY  , referencedColumnName=IT_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_KhLincKihon.SYONO  , referencedColumnName=IT_KykKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_KykKihon getKykKihon() {
        return iT_KykKihon;
    }

    public void setKykKihon(IT_KykKihon pIT_KykKihon) {
        this.iT_KykKihon = pIT_KykKihon;
    }

}

