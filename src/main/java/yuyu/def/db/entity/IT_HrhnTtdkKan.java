package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_HrhnTtdkKan;

/**
 * 手続完了（払方変更）テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_HrhnTtdkKan} の JavaDoc を参照してください。<br />
 * @see     GenIT_HrhnTtdkKan<br />
 * @see     PKIT_HrhnTtdkKan<br />
 * @see     QIT_HrhnTtdkKan<br />
 * @see     GenQIT_HrhnTtdkKan<br />
 */
@Entity
public class IT_HrhnTtdkKan extends GenIT_HrhnTtdkKan {

    private static final long serialVersionUID = 1L;

    public IT_HrhnTtdkKan() {
    }

    public IT_HrhnTtdkKan(String pKbnkey,String pSyono,String pHenkousikibetukey) {
        super(pKbnkey,pSyono,pHenkousikibetukey);
    }

    public IT_HrhnTtdkKan(String pSyono,String pHenkousikibetukey) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pHenkousikibetukey);
    }


    private IT_KykKihon iT_KykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_HrhnTtdkKan.KBNKEY  , referencedColumnName=IT_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_HrhnTtdkKan.SYONO  , referencedColumnName=IT_KykKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_KykKihon getKykKihon() {
        return iT_KykKihon;
    }

    public void setKykKihon(IT_KykKihon pIT_KykKihon) {
        this.iT_KykKihon = pIT_KykKihon;
    }

}

