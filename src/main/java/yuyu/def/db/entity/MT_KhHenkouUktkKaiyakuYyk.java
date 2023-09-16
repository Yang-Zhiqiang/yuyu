package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenMT_KhHenkouUktkKaiyakuYyk;

/**
 * 契約保全変更受付内容（解約）予約テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMT_KhHenkouUktkKaiyakuYyk} の JavaDoc を参照してください。<br />
 * @see     GenMT_KhHenkouUktkKaiyakuYyk<br />
 * @see     PKMT_KhHenkouUktkKaiyakuYyk<br />
 * @see     QMT_KhHenkouUktkKaiyakuYyk<br />
 * @see     GenQMT_KhHenkouUktkKaiyakuYyk<br />
 */
@Entity
public class MT_KhHenkouUktkKaiyakuYyk extends GenMT_KhHenkouUktkKaiyakuYyk {

    private static final long serialVersionUID = 1L;

    public MT_KhHenkouUktkKaiyakuYyk() {
    }

    public MT_KhHenkouUktkKaiyakuYyk(String pKbnkey,String pSyono,Integer pHozenhenkouuktkrenno) {
        super(pKbnkey,pSyono,pHozenhenkouuktkrenno);
    }

    public MT_KhHenkouUktkKaiyakuYyk(String pSyono,Integer pHozenhenkouuktkrenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pHozenhenkouuktkrenno);
    }


    private MT_KhHenkouUktkYyk mT_KhHenkouUktkYyk ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=MT_KhHenkouUktkKaiyakuYyk.KBNKEY  , referencedColumnName=MT_KhHenkouUktkYyk.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=MT_KhHenkouUktkKaiyakuYyk.SYONO  , referencedColumnName=MT_KhHenkouUktkYyk.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=MT_KhHenkouUktkKaiyakuYyk.HOZENHENKOUUKTKRENNO  , referencedColumnName=MT_KhHenkouUktkYyk.HOZENHENKOUUKTKRENNO, insertable=false, updatable=false)
    })
    public MT_KhHenkouUktkYyk getKhHenkouUktkYyk() {
        return mT_KhHenkouUktkYyk;
    }

    public void setKhHenkouUktkYyk(MT_KhHenkouUktkYyk pMT_KhHenkouUktkYyk) {
        this.mT_KhHenkouUktkYyk = pMT_KhHenkouUktkYyk;
    }
}

