package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_BAK_KhHenkouUktkMkhgkHnk;


/**
 * 契約保全変更受付内容（目標額変更）バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_KhHenkouUktkMkhgkHnk} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_KhHenkouUktkMkhgkHnk<br />
 * @see     PKIT_BAK_KhHenkouUktkMkhgkHnk<br />
 * @see     QIT_BAK_KhHenkouUktkMkhgkHnk<br />
 * @see     GenQIT_BAK_KhHenkouUktkMkhgkHnk<br />
 */
@Entity
public class IT_BAK_KhHenkouUktkMkhgkHnk extends GenIT_BAK_KhHenkouUktkMkhgkHnk {

    private static final long serialVersionUID = 1L;

    public IT_BAK_KhHenkouUktkMkhgkHnk() {
    }

    public IT_BAK_KhHenkouUktkMkhgkHnk(String pKbnkey,String pSyono,String pTrkssikibetukey,Integer pHozenhenkouuktkrenno) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pHozenhenkouuktkrenno);
    }

    public IT_BAK_KhHenkouUktkMkhgkHnk(String pSyono,String pTrkssikibetukey,Integer pHozenhenkouuktkrenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pHozenhenkouuktkrenno);
    }


    private IT_BAK_KhHenkouUktk iT_BAKKhHenkouUktk ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_KhHenkouUktkMkhgkHnk.KBNKEY  , referencedColumnName=IT_BAK_KhHenkouUktk.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KhHenkouUktkMkhgkHnk.SYONO  , referencedColumnName=IT_BAK_KhHenkouUktk.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KhHenkouUktkMkhgkHnk.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_KhHenkouUktk.TRKSSIKIBETUKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KhHenkouUktkMkhgkHnk.HOZENHENKOUUKTKRENNO  , referencedColumnName=IT_BAK_KhHenkouUktk.HOZENHENKOUUKTKRENNO, insertable=false, updatable=false)
    })
    public IT_BAK_KhHenkouUktk getBAKKhHenkouUktk() {
        return iT_BAKKhHenkouUktk;
    }

    public void setBAKKhHenkouUktk(IT_BAK_KhHenkouUktk pIT_BAK_KhHenkouUktk) {
        this.iT_BAKKhHenkouUktk = pIT_BAK_KhHenkouUktk;
    }

}

