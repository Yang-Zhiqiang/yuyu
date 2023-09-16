package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_CreditCardInfo;

/**
 * クレカ情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_CreditCardInfo} の JavaDoc を参照してください。<br />
 * @see     GenIT_CreditCardInfo<br />
 * @see     PKIT_CreditCardInfo<br />
 * @see     QIT_CreditCardInfo<br />
 * @see     GenQIT_CreditCardInfo<br />
 */
@Entity
public class IT_CreditCardInfo extends GenIT_CreditCardInfo {

    private static final long serialVersionUID = 1L;

    public IT_CreditCardInfo() {
    }

    public IT_CreditCardInfo(String pKbnkey,String pSyono) {
        super(pKbnkey,pSyono);
    }

    public IT_CreditCardInfo(String pSyono) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono);
    }


    private IT_KykKihon iT_KykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_CreditCardInfo.KBNKEY  , referencedColumnName=IT_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_CreditCardInfo.SYONO  , referencedColumnName=IT_KykKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_KykKihon getKykKihon() {
        return iT_KykKihon;
    }

    public void setKykKihon(IT_KykKihon pIT_KykKihon) {
        this.iT_KykKihon = pIT_KykKihon;
    }

}

