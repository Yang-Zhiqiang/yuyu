package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_KhHenkouUktkKaiyaku;

/**
 * 契約保全変更受付内容（解約）テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhHenkouUktkKaiyaku} の JavaDoc を参照してください。
 * @see     GenIT_KhHenkouUktkKaiyaku
 * @see     PKIT_KhHenkouUktkKaiyaku
 * @see     QIT_KhHenkouUktkKaiyaku
 * @see     GenQIT_KhHenkouUktkKaiyaku
 */
@Entity
public class IT_KhHenkouUktkKaiyaku extends GenIT_KhHenkouUktkKaiyaku {

    private static final long serialVersionUID = 1L;

    public IT_KhHenkouUktkKaiyaku() {
    }

    public IT_KhHenkouUktkKaiyaku(String pKbnkey,String pSyono,Integer pHozenhenkouuktkrenno) {
        super(pKbnkey,pSyono,pHozenhenkouuktkrenno);
    }

    public IT_KhHenkouUktkKaiyaku(String pSyono,Integer pHozenhenkouuktkrenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pHozenhenkouuktkrenno);
    }



    private IT_KhHenkouUktk iT_KhHenkouUktk ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_KhHenkouUktkKaiyaku.KBNKEY  , referencedColumnName=IT_KhHenkouUktk.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_KhHenkouUktkKaiyaku.SYONO  , referencedColumnName=IT_KhHenkouUktk.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_KhHenkouUktkKaiyaku.HOZENHENKOUUKTKRENNO  , referencedColumnName=IT_KhHenkouUktk.HOZENHENKOUUKTKRENNO, insertable=false, updatable=false)
    })
    public IT_KhHenkouUktk getKhHenkouUktk() {
        return iT_KhHenkouUktk;
    }

    public void setKhHenkouUktk(IT_KhHenkouUktk pIT_KhHenkouUktk) {
        this.iT_KhHenkouUktk = pIT_KhHenkouUktk;
    }

}

