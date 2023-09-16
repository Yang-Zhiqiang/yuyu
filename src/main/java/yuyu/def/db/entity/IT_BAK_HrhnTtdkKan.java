package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_BAK_HrhnTtdkKan;

/**
 * 手続完了（払方変更）バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_HrhnTtdkKan} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_HrhnTtdkKan<br />
 * @see     PKIT_BAK_HrhnTtdkKan<br />
 * @see     QIT_BAK_HrhnTtdkKan<br />
 * @see     GenQIT_BAK_HrhnTtdkKan<br />
 */
@Entity
public class IT_BAK_HrhnTtdkKan extends GenIT_BAK_HrhnTtdkKan {

    private static final long serialVersionUID = 1L;

    public IT_BAK_HrhnTtdkKan() {
    }

    public IT_BAK_HrhnTtdkKan(String pKbnkey,String pSyono,String pTrkssikibetukey,String pHenkousikibetukey) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pHenkousikibetukey);
    }

    public IT_BAK_HrhnTtdkKan(String pSyono,String pTrkssikibetukey,String pHenkousikibetukey) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pHenkousikibetukey);
    }


    private IT_BAK_KykKihon iT_BAKKykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_HrhnTtdkKan.KBNKEY  , referencedColumnName=IT_BAK_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_HrhnTtdkKan.SYONO  , referencedColumnName=IT_BAK_KykKihon.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_HrhnTtdkKan.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_KykKihon.TRKSSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_BAK_KykKihon getBAKKykKihon() {
        return iT_BAKKykKihon;
    }

    public void setBAKKykKihon(IT_BAK_KykKihon pIT_BAK_KykKihon) {
        this.iT_BAKKykKihon = pIT_BAK_KykKihon;
    }

}

