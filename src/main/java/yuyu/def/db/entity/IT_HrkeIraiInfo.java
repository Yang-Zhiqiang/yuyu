package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_HrkeIraiInfo;

/**
 * 振替依頼情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_HrkeIraiInfo} の JavaDoc を参照してください。<br />
 * @see     GenIT_HrkeIraiInfo<br />
 * @see     PKIT_HrkeIraiInfo<br />
 * @see     QIT_HrkeIraiInfo<br />
 * @see     GenQIT_HrkeIraiInfo<br />
 */
@Entity
public class IT_HrkeIraiInfo extends GenIT_HrkeIraiInfo {

    private static final long serialVersionUID = 1L;

    public IT_HrkeIraiInfo() {
    }

    public IT_HrkeIraiInfo(String pKbnkey,String pSyono,String pHenkousikibetukey) {
        super(pKbnkey,pSyono,pHenkousikibetukey);
    }

    public IT_HrkeIraiInfo(String pSyono,String pHenkousikibetukey) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pHenkousikibetukey);
    }


    private IT_AnsyuKihon iT_AnsyuKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_HrkeIraiInfo.KBNKEY  , referencedColumnName=IT_AnsyuKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_HrkeIraiInfo.SYONO  , referencedColumnName=IT_AnsyuKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_AnsyuKihon getAnsyuKihon() {
        return iT_AnsyuKihon;
    }

    public void setAnsyuKihon(IT_AnsyuKihon pIT_AnsyuKihon) {
        this.iT_AnsyuKihon = pIT_AnsyuKihon;
    }

}

