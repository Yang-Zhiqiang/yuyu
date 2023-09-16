package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_BAK_KhShrRirekiDetail;


/**
 * 契約保全支払履歴明細バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_KhShrRirekiDetail} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_KhShrRirekiDetail<br />
 * @see     PKIT_BAK_KhShrRirekiDetail<br />
 * @see     QIT_BAK_KhShrRirekiDetail<br />
 * @see     GenQIT_BAK_KhShrRirekiDetail<br />
 */
@Entity
public class IT_BAK_KhShrRirekiDetail extends GenIT_BAK_KhShrRirekiDetail {

    private static final long serialVersionUID = 1L;

    public IT_BAK_KhShrRirekiDetail() {
    }

    public IT_BAK_KhShrRirekiDetail(String pKbnkey,String pSyono,String pTrkssikibetukey,String pHenkousikibetukey,String pSyouhncd,Integer pSyouhnsdno,Integer pKyksyouhnrenno) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pHenkousikibetukey,pSyouhncd,pSyouhnsdno,pKyksyouhnrenno);
    }

    public IT_BAK_KhShrRirekiDetail(String pSyono,String pTrkssikibetukey,String pHenkousikibetukey,String pSyouhncd,Integer pSyouhnsdno,Integer pKyksyouhnrenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pHenkousikibetukey,pSyouhncd,pSyouhnsdno,pKyksyouhnrenno);
    }


    private IT_BAK_KhShrRireki iT_BAKKhShrRireki ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_KhShrRirekiDetail.KBNKEY  , referencedColumnName=IT_BAK_KhShrRireki.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KhShrRirekiDetail.SYONO  , referencedColumnName=IT_BAK_KhShrRireki.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KhShrRirekiDetail.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_KhShrRireki.TRKSSIKIBETUKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KhShrRirekiDetail.HENKOUSIKIBETUKEY  , referencedColumnName=IT_BAK_KhShrRireki.HENKOUSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_BAK_KhShrRireki getBAKKhShrRireki() {
        return iT_BAKKhShrRireki;
    }

    public void setBAKKhShrRireki(IT_BAK_KhShrRireki pIT_BAK_KhShrRireki) {
        this.iT_BAKKhShrRireki = pIT_BAK_KhShrRireki;
    }

}

