package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_FatcaInfo;


/**
 * ＦＡＴＣＡ情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_FatcaInfo} の JavaDoc を参照してください。<br />
 * @see     GenIT_FatcaInfo<br />
 * @see     PKIT_FatcaInfo<br />
 * @see     QIT_FatcaInfo<br />
 * @see     GenQIT_FatcaInfo<br />
 */
@Entity
public class IT_FatcaInfo extends GenIT_FatcaInfo {

    private static final long serialVersionUID = 1L;

    public IT_FatcaInfo() {
    }

    public IT_FatcaInfo(String pKbnkey,String pSyono,Integer pRenno) {
        super(pKbnkey,pSyono,pRenno);
    }

    public IT_FatcaInfo(String pSyono,Integer pRenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pRenno);
    }


    private IT_KykKihon iT_KykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_FatcaInfo.KBNKEY  , referencedColumnName=IT_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_FatcaInfo.SYONO  , referencedColumnName=IT_KykKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_KykKihon getKykKihon() {
        return iT_KykKihon;
    }

    public void setKykKihon(IT_KykKihon pIT_KykKihon) {
        this.iT_KykKihon = pIT_KykKihon;
    }

}

