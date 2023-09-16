package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_BAK_HrkeIraiInfo;

/**
 * 振替依頼情報バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_HrkeIraiInfo} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_HrkeIraiInfo<br />
 * @see     PKIT_BAK_HrkeIraiInfo<br />
 * @see     QIT_BAK_HrkeIraiInfo<br />
 * @see     GenQIT_BAK_HrkeIraiInfo<br />
 */
@Entity
public class IT_BAK_HrkeIraiInfo extends GenIT_BAK_HrkeIraiInfo {

    private static final long serialVersionUID = 1L;

    public IT_BAK_HrkeIraiInfo() {
    }

    public IT_BAK_HrkeIraiInfo(String pKbnkey,String pSyono,String pTrkssikibetukey,String pHenkousikibetukey) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pHenkousikibetukey);
    }

    public IT_BAK_HrkeIraiInfo(String pSyono,String pTrkssikibetukey,String pHenkousikibetukey) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pHenkousikibetukey);
    }


    private IT_BAK_AnsyuKihon iT_BAKAnsyuKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_HrkeIraiInfo.KBNKEY  , referencedColumnName=IT_BAK_AnsyuKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_HrkeIraiInfo.SYONO  , referencedColumnName=IT_BAK_AnsyuKihon.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_HrkeIraiInfo.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_AnsyuKihon.TRKSSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_BAK_AnsyuKihon getBAKAnsyuKihon() {
        return iT_BAKAnsyuKihon;
    }

    public void setBAKAnsyuKihon(IT_BAK_AnsyuKihon pIT_BAK_AnsyuKihon) {
        this.iT_BAKAnsyuKihon = pIT_BAK_AnsyuKihon;
    }

}

