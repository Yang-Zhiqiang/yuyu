package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_BAK_KhHenkouUktkYendtHnk;

/**
 * 契約保全変更受付内容（円建変更）バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_KhHenkouUktkYendtHnk} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_KhHenkouUktkYendtHnk<br />
 * @see     PKIT_BAK_KhHenkouUktkYendtHnk<br />
 * @see     QIT_BAK_KhHenkouUktkYendtHnk<br />
 * @see     GenQIT_BAK_KhHenkouUktkYendtHnk<br />
 */
@Entity
public class IT_BAK_KhHenkouUktkYendtHnk extends GenIT_BAK_KhHenkouUktkYendtHnk {

    private static final long serialVersionUID = 1L;

    public IT_BAK_KhHenkouUktkYendtHnk() {
    }

    public IT_BAK_KhHenkouUktkYendtHnk(String pKbnkey,String pSyono,String pTrkssikibetukey,Integer pHozenhenkouuktkrenno) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pHozenhenkouuktkrenno);
    }

    public IT_BAK_KhHenkouUktkYendtHnk(String pSyono,String pTrkssikibetukey,Integer pHozenhenkouuktkrenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pHozenhenkouuktkrenno);
    }


    private IT_BAK_KhHenkouUktk iT_BAKKhHenkouUktk ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_KhHenkouUktkYendtHnk.KBNKEY  , referencedColumnName=IT_BAK_KhHenkouUktk.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KhHenkouUktkYendtHnk.SYONO  , referencedColumnName=IT_BAK_KhHenkouUktk.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KhHenkouUktkYendtHnk.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_KhHenkouUktk.TRKSSIKIBETUKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KhHenkouUktkYendtHnk.HOZENHENKOUUKTKRENNO  , referencedColumnName=IT_BAK_KhHenkouUktk.HOZENHENKOUUKTKRENNO, insertable=false, updatable=false)
    })
    public IT_BAK_KhHenkouUktk getBAKKhHenkouUktk() {
        return iT_BAKKhHenkouUktk;
    }

    public void setBAKKhHenkouUktk(IT_BAK_KhHenkouUktk pIT_BAK_KhHenkouUktk) {
        this.iT_BAKKhHenkouUktk = pIT_BAK_KhHenkouUktk;
    }

}

