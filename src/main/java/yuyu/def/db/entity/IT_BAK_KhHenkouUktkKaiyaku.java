package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_BAK_KhHenkouUktkKaiyaku;

/**
 * 契約保全変更受付内容（解約）バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_KhHenkouUktkKaiyaku} の JavaDoc を参照してください。
 * @see     GenIT_BAK_KhHenkouUktkKaiyaku
 * @see     PKIT_BAK_KhHenkouUktkKaiyaku
 * @see     QIT_BAK_KhHenkouUktkKaiyaku
 * @see     GenQIT_BAK_KhHenkouUktkKaiyaku
 */
@Entity
public class IT_BAK_KhHenkouUktkKaiyaku extends GenIT_BAK_KhHenkouUktkKaiyaku {

    private static final long serialVersionUID = 1L;

    public IT_BAK_KhHenkouUktkKaiyaku() {
    }

    public IT_BAK_KhHenkouUktkKaiyaku(String pKbnkey,String pSyono,String pTrkssikibetukey,Integer pHozenhenkouuktkrenno) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pHozenhenkouuktkrenno);
    }

    public IT_BAK_KhHenkouUktkKaiyaku(String pSyono,String pTrkssikibetukey,Integer pHozenhenkouuktkrenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pHozenhenkouuktkrenno);
    }



    private IT_BAK_KhHenkouUktk iT_BAKKhHenkouUktk ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_KhHenkouUktkKaiyaku.KBNKEY  , referencedColumnName=IT_BAK_KhHenkouUktk.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KhHenkouUktkKaiyaku.SYONO  , referencedColumnName=IT_BAK_KhHenkouUktk.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KhHenkouUktkKaiyaku.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_KhHenkouUktk.TRKSSIKIBETUKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KhHenkouUktkKaiyaku.HOZENHENKOUUKTKRENNO  , referencedColumnName=IT_BAK_KhHenkouUktk.HOZENHENKOUUKTKRENNO, insertable=false, updatable=false)
    })
    public IT_BAK_KhHenkouUktk getBAKKhHenkouUktk() {
        return iT_BAKKhHenkouUktk;
    }

    public void setBAKKhHenkouUktk(IT_BAK_KhHenkouUktk pIT_BAK_KhHenkouUktk) {
        this.iT_BAKKhHenkouUktk = pIT_BAK_KhHenkouUktk;
    }

}

