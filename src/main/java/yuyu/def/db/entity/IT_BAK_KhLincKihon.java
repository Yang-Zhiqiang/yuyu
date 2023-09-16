package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_BAK_KhLincKihon;


/**
 * 契約保全ＬＩＮＣ基本バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_KhLincKihon} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_KhLincKihon<br />
 * @see     PKIT_BAK_KhLincKihon<br />
 * @see     QIT_BAK_KhLincKihon<br />
 * @see     GenQIT_BAK_KhLincKihon<br />
 */
@Entity
public class IT_BAK_KhLincKihon extends GenIT_BAK_KhLincKihon {

    private static final long serialVersionUID = 1L;

    public IT_BAK_KhLincKihon() {
    }

    public IT_BAK_KhLincKihon(String pKbnkey,String pSyono,String pTrkssikibetukey) {
        super(pKbnkey,pSyono,pTrkssikibetukey);
    }

    public IT_BAK_KhLincKihon(String pSyono,String pTrkssikibetukey) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey);
    }


    private IT_BAK_KykKihon iT_BAKKykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_KhLincKihon.KBNKEY  , referencedColumnName=IT_BAK_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KhLincKihon.SYONO  , referencedColumnName=IT_BAK_KykKihon.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KhLincKihon.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_KykKihon.TRKSSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_BAK_KykKihon getBAKKykKihon() {
        return iT_BAKKykKihon;
    }

    public void setBAKKykKihon(IT_BAK_KykKihon pIT_BAK_KykKihon) {
        this.iT_BAKKykKihon = pIT_BAK_KykKihon;
    }

}

